package spring.type_convert.type_converter;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 是对 PropertyEditor 和 ConversionService 类型转换机制的整合，Spring 自己在用
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println("admin: " + userService.getAdminUser());
        System.out.println("random: " + userService.getRandomUser());
    }
}
