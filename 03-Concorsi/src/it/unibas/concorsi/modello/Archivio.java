package it.unibas.concorsi.modello;

import java.util.ArrayList;
import java.util.Calendar;
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

    public boolean isDomandaIncompatibile(String codiceFiscale, Concorso concorso) {
        for (Concorso altroConcorso : concorsi) {
            if (!altroConcorso.getRegione().equalsIgnoreCase(concorso.getRegione())
                    && isStessoGiorno(concorso, altroConcorso)
                    && altroConcorso.isContieneDomanda(codiceFiscale)) {
                return true;

            }
        }
        return false;
    }

    private boolean isStessoGiorno(Concorso concorso, Concorso altroConcorso) {
        Calendar c1 = concorso.getDataOra();
        Calendar c2 = altroConcorso.getDataOra();
        int anno1 = c1.get(Calendar.YEAR);
        int mese1 = c1.get(Calendar.MONTH);
        int giorno1 = c1.get(Calendar.DAY_OF_MONTH);
        int anno2 = c2.get(Calendar.YEAR);
        int mese2 = c2.get(Calendar.MONTH);
        int giorno2 = c2.get(Calendar.DAY_OF_MONTH);
        return (anno1 == anno2 && mese1 == mese2 && giorno1 == giorno2);
    }

}
