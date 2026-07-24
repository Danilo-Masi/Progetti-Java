package it.unibas.banca.persistenza;

import it.unibas.banca.modello.Archivio;
import it.unibas.banca.modello.Conto;
import it.unibas.banca.modello.Movimento;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchvioMock implements IDAOArchivio {

    @Override
    public Archivio carica(String nomeFile) throws DAOException {
        Archivio archivio = new Archivio();

        Conto c1 = new Conto("IT8909", "Mario", "Draghi", new GregorianCalendar(2022, Calendar.APRIL, 28));
        c1.aggiungiMovimento(new Movimento(new GregorianCalendar(2024, Calendar.JANUARY, 1, 10, 30), -300.00, "Prelievo"));
        c1.aggiungiMovimento(new Movimento(new GregorianCalendar(2024, Calendar.APRIL, 29, 12, 0), 1389.00, "Stipendio"));
        c1.aggiungiMovimento(new Movimento(new GregorianCalendar(2024, Calendar.JUNE, 5, 19, 11), -892.89, "Bonifico vacanza"));
        archivio.aggiungiConto(c1);

        Conto c2 = new Conto("LT5678", "Silvio", "Berlusconi", new GregorianCalendar(2021, Calendar.JANUARY, 1));
        c2.aggiungiMovimento(new Movimento(new GregorianCalendar(2024, Calendar.MARCH, 1, 10, 30), 15000.00, "Stipendio"));
        c2.aggiungiMovimento(new Movimento(new GregorianCalendar(2024, Calendar.MARCH, 9, 11, 38), -67.11, "Pagamento pos"));
        c2.aggiungiMovimento(new Movimento(new GregorianCalendar(2024, Calendar.MAY, 1, 19, 11), 9892.50, "Stipendio"));
        archivio.aggiungiConto(c2);

        Conto c3 = new Conto("IT8909", "Mario", "Draghi", new GregorianCalendar(2022, Calendar.APRIL, 28));
        archivio.aggiungiConto(c3);

        return archivio;
    }

}
