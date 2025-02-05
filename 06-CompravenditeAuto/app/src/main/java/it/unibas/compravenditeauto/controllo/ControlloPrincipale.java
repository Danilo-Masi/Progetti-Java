package it.unibas.compravenditeauto.controllo;

import it.unibas.compravenditeauto.Applicazione;
import it.unibas.compravenditeauto.modello.Archivio;
import it.unibas.compravenditeauto.modello.Auto;
import it.unibas.compravenditeauto.modello.Costanti;
import it.unibas.compravenditeauto.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private Action azioneCercaAuto = new AzioneCercaAuto();

    private class AzioneCercaAuto extends AbstractAction {

        public AzioneCercaAuto() {
            this.setEnabled(false);
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca auto");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            String annoString = vistaPrincipale.getValoreAnno();
            String meseString = vistaPrincipale.getValoreMese();
            String giornoString = vistaPrincipale.getValoreGiorno();
            boolean isOrdinamentoCrescente = vistaPrincipale.isOrdinamentoCrescente();
            String errori = convalida(annoString, meseString, giornoString);
            if (!errori.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore(errori);
                return;
            }
            String ordinamento;
            if (isOrdinamentoCrescente) {
                ordinamento = Costanti.ORDINAMENTO_CRESCENTE;
            } else {
                ordinamento = Costanti.ORDINAMENTO_DECRESCENTE;
            }
            int anno = Integer.parseInt(annoString);
            int mese = Integer.parseInt(meseString);
            int giorno = Integer.parseInt(giornoString);
            Calendar data = new GregorianCalendar(anno, mese, giorno);
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            List<Auto> listaFiltarta = archivio.cercaAuto(data, ordinamento);
            Applicazione.getInstance().getModello().putBeans(Costanti.LISTA_FILTRATA, listaFiltarta);
            vistaPrincipale.aggiornaTabella();
        }

        private String convalida(String annoString, String meseString, String giornoString) {
            StringBuilder errori = new StringBuilder();
            if (annoString.trim().isEmpty()) {
                errori.append("Il campo del anno non puo essere vuoto\n");
            }
            if (meseString.trim().isEmpty()) {
                errori.append("Il campo del mese non puo essere vuoto\n");
            }
            if (giornoString.trim().isEmpty()) {
                errori.append("Il campo del giorno non puo essere vuoto\n");
            }
            try {
                int anno = Integer.parseInt(annoString);
                int mese = Integer.parseInt(meseString);
                int giorno = Integer.parseInt(giornoString);
                Calendar calendar = new GregorianCalendar(anno, mese, giorno);
                calendar.setLenient(false);
                calendar.getTime();
            } catch (NumberFormatException e) {
                errori.append("Il valore della data non è valido\n");
            }
            return errori.toString();
        }
    }

    public Action getAzioneCercaAuto() {
        return azioneCercaAuto;
    }

}
