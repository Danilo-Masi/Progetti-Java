package it.unibas.concorsi.persistenza;

import it.unibas.concorsi.modello.Archivio;
import it.unibas.concorsi.modello.Concorso;
import it.unibas.concorsi.modello.Costanti;
import it.unibas.concorsi.modello.Domanda;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String nomeFile) throws DAOException {
        Archivio archivio = new Archivio();

        Concorso c1 = new Concorso("b101", "Concorso pubbklico", 104, "Basilicata", new GregorianCalendar(2025, Calendar.APRIL, 22, 10, 30));
        c1.aggiungiDomanda(new Domanda("DNLDMM", Costanti.MASCHIO, new GregorianCalendar(2025, Calendar.FEBRUARY, 22, 9, 22)));
        c1.aggiungiDomanda(new Domanda("MIAO55", Costanti.FEMMINA, new GregorianCalendar(2025, Calendar.FEBRUARY, 21, 10, 01)));
        c1.aggiungiDomanda(new Domanda("SSS890", Costanti.MASCHIO, new GregorianCalendar(2025, Calendar.FEBRUARY, 12, 11, 52)));
        archivio.aggiungiConcorso(c1);

        Concorso c2 = new Concorso("f104", "Concorso finanza", 106, "Basilicata", new GregorianCalendar(2025, Calendar.JULY, 1, 12, 00));
        archivio.aggiungiConcorso(c2);

        return archivio;

    }

}
