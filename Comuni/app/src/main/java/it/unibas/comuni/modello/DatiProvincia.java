package it.unibas.comuni.modello;

public class DatiProvincia implements Comparable<DatiProvincia> {

    private String provincia;
    private int numeroComuni;
    private int totalePopolazione;

    public DatiProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getNumeroComuni() {
        return numeroComuni;
    }

    public void setNumeroComuni(int numeroComuni) {
        this.numeroComuni = numeroComuni;
    }

    public int getTotalePopolazione() {
        return totalePopolazione;
    }

    public void setTotalePopolazione(int totalePopolazione) {
        this.totalePopolazione = totalePopolazione;
    }

    //Metodo per ritornare la media della provincia
    public double getMediaPopolazione() {
        return this.totalePopolazione / (double) this.numeroComuni;
    }

    @Override
    public int compareTo(DatiProvincia o) {
        if (this.getMediaPopolazione() == o.getMediaPopolazione()) {
            return 0;
        } else if (this.getMediaPopolazione() < o.getMediaPopolazione()) {
            return 1;
        }
        return -1;
    }

}
