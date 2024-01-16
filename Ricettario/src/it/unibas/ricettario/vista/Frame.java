package it.unibas.ricettario.vista;

import it.unibas.ricettario.Applicazione;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Frame extends javax.swing.JFrame {

    public void inizializza() {
        initComponents();
        VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
        this.setContentPane(new JScrollPane(vistaPrincipale));
        setLocationRelativeTo(null);
        setVisible(true);
        inizializzaAzioni();
    }
    
    //Inizializza le azioni
    private void inizializzaAzioni() {
        this.menuEsci.setAction(Applicazione.getInstance().getControlloMenu().getAzioneEsci());
        this.menuCarica.setAction(Applicazione.getInstance().getControlloMenu().getAzioneCarica());
        this.menuCerca.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCerca());
    }
    
    //Messaggio informativo
    public void mostraMessagio(String messaggio) {
        JOptionPane.showMessageDialog(this, messaggio, "Ricettario", JOptionPane.INFORMATION_MESSAGE);
    }
    
    //Messaggio d'errore
    public void mostraMessaggioErrore(String errore) {
        JOptionPane.showMessageDialog(this, errore, "Errore", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        menuCarica = new javax.swing.JMenuItem();
        menuCerca = new javax.swing.JMenuItem();
        menuEsci = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ricettario");

        jMenu1.setText("File");

        menuCarica.setText("jMenuItem1");
        jMenu1.add(menuCarica);

        menuCerca.setText("jMenuItem2");
        jMenu1.add(menuCerca);

        menuEsci.setText("jMenuItem3");
        jMenu1.add(menuEsci);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 673, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem menuCarica;
    private javax.swing.JMenuItem menuCerca;
    private javax.swing.JMenuItem menuEsci;
    // End of variables declaration//GEN-END:variables
}
