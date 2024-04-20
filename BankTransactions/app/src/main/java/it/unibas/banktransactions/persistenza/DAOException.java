package it.unibas.banktransactions.persistenza;

public class DAOException extends Exception {

    public DAOException() {
    }

    public DAOException(String msg) {
        super(msg);
    }
}
