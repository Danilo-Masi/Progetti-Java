package it.unibas.concorsi.persistenza;

import it.unibas.concorsi.modello.Archivio;


public interface IDAOArchivio {

    Archivio carica(String nomeFile) throws DAOException;
    
}
