package it.unibas.codicefiscale.vista;

import it.unibas.codicefiscale.modello.Costanti;
import it.unibas.codicefiscale.modello.Persona;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
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
        this.campoAnno.setAction(this.azioneCalcola);
    }

    public void mostraFinestraErrori(String errore) {
        JOptionPane.showMessageDialog(this, errore, "Finestra errori", JOptionPane.ERROR_MESSAGE);
    }

    public void mostraFinestraInfo(String messaggio) {
        JOptionPane.showMessageDialog(this, messaggio, "Finestra info", JOptionPane.INFORMATION_MESSAGE);
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
        campoAnno = new javax.swing.JTextField();
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
        setTitle("Codice Fiscale");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inserisci i dati della persona"));

        jLabel1.setText("Nome:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Cognome:");

        jLabel3.setText("Anno:");

        jLabel4.setText("Luogo:");

        jLabel5.setText("Sesso:");

        comboSesso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bottoneCalcola.setText("Calcola");

        labelRisultato.setBackground(new java.awt.Color(51, 153, 0));
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
                    .addComponent(labelRisultato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNome)
                            .addComponent(campoCognome)
                            .addComponent(campoAnno)
                            .addComponent(campoLuogo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboSesso, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(bottoneCalcola, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoCognome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoAnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoLuogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboSesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCalcola))
                .addGap(20, 20, 20)
                .addComponent(labelRisultato, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setMnemonic('f');
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUI gui = new GUI();
                gui.inizializza();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCalcola;
    private javax.swing.JTextField campoAnno;
    private javax.swing.JTextField campoCognome;
    private javax.swing.JTextField campoLuogo;
    private javax.swing.JTextField campoNome;
    private javax.swing.JComboBox<String> comboSesso;
    private javax.swing.JLabel labelRisultato;
    private javax.swing.JMenuItem menuCalcola;
    private javax.swing.JMenuItem menuEsci;
    // End of variables declaration//GEN-END:variables

    //Dichiarazione Oggetti
    private AzioneEsci azioneEsci = new AzioneEsci();
    private AzioneCalcola azioneCalcola = new AzioneCalcola();

    //<editor-fold defaultstate="collapsed" desc="Classe Azione Esci">
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

    //<editor-fold defaultstate="collapsed" desc="Classe Azione Calcola">
    private class AzioneCalcola extends AbstractAction {

        private Logger logger = LoggerFactory.getLogger(AzioneCalcola.class);

        public AzioneCalcola() {
            this.putValue(NAME, "Calcola");
            this.putValue(SHORT_DESCRIPTION, "Calcola codice fiscale");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String cognome = campoCognome.getText();
            String nome = campoNome.getText();
            String anno = campoAnno.getText();
            String luogo = campoLuogo.getText();
            String sesso = (String) comboSesso.getSelectedItem();
            logger.debug("Eseguo azione calcola - Nome: {}  - Cognome: {} - Anno: {}  - Luogo: {}  - Sesso: {}", nome, cognome, anno, luogo, sesso);
            String errori = convalida(nome, cognome, anno, luogo, sesso);
            if (!errori.isEmpty()) {
                logger.error("Errori nella convalida: {}", errori);
                mostraFinestraErrori(errori);
                return;
            }
            Persona persona = new Persona();
            persona.setNome(nome);
            persona.setCognome(cognome);
            persona.setSesso(sesso);
            persona.setLuogo(luogo);
            persona.setAnno(Integer.parseInt(anno));
            String codiceFiscale = persona.getCodiceFiscale();
            logger.debug("Codice fiscale: {}", codiceFiscale);
            labelRisultato.setText(codiceFiscale);
        }

        private String convalida(String nome, String cognome, String anno, String luogo, String sesso) {
            StringBuilder errori = new StringBuilder();
            if (nome.trim().isEmpty()) {
                errori.append("Il campo del nome è obbligatorio\n");
            } else if (nome.length() < 3) {
                errori.append("Il campo nome deve essere almeno di 3 caratteri\n");
            }
            if (cognome.trim().isEmpty()) {
                errori.append("Il campo del cognome è obbligatorio\n");
            } else if (cognome.length() < 3) {
                errori.append("Il campo cognome deve essere almeno di 3 caratteri\n");
            }
            if (luogo.trim().isEmpty()) {
                errori.append("Il campo del luogo è obbligatorio\n");
            }
            if (sesso.trim().isEmpty()) {
                errori.append("Il campo del sesso è obbligatorio\n");
            }
            if (anno.trim().isEmpty()) {
                errori.append("Il campo del anno è obbligatorio\n");
            } else {
                try {
                    int annoIntero = Integer.parseInt(anno);
                    if (annoIntero < 1900 | annoIntero > 2026) {
                        errori.append("l\'anno inserito non è valido");
                    }
                } catch (NumberFormatException e) {
                    errori.append("Il campo anno deve esserre un intero");
                }
            }
            return errori.toString();
        }

    }

}
