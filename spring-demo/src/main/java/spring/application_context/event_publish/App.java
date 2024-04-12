package spring.application_context.event_publish;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ApplicationContext 事件发布（ApplicationEventPublisher）
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) context.getBean("userService");
        userService.login();
    }
}
