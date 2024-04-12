package spring.ioc.config.annotation_config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring IoC：注解配置
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");
        System.out.println(userService.listUser());
    }
}
