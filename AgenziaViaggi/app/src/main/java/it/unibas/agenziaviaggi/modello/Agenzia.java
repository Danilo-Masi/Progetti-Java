package it.unibas.agenziaviaggi.modello;

import java.util.ArrayList;
import java.util.List;

public class Agenzia {

    private int codice;
    private String nome;
    private String città;
    private boolean prenotazioneOnline;
    private List<Pacchetto> listaPacchetti = new ArrayList<>();

    public Agenzia(int codice, String nome, String città, boolean prenotazioneOnline) {
        this.codice = codice;
        this.nome = nome;
        this.città = città;
        this.prenotazioneOnline = prenotazioneOnline;
    }

    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public String getCittà() {
        return città;
    }

    public boolean isPrenotazioneOnline() {
        return prenotazioneOnline;
    }

    public List<Pacchetto> getListaPacchetti() {
        return listaPacchetti;
    }

    //Metodo per aggiungere un nuovo pacchetto alla lista dei pacchetti
    public void aggiungiPacchetto(Pacchetto pacchetto) {
        this.listaPacchetti.add(pacchetto);
    }

}
