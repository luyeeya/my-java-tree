package strategy;

public class Main {
    public static void main(String[] args) {
        Payment payment = PaymentFactory.getPayment(PaymentEnum.WECHAT_PAY);
        payment.pay("u9527", 99);

        Payment payment2 = PaymentFactory.getPayment(PaymentEnum.ALI_PAY);
        payment2.pay("u2333", 10);

        Payment payment3 = PaymentFactory.getPayment(PaymentEnum.UNION_PAY);
        payment3.pay("u6666", 2);
    }
}
