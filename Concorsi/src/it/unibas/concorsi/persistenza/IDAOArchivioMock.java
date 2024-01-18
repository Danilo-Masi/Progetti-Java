package it.unibas.concorsi.persistenza;

import it.unibas.concorsi.modello.Archivio;

public interface IDAOArchivioMock {

    Archivio carica(String nomeFile) throws DAOException;

}
