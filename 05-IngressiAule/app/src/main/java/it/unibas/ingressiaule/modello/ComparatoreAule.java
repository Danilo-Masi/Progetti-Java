package it.unibas.ingressiaule.modello;

import java.util.Comparator;

public class ComparatoreAule implements Comparator<Aula> {

    @Override
    public int compare(Aula o1, Aula o2) {
        return o2.getNome().compareToIgnoreCase(o2.getNome());
    }

}
