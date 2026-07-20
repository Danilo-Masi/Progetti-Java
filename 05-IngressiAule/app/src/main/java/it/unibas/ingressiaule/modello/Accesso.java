package it.unibas.ingressiaule.modello;

import java.util.Calendar;

public class Accesso {

    private String matricola;
    private String nomeStudente;
    private String motivazione;
    private int permanenza;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matricola: ").append(matricola).append("\t");
        sb.append("Nome studente: ").append(nomeStudente).append("\t");
        sb.append("Permanenza (min): ").append(permanenza).append("\t");
        sb.append("Motivazione: ").append(motivazione).append("\t");
        sb.append("Data: ").append(data).append("\t");
        return sb.toString();
    }

}
