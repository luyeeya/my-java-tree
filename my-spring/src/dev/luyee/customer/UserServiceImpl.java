package dev.luyee.customer;


import dev.luyee.spring.Autowired;
import dev.luyee.spring.Component;
import dev.luyee.spring.Lazy;
import dev.luyee.spring.Scope;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Lazy
@Scope
@Component("userService")
public class UserServiceImpl implements UserService {
    private Date initializedTime;
    @Autowired
    private OrderService orderService;

    @Override
    public List<String> listUser() {
        return Arrays.asList("Tom", "Jerry", "ZhangSan");
    }

    @Override
    public void order() {
        orderService.createOrder();
    }

    public Date getInitializedTime() {
        return initializedTime;
    }
}
