package it.unibas.travelagency.modello;

import java.util.Calendar;

public class Pacchetto {

    private String destinazione;
    private double importo;
    private Calendar dataPartenza;
    private int durata;
    private String tipologia;

    public Pacchetto(String destinazione, double importo, Calendar dataPartenza, int durata, String tipologia) {
        this.destinazione = destinazione;
        this.importo = importo;
        this.dataPartenza = dataPartenza;
        this.durata = durata;
        this.tipologia = tipologia;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public double getImporto() {
        return importo;
    }

    public Calendar getDataPartenza() {
        return dataPartenza;
    }

    public int getDurata() {
        return durata;
    }

    public String getTipologia() {
        return tipologia;
    }

}
