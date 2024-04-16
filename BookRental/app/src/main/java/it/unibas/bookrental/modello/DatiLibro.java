package it.unibas.bookrental.modello;

public class DatiLibro {

    private String autore;
    private int numLibriNoleggiati;
    private int numLibriDaResituire;

    public DatiLibro(String autore, int numLibriNoleggiati, int numLibriDaResituire) {
        this.autore = autore;
        this.numLibriNoleggiati = numLibriNoleggiati;
        this.numLibriDaResituire = numLibriDaResituire;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public int getNumLibriNoleggiati() {
        return numLibriNoleggiati;
    }

    public void setNumLibriNoleggiati(int numLibriNoleggiati) {
        this.numLibriNoleggiati = numLibriNoleggiati;
    }

    public int getNumLibriDaResituire() {
        return numLibriDaResituire;
    }

    public void setNumLibriDaResituire(int numLibriDaResituire) {
        this.numLibriDaResituire = numLibriDaResituire;
    }

}
