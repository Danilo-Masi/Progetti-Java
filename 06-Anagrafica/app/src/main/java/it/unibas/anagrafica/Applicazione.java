package it.unibas.anagrafica;

import it.unibas.anagrafica.controllo.ControlloDettagliAzienda;
import it.unibas.anagrafica.controllo.ControlloMenu;
import it.unibas.anagrafica.controllo.ControlloPrincipale;
import it.unibas.anagrafica.modello.Modello;
import it.unibas.anagrafica.persistenza.DAOArchivioMock;
import it.unibas.anagrafica.persistenza.IDAOArchivio;
import it.unibas.anagrafica.vista.Frame;
import it.unibas.anagrafica.vista.VistaDettagliAzienda;
import it.unibas.anagrafica.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static final Applicazione singleton = new Applicazione();

    public static Applicazione getInstance() {
        return singleton;
    }

    private Applicazione() {
    }

    private IDAOArchivio daoArchivio;
    private Modello modello;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private VistaDettagliAzienda vistaDettagliAzienda;
    private ControlloDettagliAzienda controlloDettagliAzienda;

    public void inizializza() {
        this.daoArchivio = new DAOArchivioMock();
        this.modello = new Modello();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.vistaDettagliAzienda = new VistaDettagliAzienda(frame, true);
        this.controlloDettagliAzienda = new ControlloDettagliAzienda();
        // Inizializzazione
        this.vistaDettagliAzienda.inizializza();
        this.vistaPrincipale.inizializza();
        this.frame.inizializza();
    }

    public IDAOArchivio getDaoArchivio() {
        return daoArchivio;
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
