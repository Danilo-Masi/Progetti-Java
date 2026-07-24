package it.unibas.anagrafica.vista;

import it.unibas.anagrafica.Applicazione;
import it.unibas.anagrafica.modello.Azienda;
import it.unibas.anagrafica.modello.Costanti;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        initComponents();
        inizializzaAzioni();
        this.tabellaAziende.setModel(new ModelloTabellaAziende());
    }

    public String getCitta() {
        return this.campoCitta.getText();
    }

    public int getRigaSelezionata() {
        return this.tabellaAziende.getSelectedRow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        campoCitta = new javax.swing.JTextField();
        bottoneCerca = new javax.swing.JButton();
        javax.swing.JScrollPane ScroolPane = new javax.swing.JScrollPane();
        tabellaAziende = new javax.swing.JTable();
        bottoneSeleziona = new javax.swing.JButton();

        jLabel1.setText("Città:");

        bottoneCerca.setText("jButton1");

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
        ScroolPane.setViewportView(tabellaAziende);

        bottoneSeleziona.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ScroolPane, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(10, 10, 10)
                            .addComponent(campoCitta)
                            .addGap(30, 30, 30)
                            .addComponent(bottoneCerca, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(bottoneSeleziona, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoCitta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCerca))
                .addGap(30, 30, 30)
                .addComponent(ScroolPane, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(bottoneSeleziona)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCerca;
    private javax.swing.JButton bottoneSeleziona;
    private javax.swing.JTextField campoCitta;
    private javax.swing.JTable tabellaAziende;
    // End of variables declaration//GEN-END:variables

    private void inizializzaAzioni() {
        this.campoCitta.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCercaPerCitta());
        this.bottoneCerca.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCercaPerCitta());
        this.bottoneSeleziona.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneSeleziona());
    }

    public void aggiornaTabella() {
        ModelloTabellaAziende modelloTabellaAziende = (ModelloTabellaAziende) this.tabellaAziende.getModel();
        modelloTabellaAziende.setListaAziende((List<Azienda>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_FILTRATA));
        modelloTabellaAziende.aggiornaContenuto();

    }
}
