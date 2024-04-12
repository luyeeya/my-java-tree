package spring.order;

import org.springframework.core.OrderComparator;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义 Bean 的顺序
 */
public class App {
    public static void main(String[] args) {
        // 比较 Ordered 接口 getOrder() 方法的返回值
        OrderComparator orderComparator = new OrderComparator();
        List<Object> list1 = Arrays.asList(new UserServiceImplA(), new UserServiceImplB());
        list1.sort(orderComparator);
        System.out.println("sorted: " + list1);

        // 优先用 Ordered 接口 getOrder() 方法的返回值，其次用 @Order 注解的值，来比较
        AnnotationAwareOrderComparator awareOrderComparator = new AnnotationAwareOrderComparator();
        List<Object> list2 = Arrays.asList(new OrderServiceImplA(), new OrderServiceImplB());
        list2.sort(awareOrderComparator);
        System.out.println("sorted: " + list2);
    }
}
