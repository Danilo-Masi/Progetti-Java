package it.unibas.filmagency.controllo;

import it.unibas.filmagency.Applicazione;
import it.unibas.filmagency.Costanti;
import it.unibas.filmagency.modello.Attore;
import it.unibas.filmagency.modello.Film;
import it.unibas.filmagency.vista.VistaDettagliFilm;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloDettagliFilm {

    private Action azioneAggiungiAttore = new AzioneAggiungiAttore();

    private class AzioneAggiungiAttore extends AbstractAction {

        public AzioneAggiungiAttore() {
            this.putValue(NAME, "Aggiungi attore");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi un nuovo attore per questo film");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaDettagliFilm vistaDettagliFilm = Applicazione.getInstance().getVistaDettagliFilm();
            String nomeCognome = vistaDettagliFilm.getNomeCognome();
            String nazionalita = vistaDettagliFilm.getNazionalita();
            int annoNascita = vistaDettagliFilm.getAnnoNascita();
            if (nomeCognome.isEmpty() || nazionalita.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Inserisci dei valori validi per procedere");
                return;
            }
            Attore attore = new Attore(nomeCognome, nazionalita, annoNascita);
            Film filmSelezionato = (Film) Applicazione.getInstance().getModello().getBeand(Costanti.FILM_SELEZIONATO);
            filmSelezionato.aggiungiAttore(attore);
            vistaDettagliFilm.aggiornaDati();
        }
    }

    public Action getAzioneAggiungiAttore() {
        return azioneAggiungiAttore;
    }

}
