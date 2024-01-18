package it.unibas.ricettario.vista;

import it.unibas.ricettario.Applicazione;
import it.unibas.ricettario.modello.Costanti;
import it.unibas.ricettario.modello.Pietanza;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        initComponents();
        //Richiama il metodo per inizializzare i componenti
        inizializzaComponenti();
        //Richiama il metodo per inizializzare le azioni
        inizializzaAzioni();
        //Setta il modello della tabella con la tabella creata
        this.tabellaPietanze.setModel(new ModelloTabellaPietanze());
    }

    //Popola la comboBox
    private void inizializzaComponenti() {
        this.comboCategoria.removeAllItems();
        this.comboCategoria.addItem("");
        this.comboCategoria.addItem(Costanti.ANTIPASTO);
        this.comboCategoria.addItem(Costanti.PRIMO);
        this.comboCategoria.addItem(Costanti.SECONDO);
        this.comboCategoria.addItem(Costanti.DESSERT);
    }

    //Inizializza le azioni
    private void inizializzaAzioni() {
        this.bottoneCercaCategorie.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCerca());
        this.bottoneCercaSimile.setAction(Applicazione.getInstance().getControlloPrincipale().getAzoneCercaPietanzaSimile());
    }

    //Metodo per recuperare il valore selezionato nella comboBox
    public String getComboCategoria() {
        return this.comboCategoria.getSelectedItem().toString();
    }

    //Metodo per recuperare l'indice della tabella selezionato
    public int getRigaSelezionata() {
        return this.tabellaPietanze.getSelectedRow();
    }

    //Metodo per forzare l'aggiornamento della tabella
    public void aggiornaTabella() {
        //Carico la lista delle pietanze
        List<Pietanza> listaPietanze = (List<Pietanza>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
        //Prende il modello della tabella
        ModelloTabellaPietanze modelloTabella = (ModelloTabellaPietanze) this.tabellaPietanze.getModel();
        //Carica la lista nel modello della tabella
        modelloTabella.setPietanze(listaPietanze);
        //Forza l'aggiornamento del contenuto della tabella
        modelloTabella.aggiornaContenuto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        comboCategoria = new javax.swing.JComboBox<>();
        bottoneCercaCategorie = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaPietanze = new javax.swing.JTable();
        bottoneCercaSimile = new javax.swing.JButton();

        jLabel1.setText("Categoria:");

        comboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bottoneCercaCategorie.setText("jButton1");

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

        bottoneCercaSimile.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(bottoneCercaCategorie, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)))
                    .addComponent(bottoneCercaSimile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCercaCategorie))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottoneCercaSimile)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCercaCategorie;
    private javax.swing.JButton bottoneCercaSimile;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabellaPietanze;
    // End of variables declaration//GEN-END:variables

}
