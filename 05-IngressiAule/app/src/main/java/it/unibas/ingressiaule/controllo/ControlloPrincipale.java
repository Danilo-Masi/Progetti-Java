package it.unibas.ingressiaule.controllo;

import it.unibas.ingressiaule.Applicazione;
import it.unibas.ingressiaule.modello.Archivio;
import it.unibas.ingressiaule.modello.Aula;
import it.unibas.ingressiaule.modello.Costanti;
import it.unibas.ingressiaule.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private Action azioneCerca = new AzioneCerca();

    private class AzioneCerca extends AbstractAction {

        public AzioneCerca() {
            this.setEnabled(false);
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca aule per piano");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_P);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt P"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            String pianoString = vistaPrincipale.getCampoPiano();
            String errori = convalida(pianoString);
            if (!errori.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore(errori);
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            int piano = Integer.parseInt(pianoString);
            List<Aula> listaFiltrata = archivio.cercaAulePerPiano(piano);
            Applicazione.getInstance().getModello().putBeans(Costanti.LISTA_FILTRATA, listaFiltrata);
            vistaPrincipale.aggiornaTabella();
        }
    }

    private String convalida(String pianoString) {
        StringBuilder errori = new StringBuilder();
        if (pianoString.isEmpty()) {
            errori.append("Il campo del piano non può essere vuoto \n");
        }
        try {
            int piano = Integer.parseInt(pianoString);
            System.out.println(piano);
        } catch (NumberFormatException e) {
            errori.append("Il valore inserito per il piano non è valido \n");
        }
        return errori.toString();
    }

    public Action getAzioneCerca() {
        return azioneCerca;
    }

}
