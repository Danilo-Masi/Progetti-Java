package it.unibas.ingressiaule.vista;

import it.unibas.ingressiaule.Applicazione;
import it.unibas.ingressiaule.modello.Costanti;
import it.unibas.ingressiaule.modello.DatiAccessiMese;
import java.util.List;

public class VistaMesiFrequenti extends javax.swing.JDialog {

    public VistaMesiFrequenti(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }

    public void inizializza() {
        initComponents();
        this.tabellaMesiFrequenti.setModel(new ModelloTabellaDatiMese());
        this.pack();
    }

    public void visuallizza() {
        aggiornaDati();
        setLocationRelativeTo(getParent());
        this.setVisible(true);
    }

    public void aggiornaDati() {
        List<DatiAccessiMese> datiMese = (List<DatiAccessiMese>) Applicazione.getInstance().getModello().getBean(Costanti.DATI_MESE);
        ModelloTabellaDatiMese modelloTabellaDatiMese = (ModelloTabellaDatiMese) this.tabellaMesiFrequenti.getModel();
        modelloTabellaDatiMese.setDatiMese(datiMese);
        modelloTabellaDatiMese.aggiornaContenuto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaMesiFrequenti = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabellaMesiFrequenti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabellaMesiFrequenti);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable tabellaMesiFrequenti;
    // End of variables declaration//GEN-END:variables

}
