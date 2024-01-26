package it.unibas.ingressiaule.controllo;

import it.unibas.ingressiaule.Applicazione;
import it.unibas.ingressiaule.Costanti;
import it.unibas.ingressiaule.modello.Accesso;
import it.unibas.ingressiaule.modello.Aula;
import it.unibas.ingressiaule.vista.VistaDettagliAula;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloDettagliAula {

    private Action azioneAggiungiAccesso = new AzioneAggiungiAccesso();

    private class AzioneAggiungiAccesso extends AbstractAction {

        private AzioneAggiungiAccesso() {
            this.putValue(NAME, "Aggiungi");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi un accesso");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaDettagliAula vistaDettagliAula = Applicazione.getInstance().getVistaDettagliAula();
            String matricola = vistaDettagliAula.getMatricola();
            String nome = vistaDettagliAula.getNomeStudente();
            String motivazione = vistaDettagliAula.getMotivazione();
            String permanenza = vistaDettagliAula.getPermanenza();
            String anno = vistaDettagliAula.getAnno();
            String mese = vistaDettagliAula.getMese();
            String giorno = vistaDettagliAula.getGiorno();
            String ora = vistaDettagliAula.getOra();
            String minuti = vistaDettagliAula.getMinuti();
            String errori = this.convalida(matricola, nome, motivazione, permanenza, anno, mese, giorno, ora, minuti);
            if (!errori.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore(errori);
                return;
            }
            int permanenzaIntero = Integer.parseInt(permanenza);
            int annoIntero = Integer.parseInt(anno);
            int meseIntero = Integer.parseInt(mese);
            int giornoIntero = Integer.parseInt(giorno);
            int oraIntero = Integer.parseInt(ora);
            int minutiIntero = Integer.parseInt(minuti);
            Calendar dataAccesso = new GregorianCalendar(annoIntero, meseIntero, giornoIntero, oraIntero, minutiIntero);
            Accesso accesso = new Accesso(matricola, nome, permanenzaIntero, motivazione, dataAccesso);
            Aula aula = (Aula) Applicazione.getInstance().getModello().getBeans(Costanti.AULA_SELEZIONATA);
            aula.addAccesso(accesso);
            Applicazione.getInstance().getFrame().mostraMessaggio("Accesso aggiunto corrattamente");
            vistaDettagliAula.aggiornaDati();
        }

        private String convalida(String matricola, String nome, String motivazione, String permanenza, String anno, String mese, String giorno, String ora, String minuti) {
            StringBuilder errori = new StringBuilder();
            if (matricola.trim().isEmpty()) {
                errori.append("Il campo matricola è obbligatorio \n");
            }
            if (nome.trim().isEmpty()) {
                errori.append("Il campo nome è obbligatorio \n");
            }
            if (motivazione.trim().isEmpty()) {
                errori.append("Il campo motivazione è obbligatorio \n");
            }
            if (permanenza.trim().isEmpty()) {
                errori.append("Il campo permanenza è obbligatorio \n");
            } else {
                try {
                    int permanenzaIntero = Integer.parseInt(permanenza);
                    if (permanenzaIntero < 0) {
                        errori.append("La permanenza deve essere maggiore di 0 \n");
                    }
                } catch (NumberFormatException e) {
                    errori.append("Il campo permanenza deve essere un intero \n");
                }
            }
            try {
                int interoGiorno = Integer.parseInt(giorno);
                int interoMese = Integer.parseInt(mese);
                int interoAnno = Integer.parseInt(anno);
                int interoOra = Integer.parseInt(ora);
                int interoMinuti = Integer.parseInt(minuti);
                Calendar calendar = new GregorianCalendar(interoAnno, interoMese, interoGiorno, interoOra, interoMinuti);
                calendar.setLenient(false);
                Date data = calendar.getTime();
                Date dataAttuale = new Date();
                if (data.after(dataAttuale)) {
                    errori.append("La data di accesso non è valida \n");
                }
            } catch (Exception e) {
                errori.append("la data non è corretta \n");
            }
            return errori.toString();
        }

    }

    public Action getAzioneAggiungiAccesso() {
        return azioneAggiungiAccesso;
    }

}
