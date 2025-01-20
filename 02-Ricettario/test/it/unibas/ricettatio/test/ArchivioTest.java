package it.unibas.ricettatio.test;

import it.unibas.ricettario.modello.Archivio;
import it.unibas.ricettario.modello.Costanti;
import it.unibas.ricettario.modello.Pietanza;
import it.unibas.ricettario.persistenza.DAOArchivioMock;
import it.unibas.ricettario.persistenza.DAOException;
import it.unibas.ricettario.persistenza.IDAOArchivio;
import junit.framework.TestCase;

public class ArchivioTest extends TestCase {

    public ArchivioTest(String testName) {
        super(testName);
    }

    private IDAOArchivio dAOArchivio = new DAOArchivioMock();
    private Archivio archivio;

    @Override
    public void setUp() {
        try {
            this.archivio = dAOArchivio.carica("");
        } catch (DAOException ex) {
            fail("Impossibile caricare l'archivio");
        }
    }

    public void testFiltroCategoria() {
        assertEquals(0, archivio.cercaPietanzePerCategoria(Costanti.ANTIPASTO).size());
        assertEquals(1, archivio.cercaPietanzePerCategoria(Costanti.PRIMO).size());
        assertEquals(1, archivio.cercaPietanzePerCategoria(Costanti.SECONDO).size());
        assertEquals(0, archivio.cercaPietanzePerCategoria(Costanti.DESSERT).size());
    }

    public void testPietanzaSimileCategoria() {
        Pietanza pastaAlSugo = archivio.getPietanze().get(0);
        Pietanza agnelloConPatate = archivio.getPietanze().get(1);
        assertEquals("Agnello con patate", archivio.cercaPietanzaSimile(pastaAlSugo).getNome());
        assertEquals("Pasta al sugo", archivio.cercaPietanzaSimile(agnelloConPatate).getNome());
    }

}
