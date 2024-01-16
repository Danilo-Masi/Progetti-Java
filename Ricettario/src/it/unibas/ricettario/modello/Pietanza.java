package it.unibas.ricettario.modello;

import java.util.ArrayList;
import java.util.List;

public class Pietanza {

    private String nome;
    private String categoria;
    private double costo;
    private List<Ingrediente> ingredienti = new ArrayList<>();

    public Pietanza(String nome, String categoria, double costo) {
        this.nome = nome;
        this.categoria = categoria;
        this.costo = costo;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getCosto() {
        return costo;
    }

    public List<Ingrediente> getIngredienti() {
        return ingredienti;
    }

    public void aggiungiIngrediente(Ingrediente e) {
        ingredienti.add(e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("nome=").append(nome);
        sb.append(", categoria=").append(categoria);
        sb.append(", costo=").append(costo);
        sb.append(", ingredienti=").append(ingredienti);
        return sb.toString();
    }

    //Funzione che restituisce le kcal di ogni pietanza
    public double getKcal() {
        double somma = 0.0;
        for (Ingrediente ingrediente : ingredienti) {
            somma += ingrediente.getKcal();
        }
        return somma;
    }

}
