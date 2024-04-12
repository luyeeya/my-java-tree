package spring.order;

import org.springframework.core.annotation.Order;

@Order(1)
public class OrderServiceImplB {
    @Override
    public String toString() {
        return "OrderServiceImplB";
    }
}
