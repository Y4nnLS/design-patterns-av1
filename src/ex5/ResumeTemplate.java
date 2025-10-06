package src.ex5;

import java.util.List;

class ResumeTemplate extends DocumentTemplate {

    public ResumeTemplate() {
        super("Currículo",
                new Style("#222222", "Inter", "assets/logo-default.png"),
                List.of("Cabeçalho", "Experiência", "Formação", "Habilidades"));
    }
}
