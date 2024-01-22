package it.unibas.comuni.persistenza;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.unibas.comuni.modello.Archivio;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAOArchivioJson implements IDAOArchivio {

    private Logger logger = LoggerFactory.getLogger(DAOArchivioJson.class);

    @Override
    public Archivio carica(InputStream inputStream) throws DAOException {
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            Archivio archivio = gson.fromJson(new InputStreamReader(inputStream), Archivio.class);
            logger.debug("Caricato l'archivio contenente " + archivio.getListaComuni().size() + " comuni");
            return archivio;
        } catch (Exception e) {
            throw new DAOException("Impossibile caricate il file json " + e.getLocalizedMessage());
        }

    }

}
