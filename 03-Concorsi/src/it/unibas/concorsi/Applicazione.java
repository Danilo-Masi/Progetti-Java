package it.unibas.concorsi;

import it.unibas.concorsi.controllo.ControlloDettagliConcorso;
import it.unibas.concorsi.controllo.ControlloFrame;
import it.unibas.concorsi.controllo.ControlloPrincipale;
import it.unibas.concorsi.modello.Modello;
import it.unibas.concorsi.persistenza.DAOArchivoMock;
import it.unibas.concorsi.persistenza.IDAOArchivio;
import it.unibas.concorsi.vista.Frame;
import it.unibas.concorsi.vista.VistaDettagliConcorso;
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
    private IDAOArchivio dAOArchivio;
    private Frame frame;
    private VistaPrincipale vistaPrincipale;
    private VistaDettagliConcorso vistaDettagliConcorso;
    private ControlloFrame controlloFrame;
    private ControlloPrincipale controlloPrincipale;
    private ControlloDettagliConcorso controlloDettagliConcorso;

    public void inizializza() {
        this.modello = new Modello();
        this.dAOArchivio = new DAOArchivoMock();
        this.frame = new Frame();
        this.vistaPrincipale = new VistaPrincipale();
        this.vistaDettagliConcorso = new VistaDettagliConcorso(frame, true);
        this.controlloFrame = new ControlloFrame();
        this.controlloPrincipale = new ControlloPrincipale();
        this.controlloDettagliConcorso = new ControlloDettagliConcorso();
        // Inizializzazione
        this.vistaDettagliConcorso.inizializza();
        this.vistaPrincipale.inizializza();
        this.frame.inizializza();
    }

    public static Applicazione getSingleton() {
        return singleton;
    }

    public Modello getModello() {
        return modello;
    }

    public IDAOArchivio getdAOArchivio() {
        return dAOArchivio;
    }

    public Frame getFrame() {
        return frame;
    }

    public VistaPrincipale getVistaPrincipale() {
        return vistaPrincipale;
    }

    public ControlloFrame getControlloFrame() {
        return controlloFrame;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public VistaDettagliConcorso getVistaDettagliConcorso() {
        return vistaDettagliConcorso;
    }

    public ControlloDettagliConcorso getControlloDettagliConcorso() {
        return controlloDettagliConcorso;
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
