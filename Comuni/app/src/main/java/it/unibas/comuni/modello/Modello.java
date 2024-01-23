package it.unibas.comuni.modello;

import java.util.HashMap;
import java.util.Map;

public class Modello {

    private Map<String, Object> beans = new HashMap<>();

    public void putBeans(String chiave, Object valore) {
        this.beans.put(chiave, valore);
    }

    public Object getBeans(String chiave) {
        return this.beans.get(chiave);
    }

}
