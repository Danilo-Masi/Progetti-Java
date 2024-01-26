package it.unibas.ingressiaule;

import it.unibas.ingressiaule.controllo.ControlloDettagliAula;
import it.unibas.ingressiaule.controllo.ControlloMenu;
import it.unibas.ingressiaule.controllo.ControlloPrincipale;
import it.unibas.ingressiaule.modello.Modello;
import it.unibas.ingressiaule.persistenza.DAOArchivioMock;
import it.unibas.ingressiaule.persistenza.IDAOArchivio;
import it.unibas.ingressiaule.vista.Frame;
import it.unibas.ingressiaule.vista.VistaDettagliAula;
import it.unibas.ingressiaule.vista.VistaMesiFrequenti;
import it.unibas.ingressiaule.vista.VistaPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static Applicazione singleton = new Applicazione();

    private Applicazione() {
    }

    public static Applicazione getInstance() {
        return singleton;
    }

    private IDAOArchivio daoArchivio;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private Modello modello;
    private VistaDettagliAula vistaDettagliAula;
    private ControlloDettagliAula controlloDettagliAula;
    private VistaMesiFrequenti vistaMesiFrequenti;

    private void inizializza() {
        this.daoArchivio = new DAOArchivioMock();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.modello = new Modello();
        this.vistaDettagliAula = new VistaDettagliAula(frame, true);
        this.controlloDettagliAula = new ControlloDettagliAula();
        this.vistaMesiFrequenti = new VistaMesiFrequenti(frame, true);
        //Avvia
        this.frame.inizializza();
        this.vistaPrincipale.inizializza();
        this.vistaDettagliAula.inizializza();
        this.vistaMesiFrequenti.inizializza();
    }

    public IDAOArchivio getDaoArchivio() {
        return daoArchivio;
    }

    public void setDaoArchivio(IDAOArchivio daoArchivio) {
        this.daoArchivio = daoArchivio;
    }

    public ControlloMenu getControlloMenu() {
        return controlloMenu;
    }

    public void setControlloMenu(ControlloMenu controlloMenu) {
        this.controlloMenu = controlloMenu;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public void setControlloPrincipale(ControlloPrincipale controlloPrincipale) {
        this.controlloPrincipale = controlloPrincipale;
    }

    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public void setVistaPrincipale(VistaPrincipale vistaPrincipale) {
        this.vistaPrincipale = vistaPrincipale;
    }

    public Modello getModello() {
        return modello;
    }

    public VistaDettagliAula getVistaDettagliAula() {
        return vistaDettagliAula;
    }

    public ControlloDettagliAula getControlloDettagliAula() {
        return controlloDettagliAula;
    }

    public VistaMesiFrequenti getVistaMesiFrequenti() {
        return vistaMesiFrequenti;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Applicazione.getInstance().inizializza();
            }

        });
    }

}
