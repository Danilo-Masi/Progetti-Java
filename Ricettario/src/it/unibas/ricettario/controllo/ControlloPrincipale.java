package it.unibas.ricettario.controllo;

import it.unibas.ricettario.Applicazione;
import it.unibas.ricettario.modello.Archivio;
import it.unibas.ricettario.modello.Costanti;
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
            //Prendi il valore inserito dall'utenet
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            String categoria = vistaPrincipale.getComboCategoria();
            //Verifica che il valore sia buono
            if(categoria.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Seleziona prima una categoria di pietanze");
                return;
            }
            //Prende i dati dell'archivio precedentemente caricato nel modello
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            //Filtra le pietanze in base alla categoria selezionata dall'utente
            List<Pietanza> pietanzeFiltrate = archivio.cercaPietanzePerCategoria(categoria);
            //Carico una lista nel modello con le pietanze filtrate
            Applicazione.getInstance().getModello().putBean(Costanti.LISTA_FILTRATA, pietanzeFiltrate);
            //Aggiorna visualmente la tabella
            vistaPrincipale.aggiornaTabella();
            
        }

    }

    public Action getAzioneCerca() {
        return AzioneCerca;
    }

}
