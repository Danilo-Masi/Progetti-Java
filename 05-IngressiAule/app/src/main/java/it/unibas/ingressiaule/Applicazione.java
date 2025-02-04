package it.unibas.ingressiaule;

import it.unibas.ingressiaule.controllo.ControlloDettagliAccesso;
import it.unibas.ingressiaule.controllo.ControlloMenu;
import it.unibas.ingressiaule.controllo.ControlloPrincipale;
import it.unibas.ingressiaule.modello.Modello;
import it.unibas.ingressiaule.persistenza.DAOArchivio;
import it.unibas.ingressiaule.persistenza.IDAOArchivio;
import it.unibas.ingressiaule.vista.Frame;
import it.unibas.ingressiaule.vista.VistaDettagliAccesso;
import it.unibas.ingressiaule.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static Applicazione singleton = new Applicazione();

    public static Applicazione getInstance() {
        return singleton;
    }

    private Applicazione() {
    }

    private Modello modello;
    private IDAOArchivio daoArchivio;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private VistaDettagliAccesso vistaDettagliAccesso;
    private ControlloDettagliAccesso controlloDettagliAccesso;

    private void inizializza() {
        this.modello = new Modello();
        this.daoArchivio = new DAOArchivio();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.vistaDettagliAccesso = new VistaDettagliAccesso(frame, true);
        this.controlloDettagliAccesso = new ControlloDettagliAccesso();
        // Inzializza viste
        this.vistaPrincipale.inizializza();
        this.vistaDettagliAccesso.inizializza();
        this.frame.inizializza();
    }

    public Modello getModello() {
        return modello;
    }

    public IDAOArchivio getDaoArchivio() {
        return daoArchivio;
    }

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public VistaDettagliAccesso getVistaDettagliAccesso() {
        return vistaDettagliAccesso;
    }

    public ControlloDettagliAccesso getControlloDettagliAccesso() {
        return controlloDettagliAccesso;
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
