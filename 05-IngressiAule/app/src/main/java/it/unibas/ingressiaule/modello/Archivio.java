package it.unibas.ingressiaule.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
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
        List<Accesso> listaAccessiDomenica = new ArrayList<>();
        for (Aula aula : listaAule) {
            for (Accesso accesso : aula.getListaAccessi()) {
                if (accesso.getData().get(Calendar.DAY_OF_WEEK) == 1) {
                    listaAccessiDomenica.add(accesso);
                }
            }
        }
        logger.debug("Lista accessi Domenica: {}", listaAccessiDomenica.size());
        if (!listaAccessiDomenica.isEmpty()) {
            int counter = 1;
            for (int i = 0; i < listaAccessiDomenica.size(); i++) {
                Accesso accesso = listaAccessiDomenica.get(i);
                Calendar dataAccesso = accesso.getData();
                String matricola = accesso.getMatricola();
                logger.debug("Accesso stundete: {} - {}", accesso.getNomeStudente(), matricola);
                for (int j = i + 1; j < listaAccessiDomenica.size(); j++) {
                    Accesso altroAccesso = listaAccessiDomenica.get(j);
                    Calendar altroAccessoData = altroAccesso.getData();
                    String altroAccessoMatricola = altroAccesso.getMatricola();
                    if (dataAccesso.equals(altroAccessoData) && matricola.equals(altroAccessoMatricola)) {
                        return true;
                    }
                }
            }
            logger.debug("Counter: {}", counter);
        }
        return false;
    }

}
