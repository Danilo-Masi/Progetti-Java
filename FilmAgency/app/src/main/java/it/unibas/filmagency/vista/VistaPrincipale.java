package it.unibas.filmagency.vista;

import it.unibas.filmagency.Applicazione;
import it.unibas.filmagency.Costanti;
import it.unibas.filmagency.modello.Film;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class VistaPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        initComponents();
        inizializzaAzioni();
        this.tabellaFilm.setModel(new ModelloTabellaFilm());
    }

    private void inizializzaAzioni() {
        this.bottoneCercaFilm.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCercaFilm());
        this.bottoneMostraDettagli.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneMostraDettagliFilm());
    }

    public Calendar getDataInserita() {
        Calendar cal = Calendar.getInstance();
        Date dataInserita = (Date) spinnerDataUscita.getValue();
        cal.setTime(dataInserita);
        return cal;
    }

    public boolean isCrescente() {
        return this.ordinamentoCrescente.isSelected();
    }

    public boolean isDescrescente() {
        return this.ordinamentoDescrescente.isSelected();
    }

    public int getRigaSelezionata() {
        return this.tabellaFilm.getSelectedRow();
    }

    public void aggiornaDati() {
        List<Film> listaFiltrata = (List<Film>) Applicazione.getInstance().getModello().getBeand(Costanti.LISTA_FILTRATA);
        ModelloTabellaFilm modelloTabellaFilm = (ModelloTabellaFilm) this.tabellaFilm.getModel();
        modelloTabellaFilm.setListaFilm(listaFiltrata);
        modelloTabellaFilm.aggiornaTabella();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.ButtonGroup gruppoOrdinamentoData = new javax.swing.ButtonGroup();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        spinnerDataUscita = new javax.swing.JSpinner();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        ordinamentoCrescente = new javax.swing.JRadioButton();
        ordinamentoDescrescente = new javax.swing.JRadioButton();
        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        tabellaFilm = new javax.swing.JTable();
        bottoneCercaFilm = new javax.swing.JButton();
        bottoneMostraDettagli = new javax.swing.JButton();

        jLabel1.setText("Data di uscita del film:");

        spinnerDataUscita.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));

        jLabel2.setText("Ordinamento (data):");

        gruppoOrdinamentoData.add(ordinamentoCrescente);
        ordinamentoCrescente.setSelected(true);
        ordinamentoCrescente.setText("Crescente");

        gruppoOrdinamentoData.add(ordinamentoDescrescente);
        ordinamentoDescrescente.setText("Descrescente");
        ordinamentoDescrescente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordinamentoDescrescenteActionPerformed(evt);
            }
        });

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

        bottoneCercaFilm.setText("jButton1");

        bottoneMostraDettagli.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ordinamentoCrescente)
                                .addGap(10, 10, 10)
                                .addComponent(ordinamentoDescrescente))
                            .addComponent(spinnerDataUscita, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(bottoneMostraDettagli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(bottoneCercaFilm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spinnerDataUscita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ordinamentoCrescente)
                    .addComponent(ordinamentoDescrescente))
                .addGap(20, 20, 20)
                .addComponent(bottoneCercaFilm)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(bottoneMostraDettagli)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ordinamentoDescrescenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordinamentoDescrescenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ordinamentoDescrescenteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCercaFilm;
    private javax.swing.JButton bottoneMostraDettagli;
    private javax.swing.JRadioButton ordinamentoCrescente;
    private javax.swing.JRadioButton ordinamentoDescrescente;
    private javax.swing.JSpinner spinnerDataUscita;
    private javax.swing.JTable tabellaFilm;
    // End of variables declaration//GEN-END:variables
}
