package spring.type_convert.type_converter;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println("admin: " + userService.getAdminUser());
        System.out.println("random: " + userService.getRandomUser());
    }
}
