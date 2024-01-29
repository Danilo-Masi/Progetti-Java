package it.unibas.appfilm;

import it.unibas.appfilm.controllo.ControlloMenu;
import it.unibas.appfilm.controllo.ControlloPrincipale;
import it.unibas.appfilm.modello.Modello;
import it.unibas.appfilm.persistenza.DAOArchivioMock;
import it.unibas.appfilm.persistenza.IDAOArchivio;
import it.unibas.appfilm.vista.Frame;
import it.unibas.appfilm.vista.VistaDettagliFilm;
import it.unibas.appfilm.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static Applicazione singleton = new Applicazione();

    private Applicazione() {
    }

    public static Applicazione getInstance() {
        return singleton;
    }

    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private IDAOArchivio daoArchivio;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private Modello modello;
    private VistaDettagliFilm vistaDettagliFilm;

    private void inizializza() {

        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.daoArchivio = new DAOArchivioMock();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.modello = new Modello();
        this.vistaDettagliFilm = new VistaDettagliFilm(frame, true);

        this.frame.inizializza();
        this.vistaPrincipale.inizializza();
        this.vistaDettagliFilm.inizializza();

    }

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public IDAOArchivio getDaoArchivio() {
        return daoArchivio;
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public Modello getModello() {
        return modello;
    }

    public VistaDettagliFilm getVistaDettagliFilm() {
        return vistaDettagliFilm;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Applicazione.getInstance().inizializza();
            }
        });
    }

}
