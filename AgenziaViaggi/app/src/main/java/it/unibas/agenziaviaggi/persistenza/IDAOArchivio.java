package it.unibas.agenziaviaggi.persistenza;

import it.unibas.agenziaviaggi.modello.Archivio;

public interface IDAOArchivio {

    Archivio carica(String fileName) throws DAOException;

}
