package it.unibas.sistemiistituti.persistenza;

import it.unibas.sistemiistituti.Costanti;
import it.unibas.sistemiistituti.modello.Archivio;
import it.unibas.sistemiistituti.modello.Classe;
import it.unibas.sistemiistituti.modello.Istituto;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivioMock implements IDAOArchivio {

    @Override
    public Archivio carica(String nomefile) throws DAOException {

        Archivio archivio = new Archivio();

        Istituto istituto1 = new Istituto("GH23", "Gugliermo Marconi", Costanti.MEDIE);
        Calendar dataInizio1 = new GregorianCalendar(2024, Calendar.DECEMBER, 1);
        Classe classe1 = new Classe("1C", 15, "Danilo Masi", dataInizio1);
        istituto1.aggiungiClasse(classe1);
        archivio.aggiungiIstituto(istituto1);

        Istituto istituto2 = new Istituto("8765", "Ernesto Battaglini", Costanti.SUPERIORI);
        Calendar dataInizio2 = new GregorianCalendar(2024, Calendar.SEPTEMBER, 7);
        Classe classe2 = new Classe("1C", 10, "Danilo Masi", dataInizio2);
        istituto2.aggiungiClasse(classe2);
        archivio.aggiungiIstituto(istituto2);

        return archivio;

    }

}
