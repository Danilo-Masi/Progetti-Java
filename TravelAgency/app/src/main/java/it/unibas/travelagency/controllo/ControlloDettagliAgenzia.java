package it.unibas.travelagency.controllo;

import it.unibas.travelagency.Applicazione;
import it.unibas.travelagency.modello.Agenzia;
import it.unibas.travelagency.modello.Costanti;
import it.unibas.travelagency.modello.Pacchetto;
import it.unibas.travelagency.vista.VistaDettagliAgenzia;
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

public class ControlloDettagliAgenzia {

    private Action azioneAggiungiNuovoPacchetto = new AzioneAggiungiNuovoPacchetto();

    private class AzioneAggiungiNuovoPacchetto extends AbstractAction {

        public AzioneAggiungiNuovoPacchetto() {
            this.putValue(NAME, "Aggiungi pacchetto");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi un nuovo pacchetto");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_P);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt P"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaDettagliAgenzia vistaDettagliAgenzia = Applicazione.getInstance().getVistaDettagliAgenzia();
            String destinazioneInserita = vistaDettagliAgenzia.getDestinazioneInserita();
            double importoInserito = vistaDettagliAgenzia.getImportoInserito();
            Calendar dataInserita = vistaDettagliAgenzia.getDataInserita();
            int durataInserita = vistaDettagliAgenzia.getDurataInserita();
            String tipologiaSelezionata = vistaDettagliAgenzia.getTipologiaSelezionata();
            if (destinazioneInserita.isEmpty() || tipologiaSelezionata.isEmpty() || tipologiaSelezionata.equalsIgnoreCase("")) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("I valori inseriti non sono validi");
                return;
            }
            Pacchetto pacchetto = new Pacchetto(destinazioneInserita, importoInserito, dataInserita, durataInserita, tipologiaSelezionata);
            Agenzia agenziaSelezionata = (Agenzia) Applicazione.getInstance().getModello().getBeans(Costanti.AGENZIA_SELEZIONATA);
            agenziaSelezionata.aggiungiPacchetto(pacchetto);
            Applicazione.getInstance().getFrame().mostraMessaggio("Pacchetto aggiunto correttamente alla lista dei pacchetti dell'agenzia");
            vistaDettagliAgenzia.aggiornaDati();
        }
    }

    public Action getAzioneAggiungiNuovoPacchetto() {
        return azioneAggiungiNuovoPacchetto;
    }

}
