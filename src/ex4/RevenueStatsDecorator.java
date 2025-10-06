package src.ex4;

class RevenueStatsDecorator extends ReportDecorator {

    public RevenueStatsDecorator(Report wrappee) {
        super(wrappee);
    }

    @Override
    public String generate() {
        String base = wrappee.generate();
        // Simulação de cálculo:
        String stats = """
                --- Estatísticas ---
                Total de pedidos: 4
                Faturamento bruto: R$ 8.540,00
                Ticket médio: R$ 2.135,00
                """;
        return base + stats;
    }
}
