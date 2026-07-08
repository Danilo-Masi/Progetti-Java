package it.unibas.ricettario.test;

import it.unibas.ricettario.modello.Archivio;
import it.unibas.ricettario.modello.Costanti;
import it.unibas.ricettario.modello.Pietanza;
import it.unibas.ricettario.persistenza.DAOArchivioMock;
import it.unibas.ricettario.persistenza.DAOException;
import it.unibas.ricettario.persistenza.IDAOArchivio;
import junit.framework.TestCase;

public class ArchivioTest extends TestCase {

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
        assertEquals(0, archivio.cercaPietanzaPerCategoria(Costanti.ANTIPASTO).size());
        assertEquals(3, archivio.cercaPietanzaPerCategoria(Costanti.PRIMO).size());
        assertEquals(1, archivio.cercaPietanzaPerCategoria(Costanti.SECONDO).size());
        assertEquals(0, archivio.cercaPietanzaPerCategoria(Costanti.DESSERT).size());
    }

    public void testPietanzaSimileCategoria() {
        Pietanza pietanzaPastaAlleNoci = archivio.getPietanze().get(0);
        Pietanza pietanzaPastaAiGamberi = archivio.getPietanze().get(1);
        assertEquals("Pasta e Panna", archivio.cercaPietanzaSimile(pietanzaPastaAlleNoci).getNome());
        assertEquals("Pasta alle Noci", archivio.cercaPietanzaSimile(pietanzaPastaAiGamberi).getNome());
    }

}
