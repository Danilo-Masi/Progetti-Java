package it.unibas.comuni.test;

import it.unibas.comuni.modello.Archivio;
import it.unibas.comuni.modello.DatiProvincia;
import it.unibas.comuni.modello.OperatoreDatiProvincia;
import it.unibas.comuni.persistenza.DAOArchivioJson;
import it.unibas.comuni.persistenza.DAOException;
import it.unibas.comuni.persistenza.IDAOArchivio;
import java.io.InputStream;
import java.util.List;
import junit.framework.TestCase;

public class TestOperatoreDatiProvincia extends TestCase {
    
    private IDAOArchivio dAOArchivio = new DAOArchivioJson();
    private OperatoreDatiProvincia operatore = new OperatoreDatiProvincia();

    public void testCaricaArchivio() {
        InputStream inputStream = TestOperatoreDatiProvincia.class.getResourceAsStream("/Archivio-Comuni.json");
        assertNotNull(inputStream);
        try {
            Archivio archivio = dAOArchivio.carica(inputStream);
            List<DatiProvincia> datiProvincia = operatore.calcolaDatiProvince(archivio.getListaComuni(), 3);
            assertEquals(3, datiProvincia.size());
            assertEquals("Barletta-Andria-Trani", datiProvincia.get(0).getProvincia());
            assertEquals(10, datiProvincia.get(0).getNumeroComuni());
            assertEquals(39172.3, datiProvincia.get(0).getMediaPopolazione());
        } catch (DAOException ex) {
            fail("Eccezzione durante il caricamento");
        }
    }

}
