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

    private static Applicazione singleton = new Applicazione();

    private Applicazione() {
    }

    public static Applicazione getInstance() {
        return singleton;
    }

    private IDAOArchivio daoArchivio;
    private Modello modello;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private OperatoreDatiProvincia operatoreDatiProvincia;

    public void inizializza() {
        this.daoArchivio = new DAOArchivioJson();
        this.modello = new Modello();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.operatoreDatiProvincia = new OperatoreDatiProvincia();
        //Avvia i componenti
        this.frame.inizializza();
        this.vistaPrincipale.inizializza();
    }

    public IDAOArchivio getDaoArchivio() {
        return daoArchivio;
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
