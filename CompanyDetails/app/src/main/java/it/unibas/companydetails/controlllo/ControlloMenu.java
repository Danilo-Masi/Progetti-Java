package it.unibas.companydetails.controlllo;

import it.unibas.companydetails.Applicazione;
import it.unibas.companydetails.Costanti;
import it.unibas.companydetails.modello.Archivio;
import it.unibas.companydetails.persistenza.DAOException;
import it.unibas.companydetails.persistenza.IDAOArchivio;
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
            if(verifica) {
                Applicazione.getInstance().getFrame().mostraMessaggio("La regione " + "" + "è la più frequente e ha per tre volte il numero di dipendenti residenti della regione " + "");
            }else {
                Applicazione.getInstance().getFrame().mostraMessaggio("Non ci sono forti disparità tra le varie regioni");
            }
        }
    }

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Carica archivio mock");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio dAOArchivio = Applicazione.getInstance().getdAOArchivio();
            try {
                Archivio archivio = dAOArchivio.carica("");
                Applicazione.getInstance().getModello().putBeans(Costanti.ARCHIVIO, archivio);
                Applicazione.getInstance().getFrame().mostraMessaggio("Archivio contenente " + archivio.getListaAziende().size() + " aziende, caricato correttamente");
                //Abilita azioni
                Applicazione.getInstance().getControlloPrincipale().getAzioneCercaAziende().setEnabled(true);
                Applicazione.getInstance().getControlloPrincipale().getAzioneMostraDettagli().setEnabled(true);
                Applicazione.getInstance().getControlloMenu().getAzioneVerifica().setEnabled(true);
            } catch (DAOException daoEx) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Errore durante il caricamento dell'archivio");
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
