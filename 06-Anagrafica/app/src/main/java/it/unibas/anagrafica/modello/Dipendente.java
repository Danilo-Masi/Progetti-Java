package it.unibas.anagrafica.modello;

import java.util.Calendar;

public class Dipendente {

    private String codiceFiscale;
    private String nome;
    private String cognome;
    private Calendar dataAssunzione;
    private String regioneResidenza;

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
        sb.append("codiceFiscale=").append(codiceFiscale);
        sb.append(", nome=").append(nome);
        sb.append(", cognome=").append(cognome);
        sb.append(", dataAssunzione=").append(dataAssunzione);
        sb.append(", regioneResidenza=").append(regioneResidenza);
        return sb.toString();
    }

}
