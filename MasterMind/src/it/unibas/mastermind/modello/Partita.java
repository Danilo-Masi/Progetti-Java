package it.unibas.mastermind.modello;

import java.util.List;
import java.util.ArrayList;

public class Partita {

    private Combinazione combinazioneNascosta;
    private List<Risposta> listaRisposte = new ArrayList<>();

    public Partita(Combinazione combinazioneNascosta) {
        this.combinazioneNascosta = combinazioneNascosta;
    }

    public void aggiungiRisposta(Risposta risposta) {
        listaRisposte.add(risposta);
    }

    public Combinazione getCombinazioneNascosta() {
        return combinazioneNascosta;
    }

    public List<Risposta> getListaRisposte() {
        return listaRisposte;
    }
    
    public int getNumeroTentativi() {
        return listaRisposte.size();
    }

}
