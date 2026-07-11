package it.unibas.ricettario.controllo;

import it.unibas.ricettario.Applicazione;
import it.unibas.ricettario.modello.Archivio;
import it.unibas.ricettario.modello.Costanti;
import it.unibas.ricettario.persistenza.DAOException;
import it.unibas.ricettario.persistenza.IDAOArchivio;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlloMenu {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(ControlloMenu.class);

    private Action azioneEsci = new AzioneEsci();
    private Action azioneCarica = new AzioneCarica();

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(NAME, "Carica archivio");
            this.putValue(SHORT_DESCRIPTION, "Carica l'archivio con i dati");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio dAOArchivio = Applicazione.getInstance().getdAOArchivio();
            try {
                Archivio archivio = dAOArchivio.carica(" ");
                Applicazione.getInstance().getModello().putBean(Costanti.ARCHIVIO, archivio);
                Applicazione.getInstance().getFrame().mostraMessaggio("Caricato l'archvio contentente " + archivio.getPietanze().size() + " pietanze");
                // Abilita azioni
                Applicazione.getInstance().getControlloPrincipale().getAzioneCercaTipologia().setEnabled(true);
                Applicazione.getInstance().getControlloPrincipale().getAzioneCercaPietanzaSimile().setEnabled(true);
            } catch (DAOException ex) {
                logger.debug("Exception durante il caricamento dell'archivio: {}", ex.toString());
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Errore durante il caricamento dell'archivio");
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

    public Action getAzioneEsci() {
        return azioneEsci;
    }

    public Action getAzioneCarica() {
        return azioneCarica;
    }

}
