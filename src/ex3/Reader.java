package src.ex3;

class Reader implements Subscriber {

    private final String name;

    public Reader(String name) {
        this.name = name;
    }

    @Override
    public void update(String topicName, String newsTitle) {
        System.out.printf("Leitor %s recebeu em [%s]: %s%n", name, topicName, newsTitle);
    }

    @Override
    public String getName() {
        return name;
    }
}
