package it.unibas.appfilm.modello;

import it.unibas.appfilm.Costanti;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    private Logger logger = (Logger) LoggerFactory.getLogger(Archivio.class);

    private List<Film> listaFilm = new ArrayList<>();

    public List<Film> getListaFilm() {
        return listaFilm;
    }

    public void setListaFilm(List<Film> listaFilm) {
        this.listaFilm = listaFilm;
    }

    public void aggiungiFilm(Film film) {
        this.listaFilm.add(film);
    }

    //Metodo per cercare i film in base alla data passatagli dall'utente
    public List<Film> cercaPerData(Calendar data, String ordinamento) {
        List<Film> listaFiltrata = new ArrayList<>();
        for (Film film : listaFilm) {
            if (film.getDataUscita().getTime().before(data.getTime())) {
                listaFiltrata.add(film);
            }
        }
        if (ordinamento.equals(Costanti.CRESCENTE)) {
            listaFiltrata.sort(new ComparatoreDataCrescente());
        } else {
            listaFiltrata.sort(new ComparatoreDataDecrescente());
        }
        return listaFiltrata;
    }

    //Metodo per verificare nell'archivio se ci sono utenti duplicati
    public boolean verificaDuplicati() {
        List<Attore> listaAttori = new ArrayList<>();
        for (Film film : listaFilm) {
            listaAttori.addAll(film.getListaAttori());
        }
        int size = listaAttori.size();
        for (int i = 0; i < size - 1; i++) {
            Attore a1 = listaAttori.get(i);

            for (int j = i + 1; j < size - 1; j++) {
                Attore a2 = listaAttori.get(j);
                if (a1.getNomeECognome().equalsIgnoreCase(a2.getNomeECognome())
                        && a1.getDataNascita() == a2.getDataNascita()) {
                    return true;
                }
            }

        }
        return false;
    }

    //Metodo per calcolare quanti attori ci sono per ogni nazionalita
    public List<DatiFilm> calcolaAttoriPerNazionalita(List<Attore> listaAttori) {
        // Creo una mappa per tenere traccia delle informazioni per ciascuna nazionalità
        Map<String, DatiFilm> mappaDatifilm = new HashMap<>();
        // Itero attraverso la lista degli attori
        for (Attore attore : listaAttori) {
            // Prendo la nazionalità di ogni attore
            String nazionalita = attore.getNazionalita();
            // Aggiorno le informazioni del film nella mappa
            DatiFilm datiFilm = mappaDatifilm.get(nazionalita);
            // Se non esiste ancora una voce per questa nazionalità, la creo
            if (datiFilm == null) {
                datiFilm = new DatiFilm(nazionalita);
                mappaDatifilm.put(nazionalita, datiFilm);
            }
            // Incremento il numero di attori per la nazionalità corrente
            datiFilm.setNumeroAttori(datiFilm.getNumeroAttori() + 1);
        }
        // Creo una lista a partire dai valori della mappa (oggetti DatiFilm)
        List<DatiFilm> listaDatiFilm = new ArrayList<>(mappaDatifilm.values());
        // Ordino la lista in base al numero di attori usando il comparatore DatiFilm
        Collections.sort(listaDatiFilm, new DatiFilm());
        // Restituisco la lista ordinata
        return listaDatiFilm;
    }

}
