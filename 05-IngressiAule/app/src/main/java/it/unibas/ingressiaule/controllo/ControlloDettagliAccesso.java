package it.unibas.ingressiaule.controllo;

import it.unibas.ingressiaule.Applicazione;
import it.unibas.ingressiaule.modello.Accesso;
import it.unibas.ingressiaule.modello.Aula;
import it.unibas.ingressiaule.modello.Costanti;
import it.unibas.ingressiaule.vista.VistaDettagliAccesso;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloDettagliAccesso {

    private Action azioneNuovoAccesso = new AzioneNuovoAccesso();

    private class AzioneNuovoAccesso extends AbstractAction {

        public AzioneNuovoAccesso() {
            this.putValue(NAME, "Nuovo accesso");
            this.putValue(SHORT_DESCRIPTION, "Inserisci un nuovo accesso");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaDettagliAccesso vistaDettagliAccesso = Applicazione.getInstance().getVistaDettagliAccesso();
            String nome = vistaDettagliAccesso.getValoreNome();
            String matricola = vistaDettagliAccesso.getValoreMatricola();
            int permanenza = vistaDettagliAccesso.getValoreDurata();
            String motivazione = vistaDettagliAccesso.getValoreMotivazione();
            String anno = vistaDettagliAccesso.getValoreAnno();
            String mese = vistaDettagliAccesso.getValoreMese();
            String giorno = vistaDettagliAccesso.getValoreGiorno();
            String ora = vistaDettagliAccesso.getValoreOra();
            String minuti = vistaDettagliAccesso.getValoreMinuti();
            String errori = convalida(nome, matricola, motivazione, anno, mese, giorno, ora, minuti);
            if (!errori.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore(errori);
                return;
            }
            int interoAnno = Integer.parseInt(anno);
            int interoMese = Integer.parseInt(mese);
            int interoGiorno = Integer.parseInt(giorno);
            int interoOra = Integer.parseInt(ora);
            int interoMinuti = Integer.parseInt(minuti);
            Calendar dataAccesso = new GregorianCalendar(interoAnno, interoMese, interoGiorno, interoOra, interoMinuti);
            Accesso nuovoAccesso = new Accesso(matricola, nome, permanenza, motivazione, dataAccesso);
            Aula aulaSelezionata = (Aula) Applicazione.getInstance().getModello().getBeans(Costanti.AULA_SELZIONATA);
            aulaSelezionata.aggiungiAccesso(nuovoAccesso);
            vistaDettagliAccesso.aggiornaComponenti();
        }

        private String convalida(String nome, String matricola, String motivazione, String anno, String mese, String giorno, String ora, String minuti) {
            StringBuilder errori = new StringBuilder();
            if (nome.trim().isEmpty()) {
                errori.append("Il campo del nome non può essere vuoto\n");
            }
            if (matricola.trim().isEmpty()) {
                errori.append("Il campo della matricola non può essere vuoto\n");
            }
            if (motivazione.trim().isEmpty()) {
                errori.append("Il campo della motivazione non può essere vuoto\n");
            }
            if (anno.trim().isEmpty()) {
                errori.append("Il campo del anno non può essere vuoto\n");
            }
            if (mese.trim().isEmpty()) {
                errori.append("Il campo del mese non può essere vuoto\n");
            }
            if (giorno.trim().isEmpty()) {
                errori.append("Il campo del giorno non può essere vuoto\n");
            }
            if (ora.trim().isEmpty()) {
                errori.append("Il campo dell'ora non può essere vuoto\n");
            }
            if (minuti.trim().isEmpty()) {
                errori.append("Il campo dei minuti non può essere vuoto\n");
            }
            try {
                int interoAnno = Integer.parseInt(anno);
                int interoMese = Integer.parseInt(mese);
                int interoGiorno = Integer.parseInt(giorno);
                int interoOra = Integer.parseInt(ora);
                int interoMinuti = Integer.parseInt(minuti);
                Calendar calendar = new GregorianCalendar();
                calendar.setLenient(false);
                calendar.set(interoAnno, interoMese, interoGiorno, interoOra, interoMinuti);
                calendar.getTime();
                if (calendar.getTime().after(new GregorianCalendar().getTime())) {
                    errori.append("La data inserita è successiva al momento di inserimento, quindi non valida\n");
                }
            } catch (NumberFormatException e) {
                errori.append("I valori della data inseriti non sono validi\n");
            }
            return errori.toString();
        }
    }

    public Action getAzioneNuovoAccesso() {
        return azioneNuovoAccesso;
    }

}
