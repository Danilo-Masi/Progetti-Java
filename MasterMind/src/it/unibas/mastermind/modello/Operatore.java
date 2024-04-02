package it.unibas.mastermind.modello;

import java.util.Random;

public class Operatore {

    private static final Random random = new Random();

    public Combinazione generaCombinazione() {
        Combinazione combinazione = new Combinazione();
        for (int i = 0; i < Costanti.CIFRE_COMBINAZIONE; i++) {
            int cifraCasuale = random.nextInt(Costanti.CIFRA_MASSIMA) + 1;

            combinazione.setCifraPosizione(cifraCasuale, i);
        }
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

}
