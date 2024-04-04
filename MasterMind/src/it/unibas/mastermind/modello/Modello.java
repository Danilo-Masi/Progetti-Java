package it.unibas.mastermind.modello;

import java.util.HashMap;
import java.util.Map;

public class Modello {

    Map<String, Object> beans = new HashMap<>();

    public void putBeans(String key, Object value) {
        this.beans.put(key, value);
    }

    public Object getBeans(String key) {
        return this.beans.get(key);
    }

}
