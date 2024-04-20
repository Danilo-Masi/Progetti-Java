package it.unibas.banktransactions.persistenza;

import it.unibas.banktransactions.modello.Archivio;

public interface IDAOArchivio {

    Archivio carica(String nomeFile) throws DAOException;

}
