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
    private List<Domanda> listaDomande = new ArrayList<>();

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

    public String getDescrizione() {
        return descrizione;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public String getRegione() {
        return regione;
    }

    public Calendar getDataOra() {
        return dataOra;
    }

    public List<Domanda> getDomande() {
        return listaDomande;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Codice: ").append(codice);
        sb.append("Descrizione: ").append(descrizione);
        sb.append("Numero posti: ").append(numeroPosti);
        sb.append("Regione: ").append(regione);
        sb.append("Data e ora: ").append(dataOra);
        sb.append("Lista domande: ").append(listaDomande);
        return sb.toString();
    }

    public void aggiungiDomanda(Domanda domanda) {
        this.listaDomande.add(domanda);
    }

    public boolean isContieneDomanda(String codiceFiscale) {
        for (Domanda domanda : listaDomande) {
            if (domanda.getCodiceFiscaleRichiedente().equalsIgnoreCase(codiceFiscale)) {
                return true;
            }
        }
        return false;
    }
}
