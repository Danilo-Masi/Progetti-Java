package it.unibas.codicefiscale.vista;

import it.unibas.codicefiscale.modello.Costanti;
import it.unibas.codicefiscale.modello.Persona;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GUI extends javax.swing.JFrame {
    
    private void inizializza() {
        //Inizializza i componenti autogenerati
        initComponents();
        //Inzializza il valore dei componenti
        inizializzaComponenti();
        //Assegna un azione al componente grafico
        inizializzaAzioni();
        //Si posiziona al centro in base alla schermata padre˙
        this.setLocationRelativeTo(null);
        //Rende visibile l'app˙
        this.setVisible(true);
    }
    
    private void inizializzaComponenti() {
        //Rimuove tutti gli items di default
        this.comboSesso.removeAllItems();
        //Aggiugni gli items nella comboBox
        this.comboSesso.addItem("");
        this.comboSesso.addItem(Costanti.MASCHIO);
        this.comboSesso.addItem(Costanti.FEMMINA);
    }
    
    private void inizializzaAzioni() {
        this.menuEsci.setAction(this.azioneEsci);
        this.menuCalcola.setAction(this.azioneCalcola);
        this.bottoneCalcola.setAction(this.azioneCalcola);
    }
    
    public void mostraFinestraErrori(String errore) {
        JOptionPane.showMessageDialog(this, errore, "Errori", JOptionPane.ERROR_MESSAGE);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel LabelNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        javax.swing.JLabel LabelCognome = new javax.swing.JLabel();
        campoCognome = new javax.swing.JTextField();
        javax.swing.JLabel LabelAnno = new javax.swing.JLabel();
        campoEta = new javax.swing.JTextField();
        javax.swing.JLabel LabelLuogo = new javax.swing.JLabel();
        campoLuogo = new javax.swing.JTextField();
        javax.swing.JLabel LabelSesso = new javax.swing.JLabel();
        comboSesso = new javax.swing.JComboBox<>();
        bottoneCalcola = new javax.swing.JButton();
        LabelRisultato = new javax.swing.JLabel();
        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        menuCalcola = new javax.swing.JMenuItem();
        menuEsci = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Codice fiscale");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inserisci dati utente"));

        LabelNome.setText("Nome:");

        LabelCognome.setText("Cognome:");

        LabelAnno.setText("Anno:");

        LabelLuogo.setText("Luogo:");

        LabelSesso.setText("Sesso:");

        comboSesso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bottoneCalcola.setText("Calcola");

        LabelRisultato.setBackground(new java.awt.Color(51, 153, 0));
        LabelRisultato.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        LabelRisultato.setForeground(new java.awt.Color(255, 255, 255));
        LabelRisultato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelRisultato.setText("Risultato");
        LabelRisultato.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(LabelRisultato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelSesso)
                            .addComponent(LabelLuogo)
                            .addComponent(LabelAnno)
                            .addComponent(LabelCognome)
                            .addComponent(LabelNome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboSesso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(350, 350, 350)
                                .addComponent(bottoneCalcola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(campoEta, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoCognome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoLuogo))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNome)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCognome)
                    .addComponent(campoCognome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelAnno)
                    .addComponent(campoEta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelLuogo)
                    .addComponent(campoLuogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelSesso)
                    .addComponent(comboSesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCalcola))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelRisultato, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
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

        /* Look and Feel*/
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GUI gui = new GUI();
                gui.inizializza();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelRisultato;
    private javax.swing.JButton bottoneCalcola;
    private javax.swing.JTextField campoCognome;
    private javax.swing.JTextField campoEta;
    private javax.swing.JTextField campoLuogo;
    private javax.swing.JTextField campoNome;
    private javax.swing.JComboBox<String> comboSesso;
    private javax.swing.JMenuItem menuCalcola;
    private javax.swing.JMenuItem menuEsci;
    // End of variables declaration//GEN-END:variables

    //Gestore degli eventi
    private AzioneEsci azioneEsci = new AzioneEsci();
    private AzioneCalcola azioneCalcola = new AzioneCalcola();

    //Azione per uscire dall'app
    private class AzioneEsci extends AbstractAction {
        
        public AzioneEsci() {
            this.putValue(NAME, "Esci");
            this.putValue(SHORT_DESCRIPTION, "Esci dall'app");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_E);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt E"));
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
            this.putValue(SHORT_DESCRIPTION, "Calcola il codice fiscale");
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            //Prende i valori dai vari field
            String nome = campoNome.getText();
            String cognome = campoCognome.getText();
            String luogo = campoLuogo.getText();
            String anno = campoEta.getText();
            String sesso = comboSesso.getSelectedItem().toString();
            logger.debug("Eseguo azione calcola - Nome: {} - Cognome: {} - Anno: {} - Luogo: {} - Sesso: {}", nome, cognome, anno, luogo, sesso);
            //fa la convalida dei campi
            String errori = convalida(nome, cognome, anno, luogo, sesso);
            if (!errori.isEmpty()) {
                logger.error("Errori nella convalida: {}", errori);
                mostraFinestraErrori(errori);
                return;
            }
            //Crea la perona con i dati dell'utente
            Persona persona = new Persona();
            persona.setNome(nome);
            persona.setCognome(cognome);
            persona.setSesso(sesso);
            persona.setLuogo(luogo);
            persona.setAnno(Integer.parseInt(anno));
            //Calcola il codice fiscale
            String codiceFiscale = persona.getCodiceFiscale();
            logger.debug(codiceFiscale);
            //Imposta il risultato nella label
            LabelRisultato.setText(codiceFiscale);
        }
        
        private String convalida(String nome, String cognome, String anno, String luogo, String sesso) {
            StringBuilder errori = new StringBuilder();
            if (nome.trim().isEmpty()) {
                errori.append("Il campo nome è obbligario \n");
            } else if (nome.length() < 3) {
                errori.append("Il campo nome deve avere almeno 3 caratteri");
            }
            if (cognome.trim().isEmpty()) {
                errori.append("Il campo cognome è obbligario \n");
            } else if (cognome.length() < 3) {
                errori.append("Il campo cognome deve avere almeno 3 caratteri");
            }
            if (luogo.trim().isEmpty()) {
                errori.append("Il campo luogo è obbligario \n");
            }
            if (sesso.trim().isEmpty()) {
                errori.append("Il campo sesso è obbligario \n");
            }
            if (anno.trim().isEmpty()) {
                errori.append("Il campo anno è obbligario \n");
            } else {
                try {
                    int annoIntero = Integer.parseInt(anno);
                } catch (NumberFormatException nfe) {
                    errori.append("Il campo anno deve essere un numero");
                }
            }
            return errori.toString();
        }
    }
    
}
