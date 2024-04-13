package spring.ioc.bean_factory_post_processor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * BeanFactoryPostProcessor：BeanFactory 后置处理器，是一个扩展点，用来修改 BeanFactory 中的内容
 * 举例：由于发生在 BeanDefinition 注册之后，因此在这里可以修改 BeanDefinition
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context.getBean("userService", UserService.class));
        System.out.println(context.getBean("userService", UserService.class));

    }
}
