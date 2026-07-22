package it.unibas.anagrafica.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    private Logger logger = LoggerFactory.getLogger(Archivio.class);

    private List<Azienda> listaAziende = new ArrayList<>();

    public List<Azienda> getListaAziende() {
        return listaAziende;
    }

    public void aggiungiAzienda(Azienda azienda) {
        this.listaAziende.add(azienda);
    }

    public List<Azienda> cercaAziendePerCitta(String citta) {
        List<Azienda> risultato = new ArrayList<>();
        for (Azienda azienda : listaAziende) {
            if (azienda.getCittaSede().equalsIgnoreCase(citta)) {
                risultato.add(azienda);
            }
        }
        Collections.sort(risultato);
        return risultato;
    }

    public boolean verificaDisparita() {
        Map<String, Integer> mappaDipendentiRegione = calcolaDipendentiPerRegione();
        logger.debug(mappaDipendentiRegione.keySet() + " - " + mappaDipendentiRegione.values());
        // Trovo  la regione con più dipendenti e quella con meno, scorrendo
        // le chiavi e confrontando i valori associati
        String regioneMax = null;
        String regioneMin = null;
        for (String regione : mappaDipendentiRegione.keySet()) {
            int valore = mappaDipendentiRegione.get(regione);
            if (regioneMax == null || valore > mappaDipendentiRegione.get(regioneMax)) {
                regioneMax = regione;
            }
            if (regioneMin == null || valore < mappaDipendentiRegione.get(regioneMin)) {
                regioneMin = regione;
            }
        }
        int max = mappaDipendentiRegione.get(regioneMax);
        int min = mappaDipendentiRegione.get(regioneMin);
        logger.debug("Regione min: {} ({})", regioneMin, min);
        logger.debug("Regione max: {} ({})", regioneMax, max);
        // "Più del triplo" = strettamente maggiore di 3 volte
        boolean verifica = max > min * 3;
        logger.debug("Verfica finale: {}", verifica);
        return verifica;
    }

    private Map<String, Integer> calcolaDipendentiPerRegione() {
        Map<String, Integer> mappaDipendentiRegione = new HashMap<>();
        for (Azienda azienda : listaAziende) {
            for (Dipendente dipendente : azienda.getListaDipendenti()) {
                String regione = dipendente.getRegioneResidenza();
                Integer vecchieOccorrenze = mappaDipendentiRegione.get(regione);
                if (vecchieOccorrenze == null) {
                    mappaDipendentiRegione.put(regione, 1);
                } else {
                    mappaDipendentiRegione.put(regione, vecchieOccorrenze + 1);
                }
            }
        }
        return mappaDipendentiRegione;
    }

    public List<DatiAnniFrequenti> ricercaAnniFrequenti() {
        // Chiamo METODO 1
        Map<String, List<Dipendente>> mappaDipendentiPerRegione = raggruppaDipendentiPerRegione();
        logger.debug("Chiavi mappa dipendenti per regione: {}", mappaDipendentiPerRegione.keySet());
        List<DatiAnniFrequenti> listaDatiAnniFrequenti = new ArrayList<>();
        for (String regione : mappaDipendentiPerRegione.keySet()) {
            List<Dipendente> dipendentiRegione = mappaDipendentiPerRegione.get(regione);
            // Chiamo METODO 2
            DatiAnniFrequenti datiAnniFrequenti = calcolaAnnoFrequente(regione, dipendentiRegione);
            listaDatiAnniFrequenti.add(datiAnniFrequenti);
        }
        Collections.sort(listaDatiAnniFrequenti);
        return listaDatiAnniFrequenti;
    }

    // METODO 1
    private Map<String, List<Dipendente>> raggruppaDipendentiPerRegione() {
        Map<String, List<Dipendente>> mappaDipendentiPerRegione = new HashMap<>();
        for (Azienda azienda : listaAziende) {
            for (Dipendente dipendente : azienda.getListaDipendenti()) {
                String regione = dipendente.getRegioneResidenza();
                List<Dipendente> dipendentiRegione = mappaDipendentiPerRegione.get(regione);
                if (dipendentiRegione == null) {
                    dipendentiRegione = new ArrayList<>();
                    mappaDipendentiPerRegione.put(regione, dipendentiRegione);
                }
                dipendentiRegione.add(dipendente);
            }
        }
        return mappaDipendentiPerRegione;
    }

    // METODO 2
    private DatiAnniFrequenti calcolaAnnoFrequente(String regione, List<Dipendente> dipendentiRegione) {
        // Prima conto le occorrenze per anno...
        // Chiamo METODO 3
        Map<Integer, Integer> mappaOccorrenzeAnno = calcolaMappaOccorrenzePerAnno(dipendentiRegione);
        // Poi cerco la chiave (anno) con il valore massimo, tenendomi
        // anche il valore stesso (numeroAssunzioni), che altrimenti perderei.
        Integer annoMax = null;
        for (Integer anno : mappaOccorrenzeAnno.keySet()) {
            if (annoMax == null || mappaOccorrenzeAnno.get(anno) > mappaOccorrenzeAnno.get(annoMax)) {
                annoMax = anno;
            }
        }
        int numeroAssunzioniAnnoMax = mappaOccorrenzeAnno.get(annoMax);
        return new DatiAnniFrequenti(regione, annoMax, numeroAssunzioniAnnoMax);
    }

    // METODO 3
    private Map<Integer, Integer> calcolaMappaOccorrenzePerAnno(List<Dipendente> dipendentiRegione) {
        Map<Integer, Integer> mappaOccorrenzeAnno = new HashMap<>();
        for (Dipendente dipendente : dipendentiRegione) {
            int anno = dipendente.getDataAssunzione().get(Calendar.YEAR);
            Integer vecchieOccorrenze = mappaOccorrenzeAnno.get(anno);
            if (vecchieOccorrenze == null) {
                mappaOccorrenzeAnno.put(anno, 1);
            } else {
                mappaOccorrenzeAnno.put(anno, vecchieOccorrenze + 1);
            }
        }
        return mappaOccorrenzeAnno;
    }

}
