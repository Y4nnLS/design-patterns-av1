package src.ex5;

import java.util.List;

class ProposalTemplate extends DocumentTemplate {

    public ProposalTemplate() {
        super("Proposta Comercial",
                new Style("#0055AA", "Roboto", "assets/logo-default.png"),
                List.of("Capa", "Escopo", "Cronograma", "Investimento", "Condições"));
    }
}
