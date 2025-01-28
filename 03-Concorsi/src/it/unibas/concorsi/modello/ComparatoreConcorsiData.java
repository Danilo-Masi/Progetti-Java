package it.unibas.concorsi.modello;

import java.util.Comparator;

public class ComparatoreConcorsiData implements Comparator<Concorso> {

    @Override
    public int compare(Concorso o1, Concorso o2) {
        return o1.getDataOra().compareTo(o2.getDataOra());
    }

}
