package it.unibas.concorsi.modello;

import java.util.Comparator;

public class ComparatoreConcorsiPosti implements Comparator<Concorso> {

    @Override
    public int compare(Concorso o1, Concorso o2) {
        return o2.getNumeroPosti() - o1.getNumeroPosti();
    }

}
