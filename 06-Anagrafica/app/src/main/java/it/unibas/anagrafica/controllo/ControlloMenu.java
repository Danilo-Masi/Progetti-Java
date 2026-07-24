package it.unibas.anagrafica.controllo;

import it.unibas.anagrafica.Applicazione;
import it.unibas.anagrafica.modello.Archivio;
import it.unibas.anagrafica.modello.Costanti;
import it.unibas.anagrafica.persistenza.DAOException;
import it.unibas.anagrafica.persistenza.IDAOArchivio;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloMenu {

    private Action azioneEsci = new AzioneEsci();
    private Action azioneCarica = new AzioneCarica();
    private Action azionVerifica = new AzioneVerifica();

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            this.putValue(NAME, "Verifica");
            this.putValue(SHORT_DESCRIPTION, "Verifica Archivio");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
            boolean verifica = archivio.verificaDisparita();
            if (verifica) {
                Applicazione.getInstance().getFrame().mostraMessaggio("Nell'archivio cè una regione con 3 volte il numero di dipendneti di un altra ");
            } else {
                Applicazione.getInstance().getFrame().mostraMessaggio("NON ci sono regioni con forti diparita");
            }
        }
    }

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Carica dati dall'archivio");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio dAOArchivio = Applicazione.getInstance().getDaoArchivio();
            try {
                Archivio archivio = dAOArchivio.carica("");
                Applicazione.getInstance().getFrame().mostraMessaggio("Caricato archivio contenente: " + archivio.getListaAziende().size() + " aziende");
                Applicazione.getInstance().getModello().putBean(Costanti.ARCHIVIO, archivio);
                // Abilita azioni
                Applicazione.getInstance().getControlloPrincipale().getAzioneCercaPerCitta().setEnabled(true);
                Applicazione.getInstance().getControlloPrincipale().getAzioneSeleziona().setEnabled(true);
                Applicazione.getInstance().getControlloMenu().getAzionVerifica().setEnabled(true);
            } catch (DAOException ex) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Impossibile caricare l'archivio");
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

    public Action getAzionVerifica() {
        return azionVerifica;
    }

    public Action getAzioneEsci() {
        return azioneEsci;
    }

    public Action getAzioneCarica() {
        return azioneCarica;
    }

}
