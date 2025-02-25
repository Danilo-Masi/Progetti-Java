package it.unibas.ricettario;

import it.unibas.ricettario.controllo.ControlloMenu;
import it.unibas.ricettario.controllo.ControlloPrincipale;
import it.unibas.ricettario.modello.Modello;
import it.unibas.ricettario.persistenza.DAOArchivioMock;
import it.unibas.ricettario.persistenza.IDAOArchivio;
import it.unibas.ricettario.vista.Frame;
import it.unibas.ricettario.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static Applicazione singleton = new Applicazione();

    private Applicazione() {
    }

    public static Applicazione getInstance() {
        return singleton;
    }

    private Modello modello;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private IDAOArchivio dAOArchivio;

    public void inizializza() {
        this.modello = new Modello();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.dAOArchivio = new DAOArchivioMock();
        // Inizializzazione dei componenti
        this.vistaPrincipale.inizializza();
        this.frame.inizializza();
    }

    public Modello getModello() {
        return modello;
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

    public IDAOArchivio getdAOArchivio() {
        return dAOArchivio;
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
