package it.unibas.banktransactions.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContoCorrente {

    private String Iban;
    private String credenzialiIntestario;
    private Calendar dataSottoscrizione;
    private List<Movimento> listaMovimenti = new ArrayList<>();

    public ContoCorrente(String Iban, String credenzialiIntestario, Calendar dataSottoscrizione) {
        this.Iban = Iban;
        this.credenzialiIntestario = credenzialiIntestario;
        this.dataSottoscrizione = dataSottoscrizione;
    }

    public String getIban() {
        return Iban;
    }

    public String getCredenzialiIntestario() {
        return credenzialiIntestario;
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
        sb.append("IBAN: ").append(Iban);
        sb.append("Credenziali: ").append(credenzialiIntestario);
        sb.append("Data sottoscrizione: ").append(dataSottoscrizione);
        sb.append("Numero movimenti: ").append(listaMovimenti.size());
        return sb.toString();
    }

    public void aggiungiMovimento(Movimento movimento) {
        this.listaMovimenti.add(movimento);
    }

}
