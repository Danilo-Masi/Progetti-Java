package it.unibas.comuni.controllo;

import it.unibas.comuni.Applicazione;
import it.unibas.comuni.Costanti;
import it.unibas.comuni.modello.Archivio;
import it.unibas.comuni.modello.Comune;
import it.unibas.comuni.modello.DatiProvincia;
import it.unibas.comuni.modello.OperatoreDatiProvincia;
import it.unibas.comuni.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private Action azioneCalcola = new AzioneCalcola();

    private class AzioneCalcola extends AbstractAction {

        private AzioneCalcola() {
            this.putValue(NAME, "Calcola");
            this.putValue(SHORT_DESCRIPTION, "Calcola ");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_J);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getAWTKeyStroke("ctrl alt J"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Integer numeroProvince = Applicazione.getInstance().getVistaPrincipale().getNumeroProvince();
            OperatoreDatiProvincia operatoreDatiProvincia = Applicazione.getInstance().getOperatoreDatiProvincia();
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            List<DatiProvincia> datiProvince = operatoreDatiProvincia.calcolaDatiProvince(archivio.getListaComuni(), numeroProvince);
            Applicazione.getInstance().getModello().putBeans(Costanti.DATI_PROVINCE, datiProvince);
            Applicazione.getInstance().getVistaPrincipale().aggiornaTabella();
            
        }
    }

    public Action getAzioneCalcola() {
        return azioneCalcola;
    }

}
