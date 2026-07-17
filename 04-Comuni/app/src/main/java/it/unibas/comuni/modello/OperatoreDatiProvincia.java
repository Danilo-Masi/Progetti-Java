package it.unibas.comuni.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperatoreDatiProvincia {

    public List<DatiProvincia> calcolaDatiProvincia(List<Comune> listaComuni, int numeroProvince) {
        // Mappa che associa il nome della provincia (chiave) ai dati aggregati di quella provincia (valore).
        // Serve per accumulare, provincia per provincia, il numero di comuni e la popolazione totale
        // man mano che scorro tutti i comuni della lista.
        Map<String, DatiProvincia> mappaProvince = new HashMap<>();
        // Scorro uno alla volta tutti i comuni ricevuti in ingresso
        for (Comune comune : listaComuni) {
            // Controllo se la provincia di questo comune è già presente nella mappa
            DatiProvincia datiProvincia = mappaProvince.get(comune.getProvincia());
            // Se è la PRIMA volta che incontro questa provincia (non è ancora nella mappa)...
            if (datiProvincia == null) {
                // ...creo un nuovo oggetto DatiProvincia per questa provincia...
                datiProvincia = new DatiProvincia(comune.getProvincia());
                // ...e lo inserisco subito nella mappa, cosi al prossimo comune della stessa
                // provincia lo trovero gia presente
                mappaProvince.put(comune.getProvincia(), datiProvincia);
            }
            // A questo punto "datiProvincia" esiste sempre (o l'ho appena creato,
            // o era gia presente nella mappa da un ciclo precedente).
            // Aggiorno quindi i contatori di questa provincia con i dati del comune corrente:
            // Incremento di 1 il numero di comuni appartenenti a questa provincia
            datiProvincia.setNumeroComuni(datiProvincia.getNumeroComuni() + 1);
            // Sommo la popolazione del comune corrente al totale della popolazione della provincia
            datiProvincia.setTotalePopolazione(datiProvincia.getTotalePopolazione() + comune.getPopolazione());
        }
        // Terminato il ciclo, la mappa contiene un DatiProvincia gia completo per ogni provincia trovata.
        // Estraggo solo i valori (i DatiProvincia) e li metto in una lista
        List<DatiProvincia> listaDatiProvincia = new ArrayList<>(mappaProvince.values());
        // Ordino la lista secondo il criterio definito dal metodo compareTo() di DatiProvincia
        Collections.sort(listaDatiProvincia);
        // L'utente vuole solo le prime "numeroProvince" province della lista ordinata (es. la top 5).
        // Se la lista ha piu elementi di quelli richiesti, la taglio tenendo solo i primi "numeroProvince"
        if (listaDatiProvincia.size() > numeroProvince) {
            listaDatiProvincia = listaDatiProvincia.subList(0, numeroProvince);
        }
        // Restituisco la lista finale, ordinata e limitata al numero di province richiesto
        return listaDatiProvincia;
    }

}
