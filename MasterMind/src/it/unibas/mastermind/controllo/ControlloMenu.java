package it.unibas.mastermind.controllo;

import it.unibas.mastermind.Applicazione;
import it.unibas.mastermind.modello.Combinazione;
import it.unibas.mastermind.modello.Costanti;
import it.unibas.mastermind.modello.Operatore;
import it.unibas.mastermind.modello.Partita;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloMenu {

    private Action azioneEsci = new AzioneEsci();
    private Action azioneIniziaPartita = new AzioneIniziaPartita();
    private Action azioneInterrompi = new AzioneInterrompi();

    private class AzioneInterrompi extends AbstractAction {

        public AzioneInterrompi() {
            this.putValue(NAME, "Interrompi partita");
            this.putValue(SHORT_DESCRIPTION, "Interrompi la partita");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_I);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt I"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Partita partita = (Partita) Applicazione.getInstance().getModello().getBeans(Costanti.PARTITA);
            Applicazione.getInstance().getFrame().mostraMessaggio("Peccato la combinazione da indovinare era:  " + partita.getCombinazioneNascosta());
            Applicazione.getInstance().getControlloPrincipale().getAzioneTentativo().setEnabled(false);
            Applicazione.getInstance().getControlloMenu().getAzioneIniziaPartita().setEnabled(true);
            Applicazione.getInstance().getControlloMenu().getAzioneInterrompi().setEnabled(false);
        }
    }

    private class AzioneIniziaPartita extends AbstractAction {

        public AzioneIniziaPartita() {
            this.putValue(NAME, "Inizia partita");
            this.putValue(SHORT_DESCRIPTION, "Inizia nuova partita");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_N);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt N"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Operatore operatore = new Operatore();
            Combinazione combinaizoneSegreta = operatore.generaCombinazione();
            Partita partita = new Partita(combinaizoneSegreta);
            Applicazione.getInstance().getModello().putBeans(Costanti.PARTITA, partita);
            //Abilita bottone
            Applicazione.getInstance().getControlloPrincipale().getAzioneTentativo().setEnabled(true);
            Applicazione.getInstance().getControlloMenu().getAzioneIniziaPartita().setEnabled(false);
            Applicazione.getInstance().getControlloMenu().getAzioneInterrompi().setEnabled(true);
        }
    }

    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public Action getAzioneInterrompi() {
        return azioneInterrompi;
    }

    public Action getAzioneIniziaPartita() {
        return azioneIniziaPartita;
    }

    public Action getAzioneEsci() {
        return azioneEsci;
    }

}
