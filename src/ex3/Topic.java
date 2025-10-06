package src.ex3;

import java.util.*;

class Topic {

    private final String name;
    private final Set<Subscriber> subscribers = new HashSet<>();

    public Topic(String name) {
        this.name = name;
    }

    public void subscribe(Subscriber s) {
        subscribers.add(s);
    }

    public void unsubscribe(Subscriber s) {
        subscribers.remove(s);
    }

    public void publish(String newsTitle) {
        // Notifica todos os inscritos
        for (Subscriber s : subscribers) {
            s.update(name, newsTitle);
        }
    }
}
