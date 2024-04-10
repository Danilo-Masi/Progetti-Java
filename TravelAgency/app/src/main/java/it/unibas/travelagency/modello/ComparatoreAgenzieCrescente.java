package it.unibas.travelagency.modello;

import java.util.Comparator;

public class ComparatoreAgenzieCrescente implements Comparator<Agenzia> {

    @Override
    public int compare(Agenzia o1, Agenzia o2) {
        return o1.getNome().compareTo(o2.getNome());
    }

}
