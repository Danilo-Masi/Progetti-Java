package it.unibas.filmagency.modello;

public class DatiFilm {

    private String nazione;
    private int numeroAttori;

    public DatiFilm(String nazione) {
        this.nazione = nazione;
        this.numeroAttori = 0;
    }

    public DatiFilm() {
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public int getNumeroAttori() {
        return numeroAttori;
    }

    public void setNumeroAttori(int numeroAttori) {
        this.numeroAttori = numeroAttori;
    }

}
