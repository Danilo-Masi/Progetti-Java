package it.unibas.anagrafica;

import it.unibas.anagrafica.modello.Archivio;
import it.unibas.anagrafica.persistenza.DAOArchivioMock;
import it.unibas.anagrafica.persistenza.DAOException;
import it.unibas.anagrafica.persistenza.IDAOArchivio;
import junit.framework.TestCase;

public class ArchivioTest extends TestCase {

    private IDAOArchivio daoArhivio;
    private Archivio archivio;

    @Override
    public void setUp() {
        daoArhivio = new DAOArchivioMock();
        try {
            archivio = daoArhivio.carica("");
        } catch (DAOException ex) {
            fail("Impossibile caricare l'archivio");
        }
    }

    public void testArchivio() {
        assertNotNull(archivio);
        assertEquals(2, archivio.getListaAziende().size());
    }

    public void testAziendePerCitta() {
        assertEquals(1, archivio.cercaAziendePerCitta("Milano").size());
        assertEquals(1, archivio.cercaAziendePerCitta("Alessandria").size());
    }
    
    public void testVerificaArchivio() {
        assertTrue(archivio.verificaDisparita());
    }
    
    public void testAnniFrequenti() {
        archivio.ricercaAnniFrequenti();
    }

}
