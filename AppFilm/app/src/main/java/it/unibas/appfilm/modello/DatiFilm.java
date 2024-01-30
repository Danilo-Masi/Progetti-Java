package it.unibas.appfilm.modello;

import java.util.Comparator;

public class DatiFilm implements Comparator<DatiFilm> {

    private String nazione;
    private int numeroAttori;

    public DatiFilm() {
    }

    public DatiFilm(String nazione) {
        this.nazione = nazione;
        this.numeroAttori = 0;
    }

    public String getNazione() {
        return nazione;
    }

    public void setNazione(String nazione) {
        this.nazione = nazione;
    }

    public int getNumeroAttori() {
        return numeroAttori;
    }

    public void setNumeroAttori(int numeroAttori) {
        this.numeroAttori = numeroAttori;
    }

    @Override
    public int compare(DatiFilm o1, DatiFilm o2) {
        int size1 = o1.getNumeroAttori();
        int size2 = o2.getNumeroAttori();

        if (size1 > size2) {
            return -1;
        } else if (size1 < size2) {
            return 1;
        } else {
            return 0;
        }
    }

}
