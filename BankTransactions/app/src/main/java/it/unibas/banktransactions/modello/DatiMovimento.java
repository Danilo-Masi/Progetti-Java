package it.unibas.banktransactions.modello;

public class DatiMovimento {

    private String tipologia;
    private int numeroOperazioni;

    public DatiMovimento(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public int getNumeroOperazioni() {
        return numeroOperazioni;
    }

    public void setNumeroOperazioni(int numeroOperazioni) {
        this.numeroOperazioni = numeroOperazioni;
    }

}
