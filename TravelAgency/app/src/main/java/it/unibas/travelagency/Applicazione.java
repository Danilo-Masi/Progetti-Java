package it.unibas.travelagency;

import it.unibas.travelagency.controllo.ControlloDettagliAgenzia;
import it.unibas.travelagency.controllo.ControlloMenu;
import it.unibas.travelagency.controllo.ControlloPrincipale;
import it.unibas.travelagency.modello.Modello;
import it.unibas.travelagency.persistenza.DAOArchivioMock;
import it.unibas.travelagency.persistenza.IDAOArchivio;
import it.unibas.travelagency.vista.Frame;
import it.unibas.travelagency.vista.VistaDettagliAgenzia;
import it.unibas.travelagency.vista.VistaPrincipale;
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
    private IDAOArchivio dAOArchivio;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private VistaDettagliAgenzia vistaDettagliAgenzia;
    private ControlloDettagliAgenzia controlloDettagliAgenzia;

    private void inizializza() {
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.modello = new Modello();
        this.dAOArchivio = new DAOArchivioMock();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.vistaDettagliAgenzia = new VistaDettagliAgenzia(frame, true);
        this.controlloDettagliAgenzia = new ControlloDettagliAgenzia();
        //Inizializzazione
        this.vistaDettagliAgenzia.inizializza();
        this.vistaPrincipale.inizializza();
        this.frame.inizializza();
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

    public VistaDettagliAgenzia getVistaDettagliAgenzia() {
        return vistaDettagliAgenzia;
    }

    public ControlloDettagliAgenzia getControlloDettagliAgenzia() {
        return controlloDettagliAgenzia;
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
