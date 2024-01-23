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

    private Action azioneCarica = new AzioneCarica();
    private Action azioneEsci = new AzioneEsci();

    private class AzioneCarica extends AbstractAction {

        private AzioneCarica() {
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Carica archivio");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //Crea il compoente per selezionare il file
            JFileChooser fileChooser = new JFileChooser(new File("."));
            //Apre la dialog per selezionare il file
            int risultato = fileChooser.showOpenDialog(Applicazione.getInstance().getFrame());
            //Verifica che sia stato selezionato un file
            if (risultato != JFileChooser.APPROVE_OPTION) {
                return;
            }
            //Prende il file selezionato
            File fileSelezionato = fileChooser.getSelectedFile();
            logger.debug("File selezionato: " + fileSelezionato);
            //Imposta il cursore di caricamento
            Applicazione.getInstance().getFrame().mostraCursoreCaricamento();
            //Richiamo il WorkerCaricaArchivio per dividere il thread principale da quello secondario
            WorkerCaricaArchivio workerCaricaArchivio = new WorkerCaricaArchivio(fileSelezionato);
            workerCaricaArchivio.execute();
        }

    }

    private class AzioneEsci extends AbstractAction {

        private AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_Z);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt Z"));
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
