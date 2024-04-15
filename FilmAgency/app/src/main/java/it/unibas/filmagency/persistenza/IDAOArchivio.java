package it.unibas.filmagency.persistenza;

import it.unibas.filmagency.modello.Archivio;

public interface IDAOArchivio {

    Archivio carica(String nomeFile) throws DAOException;

}
