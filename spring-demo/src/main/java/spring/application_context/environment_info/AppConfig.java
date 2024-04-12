package spring.application_context.environment_info;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("spring.application_context.environment_info")
@PropertySource("classpath:custom.properties")
public class AppConfig {
}
