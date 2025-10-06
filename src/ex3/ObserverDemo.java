package src.ex3;

public class ObserverDemo {
    public static void main(String[] args) {
        NewsHub hub = new NewsHub();

        Topic politica   = hub.getOrCreateTopic("Política");
        Topic esportes   = hub.getOrCreateTopic("Esportes");
        Topic tecnologia = hub.getOrCreateTopic("Tecnologia");

        Subscriber ana   = new Reader("Ana");
        Subscriber bruno = new Reader("Bruno");
        Subscriber cata  = new Reader("Catarina");

        politica.subscribe(ana);
        politica.subscribe(bruno);

        esportes.subscribe(bruno);
        esportes.subscribe(cata);

        tecnologia.subscribe(ana);

        politica.publish("Reforma aprovada na Câmara");
        esportes.publish("Time X vence final");
        tecnologia.publish("Novo chipset lançado");
    }
}