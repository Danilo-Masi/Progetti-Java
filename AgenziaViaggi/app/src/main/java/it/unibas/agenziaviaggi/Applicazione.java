package it.unibas.agenziaviaggi;

import it.unibas.agenziaviaggi.controllo.ControlloMenu;
import it.unibas.agenziaviaggi.controllo.ControlloPrincipale;
import it.unibas.agenziaviaggi.modello.Modello;
import it.unibas.agenziaviaggi.persistenza.DAOArchivioMock;
import it.unibas.agenziaviaggi.persistenza.IDAOArchivio;
import it.unibas.agenziaviaggi.vista.Frame;
import it.unibas.agenziaviaggi.vista.VistaDettagliAgenzia;
import it.unibas.agenziaviaggi.vista.VistaPrincipale;
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
    private IDAOArchivio daoArchivio;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private VistaDettagliAgenzia vistaDettagliAgenzia;

    private void inizializza() {
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.modello = new Modello();
        this.daoArchivio = new DAOArchivioMock();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.vistaDettagliAgenzia = new VistaDettagliAgenzia(frame, true);

        this.frame.inizializza();
        this.vistaPrincipale.inizializza();
        this.vistaDettagliAgenzia.inizializza();
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

    public IDAOArchivio getDaoArchivio() {
        return daoArchivio;
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Applicazione.getInstance().inizializza();
            }
        });
    }

}
