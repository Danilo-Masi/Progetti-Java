package it.unibas.agenziaviaggi.controllo;

import it.unibas.agenziaviaggi.Applicazione;
import it.unibas.agenziaviaggi.Costanti;
import it.unibas.agenziaviaggi.modello.Archivio;
import it.unibas.agenziaviaggi.persistenza.DAOException;
import it.unibas.agenziaviaggi.persistenza.IDAOArchivio;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloMenu {

    private Action azioneEsci = new AzioneEsci();
    private Action azioneCarica = new AzioneCarica();

    private class AzioneCarica extends AbstractAction {

        private AzioneCarica() {
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Carica archivio mock");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio daoArchivio = Applicazione.getInstance().getDaoArchivio();
            try {
                Archivio archivio = daoArchivio.carica("");
                Applicazione.getInstance().getModello().putBeans(Costanti.ARCHIVIO, archivio);
                Applicazione.getInstance().getFrame().mostraMessaggio("Archvio caricato contenente: " + archivio.getListaAgenzie().size() + " agenzie");
                //Abilita azioni
                Applicazione.getInstance().getControlloPrincipale().getAzioneCercaAgenzie().setEnabled(true);
                Applicazione.getInstance().getControlloPrincipale().getAzioneAggiungiPacchetto().setEnabled(true);
            } catch (DAOException daoEx) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Impossibile caricare l'archivio " + daoEx.getMessage());
            }

        }

    }

    private class AzioneEsci extends AbstractAction {

        private AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt E"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public Action getAzioneCarica() {
        return azioneCarica;
    }

    public Action getAzioneEsci() {
        return azioneEsci;
    }

}
