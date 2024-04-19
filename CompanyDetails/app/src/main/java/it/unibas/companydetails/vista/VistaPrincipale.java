package it.unibas.companydetails.vista;

import it.unibas.companydetails.Applicazione;
import it.unibas.companydetails.Costanti;
import it.unibas.companydetails.modello.Azienda;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        initComponents();
        inizializzaAzioni();
        this.tabellaAziende.setModel(new ModelloTabellaAziende());
    }

    private void inizializzaAzioni() {
        this.bottoneCercaAziende.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCercaAziende());
        this.bottoneMostraDettagli.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneMostraDettagli());
    }

    public String getCittaSede() {
        return this.campoCittaSede.getText();
    }

    public int getRigaSelezionata() {
        return this.tabellaAziende.getSelectedRow();
    }

    public void aggiornaDati() {
        List<Azienda> listaFiltrata = (List<Azienda>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
        ModelloTabellaAziende modelloTabellaAziende = (ModelloTabellaAziende) this.tabellaAziende.getModel();
        modelloTabellaAziende.setListaAziende(listaFiltrata);
        modelloTabellaAziende.aggiornaTabella();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        campoCittaSede = new javax.swing.JTextField();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaAziende = new javax.swing.JTable();
        bottoneCercaAziende = new javax.swing.JButton();
        bottoneMostraDettagli = new javax.swing.JButton();

        jLabel1.setText("Nome citta della sede:");

        tabellaAziende.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaAziende);

        bottoneCercaAziende.setText("jButton1");

        bottoneMostraDettagli.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15)
                        .addComponent(campoCittaSede, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                    .addComponent(bottoneCercaAziende, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(146, 146, 146)
                                .addComponent(bottoneMostraDettagli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(1, 1, 1)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoCittaSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(bottoneCercaAziende)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(bottoneMostraDettagli)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCercaAziende;
    private javax.swing.JButton bottoneMostraDettagli;
    private javax.swing.JTextField campoCittaSede;
    private javax.swing.JTable tabellaAziende;
    // End of variables declaration//GEN-END:variables
}
