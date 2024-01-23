package it.unibas.ingressiaule.modello;

import java.util.ArrayList;
import java.util.List;

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

}
