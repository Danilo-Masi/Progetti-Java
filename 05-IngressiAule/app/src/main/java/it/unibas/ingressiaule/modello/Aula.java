package it.unibas.ingressiaule.modello;

import java.util.ArrayList;
import java.util.List;

public class Aula {

    private String codice;
    private String nome;
    private int piano;
    private List<Accesso> listaAccessi = new ArrayList<>();

    public Aula(String codice, String nome, int piano) {
        this.codice = codice;
        this.nome = nome;
        this.piano = piano;
    }

    public String getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public int getPiano() {
        return piano;
    }

    public List<Accesso> getListaAccessi() {
        return listaAccessi;
    }

    public void aggiungiAccesso(Accesso accesso) {
        this.listaAccessi.add(accesso);
    }

}
