package it.unibas.banca.modello;

import java.util.Comparator;

public class ComparatoreNome implements Comparator<Conto> {

    @Override
    public int compare(Conto o1, Conto o2) {
        return o1.getNomeIntestatario().compareTo(o2.getNomeIntestatario());
    }

}
