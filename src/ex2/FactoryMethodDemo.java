package src.ex2;

import java.math.BigDecimal;

public class FactoryMethodDemo {

    public static void main(String[] args) {
        PaymentProcessor p1 = PaymentFactory.create(PaymentType.CREDIT_CARD);
        p1.process(new BigDecimal("249.90"));

        PaymentProcessor p2 = PaymentFactory.create(PaymentType.BOLETO);
        p2.process(new BigDecimal("1299.00"));

        PaymentProcessor p3 = PaymentFactory.create(PaymentType.PIX);
        p3.process(new BigDecimal("39.99"));
    }
}
