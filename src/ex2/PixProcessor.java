package src.ex2;

import java.math.BigDecimal;

class PixProcessor implements PaymentProcessor {

    @Override
    public boolean process(BigDecimal amount) {
        System.out.println("[PIX] Gerando QR Code para R$ " + amount);
        return true;
    }
}
