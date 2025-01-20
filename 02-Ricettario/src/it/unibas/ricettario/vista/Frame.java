package it.unibas.ricettario.vista;

public class Frame extends javax.swing.JFrame {

    public void inizializza() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
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

        menuCarica.setText("Carica");
        menuCarica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCaricaActionPerformed(evt);
            }
        });
        jMenu1.add(menuCarica);

        menuCerca.setText("Cerca");
        jMenu1.add(menuCerca);

        menuEsci.setText("Esci");
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

    private void menuCaricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCaricaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuCaricaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem menuCarica;
    private javax.swing.JMenuItem menuCerca;
    private javax.swing.JMenuItem menuEsci;
    // End of variables declaration//GEN-END:variables
}
