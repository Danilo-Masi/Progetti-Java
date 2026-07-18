package it.unibas.comuni.controllo;

import it.unibas.comuni.Applicazione;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlloMenu {

    private Logger logger = LoggerFactory.getLogger(ControlloMenu.class);

    private Action azioneEsci = new AzioneEsci();
    private Action azioneCarica = new AzioneCarica();

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Carica archivio Json");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_J);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt J"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser(new File("./src/test/resources"));
            int risultato = fileChooser.showOpenDialog(Applicazione.getInstance().getFrame());
            if (risultato != JFileChooser.APPROVE_OPTION) {
                logger.debug("L'utente ha annulato");
                return;
            }
            File fileSelezionato = fileChooser.getSelectedFile();
            logger.debug("File selezionato: " + fileSelezionato.getName());
            Applicazione.getInstance().getFrame().mostraCursoreCaricamento();
            WorkerCaricaArchivio workerCaricaArchivio = new WorkerCaricaArchivio(fileSelezionato);
            workerCaricaArchivio.execute();
            Applicazione.getInstance().getFrame().nascondiCursoreCaricamento();
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Azione Esci">   
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
