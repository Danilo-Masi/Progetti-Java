package it.unibas.travelagency.controllo;

import it.unibas.travelagency.Applicazione;
import it.unibas.travelagency.modello.Archivio;
import it.unibas.travelagency.modello.Costanti;
import it.unibas.travelagency.persistenza.DAOException;
import it.unibas.travelagency.persistenza.IDAOArchivio;
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
            boolean verificaArchivio = archivio.verificaArchivio();
            if (verificaArchivio) {
                Applicazione.getInstance().getFrame().mostraMessaggio("Si ci sono pacchetti che si sovrappongono in più mesi");
            } else {
                Applicazione.getInstance().getFrame().mostraMessaggio("Non ci sono pacchetti che si sovrappongono in più mesi");
            }
        }
    }

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Carica archivio");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            IDAOArchivio dAOArchivio = Applicazione.getInstance().getdAOArchivio();
            try {
                Archivio archivio = dAOArchivio.carica("");
                Applicazione.getInstance().getModello().putBeans(Costanti.ARCHIVIO, archivio);
                Applicazione.getInstance().getFrame().mostraMessaggio("Archivio caricato correttamente");
                //Abilita e disabilita azioni
                Applicazione.getInstance().getControlloPrincipale().getAzioneCercaAgenzie().setEnabled(true);
                Applicazione.getInstance().getControlloPrincipale().getAzioneMostraDettagli().setEnabled(true);
                Applicazione.getInstance().getControlloMenu().getAzioneVerifica().setEnabled(true);
            } catch (DAOException daoE) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Errore nel caricamento dell'archivio " + daoE);
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
