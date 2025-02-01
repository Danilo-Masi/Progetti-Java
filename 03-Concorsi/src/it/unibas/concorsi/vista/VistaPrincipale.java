package it.unibas.concorsi.vista;

import it.unibas.concorsi.Applicazione;
import it.unibas.concorsi.modello.Concorso;
import it.unibas.concorsi.modello.Costanti;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        initComponents();
        this.tabellaConcorsi.setModel(new ModelloTabellaConcorsi());
        inizializzaAzioni();
    }

    private void inizializzaAzioni() {
        this.bottoneCerca.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCerca());
        this.bottoneSeleziona.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneSelezionaConcorso());
    }

    public String getCampoRegione() {
        return this.campoRegione.getText();
    }

    public boolean isOrdinamentoData() {
        return this.radioOrdinamentoData.isSelected();
    }

    public boolean isOrdinamentoPosti() {
        return this.radioOrdinamentoPosti.isSelected();
    }

    public int getRigaSelezionata() {
        return this.tabellaConcorsi.getSelectedRow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.ButtonGroup gruppoOrdinamento = new javax.swing.ButtonGroup();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        campoRegione = new javax.swing.JTextField();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        radioOrdinamentoData = new javax.swing.JRadioButton();
        radioOrdinamentoPosti = new javax.swing.JRadioButton();
        bottoneCerca = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaConcorsi = new javax.swing.JTable();
        bottoneSeleziona = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ricerca per regione"));

        jLabel1.setText("Regione:");

        jLabel2.setText("Ordinamento:");

        gruppoOrdinamento.add(radioOrdinamentoData);
        radioOrdinamentoData.setSelected(true);
        radioOrdinamentoData.setText("Data crescente");

        gruppoOrdinamento.add(radioOrdinamentoPosti);
        radioOrdinamentoPosti.setText("Num. posti decrescente");

        bottoneCerca.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoRegione)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radioOrdinamentoData)
                        .addGap(18, 18, 18)
                        .addComponent(radioOrdinamentoPosti)
                        .addGap(18, 18, 18)
                        .addComponent(bottoneCerca, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoRegione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(radioOrdinamentoData)
                    .addComponent(radioOrdinamentoPosti)
                    .addComponent(bottoneCerca))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        tabellaConcorsi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaConcorsi);

        bottoneSeleziona.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bottoneSeleziona, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(bottoneSeleziona)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCerca;
    private javax.swing.JButton bottoneSeleziona;
    private javax.swing.JTextField campoRegione;
    private javax.swing.JRadioButton radioOrdinamentoData;
    private javax.swing.JRadioButton radioOrdinamentoPosti;
    private javax.swing.JTable tabellaConcorsi;
    // End of variables declaration//GEN-END:variables

    public void aggiornaTabella() {
        ModelloTabellaConcorsi modelloTabellaConcorsi = (ModelloTabellaConcorsi) this.tabellaConcorsi.getModel();
        modelloTabellaConcorsi.setListaConcorsi((List<Concorso>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA));
        modelloTabellaConcorsi.aggiornaContenuto();
    }
}
