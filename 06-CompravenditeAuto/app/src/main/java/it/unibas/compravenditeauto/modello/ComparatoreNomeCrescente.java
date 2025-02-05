package it.unibas.compravenditeauto.modello;

import java.util.Comparator;

public class ComparatoreNomeCrescente implements Comparator<Auto> {

    @Override
    public int compare(Auto o1, Auto o2) {
        return o1.getModello().compareTo(o2.getModello());
    }

}
