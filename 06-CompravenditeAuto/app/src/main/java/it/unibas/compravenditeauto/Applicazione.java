package it.unibas.compravenditeauto;

import it.unibas.compravenditeauto.controllo.ControlloDettagliAuto;
import it.unibas.compravenditeauto.controllo.ControlloMenu;
import it.unibas.compravenditeauto.controllo.ControlloPrincipale;
import it.unibas.compravenditeauto.modello.Modello;
import it.unibas.compravenditeauto.persistenza.DAOArchivio;
import it.unibas.compravenditeauto.persistenza.IDAOArchivio;
import it.unibas.compravenditeauto.vista.Frame;
import it.unibas.compravenditeauto.vista.VistaDettagliAuto;
import it.unibas.compravenditeauto.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static Applicazione singleton = new Applicazione();

    public static Applicazione getInstance() {
        return singleton;
    }

    private Applicazione() {
    }

    private Modello modello;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private IDAOArchivio daoArchivio;
    private VistaDettagliAuto vistaDettagliAuto;
    private ControlloDettagliAuto controlloDettagliAuto;

    private void inizializza() {
        this.modello = new Modello();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.daoArchivio = new DAOArchivio();
        this.vistaDettagliAuto = new VistaDettagliAuto(frame, true);
        this.controlloDettagliAuto = new ControlloDettagliAuto();
        // Inizializza le viste
        this.vistaPrincipale.inizializza();
        this.vistaDettagliAuto.inizializza();
        this.frame.inizializza();
    }

    public Modello getModello() {
        return modello;
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

    public IDAOArchivio getDaoArchivio() {
        return daoArchivio;
    }

    public VistaDettagliAuto getVistaDettagliAuto() {
        return vistaDettagliAuto;
    }

    public ControlloDettagliAuto getControlloDettagliAuto() {
        return controlloDettagliAuto;
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
