package it.unibas.companydetails.modello;

import java.util.Comparator;

public class ComparatoreCrescente implements Comparator<Azienda> {

    @Override
    public int compare(Azienda o1, Azienda o2) {
        return o1.getCittaSede().compareTo(o2.getCittaSede());
    }

}
