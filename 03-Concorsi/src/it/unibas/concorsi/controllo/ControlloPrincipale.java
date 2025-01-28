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
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private Action AzioneCerca = new AzioneCerca();

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

    public Action getAzioneCerca() {
        return AzioneCerca;
    }

}
