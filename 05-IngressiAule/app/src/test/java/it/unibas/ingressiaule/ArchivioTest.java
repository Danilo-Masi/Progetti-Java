package it.unibas.ingressiaule;

import it.unibas.ingressiaule.modello.Archivio;
import it.unibas.ingressiaule.persistenza.DAOArchivioMock;
import it.unibas.ingressiaule.persistenza.IDAOArchivio;
import junit.framework.TestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArchivioTest extends TestCase {

    private Logger logger = LoggerFactory.getLogger(ArchivioTest.class);

    private IDAOArchivio daoArchivio;
    private Archivio archivio;

    @Override
    protected void setUp() throws Exception {
        daoArchivio = new DAOArchivioMock();
        archivio = daoArchivio.carica("");
    }

    public void testAulePerPiano() {
        assertEquals(3, archivio.cercaAulePerPiano(0).size());
        assertEquals(3, archivio.cercaAulePerPiano(1).size());
        assertEquals(3, archivio.cercaAulePerPiano(2).size());
    }

    public void testDuplicati() {
        assertTrue(archivio.isAccessiDuplicati());
    }

}
