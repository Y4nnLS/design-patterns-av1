package src.ex1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LandFreight implements FreightStrategy {

    private final BigDecimal pricePerKm;

    public LandFreight(BigDecimal pricePerKm) {
        this.pricePerKm = pricePerKm;
    }

    @Override
    public BigDecimal calculate(Shipment s) {
        BigDecimal total = s.baseFee
                .add(pricePerKm.multiply(BigDecimal.valueOf(s.distanceKm)));
        return total.setScale(2, RoundingMode.HALF_UP);
    }
}
