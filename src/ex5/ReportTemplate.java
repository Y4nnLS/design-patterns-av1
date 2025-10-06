package src.ex5;

import java.util.List;

class ReportTemplate extends DocumentTemplate {
    public ReportTemplate() {
        super("Relatório",
              new Style("#333333", "Serif", "assets/logo-default.png"),
              List.of("Resumo Executivo", "Resultados", "Conclusão"));
    }
}
