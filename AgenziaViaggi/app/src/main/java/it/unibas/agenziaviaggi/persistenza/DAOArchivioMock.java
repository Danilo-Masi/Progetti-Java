package it.unibas.agenziaviaggi.persistenza;

import it.unibas.agenziaviaggi.Costanti;
import it.unibas.agenziaviaggi.modello.Agenzia;
import it.unibas.agenziaviaggi.modello.Archivio;
import it.unibas.agenziaviaggi.modello.Pacchetto;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivioMock implements IDAOArchivio {

    @Override
    public Archivio carica(String fileName) throws DAOException {
        Archivio archivio = new Archivio();

        Agenzia agenzia1 = new Agenzia(123, "Aenusia", "Lavello", true);

        Calendar dataPartenza1 = new GregorianCalendar(2024, Calendar.JUNE, 12);
        Pacchetto pacchetto1 = new Pacchetto("Caraibi", 1200.0, dataPartenza1, 3, Costanti.TIPOLOGIA_VILLAGGIO);
        agenzia1.aggiungiPacchetto(pacchetto1);
        Calendar dataPartenza2 = new GregorianCalendar(2024, Calendar.APRIL, 1);
        Pacchetto pacchetto2 = new Pacchetto("New york", 6500.0, dataPartenza2, 15, Costanti.TIPOLOGIA_CITTA);
        agenzia1.aggiungiPacchetto(pacchetto2);
        Calendar dataPartenza3 = new GregorianCalendar(2024, Calendar.MAY, 23);
        Pacchetto pacchetto3 = new Pacchetto("Budapest", 670.0, dataPartenza3, 4, Costanti.TIPOLOGIA_CITTA);
        agenzia1.aggiungiPacchetto(pacchetto3);
        
        Agenzia agenzia2 = new Agenzia(777, "Wandelogue", "Lavello", false);
        
        archivio.aggiungiAgenzia(agenzia1);
        archivio.aggiungiAgenzia(agenzia2);

        return archivio;
    }

}
