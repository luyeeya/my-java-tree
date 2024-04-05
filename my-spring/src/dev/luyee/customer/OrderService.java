package dev.luyee.customer;

import dev.luyee.spring.BeanNameAware;
import dev.luyee.spring.Component;
import dev.luyee.spring.InitializingBean;

import java.util.Date;

@Component
public class OrderService implements BeanNameAware, InitializingBean {
    private String beanName;

    private Date initializedTime;

    public void createOrder() {
        System.out.printf("[%s] A new order created.", this.beanName);
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.printf("[%s] After properties set, do something...%n", this.beanName);
    }

    public Date getInitializedTime() {
        return initializedTime;
    }
}
