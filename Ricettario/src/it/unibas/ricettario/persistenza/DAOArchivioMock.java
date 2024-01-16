package it.unibas.ricettario.persistenza;

import it.unibas.ricettario.modello.Archivio;
import it.unibas.ricettario.modello.Costanti;
import it.unibas.ricettario.modello.Ingrediente;
import it.unibas.ricettario.modello.Pietanza;

public class DAOArchivioMock implements IDAOArchivio {

    @Override
    public Archivio carica(String nomeFile) throws DAOException {
        //Crea nuova istanza dell'archivio
        Archivio archivio = new Archivio();
        //Crea una nuova pietanza
        Pietanza pietanzaPastaAlleNoci = new Pietanza("Pasta alle noci", Costanti.PRIMO, 10.0);
        pietanzaPastaAlleNoci.aggiungiIngrediente(new Ingrediente("Pasta", 80, false, 400));
        pietanzaPastaAlleNoci.aggiungiIngrediente(new Ingrediente("Noci", 30, true, 700));
        pietanzaPastaAlleNoci.aggiungiIngrediente(new Ingrediente("Panna", 100, true, 500));
        archivio.aggiungiPietanza(pietanzaPastaAlleNoci);
        //Crea una nuova pietanza
        Pietanza pietanzaPastaAiGamberi = new Pietanza("Pasta ai gamberi", Costanti.PRIMO, 20.0);
        pietanzaPastaAiGamberi.aggiungiIngrediente(new Ingrediente("Pasta", 80, false, 400));
        pietanzaPastaAiGamberi.aggiungiIngrediente(new Ingrediente("Gamberi", 100, false, 300));
        pietanzaPastaAiGamberi.aggiungiIngrediente(new Ingrediente("Panna", 100, true, 500));
        archivio.aggiungiPietanza(pietanzaPastaAiGamberi);
        //Ritorna l'archivio con le pietanza
        return archivio;
    }

}
