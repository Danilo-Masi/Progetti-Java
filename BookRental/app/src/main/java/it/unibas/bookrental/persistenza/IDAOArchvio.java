package it.unibas.bookrental.persistenza;

import it.unibas.bookrental.modello.Archivio;

public interface IDAOArchvio {

    Archivio carica(String nomeFile) throws DAOException;

}
