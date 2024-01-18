package it.unibas.ricettario.modello;

import java.util.HashMap;
import java.util.Map;

public class Modello {

    private Map<String, Object> beans = new HashMap<>();

    //Metodo per impostare un elemento alla mappa
    public void putBean(String chiave, Object valore) {
        this.beans.put(chiave, valore);
    }

    //Metodo per prelevare un elemento dalla mappa
    public Object getBeans(String chiave) {
        return this.beans.get(chiave);
    }

}
