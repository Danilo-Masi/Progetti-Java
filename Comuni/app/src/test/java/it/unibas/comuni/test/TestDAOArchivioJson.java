package it.unibas.comuni.test;

import it.unibas.comuni.modello.Archivio;
import it.unibas.comuni.persistenza.DAOArchivioJson;
import it.unibas.comuni.persistenza.DAOException;
import it.unibas.comuni.persistenza.IDAOArchivio;
import java.io.InputStream;
import junit.framework.TestCase;

public class TestDAOArchivioJson extends TestCase {
    
    private IDAOArchivio dAOArchivio = new DAOArchivioJson();

    public void testCaricaArchivio() {
        InputStream inputStream = TestDAOArchivioJson.class.getResourceAsStream("/Archivio-Comuni.json");
        assertNotNull(inputStream);
        try {
            Archivio archivio = dAOArchivio.carica(inputStream);
            assertNotNull(archivio);
            assertEquals("2020-02-19", archivio.getDataAggiornamento());
            assertEquals(7904, archivio.getListaComuni().size());
        } catch (DAOException ex) {
            fail("Eccezzione durante il caricamento");
        }
    }

}
