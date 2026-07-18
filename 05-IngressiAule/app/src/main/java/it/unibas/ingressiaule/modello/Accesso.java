package it.unibas.ingressiaule.modello;

import java.util.Calendar;

public class Accesso {

    private String matricola;
    private String nomeStudente;
    private int permanenza;
    private String motivazione;
    private Calendar data;

    public Accesso(String matricola, String nomeStudente, int permanenza, String motivazione, Calendar data) {
        this.matricola = matricola;
        this.nomeStudente = nomeStudente;
        this.permanenza = permanenza;
        this.motivazione = motivazione;
        this.data = data;
    }

    public String getMatricola() {
        return matricola;
    }

    public String getNomeStudente() {
        return nomeStudente;
    }

    public int getPermanenza() {
        return permanenza;
    }

    public String getMotivazione() {
        return motivazione;
    }

    public Calendar getData() {
        return data;
    }

}
