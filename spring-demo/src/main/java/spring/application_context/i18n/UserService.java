package spring.application_context.i18n;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class UserService implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void listUsers() {
        String zhTitle = applicationContext.getMessage("title", null, Locale.CHINA);
        String enTitle = applicationContext.getMessage("title", null, Locale.ENGLISH);
        System.out.println("zhTitle = " + zhTitle + ", enTitle = " + enTitle);
    }
}
