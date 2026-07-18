package it.unibas.comuni;

import it.unibas.comuni.controllo.ControlloMenu;
import it.unibas.comuni.controllo.ControlloPrincipale;
import it.unibas.comuni.modello.Modello;
import it.unibas.comuni.modello.OperatoreDatiProvincia;
import it.unibas.comuni.persistenza.DAOArchivioJson;
import it.unibas.comuni.persistenza.IDAOArchivio;
import it.unibas.comuni.vista.Frame;
import it.unibas.comuni.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    public static final Applicazione singleton = new Applicazione();

    private Applicazione() {
    }

    public static Applicazione getInstance() {
        return singleton;
    }

    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private IDAOArchivio dAOArchivio;
    private Modello modello;
    private OperatoreDatiProvincia operatoreDatiProvincia;

    private void inizializza() {
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.dAOArchivio = new DAOArchivioJson();
        this.modello = new Modello();
        this.operatoreDatiProvincia = new OperatoreDatiProvincia();
        // Inizializza azioni
        this.vistaPrincipale.inizializza();
        this.frame.inizializza();
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

    public IDAOArchivio getdAOArchivio() {
        return dAOArchivio;
    }

    public Modello getModello() {
        return modello;
    }

    public OperatoreDatiProvincia getOperatoreDatiProvincia() {
        return operatoreDatiProvincia;
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
