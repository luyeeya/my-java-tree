package proxy.dynamic.jdk;

public class OrderServiceImpl implements OrderService {
    public void order() {
        System.out.println("ordering...");
        System.out.println("order complete");
    }
}
