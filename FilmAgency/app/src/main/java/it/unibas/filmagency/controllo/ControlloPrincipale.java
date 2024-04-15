package it.unibas.filmagency.controllo;

import it.unibas.filmagency.Applicazione;
import it.unibas.filmagency.Costanti;
import it.unibas.filmagency.modello.Archivio;
import it.unibas.filmagency.modello.Film;
import it.unibas.filmagency.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private Action azioneCercaFilm = new AzioneCercaFilm();
    private Action azioneMostraDettagliFilm = new AzioneMostraDettagliFilm();

    private class AzioneMostraDettagliFilm extends AbstractAction {

        public AzioneMostraDettagliFilm() {
            this.putValue(NAME, "Mostra dettagli");
            this.putValue(SHORT_DESCRIPTION, "Mostra dettagli film selezionato");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_M);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt M"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            int rigaSelezionata = vistaPrincipale.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Selezionare una riga per procedere");
                return;
            }
            List<Film> listaFiltrata = (List<Film>) Applicazione.getInstance().getModello().getBeand(Costanti.LISTA_FILTRATA);
            Film filmSelezionato = listaFiltrata.get(rigaSelezionata);
            Applicazione.getInstance().getModello().putBeans(Costanti.FILM_SELEZIONATO, filmSelezionato);
            Applicazione.getInstance().getVistaDettagliFilm().visualizza();
        }
    }

    private class AzioneCercaFilm extends AbstractAction {

        public AzioneCercaFilm() {
            this.putValue(NAME, "Cerca film");
            this.putValue(SHORT_DESCRIPTION, "Cerca film in base alla data");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_F);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt F"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            Calendar dataInserita = vistaPrincipale.getDataInserita();
            String criterio;
            if (vistaPrincipale.isCrescente()) {
                criterio = Costanti.ORDINAMENTO_CRESCENTE;
            } else {
                criterio = Costanti.ORDINAMENTO_DECRESCENTE;
            }
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeand(Costanti.ARCHIVIO);
            List<Film> listaFiltrata = archivio.cercaFilmPerData(dataInserita, criterio);
            Applicazione.getInstance().getModello().putBeans(Costanti.LISTA_FILTRATA, listaFiltrata);
            vistaPrincipale.aggiornaDati();
        }
    }

    public Action getAzioneMostraDettagliFilm() {
        return azioneMostraDettagliFilm;
    }

    public Action getAzioneCercaFilm() {
        return azioneCercaFilm;
    }

}
