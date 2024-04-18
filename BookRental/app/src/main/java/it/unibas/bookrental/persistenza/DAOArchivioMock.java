package it.unibas.bookrental.persistenza;

import it.unibas.bookrental.modello.Archivio;
import it.unibas.bookrental.modello.Libro;
import it.unibas.bookrental.modello.Utente;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivioMock implements IDAOArchvio {

    @Override
    public Archivio carica(String nomeFile) throws DAOException {
        Archivio archivio = new Archivio();

        Utente utente1 = new Utente("Dmasiiii", "Danilo", "Masi");
        Calendar dataInizio1 = new GregorianCalendar(2024, Calendar.OCTOBER, 1);
        Calendar dataFine1 = new GregorianCalendar(2024, Calendar.OCTOBER, 15);
        Libro libro1 = new Libro("Il Signore degli anelli", "J.R.R. Tolkien", dataInizio1, dataFine1);
        utente1.aggiungiLibro(libro1);
        Calendar dataInizio2 = new GregorianCalendar(2024, Calendar.SEPTEMBER, 2);
        Libro libro2 = new Libro("Norwegian Woods", "Murakami", dataInizio2, null);
        utente1.aggiungiLibro(libro2);
        archivio.aggiungiUtente(utente1);

        return archivio;
    }

}
