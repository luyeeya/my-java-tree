package spring.ioc.config.java_config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring IoC：Java Config
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");
        System.out.println(userService.listUser());
    }
}
