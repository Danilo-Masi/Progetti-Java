package it.unibas.anagrafica.vista;

import it.unibas.anagrafica.Applicazione;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Frame extends javax.swing.JFrame {

    public void inizializza() {
        initComponents();
        this.setContentPane(new JScrollPane(Applicazione.getInstance().getVistaPrincipale()));
        setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
        iniziallizzaAzioni();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        menuRicerca = new javax.swing.JMenuItem();
        menuVerifica = new javax.swing.JMenuItem();
        menuCarica = new javax.swing.JMenuItem();
        menuEsci = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        menuRicerca.setText("jMenuItem1");
        jMenu1.add(menuRicerca);

        menuVerifica.setText("jMenuItem2");
        jMenu1.add(menuVerifica);

        menuCarica.setText("jMenuItem3");
        jMenu1.add(menuCarica);

        menuEsci.setText("jMenuItem4");
        jMenu1.add(menuEsci);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem menuCarica;
    private javax.swing.JMenuItem menuEsci;
    private javax.swing.JMenuItem menuRicerca;
    private javax.swing.JMenuItem menuVerifica;
    // End of variables declaration//GEN-END:variables

    private void iniziallizzaAzioni() {
        this.menuEsci.setAction(Applicazione.getInstance().getControlloMenu().getAzioneEsci());
        this.menuCarica.setAction(Applicazione.getInstance().getControlloMenu().getAzioneCarica());
        this.menuVerifica.setAction(Applicazione.getInstance().getControlloMenu().getAzionVerifica());
    }

    public void mostraMessaggio(String messaggio) {
        JOptionPane.showMessageDialog(this, messaggio, this.getTitle() + " - Messaggio", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostraMessaggioErrore(String errore) {
        JOptionPane.showMessageDialog(this, errore, this.getTitle() + " - Errore", JOptionPane.ERROR_MESSAGE);
    }
}
