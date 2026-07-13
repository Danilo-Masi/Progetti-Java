package it.unibas.concorsi.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Archivio {

    private List<Concorso> listaConcorsi = new ArrayList<>();

    public List<Concorso> getListaConcorsi() {
        return listaConcorsi;
    }

    public void aggiungiConcorso(Concorso c) {
        this.listaConcorsi.add(c);
    }

    public List<Concorso> cercaConcorsiPerRegione(String regione, String criterioOrdinamento) {
        List<Concorso> listaFiltrata = new ArrayList<>();
        for (Concorso concorso : listaConcorsi) {
            if (concorso.getRegione().equalsIgnoreCase(regione)) {
                listaFiltrata.add(concorso);
            }
        }
        if (criterioOrdinamento.equalsIgnoreCase(Costanti.ORDINAMENTO_DATA)) {
            Collections.sort(listaFiltrata, new ComparatoreConcorsiData());
        } else {
            Collections.sort(listaFiltrata, new ComparatoreConcorsiPosti());
        }
        return listaFiltrata;
    }

}
