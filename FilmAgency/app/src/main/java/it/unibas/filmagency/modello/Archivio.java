package it.unibas.filmagency.modello;

import it.unibas.filmagency.Costanti;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Archivio {

    private List<Film> listaFilm = new ArrayList<>();

    public List<Film> getListaFilm() {
        return listaFilm;
    }

    public void aggiungiFilm(Film film) {
        this.listaFilm.add(film);
    }

    public List<Film> cercaFilmPerData(Calendar dataInserita, String criterio) {
        List<Film> listaFiltrata = new ArrayList<>();
        for (Film film : listaFilm) {
            if (film.getDataUscita().before(dataInserita)) {
                listaFiltrata.add(film);
            }
        }
        if (criterio.equalsIgnoreCase(Costanti.ORDINAMENTO_CRESCENTE)) {
            Collections.sort(listaFiltrata, new ComparatoreDataCrescente());
        } else {
            Collections.sort(listaFiltrata, new ComparatoreDataDecrescente());
        }
        return listaFiltrata;
    }

    //Metodo che conta gli attori per ogni nazionalità
    public List<DatiFilm> calcolaAttoriPerNazionalità(List<Attore> listaAttori) {
        Map<String, DatiFilm> mappaDatiFilm = new HashMap<>();
        for (Attore attore : listaAttori) {
            String nazionalita = attore.getNazionalita();
            DatiFilm datiFilm = mappaDatiFilm.get(nazionalita);
            if (datiFilm == null) {
                datiFilm = new DatiFilm(nazionalita);
                mappaDatiFilm.put(nazionalita, datiFilm);
            }
            datiFilm.setNumeroAttori(datiFilm.getNumeroAttori() + 1);
        }
        List<DatiFilm> listaDatiFilm = new ArrayList<>(mappaDatiFilm.values());
        return listaDatiFilm;
    }

    public boolean verificaDuplicati() {
        //Prendo tutti gli attori presenti in tutti i film
        List<Attore> listaAttori = new ArrayList<>();
        for (Film film : listaFilm) {
            listaAttori.addAll(film.getListaAttori());
        }
        int size = listaAttori.size();
        for (int i = 0; i < size - 1; i++) {
            Attore a1 = listaAttori.get(i);
            for (int j = i + 1; j < size - 1; j++) {
                Attore a2 = listaAttori.get(j);
                if (a1.getNomeECognome().equalsIgnoreCase(a2.getNomeECognome())) {
                    return true;
                }
            }
        }
        return false;
    }
}
