package it.unibas.banktransactions.persistenza;

import it.unibas.banktransactions.modello.Archivio;
import it.unibas.banktransactions.modello.ContoCorrente;
import it.unibas.banktransactions.modello.Movimento;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchvioMock implements IDAOArchivio {

    @Override
    public Archivio carica(String nomeFile) throws DAOException{
        Archivio archivio = new Archivio();

        ContoCorrente c1 = new ContoCorrente("IT56FG", "Andrea Faro", new GregorianCalendar(2023, Calendar.APRIL, 28));
        Movimento m1 = new Movimento(new GregorianCalendar(2024, Calendar.MAY, 9, 10, 11), 123.98, "Bonifico");
        Movimento m2 = new Movimento(new GregorianCalendar(2024, Calendar.MAY, 19, 13, 02), 66.00, "Bonifico");
        Movimento m3 = new Movimento(new GregorianCalendar(2024, Calendar.MAY, 29, 22, 00), 3.45, "Pagamento pos");
        c1.aggiungiMovimento(m1);
        c1.aggiungiMovimento(m2);
        c1.aggiungiMovimento(m3);
        
        ContoCorrente c2 = new ContoCorrente("CIAO78", "Danl Nid", new GregorianCalendar(2023, Calendar.APRIL, 28));

        archivio.aggiungiContoCorrente(c1);
        archivio.aggiungiContoCorrente(c2);

        return archivio;
    }

}
