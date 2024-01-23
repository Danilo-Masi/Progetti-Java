package it.unibas.ingressiaule.persistenza;

import it.unibas.ingressiaule.Costanti;
import it.unibas.ingressiaule.modello.Accesso;
import it.unibas.ingressiaule.modello.Archivio;
import it.unibas.ingressiaule.modello.Aula;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivioMock implements IDAOArchivio {

    @Override
    public Archivio carica(String nomefile) throws DAOException {
        Archivio archivio = new Archivio();

        Aula aula1 = new Aula("AA33", "Aula Fibonacci", 1);
        Calendar dataAccesso1 = new GregorianCalendar(2020, Calendar.APRIL, 28);
        aula1.addAccesso(new Accesso("DM603", "Danilo Masi", 177, Costanti.LEZIONE, dataAccesso1));
        Calendar dataAccesso2 = new GregorianCalendar(2020, Calendar.MAY, 2);
        aula1.addAccesso(new Accesso("MM78", "Martin Garriz", 7, Costanti.ESAME, dataAccesso2));
        archivio.addAula(aula1);

        return archivio;
    }

}
