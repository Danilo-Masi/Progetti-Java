package it.unibas.ricettario.persistenza;

import it.unibas.ricettario.modello.Archivio;
import it.unibas.ricettario.modello.Costanti;
import it.unibas.ricettario.modello.Ingrediente;
import it.unibas.ricettario.modello.Pietanza;

public class DAOArchivioMock implements IDAOArchivio {

    @Override
    public Archivio carica(String nomeFile) throws DAOException {
        Archivio archivio = new Archivio();

        Pietanza pietanza1 = new Pietanza("Pasta al sugo", Costanti.PRIMO, 13.99);
        pietanza1.addIngrediente(new Ingrediente("Pasta", 80, true, 396));
        pietanza1.addIngrediente(new Ingrediente("Sugo", 20, true, 37));
        archivio.aggiungiPietanza(pietanza1);
        
        Pietanza pietanza2 = new Pietanza("Agnello con patate", Costanti.SECONDO, 35.61);
        pietanza2.addIngrediente(new Ingrediente("Agnello", 250, false, 678));
        pietanza2.addIngrediente(new Ingrediente("Patate", 150, true, 453));
        archivio.aggiungiPietanza(pietanza2);

        return archivio;
    }

}
