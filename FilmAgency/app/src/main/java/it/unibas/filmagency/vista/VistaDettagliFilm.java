package it.unibas.filmagency.vista;

import it.unibas.filmagency.Applicazione;
import it.unibas.filmagency.Costanti;
import it.unibas.filmagency.modello.Archivio;
import it.unibas.filmagency.modello.DatiFilm;
import it.unibas.filmagency.modello.Film;
import java.text.DateFormat;
import java.util.List;

public class VistaDettagliFilm extends javax.swing.JDialog {
    
    public VistaDettagliFilm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }
    
    public void inizializza() {
        initComponents();
        this.tabellaAttori.setModel(new ModelloTabellaAttori());
        inizializzaAzioni();
    }
    
    private void inizializzaAzioni() {
        this.bottoneAggiungiiAttore.setAction(Applicazione.getInstance().getControlloDettagliFilm().getAzioneAggiungiAttore());
    }
    
    public void visualizza() {
        aggiornaDati();
        this.setLocationRelativeTo(getParent());
        this.setVisible(true);
    }
    
    public void aggiornaDati() {
        Film filmSelezionato = (Film) Applicazione.getInstance().getModello().getBeand(Costanti.FILM_SELEZIONATO);
        this.labelNome.setText(filmSelezionato.getNomeFilm());
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
        this.labelDataUscita.setText(df.format(filmSelezionato.getDataUscita().getTime()));
        this.labelRegista.setText(filmSelezionato.getRegista());
        this.labelGenere.setText(filmSelezionato.getGenere());
        aggiornaTabella();
    }
    
    private void aggiornaTabella() {
        Film filmSelezionato = (Film) Applicazione.getInstance().getModello().getBeand(Costanti.FILM_SELEZIONATO);
        Archivio archivio = (Archivio) Applicazione.getInstance().getModello().getBeand(Costanti.ARCHIVIO);
        List<DatiFilm> listaDatiFilm = archivio.calcolaAttoriPerNazionalità(filmSelezionato.getListaAttori());
        ModelloTabellaAttori modelloTabellaAttori = (ModelloTabellaAttori) this.tabellaAttori.getModel();
        modelloTabellaAttori.setListaDatiFilm(listaDatiFilm);
        modelloTabellaAttori.aggiornaTabella();
    }
    
    public String getNomeCognome() {
        return this.campoNomeCognome.getText();
    }
    
    public String getNazionalita() {
        return this.campoNazionalita.getText();
    }
    
    public int getAnnoNascita() {
        return (int) this.spinnerAnnoNascita.getValue();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        labelDataUscita = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        labelRegista = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        labelGenere = new javax.swing.JLabel();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaAttori = new javax.swing.JTable();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        campoNomeCognome = new javax.swing.JTextField();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        campoNazionalita = new javax.swing.JTextField();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        spinnerAnnoNascita = new javax.swing.JSpinner();
        bottoneAggiungiiAttore = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome :");

        labelNome.setText("jLabel2");

        jLabel2.setText("Data uscita:");

        labelDataUscita.setText("jLabel3");

        jLabel3.setText("Regista:");

        labelRegista.setText("jLabel4");

        jLabel4.setText("Genere:");

        labelGenere.setText("jLabel5");

        tabellaAttori.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaAttori);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuovo attore"));

        jLabel5.setText("Nome e cognome:");

        jLabel6.setText("Nazionalità:");

        jLabel7.setText("Anno di nascita:");

        spinnerAnnoNascita.setModel(new javax.swing.SpinnerNumberModel(1920, 1920, 2024, 1));

        bottoneAggiungiiAttore.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNomeCognome)
                            .addComponent(campoNazionalita)
                            .addComponent(spinnerAnnoNascita)))
                    .addComponent(bottoneAggiungiiAttore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoNomeCognome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(campoNazionalita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(spinnerAnnoNascita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(bottoneAggiungiiAttore)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(10, 10, 10)
                                .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(10, 10, 10)
                                .addComponent(labelRegista, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDataUscita, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelGenere)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelNome)
                    .addComponent(jLabel2)
                    .addComponent(labelDataUscita))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelRegista)
                    .addComponent(jLabel4)
                    .addComponent(labelGenere))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneAggiungiiAttore;
    private javax.swing.JTextField campoNazionalita;
    private javax.swing.JTextField campoNomeCognome;
    private javax.swing.JLabel labelDataUscita;
    private javax.swing.JLabel labelGenere;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelRegista;
    private javax.swing.JSpinner spinnerAnnoNascita;
    private javax.swing.JTable tabellaAttori;
    // End of variables declaration//GEN-END:variables
}
