package src.ex4;

import java.util.List;

public class DecoratorDemo {
    public static void main(String[] args) {
        Report basic = new BasicSalesReport(List.of(
            "Pedido #1001 - R$ 2.500,00",
            "Pedido #1002 - R$ 1.990,00",
            "Pedido #1003 - R$ 2.050,00",
            "Pedido #1004 - R$ 2.000,00"
        ));

        // Montagem flexível, sem tocar no básico:
        Report withStats = new RevenueStatsDecorator(basic);
        Report withStatsAndChart = new ChartDecorator(withStats);
        Report full = new PdfExportDecorator(withStatsAndChart);

        System.out.println("---- Básico ----");
        System.out.println(basic.generate());

        System.out.println("---- Básico + Estatísticas + Gráfico + PDF ----");
        System.out.println(full.generate());
    }
}