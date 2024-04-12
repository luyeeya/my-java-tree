package spring.ioc.config.annotation_config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring IoC：注解配置
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");
        System.out.println(userService.listUser());

        // 编程式注册 BeanDefinition
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(OrderService.class);
        beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
        applicationContext.registerBeanDefinition("orderService", beanDefinition);
        OrderService orderService = (OrderService) applicationContext.getBean("orderService");
        orderService.createOrder();
    }
}
