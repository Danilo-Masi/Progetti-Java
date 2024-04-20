package it.unibas.banktransactions.vista;

import it.unibas.banktransactions.Applicazione;
import it.unibas.banktransactions.Costanti;
import it.unibas.banktransactions.modello.ContoCorrente;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        initComponents();
        this.tabellaContiCorrente.setModel(new ModelloTabellaContiCorrente());
        inizializzaAzioni();
    }

    private void inizializzaAzioni() {
        this.bottoneCerca.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCerca());
    }

    public boolean isDataCrescente() {
        return radioDataCrescente.isSelected();
    }

    public void aggiornaDati() {
        List<ContoCorrente> listaFiltrata = (List<ContoCorrente>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
        ModelloTabellaContiCorrente modelloTabellaContiCorrente = (ModelloTabellaContiCorrente) this.tabellaContiCorrente.getModel();
        modelloTabellaContiCorrente.setListaContiCorrente(listaFiltrata);
        modelloTabellaContiCorrente.aggiornaTabella();
    }
    
    public int getRigaSelezionata() {
        return this.tabellaContiCorrente.getSelectedRow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gruppoOrdinamento = new javax.swing.ButtonGroup();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        radioDataCrescente = new javax.swing.JRadioButton();
        radioNomeCrescente = new javax.swing.JRadioButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaContiCorrente = new javax.swing.JTable();
        bottoneCerca = new javax.swing.JButton();

        jLabel1.setText("Oridnamento:");

        gruppoOrdinamento.add(radioDataCrescente);
        radioDataCrescente.setSelected(true);
        radioDataCrescente.setText("Data crescente");
        radioDataCrescente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDataCrescenteActionPerformed(evt);
            }
        });

        gruppoOrdinamento.add(radioNomeCrescente);
        radioNomeCrescente.setText("Nome crescente");

        tabellaContiCorrente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaContiCorrente);

        bottoneCerca.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(bottoneCerca, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15)
                        .addComponent(radioDataCrescente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(radioNomeCrescente, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(radioDataCrescente)
                    .addComponent(radioNomeCrescente))
                .addGap(15, 15, 15)
                .addComponent(bottoneCerca)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void radioDataCrescenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDataCrescenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioDataCrescenteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCerca;
    private javax.swing.ButtonGroup gruppoOrdinamento;
    private javax.swing.JRadioButton radioDataCrescente;
    private javax.swing.JRadioButton radioNomeCrescente;
    private javax.swing.JTable tabellaContiCorrente;
    // End of variables declaration//GEN-END:variables
}
