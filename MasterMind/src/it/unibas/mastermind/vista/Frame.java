package it.unibas.mastermind.vista;

import it.unibas.mastermind.Applicazione;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Frame extends javax.swing.JFrame {
    
    public void inizializza() {
        initComponents();
        VistaPrincipale vistaPrincipale = Applicazione.getInstance().getVistaPrincipale();
        this.setContentPane(new JScrollPane(vistaPrincipale));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.pack();
        inizializzaAzioni();
    }
    
    private void inizializzaAzioni() {
        this.menuEsci.setAction(Applicazione.getInstance().getControlloMenu().getAzioneEsci());
        this.menuIniziaPartita.setAction(Applicazione.getInstance().getControlloMenu().getAzioneIniziaPartita());
        this.menuInterrompi.setAction(Applicazione.getInstance().getControlloMenu().getAzioneInterrompi());
    }
    
    public void mostraMessaggio(String messaggio) {
        JOptionPane.showMessageDialog(this, messaggio, "Mastermind", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mostraMessaggioErrore(String errore) {
        JOptionPane.showMessageDialog(this, errore, "Mastermind errore", JOptionPane.ERROR_MESSAGE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        menuIniziaPartita = new javax.swing.JMenuItem();
        menuInterrompi = new javax.swing.JMenuItem();
        menuEsci = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setBorder(null);
        jMenu1.setText("File");

        menuIniziaPartita.setText("jMenuItem1");
        jMenu1.add(menuIniziaPartita);

        menuInterrompi.setText("jMenuItem1");
        jMenu1.add(menuInterrompi);

        menuEsci.setText("jMenuItem2");
        jMenu1.add(menuEsci);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem menuEsci;
    private javax.swing.JMenuItem menuIniziaPartita;
    private javax.swing.JMenuItem menuInterrompi;
    // End of variables declaration//GEN-END:variables
}
