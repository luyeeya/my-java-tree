package spring.ioc.config.xml_config;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring IoC：xml 配置
 */
public class App {
    private static final String XML_PATH = "xml_config.xml";

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(XML_PATH); // or XmlBeanFactory(new ClassPathResource(XML_PATH))
        UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");
        System.out.println(userService.listUser());
    }
}
