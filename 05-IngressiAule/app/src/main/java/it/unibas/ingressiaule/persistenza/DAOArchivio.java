package it.unibas.ingressiaule.persistenza;

import it.unibas.ingressiaule.modello.Accesso;
import it.unibas.ingressiaule.modello.Archivio;
import it.unibas.ingressiaule.modello.Aula;
import it.unibas.ingressiaule.modello.Costanti;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String nomeFile) throws DAOException {
        Archivio archivio = new Archivio();

        Aula aula1 = new Aula("101A", "Aula Magna", 0);
        Accesso a1 = new Accesso("60203A", "Danilo Masi", 123, Costanti.ESAME, new GregorianCalendar(2025, Calendar.APRIL, 28, 10, 30));
        Accesso a2 = new Accesso("89001B", "Carmine Rossi", 8, Costanti.LEZIONE, new GregorianCalendar(2025, Calendar.JULY, 2, 15, 22));
        Accesso a3 = new Accesso("12343H", "Mario Naval", 34, Costanti.RICEVIMENTO, new GregorianCalendar(2025, Calendar.SEPTEMBER, 12, 12, 22));
        aula1.aggiungiAccesso(a1);
        aula1.aggiungiAccesso(a2);
        aula1.aggiungiAccesso(a3);

        Aula aula2 = new Aula("BII2", "Aula Newton", 2);
        aula2.aggiungiAccesso(new Accesso("23456O", "Mirko Bonanni", 178, Costanti.LEZIONE, new GregorianCalendar(2024, Calendar.AUGUST, 2, 10, 30)));

        archivio.aggiungiAula(aula1);
        archivio.aggiungiAula(aula2);
        
        return archivio;
    }

}
