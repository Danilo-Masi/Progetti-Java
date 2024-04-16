package it.unibas.bookrental.modello;

import java.util.ArrayList;
import java.util.List;

public class Utente {

    private String nomeUtente;
    private String nome;
    private String cognome;
    private List<Libro> listaLibri = new ArrayList<>();

    public Utente(String nomeUtente, String nome, String cognome) {
        this.nomeUtente = nomeUtente;
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public List<Libro> getListaLibri() {
        return listaLibri;
    }

    //Metodo per aggiungere un Libro alla lista dei libri
    public void aggiungiLibro(Libro libro) {
        this.listaLibri.add(libro);
    }

    //Metodo che resituisce il numero di libri presi in prestito ma non ancora restituiti
    public int getNumeroLibriNonResituiti() {
        int conta = 0;
        for (Libro libro : listaLibri) {
            if (libro.getDataFinePrestito() == null) {
                conta++;
            }
        }
        return conta;
    }

}
