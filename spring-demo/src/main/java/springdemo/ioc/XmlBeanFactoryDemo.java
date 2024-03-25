package springdemo.ioc;

import dev.luyee.Monkey;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class XmlBeanFactoryDemo {
    private static final String XML_PATH = "beanFactory.xml";

    public static void main(String[] args) {
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(XML_PATH));
        Monkey monkey = (Monkey) beanFactory.getBean("monkey");
        System.out.println(monkey);
    }
}
