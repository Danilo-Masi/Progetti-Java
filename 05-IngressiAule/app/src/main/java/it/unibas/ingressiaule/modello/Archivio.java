package it.unibas.ingressiaule.modello;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class Archivio {

    private List<Aula> listaAule = new ArrayList<>();

    public List<Aula> getListaAule() {
        return listaAule;
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
        Collections.sort(listaFiltrata, new ComparatoreAule());
        return listaFiltrata;
    }

    // Metodo per verificare se ci sono degli accessi duplicati nella Domenica
    public boolean verificaAccessiDuplicati() {
        List<Accesso> accessiDomenica = getAccessiDomenica();
        if (accessiDomenica.isEmpty()) {
            return false;

        }
        for (Accesso accesso : accessiDomenica) {
            if (contaOccorrezze(accesso, accessiDomenica) > 1) {
                return true;
            }
        }
        return false;
    }

    // Metodo per filtrare gli accessi che avvengono solo di Domenica
    private List<Accesso> getAccessiDomenica() {
        List<Accesso> risulato = new ArrayList<>();
        for (Aula aula : listaAule) {
            for (Accesso accesso : aula.getListaAccessi()) {
                Calendar data = accesso.getData();
                int giornoDellaSettimana = data.get(Calendar.DAY_OF_WEEK);
                if (giornoDellaSettimana == Calendar.SUNDAY) {
                    risulato.add(accesso);
                }
            }
        }
        return risulato;
    }

    // Metodo per verificare se ci sono duplicati (Matricola e data uguale)
    private int contaOccorrezze(Accesso accesso, List<Accesso> accessiDomenica) {
        int conta = 0;
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String giornoAccesso = df.format(accesso.getData().getTime());
        for (Accesso altroAccesso : accessiDomenica) {
            String giornoAltroAccesso = df.format(altroAccesso.getData().getTime());
            if (altroAccesso.getMatricolaStudente().equalsIgnoreCase(accesso.getMatricolaStudente()) && giornoAccesso.equals(giornoAltroAccesso)) {
                conta++;
            }
        }
        return conta;
    }

}
