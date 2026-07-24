package it.unibas.anagrafica.persistenza;

import it.unibas.anagrafica.modello.Archivio;
import it.unibas.anagrafica.modello.Azienda;
import it.unibas.anagrafica.modello.Dipendente;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivioMock implements IDAOArchivio {

    @Override
    public Archivio carica(String nomeFile) throws DAOException {
        Archivio archivio = new Archivio();

        Azienda a1 = new Azienda("IT098", "Lisandri attrezzature", "Milano");
        a1.aggiungiDipendente(new Dipendente("MSADNL", "Danilo", "Masi", new GregorianCalendar(2026, Calendar.MARCH, 2), "Basilicata"));
        a1.aggiungiDipendente(new Dipendente("HGTLOI", "Mario", "Rossi", new GregorianCalendar(2026, Calendar.FEBRUARY, 22), "Campania"));
        a1.aggiungiDipendente(new Dipendente("SINSIN", "Toro", "Lopes", new GregorianCalendar(2026, Calendar.JUNE, 5), "Lombardia"));
        a1.aggiungiDipendente(new Dipendente("NIAMAN", "Frat", "Garra", new GregorianCalendar(2026, Calendar.JUNE, 22), "Lombardia"));
        a1.aggiungiDipendente(new Dipendente("SDFGHJ", "Leone", "Lucia", new GregorianCalendar(2026, Calendar.APRIL, 15), "Veneto"));
        archivio.aggiungiAzienda(a1);

        Azienda a2 = new Azienda("IT123", "Meccanica di precisione", "Alessandria");
        a2.aggiungiDipendente(new Dipendente("SASLIO", "Nicola", "Abate", new GregorianCalendar(2024, Calendar.JANUARY, 23), "Lombardia"));
        a2.aggiungiDipendente(new Dipendente("QCTRM", "Julio", "Gimenez", new GregorianCalendar(2025, Calendar.APRIL, 28), "Puglia"));
        a2.aggiungiDipendente(new Dipendente("MAGTYU", "Leonardo", "Alessandrini", new GregorianCalendar(2024, Calendar.JULY, 1), "Lombardia"));
        a2.aggiungiDipendente(new Dipendente("QCTRM", "Julio", "Gimenez", new GregorianCalendar(2025, Calendar.APRIL, 28), "Puglia"));
        a2.aggiungiDipendente(new Dipendente("PAZZYU", "Benito", "Gonzales", new GregorianCalendar(2026, Calendar.FEBRUARY, 1), "Basilicata"));
        archivio.aggiungiAzienda(a2);

        return archivio;
    }

}
