package it.unibas.concorsi;

import it.unibas.concorsi.controllo.ControlloMenu;
import it.unibas.concorsi.controllo.ControlloPrincipale;
import it.unibas.concorsi.modello.Modello;
import it.unibas.concorsi.persistenza.DAOArchivio;
import it.unibas.concorsi.persistenza.IDAOArchivioMock;
import it.unibas.concorsi.vista.Frame;
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
    
    private void inizializza() {
        this.modello = new Modello();
        this.dAOArchivio = new DAOArchivio();
        this.vistaPrincipale = new VistaPrincipale();
        this.frame = new Frame();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        //Inizializza vista
        this.frame.inizializza();
        this.vistaPrincipale.inizializza();
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
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Applicazione.getInstance().inizializza();
            }
        });
    }
    
}
