package spring.ioc.config.java_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 声明为配置类
public class JavaConfig {
    @Bean(name = "userMapper") // 注册 BeanDefinition
    public UserMapper userMapper() {
        return new UserMapper();
    }

    @Bean(name = "userService")
    public UserServiceImpl userService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserMapper(userMapper()); // Spring 会使用自己托管的 userMapper Bean
        return userService;
    }
}
