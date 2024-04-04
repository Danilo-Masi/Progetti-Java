package it.unibas.mastermind;

import it.unibas.mastermind.controllo.ControlloMenu;
import it.unibas.mastermind.controllo.ControlloPrincipale;
import it.unibas.mastermind.modello.Modello;
import it.unibas.mastermind.vista.Frame;
import it.unibas.mastermind.vista.VistaPrincipale;
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
    private ControlloPrincipale controlloPrincipale;
    private ControlloMenu controlloMenu;

    public void inizializza() {
        //Creazione dei componenti
        this.modello = new Modello();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        //Inizializzazione
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

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
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
