package it.unibas.filmagency;

import it.unibas.filmagency.controllo.ControlloDettagliFilm;
import it.unibas.filmagency.controllo.ControlloMenu;
import it.unibas.filmagency.controllo.ControlloPrincipale;
import it.unibas.filmagency.modello.Modello;
import it.unibas.filmagency.persistenza.DAOArchivioMock;
import it.unibas.filmagency.persistenza.IDAOArchivio;
import it.unibas.filmagency.vista.Frame;
import it.unibas.filmagency.vista.VistaDettagliFilm;
import it.unibas.filmagency.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    public static Applicazione singleton = new Applicazione();

    private Applicazione() {
    }

    public static Applicazione getInstance() {
        return singleton;
    }

    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private Modello modello;
    private IDAOArchivio dAOArchivio;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private VistaDettagliFilm vistaDettagliFilm;
    private ControlloDettagliFilm controlloDettagliFilm;

    private void inizializza() {
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.modello = new Modello();
        this.dAOArchivio = new DAOArchivioMock();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.vistaDettagliFilm = new VistaDettagliFilm(frame, true);
        this.controlloDettagliFilm = new ControlloDettagliFilm();
        //Inizializzazione
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

    public Modello getModello() {
        return modello;
    }

    public IDAOArchivio getdAOArchivio() {
        return dAOArchivio;
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public VistaDettagliFilm getVistaDettagliFilm() {
        return vistaDettagliFilm;
    }

    public ControlloDettagliFilm getControlloDettagliFilm() {
        return controlloDettagliFilm;
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
