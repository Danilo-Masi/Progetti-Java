package it.unibas.companydetails.controlllo;

import it.unibas.companydetails.Applicazione;
import it.unibas.companydetails.Costanti;
import it.unibas.companydetails.modello.Archivio;
import it.unibas.companydetails.modello.Azienda;
import it.unibas.companydetails.modello.Dipendente;
import it.unibas.companydetails.vista.VistaDettagliAzienda;
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

public class ControlloDettagliAzienda {
    
    private Action azioneAggiungiDipendente = new AzioneAggiungiDipendente();
    
    private class AzioneAggiungiDipendente extends AbstractAction {
        
        public AzioneAggiungiDipendente() {
            this.putValue(NAME, "aggiungi dipendente");
            this.putValue(SHORT_DESCRIPTION, "nuovo dipendente");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_D);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt D"));
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            VistaDettagliAzienda vistaDettagliAzienda = Applicazione.getInstance().getVistaDettagliAzienda();
            String codiceFiscale = vistaDettagliAzienda.getCodiceFiscale();
            String nome = vistaDettagliAzienda.getNome();
            String cognome = vistaDettagliAzienda.getCognome();
            String residenza = vistaDettagliAzienda.getResidenza();
            String errori = verificaErrori(codiceFiscale, nome, cognome, residenza);
            if (!errori.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore(errori);
                return;
            }
            Calendar dataAssunzione = Calendar.getInstance();
            Dipendente dipendente = new Dipendente(codiceFiscale, nome, cognome, dataAssunzione, residenza);
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            Azienda aziendaSelezionata = (Azienda) Applicazione.getInstance().getModello().getBeans(Costanti.AZIENDA_SELEZIONATA);
            boolean verifica = archivio.cercaDipendentiStessoCodice(dipendente, aziendaSelezionata.getListaDipendenti());
            if (verifica) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Esiste già un dipendente con lo stesso codice fiscale");
                return;
            } else {
                aziendaSelezionata.aggiungiDipendente(dipendente);
            }
            vistaDettagliAzienda.aggiornaDati();
        }
        
        private String verificaErrori(String codiceFiscale, String nome, String cognome, String residenza) {
            StringBuilder errori = new StringBuilder();
            if (codiceFiscale.isEmpty() || codiceFiscale.length() > 6) {
                errori.append("Errore nella digitazione del codice fiscale");
            }
            if (nome.isEmpty()) {
                errori.append("Il campo nome non puo essere vuoto");
            }
            if (cognome.isEmpty()) {
                errori.append("Il campo cognome non puo essere vuoto");
            }
            if (residenza.isEmpty()) {
                errori.append("Il campo residenza non puo essere vuoto");
            }
            return errori.toString();
        }
    }
    
    public Action getAzioneAggiungiDipendente() {
        return azioneAggiungiDipendente;
    }
    
}
