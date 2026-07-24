package it.unibas.banca.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Conto {

    private String Iban;
    private String nomeIntestatario;
    private String cognomeIntestatario;
    private Calendar dataSottoscrizione;
    private List<Movimento> listaMovimenti = new ArrayList<>();

    public Conto(String Iban, String nomeIntestatario, String cognomeIntestatario, Calendar dataSottoscrizione) {
        this.Iban = Iban;
        this.nomeIntestatario = nomeIntestatario;
        this.cognomeIntestatario = cognomeIntestatario;
        this.dataSottoscrizione = dataSottoscrizione;
    }

    public String getIban() {
        return Iban;
    }

    public String getNomeIntestatario() {
        return nomeIntestatario;
    }

    public String getCognomeIntestatario() {
        return cognomeIntestatario;
    }

    public Calendar getDataSottoscrizione() {
        return dataSottoscrizione;
    }

    public List<Movimento> getListaMovimenti() {
        return listaMovimenti;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Conto{");
        sb.append("Iban=").append(Iban);
        sb.append(", nomeIntestatario=").append(nomeIntestatario);
        sb.append(", cognomeIntestatario=").append(cognomeIntestatario);
        sb.append(", dataSottoscrizione=").append(dataSottoscrizione);
        sb.append(", listaMovimenti=").append(listaMovimenti);
        sb.append('}');
        return sb.toString();
    }

    public void aggiungiMovimento(Movimento movimento) {
        this.listaMovimenti.add(movimento);
    }

}
