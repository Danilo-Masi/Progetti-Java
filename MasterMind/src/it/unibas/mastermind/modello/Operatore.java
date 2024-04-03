package it.unibas.mastermind.modello;

import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Operatore {

    private static final Logger logger = LoggerFactory.getLogger(Operatore.class);

    private static final Random random = new Random();

    public Combinazione generaCombinazione() {
        Combinazione combinazione = new Combinazione();
        for (int i = 0; i < Costanti.CIFRE_COMBINAZIONE; i++) {
            int cifraCasuale = random.nextInt(Costanti.CIFRA_MASSIMA);
            while (contaOccorrenze(cifraCasuale, combinazione) > 0) {
                cifraCasuale = random.nextInt(Costanti.CIFRA_MASSIMA);
            }
            combinazione.setCifraPosizione(cifraCasuale, i);
        }
        logger.debug("GENERATA LA COMBINAZIONE {}", combinazione);
        return combinazione;
    }

    public int contaOccorrenze(int cifra, Combinazione combinazione) {
        int conta = 0;
        for (int i = 0; i < Costanti.CIFRE_COMBINAZIONE; i++) {
            if (combinazione.getCifraPosizione(i) == cifra) {
                conta++;
            }
        }
        return conta;
    }

    public boolean verificaCorrettezza(Combinazione combinazione) {
        for (int i = 0; i < Costanti.CIFRE_COMBINAZIONE; i++) {
            int cifra = combinazione.getCifraPosizione(i);
            if (contaOccorrenze(cifra, combinazione) > 1) {
                return false;
            }
            if (cifra < 1 || cifra > (Costanti.CIFRA_MASSIMA + 1)) {
                return false;
            }
        }
        return true;
    }

    public Risposta valutaTentaivo(Combinazione combinazioneNascosta, Combinazione combinazioneTentativo) {
        logger.debug("Valuto la combinazione {} rispetto al tentativo {}", combinazioneNascosta, combinazioneTentativo);
        int palliniNeri = calcolaPalliniNeri(combinazioneNascosta, combinazioneTentativo);
        int palliniBianchi = calcolaPalliniBianchi(combinazioneNascosta, combinazioneTentativo);
        logger.debug("Risulato - Neri {} - Bianchi {}", palliniNeri, palliniBianchi);
        return new Risposta(combinazioneTentativo, palliniNeri, palliniBianchi);
    }

    private int calcolaPalliniNeri(Combinazione combinazioneNascosta, Combinazione combinazioneTentativo) {
        int somma = 0;
        for (int i = 0; i < Costanti.CIFRE_COMBINAZIONE; i++) {
            if (combinazioneNascosta.getCifraPosizione(i) == combinazioneTentativo.getCifraPosizione(i)) {
                logger.debug("Trovato pallino nero in posizione {}", i);
                somma++;
            }
        }
        return somma;
    }

    private int calcolaPalliniBianchi(Combinazione combinazioneNascosta, Combinazione combinazioneTentativo) {
        int somma = 0;
        for (int i = 0; i < Costanti.CIFRE_COMBINAZIONE; i++) {
            if (combinazioneNascosta.getCifraPosizione(i) != combinazioneTentativo.getCifraPosizione(i)) {
                if (contaOccorrenze(combinazioneTentativo.getCifraPosizione(i), combinazioneNascosta) > 0) {
                    logger.debug("trovato pallino bianco in posizione {}", i);
                    somma++;
                }
            }
        }
        return somma;
    }

}
