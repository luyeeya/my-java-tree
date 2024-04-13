package spring.ioc.factory_bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 为了测试 FactoryBean 和 @Bean 各自创建的 Bean 的区别
 * 结论：FactoryBean 和 @Bean 的作用基本相同，唯一不同的是 FactoryBean 创建的 Bean 不会经过完整的生命周期，只会经过初始化后（为了支持 AOP 功能，保留了初始化后）
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("userService") || beanName.equals("userServiceFactoryBean")) {
            System.out.println(bean + "：初始化前");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("userService") || beanName.equals("userServiceFactoryBean")) {
            System.out.println(bean + "：初始化后");
        }
        return bean;
    }
}
