package factory.method;

public class WeChatPayFactory implements PaymentFactory {
    @Override
    public Payment getPayment() {
        return new WeChatPay();
    }
}
