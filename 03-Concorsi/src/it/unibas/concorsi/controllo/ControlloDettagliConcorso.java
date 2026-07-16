package it.unibas.concorsi.controllo;

import it.unibas.concorsi.Applicazione;
import it.unibas.concorsi.modello.Archivio;
import it.unibas.concorsi.modello.Concorso;
import it.unibas.concorsi.modello.Costanti;
import it.unibas.concorsi.modello.Domanda;
import it.unibas.concorsi.vista.VistaDettagliConcorso;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloDettagliConcorso {

    private Action azioneAggiungi = new AzioneAggiungi();

    private class AzioneAggiungi extends AbstractAction {

        public AzioneAggiungi() {
            this.putValue(NAME, "Aggiungi");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi una nuova domanda");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaDettagliConcorso vistaDettagli = Applicazione.getInstance().getVistaDettagliConcorso();
            String codiceFiscale = vistaDettagli.getCodiceFiscale();
            String sesso = vistaDettagli.getSesso();
            String giorno = vistaDettagli.getGiorno();
            String mese = vistaDettagli.getMese();
            String anno = vistaDettagli.getAnno();
            String errori = convalida(codiceFiscale, sesso, giorno, mese, anno);
            if (!errori.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore(errori);
                return;
            }
            Concorso concorso = (Concorso) Applicazione.getInstance().getModello().getBean(Costanti.CONCORSO_SELEZIONATO);
            if (concorso.isContieneDomanda(codiceFiscale)) {
                Applicazione.getInstance().getFrame().mostraMessaggio("Domanda già presentata");
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
            if (archivio.isDomandaIncompatibile(codiceFiscale, concorso)) {
                Applicazione.getInstance().getFrame().mostraMessaggio("Domanda incompatibile");
                return;
            }
            int interoGiorno = Integer.parseInt(giorno);
            int interoMese = Integer.parseInt(mese);
            int interoAnno = Integer.parseInt(anno);
            Domanda domanda = new Domanda(codiceFiscale, sesso, new GregorianCalendar(interoAnno, interoMese - 1, interoGiorno));
            concorso.aggiungiDomanda(domanda);
            vistaDettagli.aggiornaDati();
        }

        private String convalida(String codiceFiscale, String sesso, String giorno, String mese, String anno) {
            StringBuilder errori = new StringBuilder();
            if (codiceFiscale.trim().isEmpty()) {
                errori.append("Il campo codice fiscale è obbligatorio \n");
            }
            if (sesso.isEmpty()) {
                errori.append("Il campo sesso è obbligatorio \n");
            }
            if (giorno.isEmpty()) {
                errori.append("Il campo giorno è obbligatorio \n");
            }
            if (mese.isEmpty()) {
                errori.append("Il campo mese è obbligatorio \n");
            }
            if (anno.isEmpty()) {
                errori.append("Il campo anno è obbligatorio \n");
            }
            try {
                int interoGiorno = Integer.parseInt(giorno);
                int interoMese = Integer.parseInt(mese);
                int interoAnno = Integer.parseInt(anno);
                Calendar calendar = new GregorianCalendar();
                calendar.setLenient(false);
                calendar.set(interoAnno, interoMese - 1, interoGiorno);
                calendar.getTime();
            } catch (Exception e) {
                errori.append("La data non è valida \n");
            }
            return errori.toString();
        }
    }

    public Action getAzioneAggiungi() {
        return azioneAggiungi;
    }

}
