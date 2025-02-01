package it.unibas.concorsi.controllo;

import it.unibas.concorsi.Applicazione;
import it.unibas.concorsi.modello.Archivio;
import it.unibas.concorsi.modello.Concorso;
import it.unibas.concorsi.modello.Costanti;
import it.unibas.concorsi.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private Action AzioneCerca = new AzioneCerca();
    private Action AzioneSelezionaConcorso = new AzioneSelezionaConcorso();

    private class AzioneSelezionaConcorso extends AbstractAction {

        public AzioneSelezionaConcorso() {
            this.setEnabled(false);
            this.putValue(NAME, "Seleziona concorso");
            this.putValue(SHORT_DESCRIPTION, "Seleziona un concorso");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_S);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt S"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            int rigaSelezionata = vistaPrincipale.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Seleziona una riga dalla tabella prima di procedere");
                return;
            }
            List<Concorso> listaFiltrata = (List<Concorso>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
            Concorso concorsoSelezionato = listaFiltrata.get(rigaSelezionata);
            Applicazione.getInstance().getModello().putBeans(Costanti.CONCORSO_SELEZIONATO, concorsoSelezionato);
            Applicazione.getInstance().getVistaDettagliConcorso().visualizza();
        }
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.setEnabled(false);
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca per regione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_R);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt R"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            String regione = Applicazione.getInstance().getVistaPrincipale().getCampoRegione();
            if (regione.trim().isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Prima di procedere inserisci una regione");
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
        return AzioneSelezionaConcorso;
    }

    public Action getAzioneCerca() {
        return AzioneCerca;
    }

}
