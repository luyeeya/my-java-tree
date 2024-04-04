package spring.ioc.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import spring.bean.annotated.UserServiceImpl;

/**
 * Spring IoC 配置之：注解配置
 */
@ComponentScan(basePackages = "spring.bean.annotated")
public class AnnotationConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");
        System.out.println(userService.listUser());
    }
}
