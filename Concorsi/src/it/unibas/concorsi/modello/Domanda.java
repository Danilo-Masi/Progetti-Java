package it.unibas.concorsi.modello;

import java.util.Calendar;

public class Domanda {

    private String codiceFiscaleRichiedente;
    private String sessoRichiedente;
    private Calendar dataPresentazione;

    public Domanda(String codiceFiscaleRichiedente, String sessoRichiedente, Calendar dataPresentazione) {
        this.codiceFiscaleRichiedente = codiceFiscaleRichiedente;
        this.sessoRichiedente = sessoRichiedente;
        this.dataPresentazione = dataPresentazione;
    }

    public String getCodiceFiscaleRichiedente() {
        return codiceFiscaleRichiedente;
    }

    public void setCodiceFiscaleRichiedente(String codiceFiscaleRichiedente) {
        this.codiceFiscaleRichiedente = codiceFiscaleRichiedente;
    }

    public String getSessoRichiedente() {
        return sessoRichiedente;
    }

    public void setSessoRichiedente(String sessoRichiedente) {
        this.sessoRichiedente = sessoRichiedente;
    }

    public Calendar getDataPresentazione() {
        return dataPresentazione;
    }

    public void setDataPresentazione(Calendar dataPresentazione) {
        this.dataPresentazione = dataPresentazione;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("codiceFiscaleRichiedente=").append(codiceFiscaleRichiedente);
        sb.append(", sessoRichiedente=").append(sessoRichiedente);
        sb.append(", dataPresentazione=").append(dataPresentazione);
        return sb.toString();
    }

}
