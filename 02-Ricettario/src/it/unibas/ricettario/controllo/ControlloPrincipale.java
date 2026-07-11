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
import javax.swing.KeyStroke;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlloPrincipale {

    private Action azioneCercaTipologia = new AzioneCercaTipologia();
    private Action azioneCercaPietanzaSimile = new AzioneCercaPietanzaSimile();

    private class AzioneCercaPietanzaSimile extends AbstractAction {

        public AzioneCercaPietanzaSimile() {
            this.putValue(NAME, "Cerca pietanza");
            this.putValue(SHORT_DESCRIPTION, "Cerca pietanza simile");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_S);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt S"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            int rigaSelezionata = vistaPrincipale.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Seleziona una pietanza prima di proseguire");
                return;
            }
            List<Pietanza> listaFiltrata = (List<Pietanza>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_FILTRATA);
            Pietanza pietanzaSelezionata = listaFiltrata.get(rigaSelezionata);
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
            Pietanza pietanzaSimile = archivio.cercaPietanzaSimile(pietanzaSelezionata);
            if (pietanzaSimile == null) {
                Applicazione.getInstance().getFrame().mostraMessaggio("Non esiste nessuna pietanza simile");
            }
            Applicazione.getInstance().getFrame().mostraMessaggio("La pietanza più simile a " + pietanzaSelezionata.getNome() +  " è " + pietanzaSimile.getNome());
        }

    }

    private class AzioneCercaTipologia extends AbstractAction {

        private Logger logger = LoggerFactory.getLogger(AzioneCercaTipologia.class);

        public AzioneCercaTipologia() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca per tipologia");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_T);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt T"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            String comboCategoria = vistaPrincipale.getComboCategoria();
            if (comboCategoria.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Seleziona una categoria prima di procedere");
                return;
            }
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBean(Costanti.ARCHIVIO);
            List<Pietanza> pietanzeFiltrate = archivio.cercaPietanzaPerCategoria(comboCategoria);
            logger.debug("Numero pietanze filtrate: {}", pietanzeFiltrate.size());
            Applicazione.getInstance().getModello().putBean(Costanti.LISTA_FILTRATA, pietanzeFiltrate);
            Applicazione.getInstance().getVistaPrincipale().aggiornaTabella();
        }
    }

    public Action getAzioneCercaTipologia() {
        return azioneCercaTipologia;
    }

    public Action getAzioneCercaPietanzaSimile() {
        return azioneCercaPietanzaSimile;
    }

}
