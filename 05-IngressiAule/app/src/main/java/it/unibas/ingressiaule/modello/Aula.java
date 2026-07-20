package it.unibas.ingressiaule.modello;

import java.util.ArrayList;
import java.util.List;

public class Aula implements Comparable<Aula> {

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

    @Override
    public int compareTo(Aula o) {
        return this.getNome().compareTo(o.getNome());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Codice: ").append(codice).append("\t");
        sb.append("Nome: ").append(nome).append("\t");
        sb.append("Piano: ").append(piano).append("\t");
        sb.append("Lista Accessi: ").append(listaAccessi).append("\t");
        return sb.toString();
    }

}
