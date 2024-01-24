package it.unibas.ingressiaule.vista;

import it.unibas.ingressiaule.Applicazione;
import it.unibas.ingressiaule.Costanti;
import it.unibas.ingressiaule.modello.Aula;

public class VistaDettagliAula extends javax.swing.JDialog {

    public VistaDettagliAula(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }

    public void inizializza() {
        initComponents();
        inizializzaComponenti();
        this.tabellaAccessi.setModel(new ModelloTabellaAccessi());
        inizializzaAzioni();
    }

    private void inizializzaComponenti() {
        this.comboMotivazione.removeAllItems();
        this.comboMotivazione.addItem("");
        this.comboMotivazione.addItem(Costanti.LEZIONE);
        this.comboMotivazione.addItem(Costanti.ESAME);
        this.comboMotivazione.addItem(Costanti.RICEVIMENTO);
    }

    private void inizializzaAzioni() {
        this.bottoneAggiungi.setAction(Applicazione.getInstance().getControlloDettagliAula().getAzioneAggiungiAccesso());
    }

    public void visualizza() {
        this.aggiornaDati();
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
    }

    public void aggiornaDati() {
        Aula aulaSelezionata = (Aula) Applicazione.getInstance().getModello().getBeans(Costanti.AULA_SELEZIONATA);
        this.labelCodice.setText(aulaSelezionata.getCodice());
        this.labelNome.setText(aulaSelezionata.getNomeAula());
        this.labelPiano.setText(aulaSelezionata.getPiano() + "");
        ModelloTabellaAccessi modelloTabella = (ModelloTabellaAccessi) this.tabellaAccessi.getModel();
        modelloTabella.setListaAccessi(aulaSelezionata.getListaAccessi());
        modelloTabella.aggiornaTabella();
    }

    public String getMatricola() {
        return this.campoMatricola.getText();
    }

    public String getNomeStudente() {
        return this.campoNome.getText();
    }

    public String getMotivazione() {
        return this.comboMotivazione.getSelectedItem().toString();
    }

    public String getPermanenza() {
        return this.campoPermanenza.getText();
    }

    public String getAnno() {
        return this.campoAnno.getText();
    }

    public String getMese() {
        return this.campoMese.getText();
    }

    public String getGiorno() {
        return this.campoGiorno.getText();
    }

    public String getOra() {
        return this.campoOra.getText();
    }

    public String getMinuti() {
        return this.campoMinuti.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        labelCodice = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        labelPiano = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaAccessi = new javax.swing.JTable();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        campoMatricola = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        comboMotivazione = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        campoPermanenza = new javax.swing.JTextField();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        campoGiorno = new javax.swing.JTextField();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
        campoMese = new javax.swing.JTextField();
        javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
        campoAnno = new javax.swing.JTextField();
        javax.swing.JLabel jLabel11 = new javax.swing.JLabel();
        campoOra = new javax.swing.JTextField();
        javax.swing.JLabel jLabel12 = new javax.swing.JLabel();
        campoMinuti = new javax.swing.JTextField();
        bottoneAggiungi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Codice:");

        labelCodice.setText("jLabel2");

        jLabel3.setText("Nome:");

        labelNome.setText("jLabel4");

        jLabel5.setText("Piano:");

        labelPiano.setText("jLabel6");

        tabellaAccessi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaAccessi);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuovo accesso"));

        jLabel2.setText("Matricola:");

        jLabel4.setText("Nome:");

        jLabel6.setText("MOtivazione:");

        comboMotivazione.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Permanenza:");

        jLabel8.setText("Giorno:");

        jLabel9.setText("Mese:");

        jLabel10.setText("Anno:");

        jLabel11.setText("Ora:");

        jLabel12.setText("Minuti:");

        bottoneAggiungi.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(campoMatricola))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(comboMotivazione, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNome)
                            .addComponent(campoPermanenza)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoGiorno))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(campoOra)
                                .addGap(38, 38, 38)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoMinuti)
                                .addGap(18, 18, 18)
                                .addComponent(bottoneAggiungi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoMese)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(campoAnno)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoMatricola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboMotivazione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(campoPermanenza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(campoGiorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(campoMese, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(campoAnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(campoOra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(campoMinuti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneAggiungi))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(labelCodice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(labelPiano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelCodice)
                    .addComponent(jLabel3)
                    .addComponent(labelNome)
                    .addComponent(jLabel5)
                    .addComponent(labelPiano))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneAggiungi;
    private javax.swing.JTextField campoAnno;
    private javax.swing.JTextField campoGiorno;
    private javax.swing.JTextField campoMatricola;
    private javax.swing.JTextField campoMese;
    private javax.swing.JTextField campoMinuti;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoOra;
    private javax.swing.JTextField campoPermanenza;
    private javax.swing.JComboBox<String> comboMotivazione;
    private javax.swing.JLabel labelCodice;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelPiano;
    private javax.swing.JTable tabellaAccessi;
    // End of variables declaration//GEN-END:variables

}
