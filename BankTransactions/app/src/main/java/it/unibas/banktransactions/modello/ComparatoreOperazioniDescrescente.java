package it.unibas.banktransactions.modello;

import java.util.Comparator;

public class ComparatoreOperazioniDescrescente implements Comparator<DatiMovimento> {

    @Override
    public int compare(DatiMovimento o1, DatiMovimento o2) {
        int ordine;
        if (o1.getNumeroOperazioni() < o2.getNumeroOperazioni()) {
            ordine = 1;
        } else if (o1.getNumeroOperazioni() == o2.getNumeroOperazioni()) {
            ordine = 0;
        } else {
            ordine = -1;
        }
        return ordine;
    }

}
