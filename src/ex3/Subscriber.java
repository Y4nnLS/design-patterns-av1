package src.ex3;

public interface Subscriber {
    void update(String topicName, String newsTitle);
    String getName();
}