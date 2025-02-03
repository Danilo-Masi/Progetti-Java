package it.unibas.ingressiaule.modello;

import java.util.Calendar;

public class Accesso {

    private String matricolaStudente;
    private String nomeStudente;
    private int minutiPermanenza;
    private String motivazione;
    private Calendar data;

    public Accesso(String matricolaStudente, String nomeStudente, int minutiPermanenza, String motivazione, Calendar data) {
        this.matricolaStudente = matricolaStudente;
        this.nomeStudente = nomeStudente;
        this.minutiPermanenza = minutiPermanenza;
        this.motivazione = motivazione;
        this.data = data;
    }

    public String getMatricolaStudente() {
        return matricolaStudente;
    }

    public void setMatricolaStudente(String matricolaStudente) {
        this.matricolaStudente = matricolaStudente;
    }

    public String getNomeStudente() {
        return nomeStudente;
    }

    public void setNomeStudente(String nomeStudente) {
        this.nomeStudente = nomeStudente;
    }

    public int getMinutiPermanenza() {
        return minutiPermanenza;
    }

    public void setMinutiPermanenza(int minutiPermanenza) {
        this.minutiPermanenza = minutiPermanenza;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matricola studente: ").append(matricolaStudente).append("\n");
        sb.append("Nome studente: ").append(nomeStudente).append("\n");
        sb.append("Minuti di permanenza: ").append(minutiPermanenza).append("\n");
        sb.append("Motivazione: ").append(motivazione).append("\n");
        sb.append("Data: ").append(data);
        return sb.toString();
    }

}
