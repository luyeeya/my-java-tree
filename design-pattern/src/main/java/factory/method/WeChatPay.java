package factory.method;

public class WeChatPay implements Payment {
    @Override
    public void pay(String userId, long amount) {
        System.out.printf("%s 使用微信支付 %s 元%n", userId, amount);
    }
}
