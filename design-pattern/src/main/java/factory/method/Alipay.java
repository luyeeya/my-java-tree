package factory.method;

public class Alipay implements Payment {
    @Override
    public void pay(String userId, long amount) {
        System.out.printf("%s 使用支付宝支付 %s 元%n", userId, amount);
    }
}
