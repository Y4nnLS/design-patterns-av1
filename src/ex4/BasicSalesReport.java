package src.ex4;

import java.util.*;

class BasicSalesReport implements Report {

    private final List<String> orders;

    public BasicSalesReport(List<String> orders) {
        this.orders = orders;
    }

    @Override
    public String generate() {
        StringBuilder sb = new StringBuilder("=== Relatório de Vendas (Básico) ===\n");
        for (String o : orders) {
            sb.append("- ").append(o).append("\n");
        }
        return sb.toString();
    }
}
