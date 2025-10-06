package src.ex5;

import java.util.*;

class DocumentTemplate implements DocumentPrototype {

    String name;
    Style style;
    private List<String> sections = new ArrayList<>();

    public DocumentTemplate(String name, Style style, List<String> sections) {
        this.name = name;
        this.style = style;
        this.sections.addAll(sections);
    }

    @Override
    public DocumentPrototype cloneDeep() {
        // Deep copy: novo objeto Style e nova lista de sections
        return new DocumentTemplate(this.name, this.style.clone(), new ArrayList<>(this.sections));
    }

    public void customize(String newColor, String newFont, String newLogo, String clientName) {
        if (newColor != null) {
            style.primaryColor = newColor;
        }
        if (newFont != null) {
            style.fontFamily = newFont;
        }
        if (newLogo != null) {
            style.logoPath = newLogo;
        }
        // Personalização de conteúdo:
        sections.add("Seção personalizada para o cliente: " + clientName);
    }

    @Override
    public String toString() {
        return "Template '%s' | %s | Sections=%s".formatted(name, style, sections);
    }
}
