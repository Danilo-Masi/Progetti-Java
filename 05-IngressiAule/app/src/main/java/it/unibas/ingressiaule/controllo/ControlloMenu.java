package it.unibas.ingressiaule.controllo;

import it.unibas.ingressiaule.Applicazione;
import it.unibas.ingressiaule.modello.Archivio;
import it.unibas.ingressiaule.modello.Costanti;
import it.unibas.ingressiaule.persistenza.DAOException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloMenu {

    private Action azioneEsci = new AzioneEsci();
    private Action azioneCarica = new AzioneCarica();

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Carica l'archivio");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Archivio archivio = Applicazione.getInstance().getDaoArchivio().carica("");
                Applicazione.getInstance().getModello().putBeans(Costanti.ARCHIVIO, archivio);
                Applicazione.getInstance().getFrame().mostraMessaggio("Archivo caricato correttamente contenente " + archivio.getListaAule().size() + " aule");
                // Abilita funzionalità
                Applicazione.getInstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
                Applicazione.getInstance().getControlloPrincipale().getAzioneInserisci().setEnabled(true);
            } catch (DAOException ex) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Errore durante il caricamento dell'archivio");
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

    public Action getAzioneCarica() {
        return azioneCarica;
    }

    public Action getAzioneEsci() {
        return azioneEsci;
    }

}
