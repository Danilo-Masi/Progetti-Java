package it.unibas.companydetails.modello;

import java.util.Calendar;

public class Dipendente {

    private String codiceFiscale;
    private String nome;
    private String cognome;
    private Calendar dataAssunzione;
    private String regioneResidenza;

    public Dipendente(String regioneResidenza) {
        this.regioneResidenza = regioneResidenza;
    }

    public Dipendente(String codiceFiscale, String nome, String cognome, Calendar dataAssunzione, String regioneResidenza) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.dataAssunzione = dataAssunzione;
        this.regioneResidenza = regioneResidenza;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Calendar getDataAssunzione() {
        return dataAssunzione;
    }

    public String getRegioneResidenza() {
        return regioneResidenza;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Codice fiscale: ").append(codiceFiscale).append("/n");
        sb.append("Nome: ").append(nome).append("/n");
        sb.append("Cognome: ").append(cognome);
        return sb.toString();
    }

}
