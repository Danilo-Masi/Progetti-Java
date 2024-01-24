package it.unibas.ingressiaule.controllo;

import it.unibas.ingressiaule.Applicazione;
import it.unibas.ingressiaule.Costanti;
import it.unibas.ingressiaule.modello.Archivio;
import it.unibas.ingressiaule.modello.Aula;
import it.unibas.ingressiaule.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private Action azioneRicerca = new AzioneRicerca();
    private Action azioneDettagliAula = new AzioneDettagliAula();

    private class AzioneDettagliAula extends AbstractAction {

        private AzioneDettagliAula() {
            this.putValue(NAME, "Nuovo accesso");
            this.putValue(SHORT_DESCRIPTION, "Inserisci nuovo accesso");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_I);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt I"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            int rigaSelezionata = vistaPrincipale.getRigaSelezionata();
            if(rigaSelezionata == -1) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Seleziona una riga prima di procedere");
                return;
            }
            List<Aula> listaFiltrata = (List<Aula>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
            Aula aulaSelezionata = listaFiltrata.get(rigaSelezionata);
            Applicazione.getInstance().getModello().putBeans(Costanti.AULA_SELEZIONATA, aulaSelezionata);
            Applicazione.getInstance().getVistaDettagliAula().visualizza();
        }

    }

    private class AzioneRicerca extends AbstractAction {

        private AzioneRicerca() {
            this.putValue(NAME, "Ricerca");
            this.putValue(SHORT_DESCRIPTION, "Ricerca aule per piano");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_R);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt R"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            Integer pianoSelezionato = vistaPrincipale.getCampoPiano();
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            List<Aula> listaFiltrata = archivio.cercaAulePerPiano(pianoSelezionato);
            Applicazione.getInstance().getModello().putBeans(Costanti.LISTA_FILTRATA, listaFiltrata);
            vistaPrincipale.aggiornaTabella();
        }
    }

    public Action getAzioneDettagliAula() {
        return azioneDettagliAula;
    }

    public Action getAzioneRicerca() {
        return azioneRicerca;
    }

}
