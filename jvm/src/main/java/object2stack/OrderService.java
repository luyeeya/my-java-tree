package object2stack;

import java.time.Instant;
import java.util.UUID;

public class OrderService {
    /**
     * 创建的 order 对象逃逸出了当前方法
     */
    public Order createOrder() {
        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setTime(Instant.now());
        return order;
    }

    /**
     * 创建的 order 对象没有逃逸出当前方法
     */
    public void printOrder() {
        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setTime(Instant.now());
//        System.out.println(order);
    }
}
