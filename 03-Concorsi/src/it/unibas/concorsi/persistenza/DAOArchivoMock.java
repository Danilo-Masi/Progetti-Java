package it.unibas.concorsi.persistenza;

import it.unibas.concorsi.modello.Archivio;
import it.unibas.concorsi.modello.Concorso;
import it.unibas.concorsi.modello.Costanti;
import it.unibas.concorsi.modello.Domanda;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivoMock implements IDAOArchivio {

    @Override
    public Archivio carica(String nomeFile) throws DAOException {
        Archivio archivio = new Archivio();

        Concorso concorso1 = new Concorso("CON01", "Concorso per l'arma dei soltani", 345, Costanti.BASILICATA,
                new GregorianCalendar(2026, Calendar.JANUARY, 1, 10, 30));
        concorso1.aggiungiDomanda(new Domanda("MSADNL99", Costanti.MASCHIO, new GregorianCalendar(2026, Calendar.APRIL, 25, 12, 00)));
        concorso1.aggiungiDomanda(new Domanda("RFGPPP89", Costanti.FEMMINA, new GregorianCalendar(2026, Calendar.APRIL, 5, 11, 11)));
        concorso1.aggiungiDomanda(new Domanda("KAKALL56", Costanti.MASCHIO, new GregorianCalendar(2026, Calendar.JUNE, 12, 12, 12)));
        archivio.aggiungiConcorso(concorso1);

        Concorso concorso2 = new Concorso("CON02", "Concorso per gatti albini", 26, Costanti.VENETO,
                new GregorianCalendar(2026, Calendar.MAY, 7, 8, 00));
        concorso2.aggiungiDomanda(new Domanda("MSADNL99", Costanti.MASCHIO, new GregorianCalendar(2026, Calendar.APRIL, 25, 12, 00)));
        concorso2.aggiungiDomanda(new Domanda("RFGPPP89", Costanti.FEMMINA, new GregorianCalendar(2026, Calendar.APRIL, 5, 11, 11)));
        concorso2.aggiungiDomanda(new Domanda("KAKALL56", Costanti.MASCHIO, new GregorianCalendar(2026, Calendar.JUNE, 12, 12, 12)));
        archivio.aggiungiConcorso(concorso2);

        return archivio;
    }

}
