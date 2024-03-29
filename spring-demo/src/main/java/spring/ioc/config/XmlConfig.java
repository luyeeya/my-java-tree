package spring.ioc.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.bean.UserServiceImpl;

/**
 * Spring IoC 配置之：xml 配置
 */
public class XmlConfig {
    private static final String XML_PATH = "xml_config.xml";
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(XML_PATH); // ClassPathXmlApplicationContext 或 XmlBeanFactory(new ClassPathResource(XML_PATH))
        UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");
        System.out.println(userService.listUser());
    }
}
