package it.unibas.sistemiistituti.persistenza;

import it.unibas.sistemiistituti.modello.Archivio;

public interface IDAOArchivio {

    Archivio carica(String nomefile) throws DAOException;

}
