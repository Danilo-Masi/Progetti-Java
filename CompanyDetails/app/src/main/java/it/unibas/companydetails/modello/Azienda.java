package it.unibas.companydetails.modello;

import java.util.ArrayList;
import java.util.List;

public class Azienda {

    private long partitaIva;
    private String denominazione;
    private String cittaSede;
    private List<Dipendente> listaDipendenti = new ArrayList<>();

    public Azienda(long partitaIva, String denominazione, String cittaSede) {
        this.partitaIva = partitaIva;
        this.denominazione = denominazione;
        this.cittaSede = cittaSede;
    }

    public long getPartitaIva() {
        return partitaIva;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public String getCittaSede() {
        return cittaSede;
    }

    public List<Dipendente> getListaDipendenti() {
        return listaDipendenti;
    }

    //Metodo per aggiungere un dipendente alla lista dei dipendendi dell'azienda
    public void aggiungiDipendente(Dipendente dipendente) {
        this.listaDipendenti.add(dipendente);
    }

}
