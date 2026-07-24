package it.unibas.anagrafica.controllo;

import it.unibas.anagrafica.Applicazione;
import it.unibas.anagrafica.modello.Azienda;
import it.unibas.anagrafica.modello.Costanti;
import it.unibas.anagrafica.modello.Dipendente;
import it.unibas.anagrafica.vista.VistaDettagliAzienda;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloDettagliAzienda {

    private Action azioneAggiungi = new AzioneAggiungi();

    private class AzioneAggiungi extends AbstractAction {

        public AzioneAggiungi() {
            this.putValue(NAME, "Aggiuni");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi dipendente");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaDettagliAzienda vistaDettagliAzienda = Applicazione.getInstance().getVistaDettagliAzienda();
            String codiceFiscale = vistaDettagliAzienda.getCodiceFiscale();
            String nome = vistaDettagliAzienda.getNome();
            String cognome = vistaDettagliAzienda.getCognome();
            String regione = vistaDettagliAzienda.getRegione();
            String anno = vistaDettagliAzienda.getAnno();
            String mese = vistaDettagliAzienda.getMese();
            String giorno = vistaDettagliAzienda.getGiorno();
            String errori = convalida(codiceFiscale, nome, cognome, regione, anno, mese, giorno);
            if (!errori.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore(errori);
                return;
            }
            int annoIntero = Integer.parseInt(anno);
            int meseIntero = Integer.parseInt(mese);
            int giornoIntero = Integer.parseInt(giorno);
            Calendar dataAssunzione = new GregorianCalendar(annoIntero, meseIntero - 1, giornoIntero);
            Dipendente dipendente = new Dipendente(codiceFiscale, nome, cognome, dataAssunzione, regione);
            Azienda azienda = (Azienda) Applicazione.getInstance().getModello().getBean(Costanti.AZIENDA_SELEZIONATA);
            boolean verificaDuplicati = azienda.verificaDuplicati();
            if (verificaDuplicati) {
                Applicazione.getInstance().getFrame().mostraMessaggio("Ci sono dipendenti registrati duplicati in questa azienda");
            } else {
                Applicazione.getInstance().getFrame().mostraMessaggio("NON Ci sono dipendenti registrati duplicati in questa azienda");
            }
            azienda.aggiungiDipendente(dipendente);
            vistaDettagliAzienda.aggiornaDati();
        }

        private String convalida(String codiceFiscale, String nome, String cognome, String regione, String anno, String mese, String giorno) {
            StringBuilder errori = new StringBuilder();
            if (codiceFiscale.trim().isEmpty()) {
                errori.append("Il campo codice fiscale non può essere vuoto\n");
            } else if (codiceFiscale.trim().length() > 6) {
                errori.append("Il codice fiscale non deve superare le 6 cifre\n");
            }
            if (nome.trim().isEmpty()) {
                errori.append("Il campo nome non può essere vuoto\n");
            }
            if (cognome.trim().isEmpty()) {
                errori.append("Il campo cognome non può essere vuoto\n");
            }
            if (regione.trim().isEmpty()) {
                errori.append("Il campo regione non può essere vuoto\n");
            }
            try {
                int annoIntero = Integer.parseInt(anno);
                int meseIntero = Integer.parseInt(mese);
                int giornoIntero = Integer.parseInt(giorno);
                Calendar data = new GregorianCalendar(annoIntero, meseIntero - 1, giornoIntero);
                Calendar adesso = new GregorianCalendar();
                if (data.after(adesso)) {
                    errori.append("La data inserita non è valida\n");
                }
                data.setLenient(false);
                data.getTime();
            } catch (Exception e) {
                errori.append("Il formato della data è sbagliato\n");
            }
            return errori.toString();
        }
    }

    public Action getAzioneAggiungi() {
        return azioneAggiungi;
    }

}
