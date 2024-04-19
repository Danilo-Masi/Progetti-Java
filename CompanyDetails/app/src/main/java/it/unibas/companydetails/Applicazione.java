package it.unibas.companydetails;

import it.unibas.companydetails.controlllo.ControlloDettagliAzienda;
import it.unibas.companydetails.controlllo.ControlloMenu;
import it.unibas.companydetails.controlllo.ControlloPrincipale;
import it.unibas.companydetails.modello.Modello;
import it.unibas.companydetails.persistenza.DAOArchivioMock;
import it.unibas.companydetails.persistenza.IDAOArchivio;
import it.unibas.companydetails.vista.Frame;
import it.unibas.companydetails.vista.VistaDettagliAzienda;
import it.unibas.companydetails.vista.VistaPrincipale;
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
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private IDAOArchivio dAOArchivio;
    private VistaDettagliAzienda vistaDettagliAzienda;
    private ControlloDettagliAzienda controlloDettagliAzienda;

    private void inizializza() {
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.modello = new Modello();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.dAOArchivio = new DAOArchivioMock();
        this.vistaDettagliAzienda = new VistaDettagliAzienda(frame, true);
        this.controlloDettagliAzienda = new ControlloDettagliAzienda();
        //Inizializzazione
        this.frame.inizializza();
        this.vistaPrincipale.inizializza();
        this.vistaDettagliAzienda.inizializza();
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

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public IDAOArchivio getdAOArchivio() {
        return dAOArchivio;
    }

    public VistaDettagliAzienda getVistaDettagliAzienda() {
        return vistaDettagliAzienda;
    }

    public ControlloDettagliAzienda getControlloDettagliAzienda() {
        return controlloDettagliAzienda;
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
