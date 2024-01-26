package it.unibas.ingressiaule.modello;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Archivio {
    
    private List<Aula> aule = new ArrayList<>();
    
    public List<Aula> getAule() {
        return aule;
    }
    
    public void setAule(List<Aula> aule) {
        this.aule = aule;
    }
    
    public void addAula(Aula aula) {
        this.aule.add(aula);
    }

    //Metodo per aggiungere un aula alla lista delle aule con lo stesso piano
    public List<Aula> cercaAulePerPiano(int piano) {
        List<Aula> listaAule = new ArrayList<>();
        for (Aula aula : aule) {
            if (aula.getPiano() <= piano) {
                listaAule.add(aula);
            }
        }
        Collections.sort(listaAule);
        return listaAule;
    }

    //Metodo per verificare se ci sono accessi duplicati di Domenica
    public boolean verificaArchivio() {
        List<Accesso> accessiDomenica = getAccessiDomenica();
        if (accessiDomenica.isEmpty()) {
            return false;
        }
        for (Accesso accesso : accessiDomenica) {
            if (contaOccorenze(accesso, accessiDomenica) > 1) {
                return true;
            }
        }
        return false;
    }

    //Metodo per filtrare gli accessi che avvengono di Domenica
    private List<Accesso> getAccessiDomenica() {
        List<Accesso> risultato = new ArrayList<>();
        for (Aula aula : aule) {
            for (Accesso accesso : aula.getListaAccessi()) {
                Calendar data = accesso.getData();
                int giornoDellaSettimana = data.get(Calendar.DAY_OF_WEEK);
                if (giornoDellaSettimana == Calendar.SUNDAY) {
                    risultato.add(accesso);
                }
            }
        }
        return risultato;
    }

    //Metodo per controllare quanti accessi ci sono nella lista degli accessi
    private int contaOccorenze(Accesso accesso, List<Accesso> accessiDomenica) {
        int conta = 0;
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String data = df.format(accesso.getData().getTime());
        for (Accesso accessoDaControllare : accessiDomenica) {
            String dataDaControllare = df.format(accessoDaControllare.getData().getTime());
            if (accesso.getMatricola().equalsIgnoreCase(accessoDaControllare.getMatricola())
                    && data.equals(dataDaControllare)) {
                conta++;
            }
        }
        return conta;
    }

    //Metodo per calcolare i mesi con piu frequenza di accesso
    public List<DatiAccessiMese> calcolaDatiMeseFrequente() {
        Map<Integer, List<Accesso>> mappaAccessiMese = raggruppaAccessiPerMese();
        List<DatiAccessiMese> risultato = new ArrayList<>();
        for (Integer mese : mappaAccessiMese.keySet()) {
            List<Accesso> accessiMese = mappaAccessiMese.get(mese);
            int tempoTotale = calcolaTempoTotale(accessiMese);
            String motivazioneFrequente = calcolaMotivazioneFrequente(accessiMese);
            DatiAccessiMese datiAccessiMese = new DatiAccessiMese(mese, motivazioneFrequente, tempoTotale);
            risultato.add(datiAccessiMese);
        }
        Collections.sort(risultato);
        return risultato;
    }

    //Metodo per trovare i mesi per ogni mese
    private Map<Integer, List<Accesso>> raggruppaAccessiPerMese() {
        Map<Integer, List<Accesso>> mappaAccessiPerMese = new HashMap<>();
        for (Aula aula : aule) {
            for (Accesso accesso : aula.getListaAccessi()) {
                Calendar data = accesso.getData();
                int mese = data.get(Calendar.MONTH);
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
    
    private int calcolaTempoTotale(List<Accesso> accessiMese) {
        int somma = 0;
        for (Accesso accesso : accessiMese) {
            somma += accesso.getPermanenza();
        }
        return somma;
    }
    
    private String calcolaMotivazioneFrequente(List<Accesso> accessiMese) {
        Map<String, Integer> mappaOccorenzePerTipologia = calcolaMappaOccorenzeTipologia(accessiMese);
        String motivazioneMax = null;
        for (String motivazione : mappaOccorenzePerTipologia.keySet()) {
            if (motivazioneMax == null
                    || mappaOccorenzePerTipologia.get(motivazione) > mappaOccorenzePerTipologia.get(motivazioneMax)) {
                motivazioneMax = motivazione;
            }
        }
        return motivazioneMax;
    }
    
    private Map<String, Integer> calcolaMappaOccorenzeTipologia(List<Accesso> accessiMese) {
        Map<String, Integer> mappaOccorenzePerTipologia = new HashMap<>();
        for (Accesso accesso : accessiMese) {
            Integer vecchieOccorrenze = mappaOccorenzePerTipologia.get(accesso.getMotivazione());
            if (vecchieOccorrenze == null) {
                mappaOccorenzePerTipologia.put(accesso.getMotivazione(), 1);
            } else {
                mappaOccorenzePerTipologia.put(accesso.getMotivazione(), vecchieOccorrenze + 1);
            }
        }
        return mappaOccorenzePerTipologia;
    }
    
}
