package spring.application_context.environment;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("spring.application_context.environment")
@PropertySource("classpath:custom.properties")
public class AppConfig {
}
