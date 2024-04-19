package it.unibas.companydetails.vista;

import it.unibas.companydetails.Applicazione;
import it.unibas.companydetails.Costanti;
import it.unibas.companydetails.modello.Archivio;
import it.unibas.companydetails.modello.Azienda;
import it.unibas.companydetails.modello.Dipendente;
import java.util.List;

public class VistaDettagliAzienda extends javax.swing.JDialog {

    public VistaDettagliAzienda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }

    public void inizializza() {
        initComponents();
        this.tabellaDipendenti.setModel(new ModelloTabellaDipendenti());
        inizializzaAzioni();
    }

    private void inizializzaAzioni() {
        this.bottoneAggiungiDipendente.setAction(Applicazione.getInstance().getControlloDettagliAzienda().getAzioneAggiungiDipendente());
    }

    public void visualizza() {
        this.aggiornaDati();
        this.setLocationRelativeTo(getParent());
        this.setVisible(true);
    }

    public void aggiornaDati() {
        Azienda aziendaSelezionata = (Azienda) Applicazione.getInstance().getModello().getBeans(Costanti.AZIENDA_SELEZIONATA);
        this.labelCittaSede.setText(aziendaSelezionata.getCittaSede());
        this.labelDenominazione.setText(aziendaSelezionata.getDenominazione());
        long pIva = aziendaSelezionata.getPartitaIva();
        String pIvaString = Long.toString(pIva);
        this.labelPartitaIva.setText(pIvaString);
        aggiornaTabella();
        verificaDuplicati();
    }

    private void aggiornaTabella() {
        Azienda aziendaSelezionata = (Azienda) Applicazione.getInstance().getModello().getBeans(Costanti.AZIENDA_SELEZIONATA);
        ModelloTabellaDipendenti modelloTabellaDipendenti = (ModelloTabellaDipendenti) this.tabellaDipendenti.getModel();
        modelloTabellaDipendenti.setListaDipendenti(aziendaSelezionata.getListaDipendenti());
        modelloTabellaDipendenti.aggiornaTabella();
    }

    private void verificaDuplicati() {
        Azienda aziendaSelezionata = (Azienda) Applicazione.getInstance().getModello().getBeans(Costanti.AZIENDA_SELEZIONATA);
        List<Dipendente> listaDipendentiAzienda = aziendaSelezionata.getListaDipendenti();
        Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeans(Costanti.ARCHIVIO);
        boolean verifica = archivio.cercaDipendentiDuplicati(listaDipendentiAzienda);
        if (verifica) {
            Applicazione.getInstance().getFrame().mostraMessaggio("Attenzione nell'azienda ci sono dipendenti duplicati registrati");
        }
    }

    public String getCodiceFiscale() {
        return this.campoCodiceFiscale.getText();
    }

    public String getNome() {
        return this.campoNome.getText();
    }

    public String getCognome() {
        return this.campoCognome.getText();
    }

    public String getResidenza() {
        return this.campoResidebza.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        labelPartitaIva = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        labelDenominazione = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        labelCittaSede = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaDipendenti = new javax.swing.JTable();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        campoCodiceFiscale = new javax.swing.JTextField();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        campoCognome = new javax.swing.JTextField();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        campoResidebza = new javax.swing.JTextField();
        bottoneAggiungiDipendente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detttagli azienda"));

        jLabel1.setText("P.IVA:");

        labelPartitaIva.setText("jLabel2");

        jLabel2.setText("Denominazione:");

        labelDenominazione.setText("jLabel3");

        jLabel3.setText("Città della sede:");

        labelCittaSede.setText("jLabel4");

        tabellaDipendenti.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaDipendenti);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(15, 15, 15)
                            .addComponent(labelPartitaIva, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(jLabel2)
                            .addGap(15, 15, 15)
                            .addComponent(labelDenominazione, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(15, 15, 15)
                            .addComponent(labelCittaSede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelPartitaIva)
                    .addComponent(jLabel2)
                    .addComponent(labelDenominazione))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelCittaSede))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuovo dipendente"));

        jLabel4.setText("Codice fiscale:");

        jLabel5.setText("Nome:");

        jLabel6.setText("Cognome:");

        jLabel7.setText("Residenza:");

        bottoneAggiungiDipendente.setText("jButton1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoCodiceFiscale)
                            .addComponent(campoCognome)))
                    .addComponent(bottoneAggiungiDipendente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoNome)
                    .addComponent(campoResidebza))
                .addGap(23, 23, 23))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoCodiceFiscale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(campoCognome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(campoResidebza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(bottoneAggiungiDipendente)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneAggiungiDipendente;
    private javax.swing.JTextField campoCodiceFiscale;
    private javax.swing.JTextField campoCognome;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoResidebza;
    private javax.swing.JLabel labelCittaSede;
    private javax.swing.JLabel labelDenominazione;
    private javax.swing.JLabel labelPartitaIva;
    private javax.swing.JTable tabellaDipendenti;
    // End of variables declaration//GEN-END:variables
}
