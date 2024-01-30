package it.unibas.sistemiistituti.controllo;

import it.unibas.sistemiistituti.Applicazione;
import it.unibas.sistemiistituti.Costanti;
import it.unibas.sistemiistituti.modello.Archivio;
import it.unibas.sistemiistituti.modello.Istituto;
import it.unibas.sistemiistituti.vista.VistaPrincipale;
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
    
    private Action azioneCerca = new AzioneCerca();
    private Action azioneNuovoPannello = new AzioneNuovoPannello();
    
    private class AzioneNuovoPannello extends AbstractAction {
        
        private AzioneNuovoPannello() {
            this.putValue(NAME, "Nuovo pannello");
            this.putValue(SHORT_DESCRIPTION, "Apri nuovo pannello");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_N);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt N"));
            this.setEnabled(false);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            int rigaSelezionata = vistaPrincipale.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getInstance().getFrame().mostraMessaggio("Seleziona un istituto prima di procedere");
                return;
            }
            List<Istituto> listaFiltrata = (List<Istituto>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
            Istituto istitutoSelezionato = listaFiltrata.get(rigaSelezionata);
            Applicazione.getInstance().getModello().putBeans(Costanti.ISTITUTO_SELEZIONATO, istitutoSelezionato);
            Applicazione.getInstance().getVistaDettagliIstituto().visualizza();
        }
    }
    
    private class AzioneCerca extends AbstractAction {
        
        private AzioneCerca() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca istituti");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_I);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt I"));
            this.setEnabled(false);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            String grado = vistaPrincipale.getGradoSelezionato();
            if (grado.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggio("Selezina un grado prima di procedere");
                return;
            }
            String ordinamento;
            if (vistaPrincipale.isOrdinamentoCrescente()) {
                ordinamento = Costanti.ORDINAMENTO_CRESCENTE;
            } else {
                ordinamento = Costanti.ORDINAMENTO_DECRESCENTE;
            }
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            List<Istituto> listaFiltrata = archivio.cercaPerGrado(grado, ordinamento);
            Applicazione.getInstance().getModello().putBeans(Costanti.LISTA_FILTRATA, listaFiltrata);
            vistaPrincipale.aggiornaDati();
        }
        
    }
    
    public Action getAzioneNuovoPannello() {
        return azioneNuovoPannello;
    }
    
    public Action getAzioneCerca() {
        return azioneCerca;
    }
    
}
