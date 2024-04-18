package it.unibas.bookrental.modello;

import java.util.Calendar;

public class Libro {

    private String nome;
    private String autore;
    private Calendar dataInizioPrestito;
    private Calendar dataFinePrestito;

    public Libro() {
    }

    public Libro(String nome, String autore, Calendar dataInizioPrestito, Calendar dataFinePrestito) {
        this.nome = nome;
        this.autore = autore;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataFinePrestito = dataFinePrestito;
    }

    public String getNome() {
        return nome;
    }

    public String getAutore() {
        return autore;
    }

    public Calendar getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public Calendar getDataFinePrestito() {
        return dataFinePrestito;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Libro{");
        sb.append("nome=").append(nome);
        sb.append(", dataFinePrestito=").append(dataFinePrestito);
        sb.append('}');
        return sb.toString();
    }

}
