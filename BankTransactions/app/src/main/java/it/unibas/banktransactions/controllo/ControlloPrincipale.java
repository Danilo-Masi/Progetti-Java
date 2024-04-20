package it.unibas.banktransactions.controllo;

import it.unibas.banktransactions.Applicazione;
import it.unibas.banktransactions.Costanti;
import it.unibas.banktransactions.modello.Archivio;
import it.unibas.banktransactions.modello.ContoCorrente;
import it.unibas.banktransactions.vista.VistaPrincipale;
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

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.putValue(NAME, "Carica");
            this.putValue(SHORT_DESCRIPTION, "Carica archivio");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            boolean isDataCrescente = vistaPrincipale.isDataCrescente();
            String criterio;
            if (isDataCrescente) {
                criterio = Costanti.DATA_CRESCENTE;
            } else {
                criterio = Costanti.NOME_CRESCENTE;
            }
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            List<ContoCorrente> listaFiltrata = archivio.cercaContiSottoscritti(criterio);
            Applicazione.getInstance().getModello().putBeans(Costanti.LISTA_FILTRATA, listaFiltrata);
            vistaPrincipale.aggiornaDati();
        }
    }

    public Action getAzioneCerca() {
        return azioneCerca;
    }

}
