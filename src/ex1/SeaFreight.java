package src.ex1;

import java.math.*;

class SeaFreight implements FreightStrategy {

    private final BigDecimal pricePerM3;
    private final BigDecimal pricePerKm;

    public SeaFreight(BigDecimal pricePerM3, BigDecimal pricePerKm) {
        this.pricePerM3 = pricePerM3;
        this.pricePerKm = pricePerKm;
    }

    @Override
    public BigDecimal calculate(Shipment s) {
        BigDecimal total = s.baseFee
                .add(pricePerM3.multiply(BigDecimal.valueOf(s.volumeM3)))
                .add(pricePerKm.multiply(BigDecimal.valueOf(s.distanceKm)));
        return total.setScale(2, RoundingMode.HALF_UP);
    }
}
