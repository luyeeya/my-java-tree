package dev.luyee.customer;

import dev.luyee.spring.MyApplicationContext;

public class Main {
    public static void main(String[] args) {
        MyApplicationContext applicationContext = new MyApplicationContext(BeanConfig.class);
        UserService userService = (UserService) applicationContext.getBean("userService");
        System.out.println("users = " + userService.listUser());
        userService.order();
    }
}
