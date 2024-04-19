package it.unibas.companydetails.controlllo;

import it.unibas.companydetails.Applicazione;
import it.unibas.companydetails.Costanti;
import it.unibas.companydetails.modello.Archivio;
import it.unibas.companydetails.modello.Azienda;
import it.unibas.companydetails.vista.VistaDettagliAzienda;
import it.unibas.companydetails.vista.VistaPrincipale;
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

    private Action azioneCercaAziende = new AzioneCercAziende();
    private Action azioneMostraDettagli = new AzioneMostraDettagli();

    private class AzioneMostraDettagli extends AbstractAction {

        public AzioneMostraDettagli() {
            this.putValue(NAME, "Mostra dettagli");
            this.putValue(SHORT_DESCRIPTION, "Mostra dettagli dell'azienda selezionata");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_M);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt M"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            int rigaSelezionata = vistaPrincipale.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Selezionare un'azienda prima di procedere");
                return;
            }
            List<Azienda> listaFiltrata = (List<Azienda>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
            Azienda aziendaSelezionata = listaFiltrata.get(rigaSelezionata);
            Applicazione.getInstance().getModello().putBeans(Costanti.AZIENDA_SELEZIONATA, aziendaSelezionata);
            VistaDettagliAzienda vistaDettagliAzienda = Applicazione.getInstance().getVistaDettagliAzienda();
            vistaDettagliAzienda.visualizza();
        }
    }

    private class AzioneCercAziende extends AbstractAction {

        public AzioneCercAziende() {
            this.putValue(NAME, "Cerca azienda");
            this.putValue(SHORT_DESCRIPTION, "Cerca aziende per nome");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            String nomeCitta = vistaPrincipale.getCittaSede();
            if (nomeCitta.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Impostare una città prima di procedere");
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            List<Azienda> listaFiltrata = archivio.cercaAziendePerCitta(nomeCitta);
            Applicazione.getInstance().getModello().putBeans(Costanti.LISTA_FILTRATA, listaFiltrata);
            vistaPrincipale.aggiornaDati();
        }

    }

    public Action getAzioneMostraDettagli() {
        return azioneMostraDettagli;
    }

    public Action getAzioneCercaAziende() {
        return azioneCercaAziende;
    }

}
