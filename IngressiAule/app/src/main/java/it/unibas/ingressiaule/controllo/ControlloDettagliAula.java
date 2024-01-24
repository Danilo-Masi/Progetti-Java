package it.unibas.ingressiaule.controllo;

import it.unibas.ingressiaule.Applicazione;
import it.unibas.ingressiaule.Costanti;
import it.unibas.ingressiaule.modello.Accesso;
import it.unibas.ingressiaule.modello.Aula;
import it.unibas.ingressiaule.vista.VistaDettagliAula;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
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
                } catch (NumberFormatException e) {
                    errori.append("Il campo permanenza deve essere un intero \n");
                }
            }
            if (anno.trim().isEmpty()) {
                errori.append("Il campo anno è obbligatorio \n");
            } else {
                try {
                    int annoIntero = Integer.parseInt(anno);
                } catch (NumberFormatException e) {
                    errori.append("Il campo anno deve essere un intero \n");
                }
            }
            if (mese.trim().isEmpty()) {
                errori.append("Il campo mese è obbligatorio \n");
            } else {
                try {
                    int meseIntero = Integer.parseInt(mese);
                } catch (NumberFormatException e) {
                    errori.append("Il campo mese deve essere un intero \n");
                }
            }
            if (giorno.trim().isEmpty()) {
                errori.append("Il campo giorno è obbligatorio \n");
            } else {
                try {
                    int giornoIntero = Integer.parseInt(giorno);
                } catch (NumberFormatException e) {
                    errori.append("Il campo giorno deve essere un intero \n");
                }
            }
            if (ora.trim().isEmpty()) {
                errori.append("Il campo ora è obbligatorio \n");
            } else {
                try {
                    int oraIntero = Integer.parseInt(ora);
                } catch (NumberFormatException e) {
                    errori.append("Il campo ora deve essere un intero \n");
                }
            }
            if (minuti.trim().isEmpty()) {
                errori.append("Il campo minuti è obbligatorio \n");
            } else {
                try {
                    int minutiIntero = Integer.parseInt(minuti);
                } catch (NumberFormatException e) {
                    errori.append("Il campo minuti deve essere un intero \n");
                }
            }
            return errori.toString();
        }

    }

    public Action getAzioneAggiungiAccesso() {
        return azioneAggiungiAccesso;
    }

}
