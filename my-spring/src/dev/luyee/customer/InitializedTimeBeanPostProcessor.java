package dev.luyee.customer;

import dev.luyee.spring.BeanPostProcessor;
import dev.luyee.spring.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class InitializedTimeBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if ("userService".equals(beanName)) {
            Object proxy = Proxy.newProxyInstance(InitializedTimeBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("切面逻辑...");
                    return method.invoke(bean);
                }
            });
            return proxy;
        }
        return bean;
    }
}
