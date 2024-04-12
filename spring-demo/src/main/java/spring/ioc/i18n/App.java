package spring.ioc.i18n;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring 国际化使用举例
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) context.getBean("userService");
        userService.listUsers();
    }
}
