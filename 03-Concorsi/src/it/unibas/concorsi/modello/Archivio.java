package it.unibas.concorsi.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
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

    public boolean isDomandaIncompatibile(String codiceFiscale, Concorso concorso) {
        for (Concorso altroConcorso : listaConcorsi) {
            if (!altroConcorso.getRegione().equalsIgnoreCase(concorso.getRegione())
                    && isStessoGiorno(concorso, altroConcorso)
                    && altroConcorso.isContieneDomanda(codiceFiscale)) {
                return true;
            }
        }
        return false;
    }

    private boolean isStessoGiorno(Concorso concorso, Concorso altroConcorso) {
        Calendar c1 = concorso.getDataEOra();
        int anno1 = c1.get(Calendar.YEAR);
        int mese1 = c1.get(Calendar.MONTH);
        int giorno1 = c1.get(Calendar.DAY_OF_MONTH);
        Calendar c2 = altroConcorso.getDataEOra();
        int anno2 = c2.get(Calendar.YEAR);
        int mese2 = c2.get(Calendar.MONTH);
        int giorno2 = c2.get(Calendar.DAY_OF_MONTH);
        return (anno1 == anno2 && mese1 == mese2 && giorno1 == giorno2);
    }

}
