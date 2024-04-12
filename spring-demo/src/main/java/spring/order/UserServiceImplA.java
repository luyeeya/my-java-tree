package spring.order;

import org.springframework.core.Ordered;

public class UserServiceImplA implements Ordered {
    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public String toString() {
        return "UserServiceImplA";
    }
}
