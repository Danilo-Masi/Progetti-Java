package it.unibas.filmagency.modello;

import java.util.Comparator;

public class ComparatoreDataDecrescente implements Comparator<Film> {

    @Override
    public int compare(Film o1, Film o2) {
        return o2.getDataUscita().compareTo(o1.getDataUscita());
    }

}
