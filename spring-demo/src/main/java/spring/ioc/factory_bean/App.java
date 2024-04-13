package spring.ioc.factory_bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * FactoryBean：用来创建复杂 Bean 的一种方式，隐藏了复杂的实例化过程
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // 获取 FactoryBean 的 getObject() 方法返回的 Bean
        System.out.println(context.getBean("userServiceFactoryBean")); // UserService@4206a205
        // 如果 FactoryBean 的 isSingleton() 方法返回 true，则 getObject() 方法返回单例 Bean
        System.out.println(context.getBean("userServiceFactoryBean")); // UserService@4206a205（单例）
        // 加上 & 前缀，可以获取 FactoryBean 本身，而不是 getObject() 返回的 Bean
        System.out.println(context.getBean("&userServiceFactoryBean")); // UserServiceFactoryBean@29ba4338
    }
}
