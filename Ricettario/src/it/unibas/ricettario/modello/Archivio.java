package it.unibas.ricettario.modello;

import java.util.ArrayList;
import java.util.List;

public class Archivio {

    private List<Pietanza> pietanze = new ArrayList<>();

    public List<Pietanza> getPietanze() {
        return pietanze;
    }

    //Metodo per aggiungere una nuova pietanza alla lista delle pietanze
    public void aggiungiPietanza(Pietanza pietanza) {
        this.pietanze.add(pietanza);
    }

    //Metodo per cercare le pietanze nella lista delle pietanze in base ad una 
    //categoria selezionata dall'utente
    public List<Pietanza> cercaPietanzePerCategoria(String categoria) {
        List<Pietanza> listaPietanze = new ArrayList<>();
        for (Pietanza nuovaPietanza : this.pietanze) {
            if (nuovaPietanza.getCategoria().equals(categoria)) {
                listaPietanze.add(nuovaPietanza);
            }
        }
        return listaPietanze;
    }

    //Metodo per cercare una pietanza simile (in base alla kcal) a quella
    //selezionata dall'utente nella tabella 
    public Pietanza cercaPietanzaSimile(Pietanza pietanza) {
        Pietanza pietanzaSimile = null;
        for (Pietanza altraPietanza : this.pietanze) {
            if (!altraPietanza.getNome().equals(pietanza.getNome())) {
                if (pietanzaSimile == null
                        || (Math.abs(altraPietanza.getKcal() - pietanza.getKcal()) < Math.abs(pietanzaSimile.getKcal() - pietanza.getKcal()))) {
                    pietanzaSimile = altraPietanza;
                }
            }
        }
        return pietanzaSimile;
    }
}
