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

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPiano() {
        return piano;
    }

    public void setPiano(int piano) {
        this.piano = piano;
    }

    public List<Accesso> getListaAccessi() {
        return listaAccessi;
    }

    public void setListaAccessi(List<Accesso> listaAccessi) {
        this.listaAccessi = listaAccessi;
    }

    public void aggiungiAccesso(Accesso accesso) {
        this.listaAccessi.add(accesso);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Codice: ").append(codice).append("\n");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Piano: ").append(piano).append("\n");
        sb.append("Lista accessi: ").append(listaAccessi).append("\n");
        return sb.toString();
    }

}
