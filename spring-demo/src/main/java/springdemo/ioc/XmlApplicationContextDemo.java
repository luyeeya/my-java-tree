package springdemo.ioc;

import dev.luyee.Monkey;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlApplicationContextDemo {
    private static final String XML_PATH = "beanFactory.xml";

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(XML_PATH);
        Monkey monkey = (Monkey) applicationContext.getBean("houzi");
        System.out.println(monkey);
    }
}
