package it.unibas.mastermind.vista;

import it.unibas.mastermind.Applicazione;
import it.unibas.mastermind.modello.Costanti;
import it.unibas.mastermind.modello.Partita;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        initComponents();
        inizializzaAzioni();
        this.tabellaRisposte.setModel(new ModelloTabellaRisposte());
    }

    private void inizializzaAzioni() {
        this.bottoneTentativo.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneTentativo());
    }

    public Integer getCifra1() {
        return (Integer) this.cifra1.getValue();
    }

    public Integer getCifra2() {
        return (Integer) this.cifra2.getValue();
    }

    public Integer getCifra3() {
        return (Integer) this.cifra3.getValue();
    }

    public Integer getCifra4() {
        return (Integer) this.cifra4.getValue();
    }

    public void aggiornaDati() {
        ModelloTabellaRisposte modelloTabellaRisposte = (ModelloTabellaRisposte) this.tabellaRisposte.getModel();
        Partita partita = (Partita) Applicazione.getInstance().getModello().getBeans(Costanti.PARTITA);
        modelloTabellaRisposte.setListaRisposte(partita.getListaRisposte());
        modelloTabellaRisposte.aggiornaContenuto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        cifra1 = new javax.swing.JSpinner();
        cifra2 = new javax.swing.JSpinner();
        cifra3 = new javax.swing.JSpinner();
        cifra4 = new javax.swing.JSpinner();
        bottoneTentativo = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaRisposte = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tentativo"));

        cifra1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 6, 1));

        cifra2.setModel(new javax.swing.SpinnerNumberModel(1, 1, 6, 1));

        cifra3.setModel(new javax.swing.SpinnerNumberModel(1, 1, 6, 1));

        cifra4.setModel(new javax.swing.SpinnerNumberModel(1, 1, 6, 1));

        bottoneTentativo.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cifra1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cifra2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cifra3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cifra4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottoneTentativo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cifra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cifra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cifra3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cifra4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneTentativo))
                .addGap(20, 20, 20))
        );

        tabellaRisposte.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaRisposte);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneTentativo;
    private javax.swing.JSpinner cifra1;
    private javax.swing.JSpinner cifra2;
    private javax.swing.JSpinner cifra3;
    private javax.swing.JSpinner cifra4;
    private javax.swing.JTable tabellaRisposte;
    // End of variables declaration//GEN-END:variables
}
