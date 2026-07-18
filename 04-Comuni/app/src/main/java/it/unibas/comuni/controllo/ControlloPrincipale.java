package it.unibas.comuni.controllo;

import it.unibas.comuni.Applicazione;
import it.unibas.comuni.modello.Archivio;
import it.unibas.comuni.modello.Comune;
import it.unibas.comuni.modello.Costanti;
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

    private Action azioneCalcolaProvince = new AzioneCalcolaProvince();

    private class AzioneCalcolaProvince extends AbstractAction {

        public AzioneCalcolaProvince() {
            this.putValue(NAME, "Calcola province");
            this.putValue(SHORT_DESCRIPTION, "Calcola le province in base al numero impostato");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Integer numeroProvince = Applicazione.getInstance().getVistaPrincipale().getNumeroProvince();
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
            OperatoreDatiProvincia operatoreDatiProvincia = Applicazione.getInstance().getOperatoreDatiProvincia();
            List<DatiProvincia> listaFiltrata = operatoreDatiProvincia.calcolaDatiProvincia(archivio.getListaComuni(), numeroProvince);
            Applicazione.getInstance().getModello().putBean(Costanti.LISTA_FILTRATA, listaFiltrata);
            Applicazione.getInstance().getVistaPrincipale().aggiornaTabella();
        }
    }

    public Action getAzioneCalcolaProvince() {
        return azioneCalcolaProvince;
    }

}
