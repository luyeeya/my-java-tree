package spring.application_context.event_publish;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserService implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void login() {
        // 发布事件方式 1：内部也是使用 applicationEventPublisher
        applicationContext.publishEvent(new LoginEvent("[from applicationContext]"));
        // 发布事件方式 2
        applicationEventPublisher.publishEvent(new LoginEvent("[from applicationEventPublisher]"));
    }
}
