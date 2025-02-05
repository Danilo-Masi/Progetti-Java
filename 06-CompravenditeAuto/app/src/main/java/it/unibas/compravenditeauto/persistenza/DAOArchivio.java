package it.unibas.compravenditeauto.persistenza;

import it.unibas.compravenditeauto.modello.Archivio;
import it.unibas.compravenditeauto.modello.Auto;
import it.unibas.compravenditeauto.modello.Operazione;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String nomeFile) throws DAOException {
        Archivio archivio = new Archivio();

        Auto auto1 = new Auto("FG093XF", "Audi X8", 2023);
        auto1.aggiungiOperazione(new Operazione(new GregorianCalendar(2023, Calendar.APRIL, 22), 0, 38599, "Mario Rossi"));
        auto1.aggiungiOperazione(new Operazione(new GregorianCalendar(2025, Calendar.AUGUST, 1), 15400, 25000, "Rocco Verdi"));

        archivio.aggiungiAuto(auto1);

        return archivio;
    }

}
