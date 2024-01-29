package it.unibas.appfilm.persistenza;

import it.unibas.appfilm.modello.Archivio;

public interface IDAOArchivio {

    Archivio carica(String nomeFile) throws DAOException;

}
