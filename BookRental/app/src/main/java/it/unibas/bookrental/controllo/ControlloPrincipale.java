package it.unibas.bookrental.controllo;

import it.unibas.bookrental.Applicazione;
import it.unibas.bookrental.Costanti;
import it.unibas.bookrental.modello.Archivio;
import it.unibas.bookrental.modello.Utente;
import it.unibas.bookrental.vista.VistaPrincipale;
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

    private Action azioneRicerca = new AzioneRicerca();
    private Action azioneMostraDettagliUtente = new AzioneMostraDettagliUtente();

    private class AzioneMostraDettagliUtente extends AbstractAction {

        public AzioneMostraDettagliUtente() {
            this.putValue(NAME, "Mostra dettagli");
            this.putValue(SHORT_DESCRIPTION, "Mostra i dettagli dell'utente selezionato");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_D);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt D"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            int rigaSelezionata = vistaPrincipale.getRigaSelezionata();
            if(rigaSelezionata == -1 ) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Selezionare un utente prima di procedere");
                return;
            }
            List<Utente> listaFiltrata = (List<Utente>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
            Utente utenteSelezionato = listaFiltrata.get(rigaSelezionata);
            Applicazione.getInstance().getModello().putBeans(Costanti.UTENTE_SELEZIONATO, utenteSelezionato);
            Applicazione.getInstance().getVistaDettagliUtente().visualizza();
        }
    }

    private class AzioneRicerca extends AbstractAction {

        public AzioneRicerca() {
            this.putValue(NAME, "Ricerca");
            this.putValue(SHORT_DESCRIPTION, "Ricerca Utenti");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_R);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt R"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            String nome = vistaPrincipale.getNome();
            String cognome = vistaPrincipale.getCognome();
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            List<Utente> listaFiltrata = archivio.cercaUtenti(nome, cognome);
            Applicazione.getInstance().getModello().putBeans(Costanti.LISTA_FILTRATA, listaFiltrata);
            vistaPrincipale.aggiornaDati();
        }
    }

    public Action getAzioneMostraDettagliUtente() {
        return azioneMostraDettagliUtente;
    }

    public Action getAzioneRicerca() {
        return azioneRicerca;
    }

}
