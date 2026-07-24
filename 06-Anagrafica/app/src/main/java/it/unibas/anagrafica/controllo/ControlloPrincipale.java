package it.unibas.anagrafica.controllo;

import it.unibas.anagrafica.Applicazione;
import it.unibas.anagrafica.modello.Archivio;
import it.unibas.anagrafica.modello.Azienda;
import it.unibas.anagrafica.modello.Costanti;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private Action azioneCercaPerCitta = new AzioneCercaPerCitta();
    private Action azioneSeleziona = new AzioneSeleziona();

    private class AzioneSeleziona extends AbstractAction {

        public AzioneSeleziona() {
            this.putValue(NAME, "Seleziona");
            this.putValue(SHORT_DESCRIPTION, "Mostra dati dell'azienda selezionata");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_S);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt S"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int rigaSelezionata = Applicazione.getInstance().getVistaPrincipale().getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Prima di procedere seleziona un azienda dalla tabella");
                return;
            }
            List<Azienda> listaFiltrata = (List<Azienda>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            Azienda aziendaSelezionata = listaFiltrata.get(rigaSelezionata);
            Applicazione.getInstance().getModello().putBean(Costanti.AZIENDA_SELEZIONATA, aziendaSelezionata);
            Applicazione.getInstance().getVistaDettagliAzienda().visualizza();
        }
    }

    private class AzioneCercaPerCitta extends AbstractAction {

        public AzioneCercaPerCitta() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca aziende per città");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_R);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt R"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String citta = Applicazione.getInstance().getVistaPrincipale().getCitta();
            if (citta.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Prima di proseguire inserisci una citta");
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
            List<Azienda> listaFiltrata = archivio.cercaAziendePerCitta(citta);
            Applicazione.getInstance().getModello().putBean(Costanti.LISTA_FILTRATA, listaFiltrata);
            Applicazione.getInstance().getVistaPrincipale().aggiornaTabella();
        }
    }

    public Action getAzioneSeleziona() {
        return azioneSeleziona;
    }

    public Action getAzioneCercaPerCitta() {
        return azioneCercaPerCitta;
    }

}
