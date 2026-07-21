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

    private static final Applicazione singleton = new Applicazione();

    private Applicazione() {
    }

    public static Applicazione getInstance() {
        return singleton;
    }

    private Modello modello;
    private IDAOArchivio dAOArchivio;
    private ControlloMenu controlloMenu;
    private ControlloPrincipale controlloPrincipale;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private VistaDettagliAula vistaDettagliAula;
    private ControlloDettagliAula controlloDettagliAula;
    private VistaMesiFrequenti vistaMesiFrequenti;

    private void inizializza() {
        this.modello = new Modello();
        this.dAOArchivio = new DAOArchivioMock();
        this.controlloMenu = new ControlloMenu();
        this.controlloPrincipale = new ControlloPrincipale();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.vistaDettagliAula = new VistaDettagliAula(frame, true);
        this.controlloDettagliAula = new ControlloDettagliAula();
        this.vistaMesiFrequenti = new VistaMesiFrequenti(frame, true);
        //Inizializzazione
        this.vistaMesiFrequenti.inizializza();
        this.vistaDettagliAula.inizializza();
        this.vistaPrincipale.inizializza();
        this.frame.inizializza();
    }

    public Modello getModello() {
        return modello;
    }

    public IDAOArchivio getdAOArchivio() {
        return dAOArchivio;
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
            @Override
            public void run() {
                Applicazione.getInstance().inizializza();
            }
        });
    }

}
