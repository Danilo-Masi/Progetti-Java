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
import javax.swing.KeyStroke;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlloPrincipale {

    private Action azioneCerca = new AzioneCerca();

    private class AzioneCerca extends AbstractAction {

        private static final Logger logger = LoggerFactory.getLogger(AzioneCerca.class);

        public AzioneCerca() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca concorsi per regione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_R);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt R"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            String regione = vistaPrincipale.getCampoRegione();
            if (regione.trim().isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Prima di procedere inserisci una regione");
                return;
            }
            String criterioOrdinamento;
            if (Applicazione.getInstance().getVistaPrincipale().isOrdinamentoData()) {
                criterioOrdinamento = Costanti.ORDINAMENTO_DATA;
            } else {
                criterioOrdinamento = Costanti.ORDINAMENTO_POSTI;
            }
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
            List<Concorso> listaFiltrata = archivio.cercaConcorsiPerRegione(regione, criterioOrdinamento);
            logger.debug("Lista filtrata contiene {} elementi", listaFiltrata.size());
            Applicazione.getInstance().getModello().putBean(Costanti.LISTA_FILTRATA, listaFiltrata);
            // TODO: AGGIORNA TABELLA
            Applicazione.getInstance().getVistaPrincipale().aggiornaTabella();
        }
    }

    public Action getAzioneCerca() {
        return azioneCerca;
    }

}
