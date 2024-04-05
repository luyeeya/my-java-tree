package dev.luyee.spring;

import dev.luyee.customer.BeanConfig;

import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MyApplicationContext {

    private final Class<BeanConfig> configClass;

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>(); // Spring AOP 基于这个

    public MyApplicationContext(Class<BeanConfig> configClass) {
        this.configClass = configClass;

        if (configClass.isAnnotationPresent(ComponentScan.class)) {
            // 1. 扫描并注册 BeanDefinition
            // 是否有 @ComponentScan 注解
            // 拿到 @ComponentScan 注解的 value 即 basePackage
            // 通过 classloader.getResource(basePackage) 获取 basePackage 资源
            // 遍历 basePackage 资源下的 class 文件，找到所有 @Component 注解的 class
            // 生成 BeanDefinition 并注册
            ComponentScan componentScan = configClass.getAnnotation(ComponentScan.class);
            String basePackage = componentScan.value(); // com.xxx.yyy
            String basePath = basePackage.replaceAll("\\.", "/"); // com/xxx/yyy
            ClassLoader classLoader = MyApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(basePath);
            File file = new File(resource.getFile());

            if (file.isDirectory()) {
                List<String> classNames = Arrays.stream(file.listFiles())
                        .map(File::getAbsolutePath)
                        .filter(f -> f.endsWith(".class"))
                        .map(f -> f.replaceAll("\\\\", ".").replaceAll("/", "."))
                        .map(f -> f.substring(f.indexOf(basePackage)))
                        .map(f -> f.substring(0, f.indexOf(".class")))
                        .collect(Collectors.toList());

                try {
                    for (String className : classNames) {
                        Class<?> clazz = Class.forName(className); // 亦可用：classLoader.loadClass(className)
                        if (clazz.isAnnotationPresent(Component.class)) {
                            // 注册 BeanPostProcessor 到容器
                            if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                                beanPostProcessors.add((BeanPostProcessor) clazz.newInstance());
                            }

                            // 获取 beanName
                            Component component = clazz.getAnnotation(Component.class);
                            String beanName = component.value();
                            if ("".equals(beanName)) {
                                beanName = Introspector.decapitalize(clazz.getSimpleName());
                            }

                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setBeanClass(clazz);
                            // BeanDefinition 设置 Scope
                            if (clazz.isAnnotationPresent(Scope.class)) {
                                Scope scope = clazz.getAnnotation(Scope.class);
                                beanDefinition.setScope(Scope.SCOPE_PROTOTYPE.equals(scope.value()) ? Scope.SCOPE_PROTOTYPE : Scope.SCOPE_SINGLETON);
                            } else {
                                beanDefinition.setScope(Scope.SCOPE_SINGLETON);
                            }
                            // BeanDefinition 设置 Lazy-Init
                            if (clazz.isAnnotationPresent(Lazy.class)) {
                                beanDefinition.setLazyInit(Boolean.TRUE);
                            }
                            beanDefinitionMap.put(beanName, beanDefinition);
                        }
                    }
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                beanDefinitionMap.forEach((k, v) -> System.out.println("[beanDefinitionMap] " + k + ": " + v));
                System.out.println("beanPostProcessors = " + beanPostProcessors);

                // 2. 实例化非懒加载的单例 Bean
                beanDefinitionMap.entrySet().stream()
                        .filter(e -> e.getValue().isSingleton() && !e.getValue().isLazyInit())
                        .forEach(e -> singletonObjects.put(e.getKey(), createBean(e.getKey(), e.getValue())));
                singletonObjects.forEach((k, v) -> System.out.println("[singletonObjects] " + k + ": " + v));

            }
        }
    }

    public Object createBean(String beanName, BeanDefinition beanDefinition) {
        Class<?> clazz = beanDefinition.getBeanClass();
        Object bean;
        try {
            bean = clazz.getConstructor().newInstance();
            // 依赖注入
            List<Field> autowiredFields = Arrays.stream(clazz.getDeclaredFields())
                    .filter(f -> f.isAnnotationPresent(Autowired.class))
                    .collect(Collectors.toList());
            for (Field field : autowiredFields) {
                Object dependency = getBean(field.getName());
                field.setAccessible(true);
                field.set(bean, dependency);
            }
            // 回调：Aware 扩展
            if (bean instanceof BeanNameAware) {
                ((BeanNameAware) bean).setBeanName(beanName);
            }
            // 初始化前⭐：BeanPostProcessor 扩展
            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                bean = beanPostProcessor.postProcessBeforeInitialization(bean, beanName);
            }
            // 初始化：InitializingBean 扩展
            if (bean instanceof InitializingBean) {
                ((InitializingBean) bean).afterPropertiesSet();
            }
            // 初始化后⭐：BeanPostProcessor 扩展
            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                bean = beanPostProcessor.postProcessAfterInitialization(bean, beanName);
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return bean;
    }

    public Object getBean(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new RuntimeException(String.format("No bean named %s available", beanName));
        }

        Object bean;
        if (beanDefinition.isSingleton()) {
            // 单例：从容器中拿
            // 容器中拿不到再根据 BeanDefinition 实例化
            if (!singletonObjects.containsKey(beanName)) {
                synchronized (MyApplicationContext.class) {
                    if (!singletonObjects.containsKey(beanName)) {
                        singletonObjects.put(beanName, createBean(beanName, beanDefinition));
                    }
                }
            }
            bean = singletonObjects.get(beanName);
        } else {
            // 多例：根据 BeanDefinition 实例化
            bean = createBean(beanName, beanDefinition);
        }

        return bean;
    }
}
