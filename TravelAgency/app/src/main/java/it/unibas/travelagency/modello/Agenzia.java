package it.unibas.travelagency.modello;

import java.util.ArrayList;
import java.util.List;

public class Agenzia {

    private String codiceUnivoco;
    private String nome;
    private String citta;
    private boolean prenotazioneOnline;
    private List<Pacchetto> listaPacchetti = new ArrayList<>();

    public Agenzia(String codiceUnivoco, String nome, String citta, boolean prenotazioneOnline) {
        this.codiceUnivoco = codiceUnivoco;
        this.nome = nome;
        this.citta = citta;
        this.prenotazioneOnline = prenotazioneOnline;
    }

    public String getCodiceUnivoco() {
        return codiceUnivoco;
    }

    public String getNome() {
        return nome;
    }

    public String getCitta() {
        return citta;
    }

    public boolean isPrenotazioneOnline() {
        return prenotazioneOnline;
    }

    public List<Pacchetto> getListaPacchetti() {
        return listaPacchetti;
    }

    public void aggiungiPacchetto(Pacchetto pacchetto) {
        this.listaPacchetti.add(pacchetto);
    }

}
