package it.unibas.compravenditeauto.persistenza;

import it.unibas.compravenditeauto.modello.Archivio;

public interface IDAOArchivio {

    Archivio carica(String nomeFile) throws DAOException;

}
