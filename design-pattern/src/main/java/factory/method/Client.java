package factory.method;

public class Client {
    public static void main(String[] args) {
        AlipayFactory aliPayFactory = new AlipayFactory();
        Payment alipay = aliPayFactory.getPayment();
        alipay.pay("u001", 100);

        WeChatPayFactory weChatPayFactory = new WeChatPayFactory();
        Payment weChatPay = weChatPayFactory.getPayment();
        weChatPay.pay("u002", 1999);
    }
}
