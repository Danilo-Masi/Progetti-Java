package it.unibas.travelagency.persistenza;

import it.unibas.travelagency.modello.Agenzia;
import it.unibas.travelagency.modello.Archivio;
import it.unibas.travelagency.modello.Costanti;
import it.unibas.travelagency.modello.Pacchetto;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivioMock implements IDAOArchivio {

    @Override
    public Archivio carica(String nomeFile) throws DAOException {
        Archivio archivio = new Archivio();

        Agenzia agenzia1 = new Agenzia("AG01", "ATravel Venusia", "Milano", true);
        Calendar dataPartenza1 = new GregorianCalendar(2024, Calendar.APRIL, 26);
        Pacchetto pacchetto1 = new Pacchetto("siviglia", 1200.00, dataPartenza1, 6, Costanti.TIPOLOGIA_CITTA);
        agenzia1.aggiungiPacchetto(pacchetto1);

        Calendar dataPartenza3 = new GregorianCalendar(2024, Calendar.APRIL, 12);
        Pacchetto pacchetto3 = new Pacchetto("Madrid", 100.00, dataPartenza3, 2, Costanti.TIPOLOGIA_CROCIERA);
        agenzia1.aggiungiPacchetto(pacchetto3);

        archivio.aggiungiAgenzia(agenzia1);

        Agenzia agenzia2 = new Agenzia("AG02", "Meeeeghee", "Milano", false);
        Calendar dataPartenza2 = new GregorianCalendar(2024, Calendar.JULY, 10);
        Pacchetto pacchetto2 = new Pacchetto("Sardegna", 675.34, dataPartenza2, 10, Costanti.TIPOLOGIA_VILLAGGIO);
        agenzia2.aggiungiPacchetto(pacchetto2);
        archivio.aggiungiAgenzia(agenzia2);

        return archivio;
    }

}
