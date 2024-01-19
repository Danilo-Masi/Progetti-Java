package it.unibas.concorsi.persistenza;

import it.unibas.concorsi.modello.Archivio;
import it.unibas.concorsi.modello.Concorso;
import it.unibas.concorsi.modello.Costanti;
import it.unibas.concorsi.modello.Domanda;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivio implements IDAOArchivioMock {

    @Override
    public Archivio carica(String nomeFile) throws DAOException {
        Archivio archivio = new Archivio();
        //Concorso 1
        Concorso concorso1 = new Concorso("BI01", "Concorso banca", 100, "Lazio",
                new GregorianCalendar(2020, Calendar.APRIL, 1, 10, 30));
        //Domande Concorso 1
        concorso1.addDomanda(new Domanda("MSADNL99", Costanti.MASCHIO,
                new GregorianCalendar(2020, Calendar.MAY, 3, 11, 15)));
        concorso1.addDomanda(new Domanda("CIATTT88", Costanti.FEMMINA,
                new GregorianCalendar(2020, Calendar.JULY, 21, 13, 23)));
        //Concorso 2
        Concorso concorso2 = new Concorso("AI04", "Concorso poste", 510, "Lazio",
                new GregorianCalendar(2023, Calendar.SEPTEMBER, 29, 8, 0));
        //Aggiunge i concorsi all'archivio
        archivio.addConcorso(concorso1);
        archivio.addConcorso(concorso2);
        return archivio;
    }

}
