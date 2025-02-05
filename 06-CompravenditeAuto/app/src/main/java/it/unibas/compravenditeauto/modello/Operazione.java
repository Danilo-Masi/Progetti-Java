package it.unibas.compravenditeauto.modello;

import java.util.Calendar;

public class Operazione {

    private Calendar dataOperazione;
    private int numKm;
    private double importoVendita;
    private String nomeProprietario;

    public Operazione(Calendar dataOperazione, int numKm, double importoVendita, String nomeProprietario) {
        this.dataOperazione = dataOperazione;
        this.numKm = numKm;
        this.importoVendita = importoVendita;
        this.nomeProprietario = nomeProprietario;
    }

    public Calendar getDataOperazione() {
        return dataOperazione;
    }

    public int getNumKm() {
        return numKm;
    }

    public double getImportoVendita() {
        return importoVendita;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data del operazione: ").append(dataOperazione);
        sb.append("Numero km: ").append(numKm);
        sb.append("Importo della vendita: ").append(importoVendita);
        sb.append("Nome del proprietario: ").append(nomeProprietario);
        return sb.toString();
    }

}
