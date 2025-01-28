package it.unibas.concorsi.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Archivio {

    private List<Concorso> concorsi = new ArrayList<>();

    public void aggiungiConcorso(Concorso concorso) {
        this.concorsi.add(concorso);
    }

    public List<Concorso> getConcorsi() {
        return this.concorsi;
    }

    public List<Concorso> getConcorsiOrdinatiInRegione(String regione, String criterioOrdinamento) {
        List<Concorso> listafiltrata = new ArrayList<>();
        for (Concorso concorso : concorsi) {
            if (concorso.getRegione().equalsIgnoreCase(regione)) {
                listafiltrata.add(concorso);
            }
        }
        if (criterioOrdinamento.equalsIgnoreCase(Costanti.CRITERIO_DATA)) {
            Collections.sort(listafiltrata, new ComparatoreConcorsiData());
        } else {
            Collections.sort(listafiltrata, new ComparatoreConcorsiPosti());
        }
        return listafiltrata;
    }

}
