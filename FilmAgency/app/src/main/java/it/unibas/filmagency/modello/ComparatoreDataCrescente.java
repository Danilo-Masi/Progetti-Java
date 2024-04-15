package it.unibas.filmagency.modello;

import java.util.Comparator;

public class ComparatoreDataCrescente implements Comparator<Film> {

    @Override
    public int compare(Film o1, Film o2) {
        return o1.getDataUscita().compareTo(o2.getDataUscita());
    }
}
