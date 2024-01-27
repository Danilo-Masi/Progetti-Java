package it.unibas.agenziaviaggi.controllo;

import it.unibas.agenziaviaggi.Applicazione;
import it.unibas.agenziaviaggi.Costanti;
import it.unibas.agenziaviaggi.modello.Agenzia;
import it.unibas.agenziaviaggi.modello.Archivio;
import it.unibas.agenziaviaggi.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private Action azioneCercaAgenzie = new AzioneCercaAgenzie();
    private Action azioneAggiungiPacchetto = new AzioneAggiungiPacchetto();

    private class AzioneAggiungiPacchetto extends AbstractAction {

        private AzioneAggiungiPacchetto() {
            this.putValue(NAME, "Aggiungi");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi pacchetto");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_G);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt G"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            int rigaSelezionata = vistaPrincipale.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Devi selezionare una riga prima di procedere");
                return;
            }
            List<Agenzia> listaFiltrata = (List<Agenzia>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
            Agenzia agenziaSelezionata = listaFiltrata.get(rigaSelezionata);
            Applicazione.getInstance().getModello().putBeans(Costanti.AGENZIA_SELEZIONATA, agenziaSelezionata);
            Applicazione.getInstance().getVistaDettagliAgenzia().visualizza();
        }
    }

    private class AzioneCercaAgenzie extends AbstractAction {

        private AzioneCercaAgenzie() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca agenzie");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_J);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt J"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            String cittaInserita = vistaPrincipale.getValoreCitta();
            String ordinamento;
            if (vistaPrincipale.isOrdinamentoCrescente()) {
                ordinamento = Costanti.ORDINAMENTO_CRESCENTE;
            } else {
                ordinamento = Costanti.ORDINAMENTO_DESCRECENTE;
            }
            String errori = convalida(cittaInserita);
            if (!errori.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore(errori);
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            List<Agenzia> listaFiltrata = archivio.cercaPerCitta(cittaInserita, ordinamento);
            Applicazione.getInstance().getModello().putBeans(Costanti.LISTA_FILTRATA, listaFiltrata);
            vistaPrincipale.aggiornaDati();
        }

    }

    private String convalida(String citta) {
        StringBuilder sb = new StringBuilder();
        if (citta.trim().isEmpty()) {
            sb.append("Il campo della città è obbligatorio ");
        }
        return sb.toString();
    }

    public Action getAzioneAggiungiPacchetto() {
        return azioneAggiungiPacchetto;
    }

    public Action getAzioneCercaAgenzie() {
        return azioneCercaAgenzie;
    }

}
