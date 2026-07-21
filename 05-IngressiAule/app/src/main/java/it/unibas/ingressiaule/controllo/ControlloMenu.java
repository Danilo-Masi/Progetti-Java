package it.unibas.ingressiaule.controllo;

import it.unibas.ingressiaule.Applicazione;
import it.unibas.ingressiaule.modello.Archivio;
import it.unibas.ingressiaule.modello.Costanti;
import it.unibas.ingressiaule.modello.DatiAccessiMese;
import it.unibas.ingressiaule.persistenza.DAOException;
import it.unibas.ingressiaule.persistenza.IDAOArchivio;
import it.unibas.ingressiaule.vista.VistaMesiFrequenti;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloMenu {

    private Action azioneEsci = new AzioneEsci();
    private Action azioneCarica = new AzioneCarica();
    private Action azioneVerifica = new AzioneVerifica();
    private Action azioneCalcolaMesiFrequenti = new AzioneCalcolaMesiFrequenti();

    private class AzioneCalcolaMesiFrequenti extends AbstractAction {

        public AzioneCalcolaMesiFrequenti() {
            this.putValue(NAME, "Calcola");
            this.putValue(SHORT_DESCRIPTION, "Calcola mesi piu frequwnti");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_F);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getAWTKeyStroke("ctrl alt F"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
            List<DatiAccessiMese> datiMese = archivio.calcolaDatiMeseFrequente();
            Applicazione.getInstance().getModello().putBean(Costanti.DATI_MESE, datiMese);
            Applicazione.getInstance().getVistaMesiFrequenti().visuallizza();
        }
    }

    private class AzioneVerifica extends AbstractAction {

        public AzioneVerifica() {
            this.putValue(NAME, "Verifica");
            this.putValue(SHORT_DESCRIPTION, "Verifica duplicati");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getAWTKeyStroke("ctrl alt V"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
            boolean verifica = archivio.isAccessiDuplicati();
            if (verifica) {
                Applicazione.getInstance().getFrame().mostraMessaggio("Di Domenica ci sono accessi duplicati");
            } else {
                Applicazione.getInstance().getFrame().mostraMessaggio("Di Domenica NON ci sono accessi duplicati");
            }
        }

    }

    private class AzioneCarica extends AbstractAction {

        public AzioneCarica() {
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Carica archivio");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getAWTKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio dAOArchivio = Applicazione.getInstance().getdAOArchivio();
            try {
                Archivio archivio = dAOArchivio.carica("");
                Applicazione.getInstance().getModello().putBean(Costanti.ARCHIVIO, archivio);
                Applicazione.getInstance().getFrame().mostraMessaggio("Archivio contente " + archivio.getListaAule().size() + " aule, caricato correttamente");
                // Abilita azioni
                Applicazione.getInstance().getControlloPrincipale().getAzioneCerca().setEnabled(true);
                Applicazione.getInstance().getControlloPrincipale().getAzioneSeleziona().setEnabled(true);
                Applicazione.getInstance().getControlloMenu().getAzioneVerifica().setEnabled(true);
                Applicazione.getInstance().getControlloMenu().getAzioneCalcolaMesiFrequenti().setEnabled(true);
            } catch (DAOException ex) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Impossibile caricare l'archivio");
            }
        }
    }

    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getAWTKeyStroke("ctrl alt E"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public Action getAzioneVerifica() {
        return azioneVerifica;
    }

    public Action getAzioneCarica() {
        return azioneCarica;
    }

    public Action getAzioneEsci() {
        return azioneEsci;
    }

    public Action getAzioneCalcolaMesiFrequenti() {
        return azioneCalcolaMesiFrequenti;
    }

}
