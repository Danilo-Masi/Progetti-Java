package it.unibas.ingressiaule.vista;

import it.unibas.ingressiaule.Applicazione;
import it.unibas.ingressiaule.Costanti;
import it.unibas.ingressiaule.modello.Aula;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {
    
    public void inizializza() {
        initComponents();
        inizializzaAzioni();
        this.tabellaAule.setModel(new ModelloTabellaAule());
    }
    
    private void inizializzaAzioni() {
        this.bottoneRicerca.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneRicerca());
        this.bottoneNuovoAccesso.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneDettagliAula());
    }
    
    public Integer getCampoPiano() {
        return (Integer) this.campoPiano.getValue();
    }
    
    public int getRigaSelezionata() {
        return this.tabellaAule.getSelectedRow();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        bottoneRicerca = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaAule = new javax.swing.JTable();
        campoPiano = new javax.swing.JSpinner();
        bottoneNuovoAccesso = new javax.swing.JButton();

        jLabel1.setText("Piano:");

        bottoneRicerca.setText("jButton1");

        tabellaAule.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaAule);

        campoPiano.setModel(new javax.swing.SpinnerNumberModel());

        bottoneNuovoAccesso.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bottoneNuovoAccesso))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(campoPiano)
                                .addGap(18, 18, 18)
                                .addComponent(bottoneRicerca))
                            .addComponent(jScrollPane1))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(bottoneRicerca)
                    .addComponent(campoPiano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(bottoneNuovoAccesso)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneNuovoAccesso;
    private javax.swing.JButton bottoneRicerca;
    private javax.swing.JSpinner campoPiano;
    private javax.swing.JTable tabellaAule;
    // End of variables declaration//GEN-END:variables

    public void aggiornaTabella() {
        List<Aula> listaFiltrata = (List<Aula>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
        ModelloTabellaAule modelloTabellaAule = (ModelloTabellaAule) this.tabellaAule.getModel();
        modelloTabellaAule.setListaAule(listaFiltrata);
        modelloTabellaAule.aggiornaTabella();
    }
}
