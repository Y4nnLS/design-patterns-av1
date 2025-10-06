package src.ex5;

public class PrototypeDemo {
    public static void main(String[] args) {
        PrototypeRegistry reg = new PrototypeRegistry();
        reg.register("resume", new ResumeTemplate());
        reg.register("proposal", new ProposalTemplate());
        reg.register("report", new ReportTemplate());

        // Gerar cópia rápida e personalizar sem mexer no protótipo
        DocumentTemplate cvAna = reg.cloneOf("resume");
        cvAna.customize("#AA0000", "Montserrat", "assets/logo-ana.png", "Ana S.A.");

        DocumentTemplate propBruno = reg.cloneOf("proposal");
        propBruno.customize("#00AA88", "OpenSans", "assets/logo-bruno.png", "Bruno LTDA");

        System.out.println(cvAna);
        System.out.println(propBruno);

        // Verifique que os protótipos originais permanecem inalterados:
        System.out.println(reg.cloneOf("resume"));   // sem a seção personalizada
        System.out.println(reg.cloneOf("proposal")); // sem a seção personalizada
    }
}