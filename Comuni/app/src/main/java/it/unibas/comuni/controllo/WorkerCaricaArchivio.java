package it.unibas.comuni.controllo;

import it.unibas.comuni.Applicazione;
import it.unibas.comuni.Costanti;
import it.unibas.comuni.modello.Archivio;
import it.unibas.comuni.persistenza.DAOException;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.SwingWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkerCaricaArchivio extends SwingWorker {
    
    private Logger logger = LoggerFactory.getLogger(WorkerCaricaArchivio.class);
    
    private File fileDaCaricare;
    
    public WorkerCaricaArchivio(File fileDaCaricare) {
        this.fileDaCaricare = fileDaCaricare;
    }

    //Operazioni eseguite sul thread secondario
    @Override
    protected Object doInBackground() throws Exception {
        logger.debug("Carico il file: " + fileDaCaricare);
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fileDaCaricare);
            Archivio archivio = Applicazione.getInstance().getDaoArchivio().carica(inputStream);
            logger.debug("Ho caricato l'archivio");
            //Thread.sleep(3000); 
            return archivio;
        } catch (DAOException ex) {
            logger.error("Eccezzione durante il caricamento " + ex.getLocalizedMessage());
            return null;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    //Operazioni eseguite sul thread principale
    //(Viene caricato una volta che il metodo doInBackgorund è concluso)
    @Override
    protected void done() {
        try {
            //Il metodo get restituisce il return di doInBackgound
            Archivio archivio = (Archivio) this.get();
            //Verifica che l'archivio non sia null
            if (archivio == null) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Impossibile caricare l'archivio da file");
                return;
            }
            //Carica l'archivio nel modello
            Applicazione.getInstance().getModello().putBeans(Costanti.ARCHIVIO, archivio);
            Applicazione.getInstance().getFrame().mostraMessaggio("Archivio Json caricato correttamente");
            //Reimposta il cursore di default
            Applicazione.getInstance().getFrame().nascondiCursoreCaricamento();
            //Abilita l'azione una volta caricato l'archivio
            Applicazione.getInstance().getControlloPrincipale().getAzioneCalcola().setEnabled(true);
        } catch (Exception ex) {
            Applicazione.getInstance().getFrame().mostraMessaggioErrore("Impossibile caricare l'archivio da file");
        }
    }
    
}
