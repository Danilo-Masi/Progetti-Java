package it.unibas.bookrental.controllo;

import it.unibas.bookrental.Applicazione;
import it.unibas.bookrental.Costanti;
import it.unibas.bookrental.modello.Archivio;
import it.unibas.bookrental.persistenza.DAOException;
import it.unibas.bookrental.persistenza.IDAOArchvio;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloMenu {

    private Action azioneEsci = new AzioneEsci();
    private Action azioneCarica = new AzioneCarica();
    private Action azioneVerifica = new AzioneVerifica();

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            this.putValue(NAME, "Verifica");
            this.putValue(SHORT_DESCRIPTION, "Verifica archivio");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            boolean verifica = archivio.verificaArchivio();
            if (verifica) {
                Applicazione.getInstance().getFrame().mostraMessaggio("Tra i libri presi in prestito da più di 6 mesi ci sono più volte libri di uno stesso autore");
            } else {
                Applicazione.getInstance().getFrame().mostraMessaggio("Tutti i libri presi in prestito da da più di 6 mesi appartengono ad autori diversi");
            }
        }
    }

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Carica Archivio Mock");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchvio dAOArchvio = Applicazione.getInstance().getdAOArchvio();
            try {
                Archivio archivio = dAOArchvio.carica("");
                Applicazione.getInstance().getModello().putBeans(Costanti.ARCHIVIO, archivio);
                Applicazione.getInstance().getFrame().mostraMessaggio("Archivio contenente " + archivio.getListaUtenti().size() + " utenti, caricato correttamente");
                //Attivazione azioni
                Applicazione.getInstance().getControlloPrincipale().getAzioneRicerca().setEnabled(true);
                Applicazione.getInstance().getControlloPrincipale().getAzioneMostraDettagliUtente().setEnabled(true);
                Applicazione.getInstance().getControlloMenu().getAzioneVerifica().setEnabled(true);
            } catch (DAOException DAOex) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Errore nel caricamento dell'archivio");
                return;
            }
        }
    }

    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
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

    public Action getAzioneVerifica() {
        return azioneVerifica;
    }

    public Action getAzioneCarica() {
        return azioneCarica;
    }

    public Action getAzioneEsci() {
        return azioneEsci;
    }

}
