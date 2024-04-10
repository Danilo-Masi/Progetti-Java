package it.unibas.travelagency.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Archivio {

    private List<Agenzia> listaAgenzie = new ArrayList<>();

    public Archivio() {
    }

    public List<Agenzia> getListaAgenzie() {
        return listaAgenzie;
    }

    public void aggiungiAgenzia(Agenzia agenzia) {
        this.listaAgenzie.add(agenzia);
    }

    public List<Agenzia> cercaAgenziaPerCitta(String citta, String criterio) {
        List<Agenzia> listaFiltrata = new ArrayList<>();
        for (Agenzia agenzia : listaAgenzie) {
            if (agenzia.getCitta().equalsIgnoreCase(citta)) {
                listaFiltrata.add(agenzia);
            }
        }
        if (criterio.equals(Costanti.ORDINAMENTO_CRESCENTE)) {
            Collections.sort(listaFiltrata, new ComparatoreAgenzieCrescente());
        } else {
            Collections.sort(listaFiltrata, new ComparatoreAgenzieDescrescente());
        }
        return listaFiltrata;
    }
    
    public List<Pacchetto> pacchettiTabellaDettagli(List<Pacchetto> listaPacchetti) {
        // Lista per i pacchetti da visualizzare nei dettagli della tabella
        List<Pacchetto> listaPacchettiTabellaDettagli = new ArrayList<>();
        // Crea una mappa di pacchetti per tipologia dalla lista di pacchetti fornita
        Map<String, List<Pacchetto>> mappaPerTipologie = listaPacchettiPerTipologia(listaPacchetti);
        // Trova il pacchetto più vicino per ogni tipologia
        Map<String, Pacchetto> mappaPacchettiVicini = cercaPacchettiVicini(mappaPerTipologie);
        // Itera su ogni entry nella mappa dei pacchetti più vicini
        for (Map.Entry<String, Pacchetto> entry : mappaPacchettiVicini.entrySet()) {
            // Aggiunge il pacchetto (valore dell'entry) alla lista dei pacchetti per la tabella dei dettagli
            listaPacchettiTabellaDettagli.add(entry.getValue());
        }
        // Restituisce la lista completa dei pacchetti per la tabella dei dettagli
        return listaPacchettiTabellaDettagli;
    }

    public Map<String, List<Pacchetto>> listaPacchettiPerTipologia(List<Pacchetto> listaPacchetti) {
        // Crea una mappa per memorizzare le liste di pacchetti divisi per tipologia.
        Map<String, List<Pacchetto>> mappaPerTipologie = new HashMap<>();
        // Itera su ogni pacchetto nella lista fornita.
        for (Pacchetto pacchetto : listaPacchetti) {
            // Ottiene la tipologia del pacchetto corrente.
            String tipologia = pacchetto.getTipologia();
            // Ottiene la lista di pacchetti per la corrente tipologia, se esiste, altrimenti crea una nuova lista.
            List<Pacchetto> pacchettiPerTipologia = mappaPerTipologie.getOrDefault(tipologia, new ArrayList<>());
            // Aggiunge il pacchetto corrente alla lista di pacchetti per la sua tipologia.
            pacchettiPerTipologia.add(pacchetto);
            // Aggiorna la mappa con la lista aggiornata di pacchetti per la tipologia corrente.
            mappaPerTipologie.put(tipologia, pacchettiPerTipologia);
        }
        // Restituisce la mappa completa di liste di pacchetti divisi per tipologia.
        return mappaPerTipologie;
    }

    public Map<String, Pacchetto> cercaPacchettiVicini(Map<String, List<Pacchetto>> mappaPerTipologia) {
        // Crea una mappa per memorizzare il pacchetto più vicino per ogni tipologia.
        Map<String, Pacchetto> pacchettiPiùVicini = new HashMap<>();
        // Ottiene l'istanza di Calendar per la data e ora corrente.
        Calendar oggi = Calendar.getInstance();
        // Itera su ogni entry nella mappa di tipologie. Ogni entry consiste in una chiave (la tipologia) e un valore (lista di pacchetti).
        for (Map.Entry<String, List<Pacchetto>> entry : mappaPerTipologia.entrySet()) {
            Pacchetto pacchettoPiùVicino = null;
            long minDiff = Long.MAX_VALUE;
            // Itera su ogni pacchetto nella lista per la tipologia corrente.
            for (Pacchetto pacchetto : entry.getValue()) {
                // Crea un'istanza di Calendar per la data del pacchetto.
                Calendar dataPacchetto = Calendar.getInstance();
                // Imposta la data del pacchetto nell'istanza di Calendar.
                dataPacchetto.setTime(pacchetto.getDataPartenza().getTime());
                // Calcola la differenza in millisecondi tra la data del pacchetto e la data corrente.
                long diff = dataPacchetto.getTimeInMillis() - oggi.getTimeInMillis();
                // Converte la differenza in giorni.
                long diffGiorni = diff / (24 * 60 * 60 * 1000);
                // Se la differenza è positiva (cioè, il pacchetto è nel futuro) ed è minore della differenza minima trovata fino ad ora, aggiorna il pacchetto più vicino e la differenza minima.
                if (diffGiorni >= 0 && diffGiorni < minDiff) {
                    minDiff = diffGiorni;
                    pacchettoPiùVicino = pacchetto;
                }
            }
            // Se è stato trovato un pacchetto più vicino per la tipologia corrente, lo aggiunge alla mappa dei pacchetti più vicini.
            if (pacchettoPiùVicino != null) {
                pacchettiPiùVicini.put(entry.getKey(), pacchettoPiùVicino);
            }
        }
        // Restituisce la mappa dei pacchetti più vicini per tipologia.
        return pacchettiPiùVicini;
    }

}
