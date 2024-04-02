package it.unibas.mastermind.modello;

public class Combinazione {

    private int[] cifre = new int[Costanti.CIFRE_COMBINAZIONE];

    public int getCifraPosizione(int posizione) {
        if (posizione < 0 || posizione >= Costanti.CIFRE_COMBINAZIONE) {
            throw new IllegalArgumentException("Posizione scorretta");
        }
        return cifre[posizione];
    }

    public void setCifraPosizione(int cifra, int posizione) {
        if (posizione < 0 || posizione >= Costanti.CIFRE_COMBINAZIONE) {
            throw new IllegalArgumentException("Posizione scorretta");
        }
        if (cifra < 1 || cifra >= Costanti.CIFRA_MASSIMA) {
            throw new IllegalArgumentException("Cifra scorretta");
        }
        cifre[posizione] = cifra;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Combinazione: ");
        for (int i = 0; i < cifre.length; i++) {
            sb.append(cifre[i]);
        }
        return sb.toString();
    }

}
