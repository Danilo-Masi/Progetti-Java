package it.unibas.concorsi.test;

import it.unibas.concorsi.modello.Archivio;
import it.unibas.concorsi.modello.Costanti;
import it.unibas.concorsi.persistenza.DAOArchivoMock;
import it.unibas.concorsi.persistenza.DAOException;
import it.unibas.concorsi.persistenza.IDAOArchivio;
import junit.framework.TestCase;

public class ArchivioTest extends TestCase {

    private IDAOArchivio dAOArchivio = new DAOArchivoMock();
    private Archivio archivio;

    @Override
    protected void setUp() throws Exception {
        try {
            this.archivio = dAOArchivio.carica("");
        } catch (DAOException ex) {
            fail("Impossibile caricare l'arhivio");
        }
    }

    public void testFiltroCategoria() {
        assertEquals(1, archivio.cercaConcorsiPerRegione(Costanti.VENETO, "").size());
        assertEquals(2, archivio.cercaConcorsiPerRegione(Costanti.BASILICATA, "").size());
        assertEquals(0, archivio.cercaConcorsiPerRegione(Costanti.FRIULI_VENEZIA_GIULIA, "").size());
        assertEquals(0, archivio.cercaConcorsiPerRegione(Costanti.PUGLIA, "").size());
    }

}
