package spring.ioc.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.bean.annotated.UserServiceImpl;

/**
 * Spring IoC 配置之：注解配置
 */
public class AnnotationConfig {
    private static final String XML_PATH = "annotation_config.xml";
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(XML_PATH); // ClassPathXmlApplicationContext
        UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");
        System.out.println(userService.listUser());
    }
}
