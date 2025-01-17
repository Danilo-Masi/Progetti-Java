package it.unibas.codicefiscale.vista;

import it.unibas.codicefiscale.modello.Costanti;
import it.unibas.codicefiscale.modello.Persona;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GUI extends javax.swing.JFrame {

    private void inizializza() {
        initComponents();
        inizializzaComponenti();
        inizializzaAzioni();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void inizializzaComponenti() {
        this.comboSesso.removeAllItems();
        this.comboSesso.addItem("");
        this.comboSesso.addItem(Costanti.MASCHIO);
        this.comboSesso.addItem(Costanti.FEMMINA);
    }

    private void inizializzaAzioni() {
        this.menuEsci.setAction(this.azioneEsci);
        this.menuCalcola.setAction(this.azioneCalcola);
        this.bottoneCalcola.setAction(this.azioneCalcola);
        this.campoNome.setAction(this.azioneCalcola);
        this.campoCognome.setAction(this.azioneCalcola);
        this.campoLuogo.setAction(this.azioneCalcola);
        this.campoEta.setAction(this.azioneCalcola);
    }

    public void mostraFinestraErrori(String errori) {
        JOptionPane.showMessageDialog(this, errori, "Errore", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        campoCognome = new javax.swing.JTextField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        campoEta = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        campoLuogo = new javax.swing.JTextField();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        comboSesso = new javax.swing.JComboBox<>();
        bottoneCalcola = new javax.swing.JButton();
        labelRisultato = new javax.swing.JLabel();
        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        menuCalcola = new javax.swing.JMenuItem();
        menuEsci = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Codice FIscale");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inserrisci i dati della persona"));

        jLabel1.setText("Nome:");

        jLabel2.setText("Cognome:");

        jLabel3.setText("Anno:");

        jLabel4.setText("Luogo:");

        jLabel5.setText("Sesso:");

        comboSesso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bottoneCalcola.setText("Calcola");

        labelRisultato.setBackground(new java.awt.Color(0, 153, 51));
        labelRisultato.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        labelRisultato.setForeground(new java.awt.Color(255, 255, 255));
        labelRisultato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRisultato.setText("RISULTATO");
        labelRisultato.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNome)
                            .addComponent(campoCognome)
                            .addComponent(campoEta)
                            .addComponent(campoLuogo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboSesso, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(bottoneCalcola, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))))
                    .addComponent(labelRisultato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoCognome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoEta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoLuogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboSesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCalcola))
                .addGap(18, 18, 18)
                .addComponent(labelRisultato, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setText("File");

        menuCalcola.setText("Calcola");
        jMenu1.add(menuCalcola);

        menuEsci.setText("Esci");
        jMenu1.add(menuEsci);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the System look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUI gui = new GUI();
                gui.inizializza();
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Variables"> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCalcola;
    private javax.swing.JTextField campoCognome;
    private javax.swing.JTextField campoEta;
    private javax.swing.JTextField campoLuogo;
    private javax.swing.JTextField campoNome;
    private javax.swing.JComboBox<String> comboSesso;
    private javax.swing.JLabel labelRisultato;
    private javax.swing.JMenuItem menuCalcola;
    private javax.swing.JMenuItem menuEsci;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>  

    private AzioneEsci azioneEsci = new AzioneEsci();
    private AzioneCalcola azioneCalcola = new AzioneCalcola();

    private class AzioneEsci extends AbstractAction {

        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'applicazione");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt X"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class AzioneCalcola extends AbstractAction {

        private Logger logger = LoggerFactory.getLogger(AzioneCalcola.class);

        public AzioneCalcola() {
            this.putValue(NAME, "Calcola");
            this.putValue(SHORT_DESCRIPTION, "Calcola codice fiscale");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt J"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = campoNome.getText();
            String cognome = campoCognome.getText();
            String luogo = campoLuogo.getText();
            String anno = campoEta.getText();
            String sesso = comboSesso.getSelectedItem().toString();
            logger.debug("Eseguo azione calcola - Nome: {} - Cognome: {} - Anno: {} - Luogo: {} - Sesso: {}", nome, cognome, anno, luogo, sesso);
            String errori = convalida(nome, cognome, anno, luogo, sesso);
            if (!errori.trim().isEmpty()) {
                logger.error("Errori nella convalida: {}", errori);
                mostraFinestraErrori(errori);
                return;
            }
            Persona persona = new Persona();
            persona.setNome(nome);
            persona.setCognome(cognome);
            persona.setLuogo(luogo);
            persona.setSesso(sesso);
            persona.setAnno(Integer.parseInt(anno));
            String codiceFiscale = persona.getCodiceFiscale();
            logger.debug("Codice fiscale: {}", codiceFiscale);
            labelRisultato.setText(codiceFiscale);
        }

        private String convalida(String nome, String cognome, String anno, String luogo, String sesso) {
            StringBuilder errori = new StringBuilder();
            if (nome.equals("") || nome.trim().length() < 3) {
                errori.append("Il campo nome non è valido \n");
            }
            if (cognome.equals("") || cognome.trim().length() < 3) {
                errori.append("Il campo cognome non è valido \n");
            }
            if (luogo.equals("")) {
                errori.append("Il campo luogo non è valido \n");
            }
            if (sesso.equals("")) {
                errori.append("Il campo sesso non è valido \n");
            }
            if (anno.trim().isEmpty()) {
                errori.append("Il campo anno non è valido \n");
            } else {
                try {
                    int annoIntero = Integer.parseInt(anno);
                } catch (NumberFormatException e) {
                    errori.append("Il campo anno deve essere un intero \n");
                }
            }
            return errori.toString();
        }
    }
}
