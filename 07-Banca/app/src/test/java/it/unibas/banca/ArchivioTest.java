package it.unibas.banca;

import it.unibas.banca.modello.Archivio;
import it.unibas.banca.modello.Costanti;
import it.unibas.banca.persistenza.DAOArchvioMock;
import it.unibas.banca.persistenza.DAOException;
import it.unibas.banca.persistenza.IDAOArchivio;
import junit.framework.TestCase;

public class ArchivioTest extends TestCase {

    private IDAOArchivio daoArchivio;
    private Archivio archivio;

    @Override
    protected void setUp() {
        daoArchivio = new DAOArchvioMock();
        try {
            archivio = daoArchivio.carica("");
        } catch (DAOException ex) {
            fail("Eccezzione durante il caricamento dell'archivio");
        }
    }

    public void testCercaPerData() {
        assertNotNull(archivio);
        assertEquals(3, archivio.cercaPerData(Costanti.ORDINAMENTO_DATA).size());
        assertEquals(3, archivio.cercaPerData(Costanti.ORDINAMENTO_NOME).size());
    }

    public void testVerificaArchivio() {
        assertTrue(archivio.verificaArchivio());
    }

    public void testRicercaMesiFrequenti() {
        archivio.ricercaMesiFrequenti();
    }

}
