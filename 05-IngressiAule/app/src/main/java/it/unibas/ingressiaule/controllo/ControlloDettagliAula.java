package it.unibas.ingressiaule.controllo;

import it.unibas.ingressiaule.Applicazione;
import it.unibas.ingressiaule.modello.Accesso;
import it.unibas.ingressiaule.modello.Aula;
import it.unibas.ingressiaule.modello.Costanti;
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

    private Action azionAggiungiAccesso = new AzioneAggiungiAccesso();

    private class AzioneAggiungiAccesso extends AbstractAction {

        public AzioneAggiungiAccesso() {
            this.putValue(NAME, "Aggiungi");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi un nuovo accesso");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_N);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt N"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaDettagliAula vistaDettagliAula = Applicazione.getInstance().getVistaDettagliAula();
            String matricola = vistaDettagliAula.getMatricola();
            String nome = vistaDettagliAula.getNome();
            String motivazione = vistaDettagliAula.getMotivazione();
            int permanenza = vistaDettagliAula.getPermanenza();
            String annoString = vistaDettagliAula.getAnnoString();
            String meseString = vistaDettagliAula.getMeseString();
            String giornoString = vistaDettagliAula.getGiornoString();
            String oraString = vistaDettagliAula.getOraString();
            String minutiString = vistaDettagliAula.getMinutiString();
            String errori = convalida(matricola, nome, motivazione, annoString, meseString, giornoString, oraString, minutiString);
            if (!errori.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore(errori);
                return;
            }
            int anno = Integer.parseInt(annoString);
            int mese = Integer.parseInt(meseString);
            int giorno = Integer.parseInt(giornoString);
            int ora = Integer.parseInt(oraString);
            int minuti = Integer.parseInt(minutiString);
            Calendar data = new GregorianCalendar(anno, mese - 1, giorno, ora, minuti);
            Accesso accesso = new Accesso(matricola, nome, permanenza, motivazione, data);
            Aula aula = (Aula) Applicazione.getInstance().getModello().getBean(Costanti.AULA);
            aula.aggiungiAccesso(accesso);
            vistaDettagliAula.aggiornaDati();
        }

        private String convalida(String matricola, String nome, String motivazione, String annoString, String meseString, String giornoString, String oraString, String minutiString) {
            StringBuilder errori = new StringBuilder();
            if (matricola.isEmpty()) {
                errori.append("Il campo matricola non può essere vuoto\n");
            }
            if (nome.isEmpty()) {
                errori.append("Il campo nome non può essere vuoto\n");
            }
            if (motivazione.isEmpty()) {
                errori.append("Il campo motivazione non può essere vuoto\n");
            }
            try {
                int anno = Integer.parseInt(annoString);
                int mese = Integer.parseInt(meseString);
                int giorno = Integer.parseInt(giornoString);
                int ora = Integer.parseInt(oraString);
                int minuti = Integer.parseInt(minutiString);
                Calendar calendar = new GregorianCalendar(anno, mese - 1, giorno, ora, minuti);
                calendar.setLenient(false);
                Date data = calendar.getTime();
                Date dataAttuale = new Date();
                if (data.after(dataAttuale)) {
                    errori.append("La data di accesso è nel futuro\n");
                }
            } catch (Exception e) {
                errori.append("Formato della data non valido\n");
            }
            return errori.toString();
        }
    }

    public Action getAzionAggiungiAccesso() {
        return azionAggiungiAccesso;
    }

}
