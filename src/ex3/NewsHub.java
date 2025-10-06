package src.ex3;

import java.util.*;

class NewsHub {

    private final Map<String, Topic> topics = new HashMap<>();

    public Topic getOrCreateTopic(String name) {
        return topics.computeIfAbsent(name, Topic::new);
    }
}
