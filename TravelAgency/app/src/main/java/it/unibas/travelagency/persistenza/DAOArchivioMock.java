package it.unibas.travelagency.persistenza;

import it.unibas.travelagency.modello.Agenzia;
import it.unibas.travelagency.modello.Archivio;
import it.unibas.travelagency.modello.Costanti;
import it.unibas.travelagency.modello.Pacchetto;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivioMock implements IDAOArchivio {

    @Override
    public Archivio carica(String nomeFile) throws DAOException{
        Archivio archivio = new Archivio();

        Agenzia agenzia1 = new Agenzia("AG01", "Travel Venusia", "Lavello", true);
        Calendar dataPartenza1 = new GregorianCalendar(2024, Calendar.APRIL, 26);
        Pacchetto pacchetto1 = new Pacchetto("siviglia", 1200.00, dataPartenza1, 6, Costanti.TIPOLOGIA_CITTA);
        agenzia1.aggiungiPacchetto(pacchetto1);
        archivio.aggiungiAgenzia(agenzia1);

        Agenzia agenzia2 = new Agenzia("AG02", "Meeeeghee", "MIlano", false);
        Calendar dataPartenza2 = new GregorianCalendar(2024, Calendar.JULY, 10);
        Pacchetto pacchetto2 = new Pacchetto("Sardegna", 675.34, dataPartenza2, 10, Costanti.TIPOLOGIA_VILLAGGIO);
        agenzia1.aggiungiPacchetto(pacchetto2);
        archivio.aggiungiAgenzia(agenzia2);

        return archivio;
    }

}
