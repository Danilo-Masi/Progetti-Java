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

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getNomeStudente() {
        return nomeStudente;
    }

    public void setNomeStudente(String nomeStudente) {
        this.nomeStudente = nomeStudente;
    }

    public int getPermanenza() {
        return permanenza;
    }

    public void setPermanenza(int permanenza) {
        this.permanenza = permanenza;
    }

    public String getMotivazione() {
        return motivazione;
    }

    public void setMotivazione(String motivazione) {
        this.motivazione = motivazione;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

}
