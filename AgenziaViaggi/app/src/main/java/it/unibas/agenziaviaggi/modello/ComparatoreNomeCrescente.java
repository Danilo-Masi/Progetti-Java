package it.unibas.agenziaviaggi.modello;

import java.util.Comparator;

public class ComparatoreNomeCrescente implements Comparator<Agenzia>{

    @Override
    public int compare(Agenzia o1, Agenzia o2) {
        return o1.getNome().compareTo(o2.getNome());
    }

}
