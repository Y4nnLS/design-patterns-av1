package src.ex1;

import java.math.BigDecimal;

public interface FreightStrategy {

    BigDecimal calculate(Shipment s);
}
