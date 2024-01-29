package it.unibas.appfilm.modello;

import it.unibas.appfilm.Costanti;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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

}
