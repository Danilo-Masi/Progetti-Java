package it.unibas.ingressiaule.modello;

import java.text.DateFormat;
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

    private List<Aula> listaAule = new ArrayList<>();

    public List<Aula> getListaAule() {
        return listaAule;
    }

    public void setListaAule(List<Aula> listaAule) {
        this.listaAule = listaAule;
    }

    public void aggiungiAula(Aula aula) {
        this.listaAule.add(aula);
    }

    public List<Aula> cercaAulePerPiano(int piano) {
        List<Aula> listaFiltrata = new ArrayList<>();
        for (Aula aula : listaAule) {
            if (aula.getPiano() <= piano) {
                listaFiltrata.add(aula);
            }
        }
        Collections.sort(listaFiltrata);
        return listaFiltrata;
    }

    public boolean isAccessiDuplicati() {
        List<Accesso> accessiDomenica = getAccessiDomenica();
        if (accessiDomenica.isEmpty()) {
            return false;
        }
        for (Accesso accesso : accessiDomenica) {
            if (contaOccorrenze(accesso, accessiDomenica) > 1) {
                return true;
            }
        }
        return false;
    }

    private List<Accesso> getAccessiDomenica() {
        List<Accesso> risultato = new ArrayList<>();
        for (Aula aula : listaAule) {
            for (Accesso accesso : aula.getListaAccessi()) {
                if (accesso.getData().get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    risultato.add(accesso);
                }
            }
        }
        return risultato;
    }

    private int contaOccorrenze(Accesso accesso, List<Accesso> accessiDomenica) {
        int conta = 0;
        DateFormat df = DateFormat.getDateInstance();
        String dataAccesso = df.format(accesso.getData().getTime());
        for (Accesso accessoDaControllare : accessiDomenica) {
            String accessoDaControllareData = df.format(accessoDaControllare.getData().getTime());
            if (dataAccesso.equals(accessoDaControllareData) && accesso.getMatricola().equalsIgnoreCase(accessoDaControllare.getMatricola())) {
                conta++;
            }
        }
        return conta;
    }

    /**
     * Metodo "orchestratore": calcola, per ogni mese in cui ci sono stati
     * accessi, la motivazione di accesso più frequente e il tempo totale di
     * permanenza.Questo metodo si occupa solo di orchestrare le chiamate e
     * costruire il risultato finale, non di calcolare i singoli valori.
     *
     * @return
     */
    public List<DatiAccessiMese> calcolaDatiMeseFrequente() {
        // Trasformo la lista "piatta" di accessi (sparsi tra le varie aule)
        // in una struttura raggruppata per mese, così da poter analizzare mese per mese
        // senza dover rifare la scansione di tutte le aule ad ogni iterazione.
        Map<Integer, List<Accesso>> mappaAccessiMese = raggruppaAccessiPerMese();
        List<DatiAccessiMese> risultato = new ArrayList<>();
        // Ogni mese diventa una riga
        // del risultato finale (un oggetto DatiAccessiMese).
        for (Integer mese : mappaAccessiMese.keySet()) {
            List<Accesso> accessiMese = mappaAccessiMese.get(mese);
            // Tempo totale di permanenza nel mese: somma su tutti gli accessi del mese,
            // indipendentemente da quale aula li ha generati
            int tempoTotale = calcolaTempoTotale(accessiMese);
            // Motivazione più ricorrente nel mese: richiede un ulteriore conteggio
            // (occorrenze per tipologia di motivazione), per questo è delegato
            // a un metodo dedicato che a sua volta si appoggia su un altro metodo
            // di supporto (calcolaMappaOccorrenzePerTipologia).
            String motivazioneFrequente = calcolaMotivazioneFrequente(accessiMese);
            DatiAccessiMese datiAccessiMese = new DatiAccessiMese(mese, motivazioneFrequente, tempoTotale);
            risultato.add(datiAccessiMese);
        }
        // Ordino il risultato finale
        Collections.sort(risultato);
        return risultato;
    }

    /**
     * Raggruppa tutti gli accessi di tutte le aule per mese di riferimento. Uso
     * il mese (0-11, secondo Calendar.MONTH) come chiave
     */
    private Map<Integer, List<Accesso>> raggruppaAccessiPerMese() {
        Map<Integer, List<Accesso>> mappaAccessiPerMese = new HashMap<>();
        // Doppio ciclo: scorro tutte le aule e, per ciascuna, tutti i suoi accessi.
        // Non uso un'unica lista "piatta" di accessi perché il dato sorgente
        // (listaAule) è organizzato per aula, quindi la struttura del ciclo
        // rispecchia quella del modello dati.
        for (Aula aula : listaAule) {
            for (Accesso accesso : aula.getListaAccessi()) {
                Calendar data = accesso.getData();
                int mese = data.get(Calendar.MONTH);
                // Se per questo mese non esiste ancora
                // una lista, la creo al volo e la inserisco in mappa prima di
                // aggiungerci l'accesso corrente. Evita di dover pre popolare
                // la mappa con tutti i 12 mesi in anticipo.
                List<Accesso> accessiMese = mappaAccessiPerMese.get(mese);
                if (accessiMese == null) {
                    accessiMese = new ArrayList<>();
                    mappaAccessiPerMese.put(mese, accessiMese);
                }
                accessiMese.add(accesso);
            }
        }
        return mappaAccessiPerMese;
    }

    /**
     * Somma le permanenze di tutti gli accessi di un singolo mese. Metodo
     * isolato per tenere separata la responsabilità di "sommare tempo" da
     * quella di "trovare la motivazione più frequente", anche se entrambi
     * lavorano sulla stessa lista di accessi.
     */
    private int calcolaTempoTotale(List<Accesso> accessiMese) {
        int somma = 0;
        for (Accesso accesso : accessiMese) {
            somma += accesso.getPermanenza();
        }
        return somma;
    }

    /**
     * Determina la motivazione di accesso più frequente in un mese. Strategia:
     * prima costruisco una mappa motivazione -> numero di occorrenze, poi
     * scorro questa mappa (molto più piccola della lista di accessi originale)
     * per trovare il massimo. Questo evita di confrontare ogni accesso con
     * tutti gli altri riducendo il problema a un conteggio + un max.
     */
    private String calcolaMotivazioneFrequente(List<Accesso> accessiMese) {
        Map<String, Integer> mappaOccorrenzePerTipologia = calcolaMappaOccorrenzePerTipologia(accessiMese);
        String motivazioneMax = null;
        // Ricerca del massimo "manuale" (non uso Collections.max con Comparator)
        // perché la mappa contiene coppie chiave-valore e serve la chiave (la
        // motivazione), non il valore (il conteggio), associata al valore massimo.
        for (String motivazione : mappaOccorrenzePerTipologia.keySet()) {
            // La condizione "motivazioneMax == null" gestisce il primo elemento
            // incontrato, quando ancora non c'è un massimo con cui confrontarsi.
            if (motivazioneMax == null || mappaOccorrenzePerTipologia.get(motivazione) > mappaOccorrenzePerTipologia.get(motivazioneMax)) {
                motivazioneMax = motivazione;
            }
        }
        return motivazioneMax;
    }

    /**
     * Conta quante volte ricorre ciascuna motivazione all'interno degli accessi
     * di un mese. Restituisce una mappa motivazione -> numero di occorrenze,
     * che viene poi consumata da calcolaMotivazioneFrequente per trovare il
     * massimo. Separare "conteggio" da "ricerca del massimo" in due metodi
     * distinti rende ciascuno dei due più semplice da leggere e da testare
     * singolarmente.
     */
    private Map<String, Integer> calcolaMappaOccorrenzePerTipologia(List<Accesso> accessiMese) {
        Map<String, Integer> mappaOccorrenzeTipologia = new HashMap<>();
        for (Accesso accesso : accessiMese) {
            Integer vecchieOccorrenze = mappaOccorrenzeTipologia.get(accesso.getMotivazione());
            if (vecchieOccorrenze == null) {
                mappaOccorrenzeTipologia.put(accesso.getMotivazione(), 1);
            } else {
                mappaOccorrenzeTipologia.put(accesso.getMotivazione(), vecchieOccorrenze + 1);
            }
        }
        return mappaOccorrenzeTipologia;
    }
}
