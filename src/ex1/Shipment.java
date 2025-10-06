package src.ex1;

import java.math.BigDecimal;

public class Shipment {

    final double distanceKm; // para terrestre/marítimo
    final double weightKg;   // para aéreo (e eventualmente outros)
    final double volumeM3;   // opcional, útil p/ marítimo
    final BigDecimal baseFee; // taxa fixa da empresa

    public Shipment(double distanceKm, double weightKg, double volumeM3, BigDecimal baseFee) {
        this.distanceKm = distanceKm;
        this.weightKg = weightKg;
        this.volumeM3 = volumeM3;
        this.baseFee = baseFee;
    }
}
