package spring.ioc.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.bean.UserMapper;
import spring.bean.UserServiceImpl;

/**
 * Spring IoC 配置之：Java Config
 */
@Configuration // 添加 @Configuration 注解声明为配置类
public class JavaConfig {
    @Bean(name = "userMapper") // Spring 会管理 @Bean 注解修饰的方法返回的 Bean 实例
    public UserMapper userMapper() {
        return new UserMapper();
    }

    @Bean(name = "userService")
    public UserServiceImpl userService(UserMapper userMapper) { // Autowiring by type from bean name 'userService' via factory method to bean named 'userMapper'
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserMapper(userMapper); // 手动设置 userMapper 属性
        return userService;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class); // AnnotationConfigApplicationContext
        UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");
        System.out.println(userService.listUser());
    }
}
