package it.unibas.ingressiaule.persistenza;

import it.unibas.ingressiaule.modello.Accesso;
import it.unibas.ingressiaule.modello.Archivio;
import it.unibas.ingressiaule.modello.Aula;
import it.unibas.ingressiaule.modello.Costanti;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivioMock implements IDAOArchivio {

    @Override
    public Archivio carica(String nomeFile) throws DAOException{
        Archivio archivio = new Archivio();

        Aula aula1 = new Aula("AU1", "Aula Magna", 0);
        aula1.aggiungiAccesso(new Accesso("60203", "Danilo masi", 123, Costanti.MOTIVAZIONE_ESAME,
                new GregorianCalendar(2026, Calendar.MAY, 6, 10, 30)));
        aula1.aggiungiAccesso(new Accesso("60201", "Mario Rossi", 123, Costanti.MOTIVAZIONE_RICEVIMENTO,
                new GregorianCalendar(2026, Calendar.APRIL, 29, 8, 11)));
        aula1.aggiungiAccesso(new Accesso("60210", "Luca Bianchi", 123, Costanti.MOTIVAZIONE_ESAME,
                new GregorianCalendar(2026, Calendar.MARCH, 22, 12, 0)));
        archivio.aggiungiAula(aula1);

        Aula aula2 = new Aula("AU1", "Aula Magna", 0);
        aula2.aggiungiAccesso(new Accesso("60203", "Danilo masi", 123, Costanti.MOTIVAZIONE_ESAME,
                new GregorianCalendar(2026, Calendar.MAY, 18, 10, 30)));
        aula2.aggiungiAccesso(new Accesso("60201", "Mario Rossi", 123, Costanti.MOTIVAZIONE_RICEVIMENTO,
                new GregorianCalendar(2026, Calendar.APRIL, 28, 8, 11)));
        aula2.aggiungiAccesso(new Accesso("60210", "Luca Bianchi", 123, Costanti.MOTIVAZIONE_ESAME,
                new GregorianCalendar(2026, Calendar.MARCH, 2, 12, 0)));
        aula2.aggiungiAccesso(new Accesso("60210", "Luca Bianchi", 123, Costanti.MOTIVAZIONE_ESAME,
                new GregorianCalendar(2026, Calendar.MARCH, 15, 12, 0)));
        archivio.aggiungiAula(aula2);

        Aula aula3 = new Aula("AU1", "Aula Magna", 0);
        aula3.aggiungiAccesso(new Accesso("60203", "Danilo masi", 123, Costanti.MOTIVAZIONE_ESAME,
                new GregorianCalendar(2026, Calendar.MAY, 2, 10, 30)));
        aula3.aggiungiAccesso(new Accesso("60201", "Mario Rossi", 123, Costanti.MOTIVAZIONE_RICEVIMENTO,
                new GregorianCalendar(2026, Calendar.APRIL, 4, 8, 11)));
        archivio.aggiungiAula(aula3);

        return archivio;
    }

}
