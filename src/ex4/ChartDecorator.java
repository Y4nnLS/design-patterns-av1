package src.ex4;

class ChartDecorator extends ReportDecorator {
    public ChartDecorator(Report wrappee) { super(wrappee); }

    @Override
    public String generate() {
        String base = wrappee.generate();
        String chart = """
                --- Gráficos ---
                [#####------] Categoria A
                [########---] Categoria B
                [###--------] Categoria C
                """;
        return base + chart;
    }
}