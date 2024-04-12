package spring.application_context.event_publish;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

@ComponentScan("spring.application_context.event_publish")
public class AppConfig {

    /**
     * 监听自定义的 LoginEvent 事件（非注解方式）
     */
    @Bean
    public ApplicationListener<LoginEvent> applicationListener() {
        return event -> System.out.println("[非注解方式]" + event.getSource() + " Someone has logged in.");
    }

    /**
     * 监听自定义的 LoginEvent 事件（注解方式）
     */
    @EventListener
    public void listenLogin(LoginEvent event) {
        System.out.println("[注解方式]" + event.getSource() + " Someone has logged in.");
    }
}
