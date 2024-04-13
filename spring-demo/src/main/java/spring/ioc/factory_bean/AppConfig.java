package spring.ioc.factory_bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("spring.ioc.factory_bean")
public class AppConfig {

    @Bean
    public UserService userService() {
        return new UserService("Created by @Bean");
    }
}
