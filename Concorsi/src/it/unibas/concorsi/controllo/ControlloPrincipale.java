package it.unibas.concorsi.controllo;

import it.unibas.concorsi.Applicazione;
import it.unibas.concorsi.modello.Archivio;
import it.unibas.concorsi.modello.Concorso;
import it.unibas.concorsi.modello.Costanti;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private Action azioneCerca = new AzioneCerca();
    private Action azioneSelezionaConcorso = new AzioneSelezionaConcorso();

    private class AzioneSelezionaConcorso extends AbstractAction {

        private AzioneSelezionaConcorso() {
            this.putValue(NAME, "Seleziona");
            this.putValue(SHORT_DESCRIPTION, "Seleziona concorso");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_O);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt O"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            List<Concorso> listaFiltrata = (List<Concorso>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
            int rigaSelezionata = Applicazione.getInstance().getVistaPrincipale().getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Nessun corso selezionato");
                return;
            }
            Concorso concorsoSelezionato = listaFiltrata.get(rigaSelezionata);
            Applicazione.getInstance().getModello().putBeans(Costanti.CONCORSO_SELEZIONATO, concorsoSelezionato);
            Applicazione.getInstance().getVistaDettagliConcorso().visualizza();

        }

    }

    private class AzioneCerca extends AbstractAction {

        private AzioneCerca() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_J);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt J"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            String regione = Applicazione.getInstance().getVistaPrincipale().getRegione();
            if (regione.trim().isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Seleziona una regione");
                return;
            }
            String criterio;
            if (Applicazione.getInstance().getVistaPrincipale().isOrdinamentoData()) {
                criterio = Costanti.CRITERIO_DATA;
            } else {
                criterio = Costanti.CRITERIO_POSTI;
            }
            List<Concorso> listaFiltrata = archivio.getConcorsiOrdinatiInRegione(regione, criterio);
            Applicazione.getInstance().getModello().putBeans(Costanti.LISTA_FILTRATA, listaFiltrata);
            Applicazione.getInstance().getVistaPrincipale().aggiornaTabella();
        }

    }

    public Action getAzioneSelezionaConcorso() {
        return azioneSelezionaConcorso;
    }

    public Action getAzioneCerca() {
        return azioneCerca;
    }

}
