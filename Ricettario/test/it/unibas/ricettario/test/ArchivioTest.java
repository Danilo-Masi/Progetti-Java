package it.unibas.ricettario.test;

import it.unibas.ricettario.persistenza.DAOArchivioMock;
import it.unibas.ricettario.persistenza.DAOException;
import it.unibas.ricettario.persistenza.IDAOArchivio;
import junit.framework.TestCase;
import it.unibas.ricettario.modello.Archivio;
import it.unibas.ricettario.modello.Costanti;
import it.unibas.ricettario.modello.Pietanza;

public class ArchivioTest extends TestCase {

    private IDAOArchivio daoArchivio = new DAOArchivioMock();
    private Archivio archivio;

    //Funzione per caricare l'archivio
    public void setUp() {
        try {
            this.archivio = daoArchivio.carica("");
        } catch (DAOException ex) {
            fail("Impossibile caricare l'archivio");
        }
    }

    //Funzione per testare la ricerca per categoria
    public void testFiltroCategoria() {
        assertEquals(2, archivio.cercaPietanzePerCategoria(Costanti.PRIMO).size());
        assertEquals(0, archivio.cercaPietanzePerCategoria(Costanti.SECONDO).size());
        assertEquals(0, archivio.cercaPietanzePerCategoria(Costanti.DESSERT).size());
    }

    //Funzione per testare la ricerca per pietanza simile
    public void testPietanzaSimileCategoria() {
        Pietanza pietanzaPastaAlleNoci = archivio.getPietanze().get(0);
        Pietanza pietanzaPastaAiGamberi = archivio.getPietanze().get(1);
        assertEquals("Pasta ai gamberi", archivio.cercaPietanzaSimile(pietanzaPastaAlleNoci).getNome());
        assertEquals("Pasta alle noci", archivio.cercaPietanzaSimile(pietanzaPastaAiGamberi).getNome());
    }

}
