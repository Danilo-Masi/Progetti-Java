package it.unibas.filmagency.modello;

public class Attore {

    private String nomeECognome;
    private String nazionalita;
    private int annoNascita;

    public Attore(String nomeECognome, String nazionalita, int annoNascita) {
        this.nomeECognome = nomeECognome;
        this.nazionalita = nazionalita;
        this.annoNascita = annoNascita;
    }

    public String getNomeECognome() {
        return nomeECognome;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public int getAnnoNascita() {
        return annoNascita;
    }

}
