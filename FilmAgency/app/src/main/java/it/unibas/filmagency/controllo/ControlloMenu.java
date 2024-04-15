package it.unibas.filmagency.controllo;

import it.unibas.filmagency.Applicazione;
import it.unibas.filmagency.Costanti;
import it.unibas.filmagency.modello.Archivio;
import it.unibas.filmagency.persistenza.DAOException;
import it.unibas.filmagency.persistenza.IDAOArchivio;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloMenu {

    private Action azioneEsci = new AzioneEsci();
    private Action azioneCarica = new AzioneCarica();
    private Action azioneVerificaDuplicati = new AzioneVerificaDuplicati();

    private class AzioneVerificaDuplicati extends AbstractAction {

        public AzioneVerificaDuplicati() {
            this.putValue(NAME, "Verifica");
            this.putValue(SHORT_DESCRIPTION, "Verifica attori duplicati");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeand(Costanti.ARCHIVIO);
            boolean verifica = archivio.verificaDuplicati();
            if (verifica) {
                Applicazione.getInstance().getFrame().mostraMessaggio("Ci sono attori che hanno partecipato a piu film");
            } else {
                Applicazione.getInstance().getFrame().mostraMessaggio("Non ci sono attori che hanno partecipato a piu film");
            }
        }
    }

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Carica archivio Mock");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio dAOArchivio = Applicazione.getInstance().getdAOArchivio();
            try {
                Archivio archivio = dAOArchivio.carica("");
                Applicazione.getInstance().getModello().putBeans(Costanti.ARCHIVIO, archivio);
                Applicazione.getInstance().getFrame().mostraMessaggio("Arhchivio caricato correttamente");
                //Attiva azioni
                Applicazione.getInstance().getControlloPrincipale().getAzioneCercaFilm().setEnabled(true);
                Applicazione.getInstance().getControlloPrincipale().getAzioneMostraDettagliFilm().setEnabled(true);
                Applicazione.getInstance().getControlloMenu().getAzioneVerificaDuplicati().setEnabled(true);
            } catch (DAOException DAOex) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Errore nel caricamento dell'archivio");
                return;
            }
        }
    }

    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'app");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt E"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public Action getAzioneVerificaDuplicati() {
        return azioneVerificaDuplicati;
    }

    public Action getAzioneCarica() {
        return azioneCarica;
    }

    public Action getAzioneEsci() {
        return azioneEsci;
    }

}
