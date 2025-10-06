package src.ex2;

import java.math.BigDecimal;

public interface PaymentProcessor {
    boolean process(BigDecimal amount);

}
