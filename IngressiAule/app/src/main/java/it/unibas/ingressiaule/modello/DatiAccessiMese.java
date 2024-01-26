package it.unibas.ingressiaule.modello;

public class DatiAccessiMese implements Comparable<DatiAccessiMese> {

    private int mese;
    private String tipologia;
    private int tempoTotale;

    public DatiAccessiMese(int mese, String tipologia, int tempoTotale) {
        this.mese = mese;
        this.tipologia = tipologia;
        this.tempoTotale = tempoTotale;
    }

    public int getMese() {
        return mese;
    }

    public String getTipologia() {
        return tipologia;
    }

    public int getTempoTotale() {
        return tempoTotale;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("mese=").append(mese);
        sb.append(", tipologia=").append(tipologia);
        sb.append(", tempoTotale=").append(tempoTotale);
        return sb.toString();
    }

    @Override
    public int compareTo(DatiAccessiMese o) {
        if (this.getMese() < o.getMese()) {
            return -1;
        } else if (this.getMese() > o.getMese()) {
            return 1;
        } else {
            return 0;
        }
    }

}
