package it.unibas.ricettario.controllo;

import it.unibas.ricettario.Applicazione;
import it.unibas.ricettario.modello.Archivio;
import it.unibas.ricettario.modello.Costanti;
import it.unibas.ricettario.modello.Modello;
import it.unibas.ricettario.modello.Pietanza;
import it.unibas.ricettario.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private Action AzioneCerca = new AzioneCerca();
    private Action AzoneCercaPietanzaSimile = new AzioneCercaPietanzaSimile();

    private class AzioneCercaPietanzaSimile extends AbstractAction {

        public AzioneCercaPietanzaSimile() {
            this.putValue(NAME, "Cerca pietanza simile ");
            this.putValue(SHORT_DESCRIPTION, "Cerca tutte le pietanze simili a quella selezionata");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_J);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt J"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            //Preleva la riga selezionata dall'utente
            int rigaSelezionata = vistaPrincipale.getRigaSelezionata();
            //Verifica che una riga sia stata selezionata
            if (rigaSelezionata == -1) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Devi selezionare una pietanza dalla tabella");
                return;
            }
            //Preleva la lista filtrata delle pietanze dal modello
            Modello modello = Applicazione.getInstance().getModello();
            List<Pietanza> listaFiltrata = (List<Pietanza>) modello.getBeans(Costanti.LISTA_FILTRATA);
            //Preleva il valore della riga selezionata dalla lista 
            Pietanza pietanzaSelezionata = listaFiltrata.get(rigaSelezionata);
            //Carica il metodo dall'archivio per cercare la lista delle pietanze simile
            Archivio archivio = (Archivio) modello.getBeans(Costanti.ARCHIVIO);
            Pietanza pietanzaSimile = archivio.cercaPietanzaSimile(pietanzaSelezionata);
            //Verifica che ci sia una pietanza simile
            if (pietanzaSimile == null) {
                Applicazione.getInstance().getFrame().mostraMessagio("Non esiste nessuna pietanza simile");
                return;
            }
            //Restituisce il risultato
            Applicazione.getInstance().getFrame().mostraMessagio("La pietanza piu simile a quella selezionata è: " + pietanzaSimile.getNome());
        }

    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca ");
            this.putValue(SHORT_DESCRIPTION, "Cerca tutte le pietanze della tipologia scelta");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_D);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt D"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //Preleva il valore selezionato dall'utente nella comboBox
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            String categoria = vistaPrincipale.getComboCategoria();
            //Verifica che sia stato selezionato un valore correttamente
            if (categoria.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Seleziona prima una categoria di pietanze");
                return;
            }
            //Preleva i dati dell'archivio precedentemente caricato nel modello
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            //Filtra le pietanze in base alla categoria selezionata dall'utente
            List<Pietanza> pietanzeFiltrate = archivio.cercaPietanzePerCategoria(categoria);
            //Carico una lista nel modello con le pietanze filtrate
            Applicazione.getInstance().getModello().putBean(Costanti.LISTA_FILTRATA, pietanzeFiltrate);
            //Aggiorna visivamente la tabella
            vistaPrincipale.aggiornaTabella();
        }

    }

    public Action getAzioneCerca() {
        return AzioneCerca;
    }

    public Action getAzoneCercaPietanzaSimile() {
        return AzoneCercaPietanzaSimile;
    }

}
