package it.unibas.companydetails.persistenza;

import it.unibas.companydetails.modello.Archivio;
import it.unibas.companydetails.modello.Azienda;
import it.unibas.companydetails.modello.Dipendente;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivioMock implements IDAOArchivio {

    @Override
    public Archivio carica(String nomeFile) throws DAOException {
        Archivio archivio = new Archivio();

        Azienda spaceX = new Azienda(8282827, "SpaceX", "Houstin");

        Calendar dataAssunzione1 = new GregorianCalendar(2016, Calendar.JANUARY, 1);
        Dipendente dipendente1 = new Dipendente("ELNMKS", "Elon", "Musk", dataAssunzione1, "Texas");
        spaceX.aggiungiDipendente(dipendente1);

        Calendar dataAssunzione2 = new GregorianCalendar(2020, Calendar.FEBRUARY, 23);
        Dipendente dipendente2 = new Dipendente("MSADNL", "Dani", "Zara", dataAssunzione2, "Basilicata");
        spaceX.aggiungiDipendente(dipendente2);

        Azienda apple = new Azienda(161616, "Apple", "Palo Alto");

        Calendar dataAssunzione3 = new GregorianCalendar(1990, Calendar.APRIL, 29);
        Dipendente dipendente3 = new Dipendente("STVJOB", "Steve", "Jobs", dataAssunzione3, "California");
        apple.aggiungiDipendente(dipendente3);

        archivio.aggiungiAzienda(spaceX);
        archivio.aggiungiAzienda(apple);

        return archivio;
    }

}
