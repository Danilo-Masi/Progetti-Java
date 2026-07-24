package it.unibas.anagrafica.modello;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Azienda implements Comparable<Azienda> {

    private Logger logger = LoggerFactory.getLogger(Azienda.class);

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

    public boolean verificaDuplicati() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        for (int i = 0; i < listaDipendenti.size(); i++) {
            Dipendente dipendente = listaDipendenti.get(i);
            String nome = dipendente.getNome();
            String cognome = dipendente.getCognome();
            String data = df.format(dipendente.getDataAssunzione().getTime());
            logger.debug("Nome: {} - Cognome: {} - Data: {}", nome, cognome, data);
            for (int j = i + 1; j < listaDipendenti.size(); j++) {
                Dipendente altroDipendente = listaDipendenti.get(j);
                String altroNome = altroDipendente.getNome();
                String altroCognome = altroDipendente.getCognome();
                String altroData = df.format(altroDipendente.getDataAssunzione().getTime());
                logger.debug("Altro Nome: {} - Altro Cognome: {} - Altro Data: {}", altroNome, altroCognome, altroData);
                if (nome.equals(altroNome) && cognome.equals(altroCognome) && data.equals(altroData)) {
                    return true;
                }
            }
        }
        return false;
    }

}
