package proxy.dynamic.jdk;

public class Main {
    public static void main(String[] args) {
        // JDK动态代理类输出到文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        UserServiceImpl userService = new UserServiceImpl();
        TimeInvocationHandler timeInvocationHandler = new TimeInvocationHandler(userService);
        UserService userServiceProxy = (UserService) timeInvocationHandler.getProxy();
        userServiceProxy.login("Louis", "123456");

        System.out.println("----------------------------------------------");

        OrderServiceImpl orderService = new OrderServiceImpl();
        TimeInvocationHandler timeInvocationHandler2 = new TimeInvocationHandler(orderService);
        OrderService orderServiceProxy = (OrderService) timeInvocationHandler2.getProxy();
        orderServiceProxy.order();
    }
}
