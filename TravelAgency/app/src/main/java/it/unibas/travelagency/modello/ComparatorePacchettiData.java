package it.unibas.travelagency.modello;

import java.util.Comparator;

public class ComparatorePacchettiData implements Comparator<Pacchetto> {

    @Override
    public int compare(Pacchetto o1, Pacchetto o2) {
        return o1.getDataPartenza().getTime().compareTo(o2.getDataPartenza().getTime());
    }

}
