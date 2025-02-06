package it.unibas.compravenditeauto.vista;

import it.unibas.compravenditeauto.Applicazione;
import it.unibas.compravenditeauto.modello.Auto;
import it.unibas.compravenditeauto.modello.Costanti;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        initComponents();
        this.tabellaAuto.setModel(new ModelloTabellaAuto());
        inizializzaAzioni();
    }

    private void inizializzaAzioni() {
        this.bottoneCerca.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCercaAuto());
        this.bottoneNuovaOperazione.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneInserisciOperazione());
    }

    public String getValoreAnno() {
        return this.campoAnno.getText();
    }

    public String getValoreMese() {
        return this.campoMese.getText();
    }

    public String getValoreGiorno() {
        return this.campoGiorno.getText();
    }

    public boolean isOrdinamentoCrescente() {
        return this.radioCrescente.isSelected();
    }

    public int getRigaSelezionata() {
        return this.tabellaAuto.getSelectedRow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gruppoOrdinamento = new javax.swing.ButtonGroup();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        campoAnno = new javax.swing.JTextField();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        campoMese = new javax.swing.JTextField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        campoGiorno = new javax.swing.JTextField();
        radioCrescente = new javax.swing.JRadioButton();
        radioDescrescente = new javax.swing.JRadioButton();
        bottoneCerca = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaAuto = new javax.swing.JTable();
        bottoneNuovaOperazione = new javax.swing.JButton();

        jLabel1.setText("Anno:");

        campoAnno.setToolTipText("");

        jLabel2.setText("Mese:");

        jLabel3.setText("Giorno");

        campoGiorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoGiornoActionPerformed(evt);
            }
        });

        gruppoOrdinamento.add(radioCrescente);
        radioCrescente.setSelected(true);
        radioCrescente.setText("Nome crescente");
        radioCrescente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCrescenteActionPerformed(evt);
            }
        });

        gruppoOrdinamento.add(radioDescrescente);
        radioDescrescente.setText("Nome decrescente");

        bottoneCerca.setText("jButton1");

        tabellaAuto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaAuto);

        bottoneNuovaOperazione.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bottoneNuovaOperazione, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoAnno)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(campoMese)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(radioCrescente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(radioDescrescente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(166, 166, 166)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bottoneCerca, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                    .addComponent(campoGiorno))))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoAnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(campoMese, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(campoGiorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioCrescente)
                    .addComponent(radioDescrescente)
                    .addComponent(bottoneCerca))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(bottoneNuovaOperazione)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campoGiornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoGiornoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoGiornoActionPerformed

    private void radioCrescenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCrescenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioCrescenteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCerca;
    private javax.swing.JButton bottoneNuovaOperazione;
    private javax.swing.JTextField campoAnno;
    private javax.swing.JTextField campoGiorno;
    private javax.swing.JTextField campoMese;
    private javax.swing.ButtonGroup gruppoOrdinamento;
    private javax.swing.JRadioButton radioCrescente;
    private javax.swing.JRadioButton radioDescrescente;
    private javax.swing.JTable tabellaAuto;
    // End of variables declaration//GEN-END:variables

    public void aggiornaTabella() {
        ModelloTabellaAuto modelloTabellaAuto = (ModelloTabellaAuto) this.tabellaAuto.getModel();
        modelloTabellaAuto.setListaAuto((List<Auto>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA));
        modelloTabellaAuto.aggiornaContenuto();
    }
}
