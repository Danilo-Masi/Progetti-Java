package it.unibas.concorsi.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Concorso {

    private String codice;
    private String descrizione;
    private int numeroPosti;
    private String regione;
    private Calendar dataOra;
    private List<Domanda> domande = new ArrayList<>();

    public Concorso(String codice, String descrizione, int numeroPosti, String regione, Calendar dataOra) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.numeroPosti = numeroPosti;
        this.regione = regione;
        this.dataOra = dataOra;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public Calendar getDataOra() {
        return dataOra;
    }

    public void setDataOra(Calendar dataOra) {
        this.dataOra = dataOra;
    }

    public List<Domanda> getDomande() {
        return domande;
    }

    public void setDomande(List<Domanda> domande) {
        this.domande = domande;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("codice=").append(codice);
        sb.append(", descrizione=").append(descrizione);
        sb.append(", numeroPosti=").append(numeroPosti);
        sb.append(", regione=").append(regione);
        sb.append(", dataOra=").append(dataOra);
        sb.append(", domande=").append(domande);
        return sb.toString();
    }

    public void addDomanda(Domanda e) {
        this.domande.add(e);
    }

    public boolean isContieneDomanda(String codiceFiscale) {
        for (Domanda domanda : domande) {
            if (domanda.getCodiceFiscaleRichiedente().equalsIgnoreCase(codiceFiscale)) {
                return true;
            }
        }
        return false;
    }

}
