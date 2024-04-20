package it.unibas.banktransactions.modello;

import java.util.HashMap;
import java.util.Map;

public class Modello {

    private Map<String, Object> beans = new HashMap<>();

    public Object getBeans(String key) {
        return this.beans.get(key);
    }

    public void putBeans(String key, Object value) {
        this.beans.put(key, value);
    }

}
