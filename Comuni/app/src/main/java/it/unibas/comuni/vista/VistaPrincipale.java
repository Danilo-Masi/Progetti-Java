package it.unibas.comuni.vista;

import it.unibas.comuni.Applicazione;
import it.unibas.comuni.Costanti;
import it.unibas.comuni.modello.DatiProvincia;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        initComponents();
        inizializzaAzioni();
        this.tabella.setModel(new ModelloTabellaDatiProvince());
    }

    private void inizializzaAzioni() {
        this.bottoneCalcola.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCalcola());
    }

    public Integer getNumeroProvince() {
        return (Integer) this.spinner.getValue();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        spinner = new javax.swing.JSpinner();
        bottoneCalcola = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabella = new javax.swing.JTable();

        jLabel1.setText("Numero province:");

        spinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        bottoneCalcola.setText("jButton1");

        tabella.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabella);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(spinner)
                        .addGap(18, 18, 18)
                        .addComponent(bottoneCalcola, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCalcola))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCalcola;
    private javax.swing.JSpinner spinner;
    private javax.swing.JTable tabella;
    // End of variables declaration//GEN-END:variables

    public void aggiornaTabella() {
        List<DatiProvincia> datiProvince = (List<DatiProvincia>) Applicazione.getInstance().getModello().getBeans(Costanti.DATI_PROVINCE);
        ModelloTabellaDatiProvince modelloTabella = (ModelloTabellaDatiProvince) this.tabella.getModel();
        modelloTabella.setProvince(datiProvince);
        modelloTabella.aggiornaTabella();
    }
}
