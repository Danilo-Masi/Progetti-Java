package it.unibas.sistemiistituti;

import it.unibas.sistemiistituti.controllo.ControlloMenu;
import it.unibas.sistemiistituti.controllo.ControlloPrincipale;
import it.unibas.sistemiistituti.modello.Modello;
import it.unibas.sistemiistituti.persistenza.DAOArchivioMock;
import it.unibas.sistemiistituti.persistenza.IDAOArchivio;
import it.unibas.sistemiistituti.vista.Frame;
import it.unibas.sistemiistituti.vista.VistaDettagliIstituto;
import it.unibas.sistemiistituti.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static Applicazione singleton = new Applicazione();

    public static Applicazione getInstance() {
        return singleton;
    }

    private Applicazione() {
    }

    private Modello modello;
    private IDAOArchivio dAOArchivio;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private VistaDettagliIstituto vistaDettagliIstituto;

    private void inizializza() {

        this.modello = new Modello();
        this.dAOArchivio = new DAOArchivioMock();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.vistaDettagliIstituto = new VistaDettagliIstituto(frame, true);

        this.frame.inizializza();
        this.vistaPrincipale.inizializza();
        this.vistaDettagliIstituto.inizializza();
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

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public VistaDettagliIstituto getVistaDettagliIstituto() {
        return vistaDettagliIstituto;
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
