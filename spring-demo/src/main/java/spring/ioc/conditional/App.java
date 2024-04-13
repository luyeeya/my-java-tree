package spring.ioc.conditional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * {@code @Conditional} 条件注解
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context.getBean("userService"));
    }
}
