package it.unibas.ingressiaule.modello;

import java.util.ArrayList;
import java.util.Collections;
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
    
}
