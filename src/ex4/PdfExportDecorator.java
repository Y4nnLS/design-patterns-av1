package src.ex4;

class PdfExportDecorator extends ReportDecorator {

    public PdfExportDecorator(Report wrappee) {
        super(wrappee);
    }

    @Override
    public String generate() {
        String base = wrappee.generate();
        // Aqui só simulamos: em um app real, geraria bytes de PDF.
        return base + "--- Exportação: [PDF gerado]\n";
    }
}
