package src.ex1;

import java.math.BigDecimal;

public class StrategyDemo {
    public static void main(String[] args) {
        Shipment sp = new Shipment(850, 120, 3.5, new BigDecimal("50.00"));

        FreightStrategy land = new LandFreight(new BigDecimal("1.20"));
        FreightStrategy air  = new AirFreight(new BigDecimal("8.90"));
        FreightStrategy sea  = new SeaFreight(new BigDecimal("30.00"), new BigDecimal("0.25"));

        System.out.println("Terrestre: R$ " + land.calculate(sp));
        System.out.println("Aéreo:     R$ " + air.calculate(sp));
        System.out.println("Marítimo:  R$ " + sea.calculate(sp));
    }
}