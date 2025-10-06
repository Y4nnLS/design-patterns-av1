package src.ex5;

import java.util.*;

class PrototypeRegistry {
    private final Map<String, DocumentTemplate> registry = new HashMap<>();

    public void register(String key, DocumentTemplate prototype) {
        registry.put(key, prototype);
    }

    public DocumentTemplate cloneOf(String key) {
        DocumentTemplate proto = registry.get(key);
        if (proto == null) throw new IllegalArgumentException("Protótipo não encontrado: " + key);
        return (DocumentTemplate) proto.cloneDeep();
    }
}