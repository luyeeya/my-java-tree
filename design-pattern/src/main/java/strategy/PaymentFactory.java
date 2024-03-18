package strategy;

import java.util.EnumMap;
import java.util.Map;

public class PaymentFactory {
    private static final Map<PaymentEnum, Payment> payments = new EnumMap<>(PaymentEnum.class);

    static {
        payments.put(PaymentEnum.ALI_PAY, new AliPay());
        payments.put(PaymentEnum.WECHAT_PAY, new WeChatPay());
        payments.put(PaymentEnum.UNION_PAY, new UnionPay());
    }

    public static Payment getPayment(PaymentEnum payment) {
        if (payment == null) {
            payment = PaymentEnum.ALI_PAY;
        }
        return payments.get(payment);
    }
}
