package it.unibas.compravenditeauto.modello;

import java.util.Comparator;

public class ComparatoreNomeDecrescente implements Comparator<Auto> {

    @Override
    public int compare(Auto o1, Auto o2) {
        return o2.getModello().compareTo(o1.getModello());
    }

}
