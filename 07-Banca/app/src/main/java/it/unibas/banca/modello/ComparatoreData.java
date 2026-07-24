package it.unibas.banca.modello;

import java.util.Comparator;

public class ComparatoreData implements Comparator<Conto> {

    @Override
    public int compare(Conto o1, Conto o2) {
        return o1.getDataSottoscrizione().compareTo(o2.getDataSottoscrizione());
    }

}
