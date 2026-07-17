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

    public void testDatiProvinciaArchivioJson() {
        InputStream inputStream = TestOperatoreDatiProvincia.class.getResourceAsStream("/Archivio-Comuni.json");
        assertNotNull(inputStream);
        try {
            Archivio archivio = dAOArchivio.carica(inputStream);
            List<DatiProvincia> datiProvince = operatore.calcolaDatiProvincia(archivio.getListaComuni(), 3);
            assertEquals(3, datiProvince.size());
            assertEquals(10, datiProvince.get(0).getNumeroComuni());
            assertEquals(391723, datiProvince.get(0).getTotalePopolazione());
            assertEquals(39172.3, datiProvince.get(0).getMediaPopolazione());
        } catch (DAOException e) {
            fail("Eccezzione durante il caricamento");
        }
    }

}
