package spring.application_context.i18n;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ApplicationContext 国际化（MessageSource）
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) context.getBean("userService");
        userService.listUsers();
    }
}
