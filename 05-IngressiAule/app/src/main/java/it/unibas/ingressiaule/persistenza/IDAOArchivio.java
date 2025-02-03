package it.unibas.ingressiaule.persistenza;

import it.unibas.ingressiaule.modello.Archivio;

public interface IDAOArchivio {

    Archivio carica(String nomeFile) throws DAOException;

}
