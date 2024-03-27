package factory.method;

public class AlipayFactory implements PaymentFactory {
    @Override
    public Payment getPayment() {
        return new Alipay();
    }
}
