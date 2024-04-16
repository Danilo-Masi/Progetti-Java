package it.unibas.bookrental;

import it.unibas.bookrental.controllo.ControlloDettagliUtente;
import it.unibas.bookrental.controllo.ControlloMenu;
import it.unibas.bookrental.controllo.ControlloPrincipale;
import it.unibas.bookrental.modello.Modello;
import it.unibas.bookrental.persistenza.DAOArchivioMock;
import it.unibas.bookrental.persistenza.IDAOArchvio;
import it.unibas.bookrental.vista.Frame;
import it.unibas.bookrental.vista.VistaDettagliUtente;
import it.unibas.bookrental.vista.VistaPrincipale;
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
    private Modello modello;
    private IDAOArchvio dAOArchvio;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private VistaDettagliUtente vistaDettagliUtente;
    private ControlloDettagliUtente controlloDettagliUtente;

    private void inizializza() {
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.modello = new Modello();
        this.dAOArchvio = new DAOArchivioMock();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.vistaDettagliUtente = new VistaDettagliUtente(frame, true);
        this.controlloDettagliUtente = new ControlloDettagliUtente();
        //Inizializzazione
        this.frame.inizializza();
        this.vistaPrincipale.inizializza();
        this.vistaDettagliUtente.inizializza();
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

    public IDAOArchvio getdAOArchvio() {
        return dAOArchvio;
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public VistaDettagliUtente getVistaDettagliUtente() {
        return vistaDettagliUtente;
    }

    public ControlloDettagliUtente getControlloDettagliUtente() {
        return controlloDettagliUtente;
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
