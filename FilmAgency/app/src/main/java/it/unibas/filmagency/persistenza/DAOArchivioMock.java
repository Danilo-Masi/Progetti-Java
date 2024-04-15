package it.unibas.filmagency.persistenza;

import it.unibas.filmagency.modello.Archivio;
import it.unibas.filmagency.modello.Attore;
import it.unibas.filmagency.modello.Film;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivioMock implements IDAOArchivio {

    @Override
    public Archivio carica(String nomeFile) throws DAOException{
        Archivio archivio = new Archivio();

        Calendar dataUscita1 = new GregorianCalendar(2023, Calendar.AUGUST, 23);
        Film film1 = new Film("Oppenheimer", dataUscita1, "Christopher Nolan", "Drammatico");
        Attore attore1 = new Attore("Cillina Murphy", "Irlandese", 1976);
        film1.aggiungiAttore(attore1);
        archivio.aggiungiFilm(film1);

        Calendar dataUscita2 = new GregorianCalendar(2023, Calendar.JULY, 22);
        Film film2 = new Film("Barbie", dataUscita2, "Cubric", "Comico");
        Attore attore2 = new Attore("MArgot Robbie", "Australiana", 1990);
        film2.aggiungiAttore(attore2);
        archivio.aggiungiFilm(film2);

        return archivio;
    }

}
