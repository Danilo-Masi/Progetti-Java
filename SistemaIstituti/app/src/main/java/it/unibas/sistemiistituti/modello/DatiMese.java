package it.unibas.sistemiistituti.modello;

import java.util.Comparator;

public class DatiMese implements Comparator<DatiMese> {

    private int mese;
    private int numeroClassi;

    public DatiMese() {
    }

    public DatiMese(int mese) {
        this.mese = mese;
        this.numeroClassi = 0;
    }

    public int getMese() {
        return mese;
    }

    public int getNumeroClassi() {
        return numeroClassi;
    }

    public void setNumeroClassi(int numeroClassi) {
        this.numeroClassi = numeroClassi;
    }

    @Override
    public String toString() {
        return "Mese: " + mese + ", Classi: " + numeroClassi;
    }

    @Override
    public int compare(DatiMese o1, DatiMese o2) {
        int size1 = o1.getNumeroClassi();
        int size2 = o2.getNumeroClassi();

        if (size1 > size2) {
            return -1;
        } else if (size1 < size2) {
            return 1;
        } else {
            return 0;
        }
    }

}
