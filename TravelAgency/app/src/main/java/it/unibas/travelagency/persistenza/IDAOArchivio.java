package it.unibas.travelagency.persistenza;

import it.unibas.travelagency.modello.Archivio;

public interface IDAOArchivio {

    Archivio carica(String nomeFile) throws DAOException;

}
