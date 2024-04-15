package it.unibas.filmagency.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Film {

    private String nomeFilm;
    private Calendar dataUscita;
    private String regista;
    private String genere;
    private List<Attore> listaAttori = new ArrayList<>();

    public Film(String nomeFilm, Calendar dataUscita, String regista, String genere) {
        this.nomeFilm = nomeFilm;
        this.dataUscita = dataUscita;
        this.regista = regista;
        this.genere = genere;
    }

    public String getNomeFilm() {
        return nomeFilm;
    }

    public Calendar getDataUscita() {
        return dataUscita;
    }

    public String getRegista() {
        return regista;
    }

    public String getGenere() {
        return genere;
    }

    public List<Attore> getListaAttori() {
        return listaAttori;
    }

    public void aggiungiAttore(Attore attore) {
        this.listaAttori.add(attore);
    }

}
