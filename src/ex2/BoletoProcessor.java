package src.ex2;

import java.math.BigDecimal;

class BoletoProcessor implements PaymentProcessor {
    @Override public boolean process(BigDecimal amount) {
        System.out.println("[Boleto] Gerando linha digitável para R$ " + amount);
        return true;
    }
}