package it.unibas.concorsi.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Archivio {
    
    private List<Concorso> concorsi = new ArrayList<>();
    
    public List<Concorso> getConcorsi() {
        return concorsi;
    }
    
    public void addConcorso(Concorso e) {
        this.concorsi.add(e);
    }
    
    public List<Concorso> getConcorsiOrdinatiInRegione(String regione, String criterioOrdinamento) {
        List<Concorso> listaFiltrata = new ArrayList<>();
        for (Concorso concorso : concorsi) {
            if (concorso.getRegione().equalsIgnoreCase(regione)) {
                listaFiltrata.add(concorso);
            }
        }
        //Ordina la lista in base al criterio di ordinamento passato
        if (criterioOrdinamento.equals(Costanti.CRITERIO_DATA)) {
            Collections.sort(listaFiltrata, new ComparatoreConcorsiData());
        } else {
            Collections.sort(listaFiltrata, new ComparatoreConcorsiPosti());
        }
        
        return listaFiltrata;
    }
    
}
