package it.unibas.anagrafica.modello;

import java.util.ArrayList;
import java.util.List;

public class Azienda implements Comparable<Azienda> {

    private String partitaIVA;
    private String denominazione;
    private String cittaSede;
    private List<Dipendente> listaDipendenti = new ArrayList<>();

    public Azienda(String partitaIVA, String denominazione, String cittaSede) {
        this.partitaIVA = partitaIVA;
        this.denominazione = denominazione;
        this.cittaSede = cittaSede;
    }

    public String getPartitaIVA() {
        return partitaIVA;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("partitaIVA=").append(partitaIVA);
        sb.append(", denominazione=").append(denominazione);
        sb.append(", cittaSede=").append(cittaSede);
        sb.append(", listaDipendenti=").append(listaDipendenti);
        return sb.toString();
    }

    public void aggiungiDipendente(Dipendente dipendente) {
        this.listaDipendenti.add(dipendente);
    }

    @Override
    public int compareTo(Azienda o) {
        return o.getDenominazione().compareTo(this.getDenominazione());
    }

}
