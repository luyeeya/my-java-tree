package strategy;

public class UnionPay implements Payment {
    @Override
    public void pay(String userId, long amount) {
        System.out.printf("%s 使用银联支付 %s 元%n", userId, amount);
    }
}
