package it.unibas.ingressiaule.modello;

import java.util.ArrayList;
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

}
