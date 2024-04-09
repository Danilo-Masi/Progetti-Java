package it.unibas.travelagency.modello;

import java.util.ArrayList;
import java.util.List;

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

}
