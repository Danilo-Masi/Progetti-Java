package it.unibas.ricettario.vista;

import it.unibas.ricettario.Applicazione;
import it.unibas.ricettario.modello.Costanti;
import it.unibas.ricettario.modello.Pietanza;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        initComponents();
        inizializzaComponenti();
        inizializzaAzioni();
        this.tabellaPietanze.setModel(new ModelloTabellaPietanze());
    }

    private void inizializzaComponenti() {
        this.comboCategoria.removeAllItems();
        this.comboCategoria.addItem("");
        this.comboCategoria.addItem(Costanti.ANTIPASTO);
        this.comboCategoria.addItem(Costanti.PRIMO);
        this.comboCategoria.addItem(Costanti.SECONDO);
        this.comboCategoria.addItem(Costanti.DESSERT);
    }

    private void inizializzaAzioni() {
        this.bottoneCercaCategoria.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCercaTipologia());
        this.bottoneCercaSimile.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCercaSimile());
    }

    public String getComboCategoria() {
        return this.comboCategoria.getSelectedItem().toString();
    }

    public void aggiornaTabella() {
        List<Pietanza> listaFiltrata = (List<Pietanza>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_FILTRATA);
        ModelloTabellaPietanze modelloTabellaPietanze = (ModelloTabellaPietanze) this.tabellaPietanze.getModel();
        modelloTabellaPietanze.setPietanze(listaFiltrata);
        modelloTabellaPietanze.aggiornaContenuto();
    }
    
    public int getRigaSelezionata() {
        return this.tabellaPietanze.getSelectedRow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        bottoneCercaCategoria = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaPietanze = new javax.swing.JTable();
        bottoneCercaSimile = new javax.swing.JButton();

        jLabel1.setText("Categoria:");

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bottoneCercaCategoria.setText("jButton1");

        tabellaPietanze.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaPietanze);

        bottoneCercaSimile.setText("jButton2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bottoneCercaSimile, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(bottoneCercaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCercaCategoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottoneCercaSimile)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCercaCategoria;
    private javax.swing.JButton bottoneCercaSimile;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JTable tabellaPietanze;
    // End of variables declaration//GEN-END:variables
}
