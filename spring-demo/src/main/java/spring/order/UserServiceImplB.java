package spring.order;

import org.springframework.core.Ordered;

public class UserServiceImplB implements Ordered {
    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public String toString() {
        return "UserServiceImplB";
    }
}
