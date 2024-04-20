package it.unibas.banktransactions.modello;

import java.util.Comparator;

public class ComparatoreNomeCrescente implements Comparator<ContoCorrente> {

    @Override
    public int compare(ContoCorrente o1, ContoCorrente o2) {
        return o1.getCredenzialiIntestario().compareTo(o2.getCredenzialiIntestario());
    }

}
