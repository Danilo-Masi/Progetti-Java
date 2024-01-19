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

    private Action azioneNuovaDomanda = new AzioneNuovaDomanda();

    private class AzioneNuovaDomanda extends AbstractAction {

        private AzioneNuovaDomanda() {
            this.putValue(NAME, "Aggiungi domanda");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi una nuova domanda");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_N);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt N"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaDettagliConcorso vistaDettagliConcorso = Applicazione.getInstance().getVistaDettagliConcorso();
            String codiceFiscale = vistaDettagliConcorso.getCodiceFiscale();
            String sesso = vistaDettagliConcorso.getSesso();
            String giorno = vistaDettagliConcorso.getGiorno();
            String mese = vistaDettagliConcorso.getMese();
            String anno = vistaDettagliConcorso.getAnno();
            //Convalida degli errori
            String errori = convalida(codiceFiscale, sesso, giorno, mese, anno);
            if (!errori.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore(errori);
                return;
            }
            Concorso concorso = (Concorso) Applicazione.getInstance().getModello().getBeans(Costanti.CONCORSO_SELEZIONATO);
            boolean isPresente = concorso.isContieneDomanda(codiceFiscale);
            if (isPresente) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Il codice fiscale è gia stato utilizzato");
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            boolean isIncompatibile = archivio.isDomandaIncompatibile(codiceFiscale, concorso);
            if (isIncompatibile) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Altra domanda nello stesso giorno");
                return;
            }
            int interoGiorno = Integer.parseInt(giorno);
            int interoMese = Integer.parseInt(mese);
            int interoAnno = Integer.parseInt(anno);
            Calendar dataDomanda = new GregorianCalendar(interoAnno, interoMese - 1, interoGiorno);
            Domanda domanda = new Domanda(codiceFiscale, sesso, dataDomanda);
            concorso.addDomanda(domanda);
            vistaDettagliConcorso.aggiornaDati();
        }
    }

    private String convalida(String codiceFiscale, String sesso, String giorno, String mese, String anno) {
        StringBuilder sb = new StringBuilder();
        if (codiceFiscale.trim().isEmpty()) {
            sb.append("Il codice fiscale è obbligatorio \n");
        }
        if (sesso.trim().isEmpty()) {
            sb.append("Il sesso è obbligatorio \n");
        }
        if (giorno.trim().isEmpty()) {
            sb.append("Il giorno è obbligatorio \n");
        }
        if (mese.trim().isEmpty()) {
            sb.append("Il mese è obbligatorio \n");
        }
        if (anno.trim().isEmpty()) {
            sb.append("L'anno è obbligatorio \n");
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
            sb.append("la data non è valida \n");
        }

        return sb.toString();
    }

    public Action getAzioneNuovaDomanda() {
        return azioneNuovaDomanda;
    }

}
