package it.unibas.concorsi;

import it.unibas.concorsi.controllo.ControlloDettagliConcorso;
import it.unibas.concorsi.controllo.ControlloMenu;
import it.unibas.concorsi.controllo.ControlloPrincipale;
import it.unibas.concorsi.modello.Modello;
import it.unibas.concorsi.persistenza.DAOArchivio;
import it.unibas.concorsi.persistenza.IDAOArchivioMock;
import it.unibas.concorsi.vista.Frame;
import it.unibas.concorsi.vista.VistaDettagliConcorso;
import it.unibas.concorsi.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static Applicazione singleton = new Applicazione();

    public static Applicazione getInstance() {
        return singleton;
    }

    private Applicazione() {
    }

    private Modello modello;
    private IDAOArchivioMock dAOArchivio;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private VistaDettagliConcorso vistaDettagliConcorso;
    private ControlloDettagliConcorso controlloDettagliConcorso;

    private void inizializza() {
        this.modello = new Modello();
        this.dAOArchivio = new DAOArchivio();
        this.vistaPrincipale = new VistaPrincipale();
        this.frame = new Frame();
        this.vistaDettagliConcorso = new VistaDettagliConcorso(frame, true);
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.controlloDettagliConcorso = new ControlloDettagliConcorso();
        //Inizializza vista
        this.frame.inizializza();
        this.vistaPrincipale.inizializza();
        this.vistaDettagliConcorso.inizializza();
    }

    public ControlloDettagliConcorso getControlloDettagliConcorso() {
        return controlloDettagliConcorso;
    }

    public Modello getModello() {
        return modello;
    }

    public IDAOArchivioMock getdAOArchivio() {
        return dAOArchivio;
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public VistaDettagliConcorso getVistaDettagliConcorso() {
        return vistaDettagliConcorso;
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
