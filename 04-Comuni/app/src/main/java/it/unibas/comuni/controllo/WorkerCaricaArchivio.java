package it.unibas.comuni.controllo;

import it.unibas.comuni.Applicazione;
import it.unibas.comuni.modello.Archivio;
import it.unibas.comuni.modello.Costanti;
import it.unibas.comuni.persistenza.DAOException;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.SwingWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkerCaricaArchivio extends SwingWorker<Object, Object> {

    private Logger logger = LoggerFactory.getLogger(WorkerCaricaArchivio.class);
    private File fileDaCaricare;

    public WorkerCaricaArchivio(File fileDaCaricare) {
        this.fileDaCaricare = fileDaCaricare;
    }

    @Override
    protected Object doInBackground() throws Exception {
        logger.debug("Carico il file: " + fileDaCaricare.getName());
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileDaCaricare);
            Archivio archivio = Applicazione.getInstance().getdAOArchivio().carica(inputStream);
            logger.debug("Ho caricato l'archivio contenete " + archivio.getListaComuni().size() + " comuni ");
            // Inserito solo per mostrare che il thread sta lavorando in backgorund e non blocca l'interfaccia
            // Thread.sleep(10000); 
            return archivio;
        } catch (DAOException e) {
            logger.error("Eccezzione durante il carimento dei dati dal file: " + e.getLocalizedMessage());
            return null;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    @Override
    protected void done() {
        try {
            Archivio archivio = (Archivio) this.get();
            if (archivio == null) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Impossibile caricare l'archivio");
            }
            Applicazione.getInstance().getModello().putBean(Costanti.ARCHIVIO, archivio);
            Applicazione.getInstance().getFrame().mostraMessaggio("Caricato l'archivio contenente " + archivio.getListaComuni().size() + " comuni");
            // Abilita azioni
            Applicazione.getInstance().getControlloPrincipale().getAzioneCalcolaProvince().setEnabled(true);
        } catch (Exception ex) {
            Applicazione.getInstance().getFrame().mostraMessaggioErrore("Impossibile caricare l'archivio");
        }
    }

}
