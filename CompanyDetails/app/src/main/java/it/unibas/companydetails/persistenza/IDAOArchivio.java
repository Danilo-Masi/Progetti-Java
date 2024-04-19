package it.unibas.companydetails.persistenza;

import it.unibas.companydetails.modello.Archivio;

public interface IDAOArchivio {

    Archivio carica(String nomeFile) throws DAOException;

}
