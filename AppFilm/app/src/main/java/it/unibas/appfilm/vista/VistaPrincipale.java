package it.unibas.appfilm.vista;

import it.unibas.appfilm.Applicazione;
import it.unibas.appfilm.Costanti;
import it.unibas.appfilm.modello.Film;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.xml.crypto.Data;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        initComponents();
        inizializzaAzioni();
        this.tabellaFilm.setModel(new ModelloTabellaFilm());
    }

    private void inizializzaAzioni() {
        this.bottoneCerca.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCercaFilm());
        this.bottoneNuovoAttore.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneNuovoAttore());
    }

    public Calendar getDataImpostata() {
        Date dataValue = (Date) this.spinnerData.getValue();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataValue);
        return calendar;
    }

    public boolean isDataCrescente() {
        return this.radioDataCrescente.isSelected();
    }

    public void aggiornaDati() {
        List<Film> listaFiltrata = (List<Film>) Applicazione.getInstance().getModello().getBeans(Costanti.LISTA_FILTRATA);
        ModelloTabellaFilm modelloTabellaFilm = (ModelloTabellaFilm) this.tabellaFilm.getModel();
        modelloTabellaFilm.setFilms(listaFiltrata);
        modelloTabellaFilm.aggiornaTabella();
    }

    public int getRigaSelezionata() {
        return this.tabellaFilm.getSelectedRow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gruppoBottoni = new javax.swing.ButtonGroup();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        spinnerData = new javax.swing.JSpinner();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        radioDataCrescente = new javax.swing.JRadioButton();
        radioDataDecrescente = new javax.swing.JRadioButton();
        bottoneCerca = new javax.swing.JButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaFilm = new javax.swing.JTable();
        bottoneNuovoAttore = new javax.swing.JButton();

        jLabel1.setText("Data:");

        spinnerData.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));

        jLabel2.setText("Ordinamento:");

        gruppoBottoni.add(radioDataCrescente);
        radioDataCrescente.setSelected(true);
        radioDataCrescente.setText("data crescente");

        gruppoBottoni.add(radioDataDecrescente);
        radioDataDecrescente.setText("data decrescente");

        bottoneCerca.setText("jButton1");

        tabellaFilm.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaFilm);

        bottoneNuovoAttore.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(398, 398, 398)
                        .addComponent(bottoneNuovoAttore, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(radioDataCrescente)
                                        .addGap(18, 18, 18)
                                        .addComponent(radioDataDecrescente)
                                        .addGap(18, 18, 18)
                                        .addComponent(bottoneCerca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(spinnerData))))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spinnerData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioDataCrescente)
                        .addComponent(radioDataDecrescente)
                        .addComponent(bottoneCerca)))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(bottoneNuovoAttore)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCerca;
    private javax.swing.JButton bottoneNuovoAttore;
    private javax.swing.ButtonGroup gruppoBottoni;
    private javax.swing.JRadioButton radioDataCrescente;
    private javax.swing.JRadioButton radioDataDecrescente;
    private javax.swing.JSpinner spinnerData;
    private javax.swing.JTable tabellaFilm;
    // End of variables declaration//GEN-END:variables
}
