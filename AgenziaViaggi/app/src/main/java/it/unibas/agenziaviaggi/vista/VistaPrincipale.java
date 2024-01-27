package it.unibas.agenziaviaggi.vista;

import it.unibas.agenziaviaggi.Applicazione;
import it.unibas.agenziaviaggi.Costanti;
import it.unibas.agenziaviaggi.modello.Agenzia;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {
    
    public void inizializza() {
        initComponents();
        inizializzaAzioni();
        this.tabellaAgenzie.setModel(new ModelloTabellaAgenzie());
    }
    
    private void inizializzaAzioni() {
        this.bottoneCerca.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCercaAgenzie());
        this.bottoneAggiungiPacchetto.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneAggiungiPacchetto());
    }
    
    public String getValoreCitta() {
        return this.campoCitta.getText();
    }
    
    public boolean isOrdinamentoCrescente() {
        return this.radioNomeCrescente.isSelected();
    }
    
    public boolean idOrindamentoDescrescente() {
        return this.radioNomeDescrescente.isSelected();
    }
    
    public int getRigaSelezionata() {
        return this.tabellaAgenzie.getSelectedRow();
    }
    
    public void aggiornaDati() {
        List<Agenzia> listaFiltrata = (List<Agenzia>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
        ModelloTabellaAgenzie modelloTabellaAgenzie = (ModelloTabellaAgenzie) this.tabellaAgenzie.getModel();
        modelloTabellaAgenzie.setAgenzie(listaFiltrata);
        modelloTabellaAgenzie.aggiornaTabella();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.ButtonGroup radioGroup = new javax.swing.ButtonGroup();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        campoCitta = new javax.swing.JTextField();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        radioNomeCrescente = new javax.swing.JRadioButton();
        radioNomeDescrescente = new javax.swing.JRadioButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaAgenzie = new javax.swing.JTable();
        bottoneCerca = new javax.swing.JButton();
        bottoneAggiungiPacchetto = new javax.swing.JButton();

        jLabel1.setText("Città:");

        jLabel2.setText("Ordinamento:");

        radioGroup.add(radioNomeCrescente);
        radioNomeCrescente.setSelected(true);
        radioNomeCrescente.setText("nome crescente");

        radioGroup.add(radioNomeDescrescente);
        radioNomeDescrescente.setText("nome decrescente");

        tabellaAgenzie.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaAgenzie);

        bottoneCerca.setText("jButton1");

        bottoneAggiungiPacchetto.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoCitta, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(radioNomeCrescente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(radioNomeDescrescente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bottoneCerca, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bottoneAggiungiPacchetto, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoCitta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(radioNomeCrescente)
                    .addComponent(radioNomeDescrescente))
                .addGap(20, 20, 20)
                .addComponent(bottoneCerca)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(bottoneAggiungiPacchetto)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneAggiungiPacchetto;
    private javax.swing.JButton bottoneCerca;
    private javax.swing.JTextField campoCitta;
    private javax.swing.JRadioButton radioNomeCrescente;
    private javax.swing.JRadioButton radioNomeDescrescente;
    private javax.swing.JTable tabellaAgenzie;
    // End of variables declaration//GEN-END:variables
}
