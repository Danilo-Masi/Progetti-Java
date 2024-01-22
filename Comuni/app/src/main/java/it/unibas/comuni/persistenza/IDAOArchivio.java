package it.unibas.comuni.persistenza;

import it.unibas.comuni.modello.Archivio;
import java.io.InputStream;

public interface IDAOArchivio {

    Archivio carica(InputStream inputStream) throws DAOException;

}
