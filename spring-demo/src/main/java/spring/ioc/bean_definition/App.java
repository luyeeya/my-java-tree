package spring.ioc.bean_definition;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 编程式注册 BeanDefinition 方法 1
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(UserMapper.class);
        beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
        context.registerBeanDefinition("userMapper", beanDefinition);

        // 编程式注册 BeanDefinition 方式 2
        // 2.1
        AnnotatedBeanDefinitionReader beanDefinitionReader = new AnnotatedBeanDefinitionReader(context);
        beanDefinitionReader.registerBean(UserService.class);
        // 2.2
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(context);
        xmlBeanDefinitionReader.loadBeanDefinitions("bean.xml");
        System.out.println(context.getBean("userService"));
        // 2.3
        ClassPathBeanDefinitionScanner beanDefinitionScanner = new ClassPathBeanDefinitionScanner(context);
        beanDefinitionScanner.scan("spring.ioc.beandefinition.scan");
        System.out.println(context.getBean("inventoryService"));

        UserService userService = (UserService) context.getBean("userService");
        System.out.println("users: " + userService.listUser());
    }
}
