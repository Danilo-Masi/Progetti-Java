package it.unibas.banca.modello;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    private Logger logger = LoggerFactory.getLogger(Archivio.class);

    private List<Conto> listaConti = new ArrayList<>();

    public List<Conto> getListaConti() {
        return listaConti;
    }

    public void aggiungiConto(Conto conto) {
        this.listaConti.add(conto);
    }

    // 2 CASO D'USO
    public List<Conto> cercaPerData(String ordinamento) {
        List<Conto> risultati = new ArrayList<>();
        Calendar oggi = new GregorianCalendar();
        for (Conto conto : listaConti) {
            if (conto.getDataSottoscrizione().before(oggi)) {
                risultati.add(conto);
            }
        }
        if (ordinamento.equalsIgnoreCase(Costanti.ORDINAMENTO_DATA)) {
            Collections.sort(risultati, new ComparatoreData());
        } else {
            Collections.sort(risultati, new ComparatoreNome());
        }
        logger.debug("Numero di risultati: {}", risultati.size());
        return risultati;
    }

    // 4 CASO D'USO
    public boolean verificaArchivio() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        for (int i = 0; i < listaConti.size() - 1; i++) {
            Conto conto = listaConti.get(i);
            logger.debug("Giro principale --- {}", i);
            logger.debug("Conto Nome: {} - cognome: {} - data: {}", conto.getNomeIntestatario(), conto.getCognomeIntestatario(), df.format(conto.getDataSottoscrizione().getTime()));
            for (int j = i + 1; j < listaConti.size(); j++) {
                Conto altroConto = listaConti.get(j);
                logger.debug("Altro Conto Nome: {} - cognome: {} - data: {}", altroConto.getNomeIntestatario(), altroConto.getCognomeIntestatario(), df.format(altroConto.getDataSottoscrizione().getTime()));
                if (conto.getNomeIntestatario().equals(altroConto.getNomeIntestatario())
                        && conto.getCognomeIntestatario().equals(altroConto.getCognomeIntestatario())
                        && df.format(conto.getDataSottoscrizione().getTime()).equals(df.format(altroConto.getDataSottoscrizione().getTime()))) {
                    return true;
                }
            }
        }
        return false;
    }

    // 5 CASO D'USO // TODO //
    public String ricercaMesiFrequenti() {
        Map<String, String> mappaTipologiePerMese = calcolaTipologiePerMese();
        return "";
    }

    private Map<String, String> calcolaTipologiePerMese() {
        Map<String, String> mappaTipologiePerMese = new HashMap<>();

        return mappaTipologiePerMese;
    }

}
