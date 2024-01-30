package it.unibas.sistemiistituti.vista;

import it.unibas.sistemiistituti.Applicazione;
import it.unibas.sistemiistituti.Costanti;
import it.unibas.sistemiistituti.modello.Istituto;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        initComponents();
        inizializzaComponenti();
        inizializzaAzioni();
    }

    private void inizializzaComponenti() {
        this.comboGrado.removeAllItems();
        this.comboGrado.addItem("");
        this.comboGrado.addItem(Costanti.ELEMENTARI);
        this.comboGrado.addItem(Costanti.MEDIE);
        this.comboGrado.addItem(Costanti.SUPERIORI);
        this.tabellaIstituti.setModel(new ModelloTabellaIstituti());
    }

    private void inizializzaAzioni() {
        this.bottoneCerca.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCerca());
        this.bottoneNuovoPannello.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneNuovoPannello());
    }

    public boolean isOrdinamentoCrescente() {
        return this.radioCrescente.isSelected();
    }

    public boolean isOrdinamentoDecrescente() {
        return this.radioDecrescente.isSelected();
    }

    public String getGradoSelezionato() {
        return this.comboGrado.getSelectedItem().toString();
    }

    public int getRigaSelezionata() {
        return this.tabellaIstituti.getSelectedRow();
    }

    public void aggiornaDati() {
        List<Istituto> listaFiltrata = (List<Istituto>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
        ModelloTabellaIstituti modelloTabellaIstituti = (ModelloTabellaIstituti) this.tabellaIstituti.getModel();
        modelloTabellaIstituti.setIstituti(listaFiltrata);
        modelloTabellaIstituti.aggiornaTabella();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        comboGrado = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        radioCrescente = new javax.swing.JRadioButton();
        radioDecrescente = new javax.swing.JRadioButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaIstituti = new javax.swing.JTable();
        bottoneCerca = new javax.swing.JButton();
        bottoneNuovoPannello = new javax.swing.JButton();

        jLabel1.setText("Grado:");

        comboGrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Oridiamento:");

        buttonGroup1.add(radioCrescente);
        radioCrescente.setSelected(true);
        radioCrescente.setText("n. classi crescente");

        buttonGroup1.add(radioDecrescente);
        radioDecrescente.setText("n. classi decrescente");

        tabellaIstituti.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaIstituti);

        bottoneCerca.setText("jButton1");

        bottoneNuovoPannello.setText("jButton2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bottoneNuovoPannello, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCerca, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(comboGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioCrescente)
                        .addGap(18, 18, 18)
                        .addComponent(radioDecrescente))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(radioCrescente)
                    .addComponent(radioDecrescente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottoneCerca)
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottoneNuovoPannello)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCerca;
    private javax.swing.JButton bottoneNuovoPannello;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comboGrado;
    private javax.swing.JRadioButton radioCrescente;
    private javax.swing.JRadioButton radioDecrescente;
    private javax.swing.JTable tabellaIstituti;
    // End of variables declaration//GEN-END:variables
}
