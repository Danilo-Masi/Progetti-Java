package it.unibas.concorsi.modello;

import java.util.Calendar;

public class Domanda {

    private String codiceFiscale;
    private String sesso;
    private Calendar dataDomanda;

    public Domanda(String codiceFiscale, String sesso, Calendar dataDomanda) {
        this.codiceFiscale = codiceFiscale;
        this.sesso = sesso;
        this.dataDomanda = dataDomanda;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getSesso() {
        return sesso;
    }

    public Calendar getDataDomanda() {
        return dataDomanda;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Codice fiscale: ").append(codiceFiscale);
        sb.append("Sesso: ").append(sesso);
        sb.append("Data domanda: ").append(dataDomanda);
        return sb.toString();
    }

}
