package it.unibas.bookrental.controllo;

import it.unibas.bookrental.Applicazione;
import it.unibas.bookrental.Costanti;
import it.unibas.bookrental.modello.Archivio;
import it.unibas.bookrental.modello.Libro;
import it.unibas.bookrental.modello.Utente;
import it.unibas.bookrental.vista.VistaDettagliUtente;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloDettagliUtente {

    private Action azioneNuovoNoleggio = new AzioneNuovoNoleggio();

    private class AzioneNuovoNoleggio extends AbstractAction {

        public AzioneNuovoNoleggio() {
            this.putValue(NAME, "Nuovo noleggio");
            this.putValue(SHORT_DESCRIPTION, "Noleggia un nuovo libro");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_N);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt N"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaDettagliUtente vistaDettagliUtente = Applicazione.getInstance().getVistaDettagliUtente();
            String titolo = vistaDettagliUtente.getAutoreInserito();
            String autore = vistaDettagliUtente.getAutoreInserito();
            Calendar data = vistaDettagliUtente.getDataInserita();
            if (titolo.isEmpty() || autore.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Compila tutti i dati prima di procedere");
                return;
            }
            Libro libro = new Libro(titolo, autore, data, null);
            Utente utenteSelzionato = (Utente) Applicazione.getInstance().getModello().getBeans(Costanti.UTENTE_SELEZIONATO);
            utenteSelzionato.aggiungiLibro(libro);
            //Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            //archivio.impostaDataFineNoleggio();
            vistaDettagliUtente.aggiornaDati();
        }
    }

    public Action getAzioneNuovoNoleggio() {
        return azioneNuovoNoleggio;
    }

}
