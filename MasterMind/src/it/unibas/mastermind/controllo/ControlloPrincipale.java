package it.unibas.mastermind.controllo;

import it.unibas.mastermind.Applicazione;
import it.unibas.mastermind.modello.Combinazione;
import it.unibas.mastermind.modello.Costanti;
import it.unibas.mastermind.modello.Operatore;
import it.unibas.mastermind.modello.Partita;
import it.unibas.mastermind.modello.Risposta;
import it.unibas.mastermind.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private Action azioneTentativo = new AzioneTentativo();

    private class AzioneTentativo extends AbstractAction {

        public AzioneTentativo() {
            this.putValue(NAME, "Tenta");
            this.putValue(SHORT_DESCRIPTION, "Tenta la nuova combinazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_T);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt T"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            int cifra1 = vistaPrincipale.getCifra1();
            int cifra2 = vistaPrincipale.getCifra2();
            int cifra3 = vistaPrincipale.getCifra3();
            int cifra4 = vistaPrincipale.getCifra4();
            Combinazione combinazioneTentativo = new Combinazione(cifra1, cifra2, cifra3, cifra4);
            Partita partita = (Partita) Applicazione.getInstance().getModello().getBeans(Costanti.PARTITA);
            Combinazione combinazioneNascosta = partita.getCombinazioneNascosta();
            Operatore operatore = new Operatore();
            if (!operatore.verificaCorrettezza(combinazioneTentativo)) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("La combinazione deve avere valori diversi");
                return;
            }
            Risposta risposta = operatore.valutaTentaivo(combinazioneNascosta, combinazioneTentativo);
            partita.aggiungiRisposta(risposta);
            if (risposta.getPalliniNeri() == Costanti.CIFRE_COMBINAZIONE) {
                Applicazione.getInstance().getFrame().mostraMessaggio("Complimenti hai indovinato in " + partita.getNumeroTentativi() + " tentivi");
                Applicazione.getInstance().getControlloPrincipale().getAzioneTentativo().setEnabled(false);
                Applicazione.getInstance().getControlloMenu().getAzioneIniziaPartita().setEnabled(true);
                Applicazione.getInstance().getControlloMenu().getAzioneInterrompi().setEnabled(false);
            }
            vistaPrincipale.aggiornaDati();
        }
    }

    public Action getAzioneTentativo() {
        return azioneTentativo;
    }

}
