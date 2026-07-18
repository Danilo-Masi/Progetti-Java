package it.unibas.ingressiaule.modello;

import java.util.ArrayList;
import java.util.List;

public class Archivio {

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

}
