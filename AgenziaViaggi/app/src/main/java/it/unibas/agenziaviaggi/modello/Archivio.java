package it.unibas.agenziaviaggi.modello;

import it.unibas.agenziaviaggi.Costanti;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Archivio {
    
    private List<Agenzia> listaAgenzie = new ArrayList<>();
    
    public List<Agenzia> getListaAgenzie() {
        return listaAgenzie;
    }

    //Metodo per agigungere una nuova agenzia alla lista delle agenzie
    public void aggiungiAgenzia(Agenzia agenzia) {
        this.listaAgenzie.add(agenzia);
    }

    //Metodo per cercare le agenzie in base alla citta 
    public List<Agenzia> cercaPerCitta(String citta, String criterioOrdinamento) {
        List<Agenzia> listaFiltrata = new ArrayList<>();
        for (Agenzia altraAgenzia : listaAgenzie) {
            if (altraAgenzia.getCittà().equalsIgnoreCase(citta)) {
                listaFiltrata.add(altraAgenzia);
            }
        }
        if (criterioOrdinamento.equals(Costanti.ORDINAMENTO_CRESCENTE)) {
            Collections.sort(listaFiltrata, new ComparatoreNomeCrescente());
        } else {
            Collections.sort(listaFiltrata, new ComparatoreNomeDecrescente());
        }
        return listaFiltrata;
    }
    
}
