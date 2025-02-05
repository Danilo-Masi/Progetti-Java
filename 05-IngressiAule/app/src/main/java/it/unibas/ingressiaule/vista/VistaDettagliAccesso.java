package it.unibas.ingressiaule.vista;

import it.unibas.ingressiaule.Applicazione;
import it.unibas.ingressiaule.modello.Aula;
import it.unibas.ingressiaule.modello.Costanti;

public class VistaDettagliAccesso extends javax.swing.JDialog {

    public VistaDettagliAccesso(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }

    public void inizializza() {
        initComponents();
        inizializzaComponentiIniziali();
        inizializzaAzioni();
    }

    private void inizializzaComponentiIniziali() {
        this.comboMotivazione.removeAllItems();
        this.comboMotivazione.addItem("");
        this.comboMotivazione.addItem(Costanti.ESAME);
        this.comboMotivazione.addItem(Costanti.LEZIONE);
        this.comboMotivazione.addItem(Costanti.RICEVIMENTO);
        // Inizializza modello tabella
        this.tabellaAccessi.setModel(new ModelloTabellaAccessi());
    }

    private void inizializzaAzioni() {
        this.bottoneNuovoAccesso.setAction(Applicazione.getInstance().getControlloDettagliAccesso().getAzioneNuovoAccesso());
    }

    public void visualizza() {
        aggiornaComponenti();
        this.setLocationRelativeTo(getParent());
        this.setVisible(true);
    }

    public void aggiornaComponenti() {
        Aula aulaSelezionata = (Aula) Applicazione.getInstance().getModello().getBeans(Costanti.AULA_SELZIONATA);
        this.labelCodice.setText(aulaSelezionata.getCodice());
        this.labelNome.setText(aulaSelezionata.getNome());
        this.labelPiano.setText(aulaSelezionata.getPiano() + "");
        ModelloTabellaAccessi modelloTabellaAccessi = (ModelloTabellaAccessi) this.tabellaAccessi.getModel();
        modelloTabellaAccessi.setListaAccessi(aulaSelezionata.getListaAccessi());
        modelloTabellaAccessi.aggiornaContenuto();
        // Formatta i campi una volta eseguita l'azione
        this.campoNome.setText("");
        this.campoMatricola.setText("");
        this.spinnerDurata.setValue(1);
        this.campoAnno.setText("");
        this.campoMese.setText("");
        this.campoGiorno.setText("");
        this.campoOra.setText("");
        this.campoMinuti.setText("");
    }

    public String getValoreNome() {
        return this.campoNome.getText();
    }

    public String getValoreMatricola() {
        return this.campoMatricola.getText();
    }

    public int getValoreDurata() {
        return (int) this.spinnerDurata.getValue();
    }

    public String getValoreMotivazione() {
        return this.comboMotivazione.getSelectedItem().toString();
    }

    public String getValoreAnno() {
        return this.campoAnno.getText();
    }

    public String getValoreMese() {
        return this.campoMese.getText();
    }

    public String getValoreGiorno() {
        return this.campoGiorno.getText();
    }

    public String getValoreOra() {
        return this.campoOra.getText();
    }

    public String getValoreMinuti() {
        return this.campoMinuti.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        labelCodice = new javax.swing.JLabel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        labelPiano = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaAccessi = new javax.swing.JTable();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        campoMatricola = new javax.swing.JTextField();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        spinnerDurata = new javax.swing.JSpinner();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        comboMotivazione = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        campoGiorno = new javax.swing.JTextField();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel();
        campoMese = new javax.swing.JTextField();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
        campoAnno = new javax.swing.JTextField();
        javax.swing.JLabel jLabel10 = new javax.swing.JLabel();
        campoOra = new javax.swing.JTextField();
        javax.swing.JLabel jLabel11 = new javax.swing.JLabel();
        campoMinuti = new javax.swing.JTextField();
        bottoneNuovoAccesso = new javax.swing.JButton();
        javax.swing.JLabel jLabel12 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Cocide aula:");

        labelCodice.setText("jLabel1");

        jLabel1.setText("Nome aula:");

        labelNome.setText("jLabel3");

        jLabel3.setText("Piano:");

        labelPiano.setText("jLabel4");

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inserisci un nuovo accesso"));

        jLabel4.setText("Matricola:");

        jLabel5.setText("Durata:");

        spinnerDurata.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel6.setText("Motivazione:");

        comboMotivazione.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Giorno:");

        jLabel8.setText("Mese:");

        jLabel9.setText("Anno:");

        jLabel10.setText("Ora:");

        jLabel11.setText("Minuti");

        campoMinuti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoMinutiActionPerformed(evt);
            }
        });

        bottoneNuovoAccesso.setText("jButton1");

        jLabel12.setText("Nome:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(campoOra, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(campoMinuti, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                        .addGap(192, 192, 192)
                        .addComponent(bottoneNuovoAccesso, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(campoMatricola)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerDurata)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboMotivazione, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(campoNome)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoGiorno, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(campoMese, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoAnno, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoMatricola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(spinnerDurata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(comboMotivazione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(campoGiorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(campoMese, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(campoAnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bottoneNuovoAccesso)
                    .addComponent(campoOra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(campoMinuti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCodice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelPiano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelCodice)
                    .addComponent(jLabel1)
                    .addComponent(labelNome)
                    .addComponent(jLabel3)
                    .addComponent(labelPiano))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoMinutiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoMinutiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoMinutiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneNuovoAccesso;
    private javax.swing.JTextField campoAnno;
    private javax.swing.JTextField campoGiorno;
    private javax.swing.JTextField campoMatricola;
    private javax.swing.JTextField campoMese;
    private javax.swing.JTextField campoMinuti;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoOra;
    private javax.swing.JComboBox<String> comboMotivazione;
    private javax.swing.JLabel labelCodice;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelPiano;
    private javax.swing.JSpinner spinnerDurata;
    private javax.swing.JTable tabellaAccessi;
    // End of variables declaration//GEN-END:variables

}
