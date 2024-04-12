package spring.type_convert.conversion_service;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) context.getBean("userService");
        System.out.println("admin: " + userService.getAdminUser());
        System.out.println("random: " + userService.getRandomUser());
    }
}
