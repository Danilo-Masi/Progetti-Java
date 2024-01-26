package it.unibas.ingressiaule.controllo;

import it.unibas.ingressiaule.Applicazione;
import it.unibas.ingressiaule.Costanti;
import it.unibas.ingressiaule.modello.Archivio;
import it.unibas.ingressiaule.modello.DatiAccessiMese;
import it.unibas.ingressiaule.persistenza.DAOException;
import it.unibas.ingressiaule.persistenza.IDAOArchivio;
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

        private AzioneCalcolaMesiFrequenti() {
            this.putValue(NAME, "Calcola");
            this.putValue(SHORT_DESCRIPTION, "Calcola mesi frequenti");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_F);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt F"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            List<DatiAccessiMese> datiMese = archivio.calcolaDatiMeseFrequente();
            Applicazione.getInstance().getModello().putBeans(Costanti.DATI_MESE, datiMese);
            Applicazione.getInstance().getVistaMesiFrequenti().visualizza();
        }
    }

    private class AzioneVerifica extends AbstractAction {

        private AzioneVerifica() {
            this.putValue(NAME, "Verifica");
            this.putValue(SHORT_DESCRIPTION, "Verifica duplicati");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_V);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt V"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            boolean presenzaDuplicati = archivio.verificaArchivio();
            if (presenzaDuplicati) {
                Applicazione.getInstance().getFrame().mostraMessaggio("Di Domenica ci sono accessi duplicati");
            } else {
                Applicazione.getInstance().getFrame().mostraMessaggio("Di Domenica non ci sono accessi verificati");
            }
        }

    }

    private class AzioneCarica extends AbstractAction {

        private AzioneCarica() {
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Caricati archivio");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            IDAOArchivio daoArchivio = Applicazione.getInstance().getDaoArchivio();
            try {
                Archivio archivio = daoArchivio.carica("");
                Applicazione.getInstance().getModello().putBeans(Costanti.ARCHIVIO, archivio);
                Applicazione.getInstance().getFrame().mostraMessaggio("Archivio caricato correttamente, contenente " + archivio.getAule().size() + " aule");
                //Abilitare l'azione cerca **
                Applicazione.getInstance().getControlloPrincipale().getAzioneRicerca().setEnabled(true);
            } catch (DAOException daoE) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Errore nel caricamento");
            }

        }

    }

    private class AzioneEsci extends AbstractAction {

        private AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'app");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt E"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }

    public Action getAzioneCalcolaMesiFrequenti() {
        return azioneCalcolaMesiFrequenti;
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

}
