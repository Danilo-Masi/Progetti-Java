package it.unibas.sistemiistituti.modello;

import java.util.Calendar;

public class Classe {

    private String codiceClasse;
    private int numeroIscritti;
    private String nomeRappresentante;
    private Calendar dataInizioLezioni;

    public Classe(String codiceClasse, int numeroIscritti, String nomeRappresentante, Calendar dataInizioLezioni) {
        this.codiceClasse = codiceClasse;
        this.numeroIscritti = numeroIscritti;
        this.nomeRappresentante = nomeRappresentante;
        this.dataInizioLezioni = dataInizioLezioni;
    }

    public String getCodiceClasse() {
        return codiceClasse;
    }

    public void setCodiceClasse(String codiceClasse) {
        this.codiceClasse = codiceClasse;
    }

    public int getNumeroIscritti() {
        return numeroIscritti;
    }

    public void setNumeroIscritti(int numeroIscritti) {
        this.numeroIscritti = numeroIscritti;
    }

    public String getNomeRappresentante() {
        return nomeRappresentante;
    }

    public void setNomeRappresentante(String nomeRappresentante) {
        this.nomeRappresentante = nomeRappresentante;
    }

    public Calendar getDataInizioLezioni() {
        return dataInizioLezioni;
    }

    public void setDataInizioLezioni(Calendar dataInizioLezioni) {
        this.dataInizioLezioni = dataInizioLezioni;
    }

}
