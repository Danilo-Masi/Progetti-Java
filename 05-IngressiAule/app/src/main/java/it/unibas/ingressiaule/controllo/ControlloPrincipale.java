package it.unibas.ingressiaule.controllo;

import it.unibas.ingressiaule.Applicazione;
import it.unibas.ingressiaule.modello.Archivio;
import it.unibas.ingressiaule.modello.Aula;
import it.unibas.ingressiaule.modello.Costanti;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private Action azioneCerca = new AzioneCerca();
    private Action azioneSeleziona = new AzioneSeleziona();

    private class AzioneSeleziona extends AbstractAction {

        public AzioneSeleziona() {
            this.putValue(NAME, "Seleziona");
            this.putValue(SHORT_DESCRIPTION, "Seleziona aula da a cui aggiungere accesso");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_S);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt S"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int rigaSelezionata = Applicazione.getInstance().getVistaPrincipale().getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Seleziona un aula prima di procedere");
                return;
            }
            List<Aula> listaFiltata = (List<Aula>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            Aula aula = listaFiltata.get(rigaSelezionata);
            Applicazione.getInstance().getModello().putBean(Costanti.AULA, aula);
            Applicazione.getInstance().getVistaDettagliAula().visualizza();
        }
    }

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca aule nel piano selezionato o piani inferiori");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_P);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt P"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Integer piano = Applicazione.getInstance().getVistaPrincipale().getPiano();
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
            List<Aula> listaFiltata = archivio.cercaAulePerPiano(piano);
            Applicazione.getInstance().getModello().putBean(Costanti.LISTA_FILTRATA, listaFiltata);
            Applicazione.getInstance().getVistaPrincipale().aggiornaTabella();
        }
    }

    public Action getAzioneSeleziona() {
        return azioneSeleziona;
    }

    public Action getAzioneCerca() {
        return azioneCerca;
    }

}
