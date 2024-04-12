package spring.type_convert.property_editor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * JDK 提供的类型转换机制
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) context.getBean("userService");
        System.out.println("admin: " + userService.getAdminUser());
    }
}
