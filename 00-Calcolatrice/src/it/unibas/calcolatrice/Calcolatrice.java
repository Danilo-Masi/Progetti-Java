package it.unibas.calcolatrice;

import java.util.ArrayList;
import java.util.List;

public class Calcolatrice {

    private List<Double> storiaOperazioni = new ArrayList<>();
    private double risultato;

    public Calcolatrice() {
    }

    public Calcolatrice(double risultato) {
        this.risultato = risultato;
    }

    public double getRisultato() {
        return risultato;
    }

    public void setRisultato(double risultato) {
        this.risultato = risultato;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Risultato: ").append(risultato);
        return sb.toString();
    }

    public void somma(double a, double b) {
        double ris = a + b;
        this.storiaOperazioni.add(ris);
        this.risultato = ris;
    }

}
