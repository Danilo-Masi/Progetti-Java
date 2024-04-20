package it.unibas.banktransactions.modello;

import java.util.Comparator;

public class ComparatoreDataCrescente implements Comparator<ContoCorrente> {

    @Override
    public int compare(ContoCorrente o1, ContoCorrente o2) {
        return o1.getDataSottoscrizione().compareTo(o2.getDataSottoscrizione());
    }

}
