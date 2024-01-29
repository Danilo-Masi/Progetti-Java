package it.unibas.appfilm.controllo;

import it.unibas.appfilm.Applicazione;
import it.unibas.appfilm.Costanti;
import it.unibas.appfilm.modello.Archivio;
import it.unibas.appfilm.persistenza.DAOException;
import it.unibas.appfilm.persistenza.IDAOArchivio;
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
        
        private AzioneVerifica() {
            this.putValue(NAME, "Verifica");
            this.putValue(SHORT_DESCRIPTION, "Verifica duplicati");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            this.setEnabled(false);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            boolean verifica = archivio.verificaDuplicati();
            if (verifica) {
                Applicazione.getInstance().getFrame().mostraMessaggio("L'archivio contiene attori duplicati");
            } else {
                Applicazione.getInstance().getFrame().mostraMessaggio("L'archivio NON contiene attori duplicati");
            }
        }
    }
    
    private class AzioneCarica extends AbstractAction {
        
        private AzioneCarica() {
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Carica archivio mock");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio dAOArchivio = Applicazione.getInstance().getDaoArchivio();
            try {
                Archivio archivio = dAOArchivio.carica("");
                Applicazione.getInstance().getModello().putBeans(Costanti.ARCHIVIO, archivio);
                Applicazione.getInstance().getFrame().mostraMessaggio("Archivio caricato, contiene " + archivio.getListaFilm().size() + " film");
                //Abilita azioni
                Applicazione.getInstance().getControlloPrincipale().getAzioneCercaFilm().setEnabled(true);
                Applicazione.getInstance().getControlloPrincipale().getAzioneNuovoAttore().setEnabled(true);
                Applicazione.getInstance().getControlloMenu().getAzioneVerifica().setEnabled(true);
            } catch (DAOException daoEx) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Errore nel caricamento");
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
    
    public Action getAzioneVerifica() {
        return azioneVerifica;
    }
    
}
