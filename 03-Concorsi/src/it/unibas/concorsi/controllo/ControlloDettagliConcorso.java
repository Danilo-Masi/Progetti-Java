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
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloDettagliConcorso {

    private Action azioneAggiungi = new AzioneAggiungi();

    private class AzioneAggiungi extends AbstractAction {

        public AzioneAggiungi() {
            this.putValue(NAME, "Aggiungi");
            this.putValue(SHORT_DESCRIPTION, "Aggingi domanda");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaDettagliConcorso vistaDettagliConcorso = Applicazione.getInstance().getVistaDettagliConcorso();
            String anno = vistaDettagliConcorso.getAnno();
            String mese = vistaDettagliConcorso.getMese();
            String giorno = vistaDettagliConcorso.getGiorno();
            String codiceFiscale = vistaDettagliConcorso.getCodiceFiscale();
            String sesso = vistaDettagliConcorso.getSesso();
            String errori = convalidaDati(anno, mese, giorno, codiceFiscale, sesso);
            if (!errori.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore(errori);
                return;
            }
            Concorso concorso = (Concorso) Applicazione.getInstance().getModello().getBeans(Costanti.CONCORSO_SELEZIONATO);
            if (concorso.isContieneDomanda(codiceFiscale)) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Domanda già presentata");
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            if (archivio.isDomandaIncompatibile(codiceFiscale, concorso)) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Domanda incompatibile");
                return;
            }
            int interoGiorno = Integer.parseInt(giorno);
            int interoMese = Integer.parseInt(mese);
            int interoAnno = Integer.parseInt(anno);
            Domanda domanda = new Domanda(codiceFiscale, sesso, new GregorianCalendar(interoAnno, interoMese - 1, interoGiorno));
            concorso.aggiungiDomanda(domanda);
            vistaDettagliConcorso.aggiornaDati();
        }
    }

    private String convalidaDati(String anno, String mese, String giorno, String codiceFiscale, String sesso) {
        StringBuilder errori = new StringBuilder();
        if (codiceFiscale.isEmpty()) {
            errori.append("Il campo del codice fiscale non può essere vuoto \n");
        }
        if (sesso.isEmpty()) {
            errori.append("Il campo del sesso non può essere vuoto \n");
        }
        if (anno.isEmpty()) {
            errori.append("Il campo del anno non può essere vuoto \n");
        }
        if (mese.isEmpty()) {
            errori.append("Il campo del mese non può essere vuoto \n");
        }
        if (giorno.isEmpty()) {
            errori.append("Il campo del giorno non può essere vuoto \n");
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
            errori.append("La data non è valida");
        }
        return errori.toString();
    }

    public Action getAzioneAggiungi() {
        return azioneAggiungi;
    }

}
