package it.unibas.calcolatrice;

import it.unibas.utilita.Console;

public class Principale {

    public static void main(String[] args) {
        System.out.println("Benvenuto nella calcolatrice");
        String nome = Console.leggiStringa();
        System.out.println("Nome: " + nome);
    }

}
