package it.unibas.appfilm.controllo;

import it.unibas.appfilm.Applicazione;
import it.unibas.appfilm.Costanti;
import it.unibas.appfilm.modello.Archivio;
import it.unibas.appfilm.modello.Attore;
import it.unibas.appfilm.modello.Film;
import it.unibas.appfilm.vista.VistaDettagliFilm;
import it.unibas.appfilm.vista.VistaPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloPrincipale {

    private Action azioneCercaFilm = new AzioneCercaFilm();
    private Action azioneNuovoAttore = new AzioneNuovoAttore();
    private Action azioneAggiungi = new AzioneAggiungi();

    private class AzioneAggiungi extends AbstractAction {

        private AzioneAggiungi() {
            this.putValue(NAME, "Aggiungi");
            this.putValue(SHORT_DESCRIPTION, "Aggiungi");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_G);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt G"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            VistaDettagliFilm vistaDettagliFilm = Applicazione.getInstance().getVistaDettagliFilm();
            String nome = vistaDettagliFilm.getCampoNomeAttore();
            String nazionalita = vistaDettagliFilm.getCampoNazionalita();
            int annoNascita = vistaDettagliFilm.getCampoAnnoNascita();
            String errori = convalida(nome, nazionalita);
            if (!errori.isEmpty()) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore(errori);
                return;
            }
            Film filmSelezionato = (Film) Applicazione.getInstance().getModello().getBeans(Costanti.FILM_SELEZIONATO);
            List<Attore> listaAttori = filmSelezionato.getListaAttori();
            listaAttori.add(new Attore(nome, nazionalita, annoNascita));
            vistaDettagliFilm.aggiornaDati();
        }

        private String convalida(String nome, String nazionalita) {
            StringBuilder errori = new StringBuilder();
            if (nome.trim().isEmpty()) {
                errori.append("Il nome è obbligatorio \n");
            }
            if (nazionalita.trim().isEmpty()) {
                errori.append("Il campo nazionalità è obbligatorio \n");
            }
            return errori.toString();
        }
    }

    private class AzioneNuovoAttore extends AbstractAction {

        private AzioneNuovoAttore() {
            this.putValue(NAME, "Nuovo attore");
            this.putValue(SHORT_DESCRIPTION, "Inserisci nuovo attore");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            int rigaSelezionata = vistaPrincipale.getRigaSelezionata();
            if (rigaSelezionata == -1) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Seleziona un film prima di procedere");
                return;
            }
            List<Film> listaFiltrata = (List<Film>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
            Film filmSelezionato = listaFiltrata.get(rigaSelezionata);
            Applicazione.getInstance().getModello().putBeans(Costanti.FILM_SELEZIONATO, filmSelezionato);
            Applicazione.getInstance().getVistaDettagliFilm().visualizza();
        }
    }

    private class AzioneCercaFilm extends AbstractAction {

        private AzioneCercaFilm() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca film");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_F);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt F"));
            this.setEnabled(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
            Calendar dataImposta = vistaPrincipale.getDataImpostata();
            boolean isOridnamentoCrescente = vistaPrincipale.isDataCrescente();
            String ordinamento;
            if (isOridnamentoCrescente) {
                ordinamento = Costanti.CRESCENTE;
            } else {
                ordinamento = Costanti.DECRESCENTE;
            }
            Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
            List<Film> listaFiltrata = archivio.cercaPerData(dataImposta, ordinamento);
            Applicazione.getInstance().getModello().putBeans(Costanti.LISTA_FILTRATA, listaFiltrata);
            vistaPrincipale.aggiornaDati();
        }

    }

    public Action getAzioneNuovoAttore() {
        return azioneNuovoAttore;
    }

    public Action getAzioneCercaFilm() {
        return azioneCercaFilm;
    }

    public Action getAzioneAggiungi() {
        return azioneAggiungi;
    }

}
