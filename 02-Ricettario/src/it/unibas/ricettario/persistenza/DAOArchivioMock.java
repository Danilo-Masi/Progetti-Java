package it.unibas.ricettario.persistenza;

import it.unibas.ricettario.modello.Archivio;
import it.unibas.ricettario.modello.Costanti;
import it.unibas.ricettario.modello.Ingrediente;
import it.unibas.ricettario.modello.Pietanza;

public class DAOArchivioMock implements IDAOArchivio {

    @Override
    public Archivio carica(String nomeFile) throws DAOException {
        Archivio archivio = new Archivio();

        Pietanza pietanzaPastaAlleNoci = new Pietanza("Pasta alle Noci", Costanti.PRIMO, 10.0);
        pietanzaPastaAlleNoci.aggiungiIngrediente(new Ingrediente("Pasta", 80, false, 400));
        pietanzaPastaAlleNoci.aggiungiIngrediente(new Ingrediente("Noci", 30, true, 700));
        pietanzaPastaAlleNoci.aggiungiIngrediente(new Ingrediente("Panna", 100, true, 500));
        archivio.aggiungiPietanza(pietanzaPastaAlleNoci);
        
        Pietanza pietanzaPastaAiGamberi = new Pietanza("Pasta ai Gamberi", Costanti.PRIMO, 12.0);
        pietanzaPastaAiGamberi.aggiungiIngrediente(new Ingrediente("Pasta", 80, false, 400));
        pietanzaPastaAiGamberi.aggiungiIngrediente(new Ingrediente("Gamberi", 100, false, 120));
        pietanzaPastaAiGamberi.aggiungiIngrediente(new Ingrediente("Panna", 100, true, 500));
        archivio.aggiungiPietanza(pietanzaPastaAiGamberi);
        
        Pietanza pietanzaPastaEPanna = new Pietanza("Pasta e Panna", Costanti.PRIMO, 8.0);
        pietanzaPastaAiGamberi.aggiungiIngrediente(new Ingrediente("Pasta", 80, false, 400));
        pietanzaPastaAiGamberi.aggiungiIngrediente(new Ingrediente("Panna", 100, true, 500));
        archivio.aggiungiPietanza(pietanzaPastaEPanna);
        
        Pietanza pietanzaGamberoni = new Pietanza("Gamberi alla griglia", Costanti.SECONDO, 12.0);
        pietanzaGamberoni.aggiungiIngrediente(new Ingrediente("Gamberi", 200, false, 120));
        archivio.aggiungiPietanza(pietanzaGamberoni);

        return archivio;
    }
}
