package it.unibas.sistemiistituti.modello;

import java.util.Comparator;

public class ComparatoreClassiCrescente implements Comparator<Istituto> {

    @Override
    public int compare(Istituto o1, Istituto o2) {
        int size1 = o1.getListaClassi().size();
        int size2 = o2.getListaClassi().size();

       if(size1 < size2) {
           return -1;
       }else if(size1 > size2) {
           return 1;
       }else {
           return 0;
       }
    }

}
