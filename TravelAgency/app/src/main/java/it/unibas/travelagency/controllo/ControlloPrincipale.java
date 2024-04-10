package it.unibas.travelagency.controllo;

import it.unibas.travelagency.Applicazione;
import it.unibas.travelagency.modello.Agenzia;
import it.unibas.travelagency.modello.Archivio;
import it.unibas.travelagency.modello.Costanti;
import it.unibas.travelagency.vista.VistaPrincipale;
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

    private Action azioneCercaAgenzie = new AzioneCercaAgenzie();
    private Action azioneMostraDettagli = new AzioneMostraDettagli();

    private class AzioneMostraDettagli extends AbstractAction {

        public AzioneMostraDettagli() {
            this.putValue(NAME, "Mostra dettagli");
            this.putValue(SHORT_DESCRIPTION, "Mostra i dettagli dell'agenzia selezionata");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_M);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt M"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            int rigaSelezionata = vistaPrincipale.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Seleziona una riga prima di procedere");
                return;
            }
            List<Agenzia> listaFiltrata = (List<Agenzia>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
            Agenzia agenziaSelezionata = listaFiltrata.get(rigaSelezionata);
            Applicazione.getInstance().getModello().putBeans(Costanti.AGENZIA_SELEZIONATA, agenziaSelezionata);
            //Visualizza il pannello dei dettagli
            Applicazione.getInstance().getVistaDettagliAgenzia().visualizza();
        }
    }

    private class AzioneCercaAgenzie extends AbstractAction {

        public AzioneCercaAgenzie() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca agenzie");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            String citta = vistaPrincipale.getValoreCitta();
            boolean ordinamentoCrescente = vistaPrincipale.getOrdinamentoCrescente();
            if (citta.trim().isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Il campo della città non puo essere vuoto");
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            String criterio;
            if (ordinamentoCrescente) {
                criterio = Costanti.ORDINAMENTO_CRESCENTE;
            } else {
                criterio = Costanti.ORDINAMENTO_DECRESCENTE;
            }
            List<Agenzia> listaFiltrata = archivio.cercaAgenziaPerCitta(citta, criterio);
            Applicazione.getInstance().getModello().putBeans(Costanti.LISTA_FILTRATA, listaFiltrata);
            vistaPrincipale.aggiornaTabella();
        }
    }

    public Action getAzioneMostraDettagli() {
        return azioneMostraDettagli;
    }

    public Action getAzioneCercaAgenzie() {
        return azioneCercaAgenzie;
    }

}
