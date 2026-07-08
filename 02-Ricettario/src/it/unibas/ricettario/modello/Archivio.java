package it.unibas.ricettario.modello;

import java.util.ArrayList;
import java.util.List;

public class Archivio {

    private List<Pietanza> pietanze = new ArrayList<>();

    public List<Pietanza> getPietanze() {
        return pietanze;
    }

    public void aggiungiPietanza(Pietanza p) {
        this.pietanze.add(p);
    }

    public List<Pietanza> cercaPietanzaPerCategoria(String categoria) {
        List<Pietanza> listaFiltrata = new ArrayList<>();
        for (Pietanza pietanza : this.pietanze) {
            if (pietanza.getCategoria().equalsIgnoreCase(categoria)) {
                listaFiltrata.add(pietanza);
            }
        }
        return listaFiltrata;
    }

    public Pietanza cercaPietanzaSimile(Pietanza pietanza) {
        Pietanza pietanzaSimile = null;
        for (Pietanza altraPietanza : this.pietanze) {
            if (!altraPietanza.getNome().equals(pietanza.getNome())) {
                if (pietanzaSimile == null || (Math.abs(altraPietanza.getKcal() - pietanza.getKcal()) < Math.abs((pietanzaSimile.getKcal() - pietanza.getKcal())))) {
                    pietanzaSimile = altraPietanza;
                }
            }
        }
        return pietanzaSimile;
    }

}
