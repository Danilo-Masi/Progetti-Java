package it.unibas.agenziaviaggi.modello;

import java.util.Comparator;

public class ComparatoreNomeDecrescente implements Comparator<Agenzia> {

    @Override
    public int compare(Agenzia o1, Agenzia o2) {
        return o2.getNome().compareTo(o1.getNome());
    }

}
