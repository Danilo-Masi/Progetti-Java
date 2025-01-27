package it.unibas.ricettario.controllo;

import it.unibas.ricettario.Applicazione;
import it.unibas.ricettario.modello.Archivio;
import it.unibas.ricettario.modello.Costanti;
import it.unibas.ricettario.modello.Pietanza;
import it.unibas.ricettario.vista.VistaPrincipale;
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

    private Action azioneCercaTipologia = new AzioneCercaTipologia();
    private Action azioneCercaSimile = new AzioneCercaSimile();

    private class AzioneCercaSimile extends AbstractAction {

        public AzioneCercaSimile() {
            this.setEnabled(false);
            this.putValue(NAME, "Cerca simile");
            this.putValue(SHORT_DESCRIPTION, "Cerca pietanza simile");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_S);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt S"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int rigaSelezionata = Applicazione.getInstance().getVistaPrincipale().getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Seleziona una pietanza prima di procedere");
                return;
            }
            List<Pietanza> listaFiltrata = (List<Pietanza>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            Pietanza pietanzaSelezionata = listaFiltrata.get(rigaSelezionata);
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
            Pietanza pietanzaSimile = archivio.cercaPietanzaSimile(pietanzaSelezionata);
            if (pietanzaSelezionata == null) {
                Applicazione.getInstance().getFrame().mostraMessaggio("Non esiste una pietanza simile");
                return;
            }
            Applicazione.getInstance().getFrame().mostraMessaggio("La pietanza simile a quella selezionata è: " + pietanzaSimile.getNome());
        }
    }

    private class AzioneCercaTipologia extends AbstractAction {

        public AzioneCercaTipologia() {
            this.setEnabled(false);
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca per tipologia");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_T);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt T"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            String categoria = vistaPrincipale.getComboCategoria();
            if (categoria.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Seleziona prima una categoria");
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
            List<Pietanza> listaFiltrata = archivio.cercaPietanzePerCategoria(categoria);
            Applicazione.getInstance().getModello().putBean(Costanti.LISTA_FILTRATA, listaFiltrata);
            vistaPrincipale.aggiornaTabella();
        }
    }

    public Action getAzioneCercaSimile() {
        return azioneCercaSimile;
    }

    public Action getAzioneCercaTipologia() {
        return azioneCercaTipologia;
    }

}
