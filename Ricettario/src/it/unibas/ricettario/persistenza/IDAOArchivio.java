package it.unibas.ricettario.persistenza;

import it.unibas.ricettario.modello.Archivio;

public interface IDAOArchivio {

    Archivio carica(String nomeFile) throws DAOException;

}
