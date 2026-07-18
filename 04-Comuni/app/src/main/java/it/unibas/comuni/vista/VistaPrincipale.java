package it.unibas.comuni.vista;

import it.unibas.comuni.Applicazione;
import it.unibas.comuni.modello.Costanti;
import it.unibas.comuni.modello.DatiProvincia;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        initComponents();
        inizializzaAzioni();
        this.tabellaDatiProvince.setModel(new ModelloTabellaDatiProvince());
    }

    private void inizializzaAzioni() {
        this.bottoneCalcola.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCalcolaProvince());
    }

    public Integer getNumeroProvince() {
        return (Integer) this.spinnerProvince.getValue();
    }

    public void aggiornaTabella() {
        ModelloTabellaDatiProvince modelloTabellaDatiProvince = (ModelloTabellaDatiProvince) this.tabellaDatiProvince.getModel();
        modelloTabellaDatiProvince.setListaDatiProvince((List<DatiProvincia>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_FILTRATA));
        modelloTabellaDatiProvince.aggiornaContenuto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        spinnerProvince = new javax.swing.JSpinner();
        bottoneCalcola = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaDatiProvince = new javax.swing.JTable();

        jLabel1.setText("Numero province:");

        spinnerProvince.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        bottoneCalcola.setText("jButton1");

        tabellaDatiProvince.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaDatiProvince);

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
                        .addGap(10, 10, 10)
                        .addComponent(spinnerProvince)
                        .addGap(20, 20, 20)
                        .addComponent(bottoneCalcola, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spinnerProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCalcola))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCalcola;
    private javax.swing.JSpinner spinnerProvince;
    private javax.swing.JTable tabellaDatiProvince;
    // End of variables declaration//GEN-END:variables

}
