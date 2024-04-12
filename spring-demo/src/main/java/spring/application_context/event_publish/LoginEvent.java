package spring.application_context.event_publish;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义的事件
 */
public class LoginEvent extends ApplicationEvent {
    public LoginEvent(Object source) {
        super(source);
    }
}
