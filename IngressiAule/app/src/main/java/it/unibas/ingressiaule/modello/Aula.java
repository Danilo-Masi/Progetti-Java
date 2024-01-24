package it.unibas.ingressiaule.modello;

import java.util.ArrayList;
import java.util.List;

public class Aula implements Comparable<Aula>{

    private String codice;
    private String nomeAula;
    private int piano;
    private List<Accesso> listaAccessi = new ArrayList<>();

    public Aula(String codice, String nomeAula, int piano) {
        this.codice = codice;
        this.nomeAula = nomeAula;
        this.piano = piano;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getNomeAula() {
        return nomeAula;
    }

    public void setNomeAula(String nomeAula) {
        this.nomeAula = nomeAula;
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
    
    //Metodo per aggiungere un accesso alla lista
    public void addAccesso(Accesso accesso) {
        this.listaAccessi.add(accesso);
    }

    @Override
    public int compareTo(Aula o) {
        return this.getNomeAula().compareTo(o.getNomeAula());
    }

}
