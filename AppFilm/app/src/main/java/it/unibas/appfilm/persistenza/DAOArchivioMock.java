package it.unibas.appfilm.persistenza;

import it.unibas.appfilm.modello.Archivio;
import it.unibas.appfilm.modello.Attore;
import it.unibas.appfilm.modello.Film;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivioMock implements IDAOArchivio {
    
    @Override
    public Archivio carica(String nomeFile) throws DAOException {
        Archivio archivio = new Archivio();
        
        //Creiamo un nuovo film
        Calendar dataFilm1 = new GregorianCalendar(1974, Calendar.JULY, 3);
        Film film1 = new Film("Ritorno al futuro", dataFilm1, "Albert Heipstain", "Avventura");
        film1.aggiungiAttore(new Attore("Michael J Fox", "Statunitense", 1956));
        film1.aggiungiAttore(new Attore("Luigi Bardi", "Italiana", 1933));
        film1.aggiungiAttore(new Attore("Elmett Brown", "Statunitense", 1948));
        archivio.aggiungiFilm(film1);
        
        //Creiamo un nuovo film
        Calendar dataFilm2 = new GregorianCalendar(2020, Calendar.APRIL, 22);
        Film film2 = new Film("Interstellar", dataFilm2, "Cristopher Nolan", "Drammatico");
        film2.aggiungiAttore(new Attore("Mattew Machgonowey", "Statunitense", 1975));
        film2.aggiungiAttore(new Attore("Elizhabet Holsen", "Inglese", 1986));
        archivio.aggiungiFilm(film2);
        
        return archivio;
    }

}
