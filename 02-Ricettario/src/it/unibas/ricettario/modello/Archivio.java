package it.unibas.ricettario.modello;

import java.util.ArrayList;
import java.util.List;

public class Archivio {

    private List<Pietanza> pietanze = new ArrayList<>();

    public List<Pietanza> getPietanze() {
        return pietanze;
    }

    public void aggiungiPietanza(Pietanza pietanza) {
        this.pietanze.add(pietanza);
    }

    public List<Pietanza> cercaPietanzePerCategoria(String categoria) {
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
        for (Pietanza altraPietanza : pietanze) {
            if (!altraPietanza.getNome().equals(pietanza.getNome())) {
                if (pietanzaSimile == null || (Math.abs(altraPietanza.getKcalTot() - pietanza.getKcalTot()) < Math.abs(pietanzaSimile.getKcalTot() - pietanza.getKcalTot()))) {
                    pietanzaSimile = altraPietanza;
                }
            }
        }
        return pietanzaSimile;
    }

}
