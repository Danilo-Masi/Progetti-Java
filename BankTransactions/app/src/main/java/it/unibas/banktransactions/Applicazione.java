package it.unibas.banktransactions;

import it.unibas.banktransactions.controllo.ControlloMenu;
import it.unibas.banktransactions.controllo.ControlloPrincipale;
import it.unibas.banktransactions.modello.Modello;
import it.unibas.banktransactions.persistenza.DAOArchvioMock;
import it.unibas.banktransactions.persistenza.IDAOArchivio;
import it.unibas.banktransactions.vista.Frame;
import it.unibas.banktransactions.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static Applicazione singleton = new Applicazione();

    private Applicazione() {
    }

    public static Applicazione getInstance() {
        return singleton;
    }

    //Controllo
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    //Modello
    private Modello modello;
    //Persistenza
    private IDAOArchivio dAOArchivio;
    //Vista
    private Frame frame;
    private VistaPrincipale vistaPrincipale;

    private void inizializza() {
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.modello = new Modello();
        this.dAOArchivio = new DAOArchvioMock();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        //Inizializzazione
        this.frame.inizializza();
        this.vistaPrincipale.inizializza();
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Applicazione.getInstance().inizializza();
            }
        });
    }

}
