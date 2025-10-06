package src.ex1;

import java.math.*;

class AirFreight implements FreightStrategy {

    private final BigDecimal pricePerKg;

    public AirFreight(BigDecimal pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    @Override
    public BigDecimal calculate(Shipment s) {
        // Ex.: menor impacto da distância, maior do peso
        BigDecimal total = s.baseFee
                .add(pricePerKg.multiply(BigDecimal.valueOf(s.weightKg)));
        return total.setScale(2, RoundingMode.HALF_UP);
    }
}
