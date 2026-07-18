package it.unibas.comuni.vista;

import it.unibas.comuni.Applicazione;
import java.awt.Cursor;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Frame extends javax.swing.JFrame {

    public void inizializza() {
        initComponents();
        inizializzaAzioni();
        this.setContentPane(new JScrollPane(Applicazione.getInstance().getVistaPrincipale()));
        setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    private void inizializzaAzioni() {
        this.menuEsci.setAction(Applicazione.getInstance().getControlloMenu().getAzioneEsci());
        this.menuCarica.setAction(Applicazione.getInstance().getControlloMenu().getAzioneCarica());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        menuCarica = new javax.swing.JMenuItem();
        menuEsci = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        menuCarica.setText("jMenuItem1");
        jMenu1.add(menuCarica);

        menuEsci.setText("jMenuItem2");
        jMenu1.add(menuEsci);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem menuCarica;
    private javax.swing.JMenuItem menuEsci;
    // End of variables declaration//GEN-END:variables

    public void mostraMessaggioErrore(String string) {
        JOptionPane.showMessageDialog(this, string, this.getTitle() + " - Errore", JOptionPane.ERROR_MESSAGE);
    }

    public void mostraMessaggio(String string) {
        JOptionPane.showMessageDialog(this, string, this.getTitle() + " - Messaggio", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostraCursoreCaricamento() {
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
    }

    public void nascondiCursoreCaricamento() {
        this.setCursor(Cursor.getDefaultCursor());
    }
}
