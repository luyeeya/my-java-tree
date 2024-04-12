package spring.order;

import org.springframework.core.annotation.Order;

@Order(2)
public class OrderServiceImplA {
    @Override
    public String toString() {
        return "OrderServiceImplA";
    }
}
