package src.ex2;

import java.math.BigDecimal;

class CreditCardProcessor implements PaymentProcessor {
    @Override public boolean process(BigDecimal amount) {
        System.out.println("[Cartão] Autorizando e capturando R$ " + amount);
        return true;
    }
}