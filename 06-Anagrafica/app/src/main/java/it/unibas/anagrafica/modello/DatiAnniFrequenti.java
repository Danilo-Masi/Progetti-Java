package it.unibas.anagrafica.modello;

public class DatiAnniFrequenti implements Comparable<DatiAnniFrequenti> {

    private String regione;
    private int anno;
    private int numeroAssunzioni;

    public DatiAnniFrequenti(String regione, int anno, int numeroAssunzioni) {
        this.regione = regione;
        this.anno = anno;
        this.numeroAssunzioni = numeroAssunzioni;
    }

    public String getRegione() {
        return regione;
    }

    public int getAnno() {
        return anno;
    }

    public int getNumeroAssunzioni() {
        return numeroAssunzioni;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("regione=").append(regione);
        sb.append(", anno=").append(anno);
        sb.append(", numeroAssunzioni=").append(numeroAssunzioni);
        return sb.toString();
    }

    @Override
    public int compareTo(DatiAnniFrequenti o) {
        if (o.getAnno() > this.getAnno()) {
            return -1;
        } else if (o.getAnno() < this.getAnno()) {
            return 1;
        } else {
            return 0;
        }
    }

}
