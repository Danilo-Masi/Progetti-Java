package it.unibas.ricettario.modello;

import java.util.ArrayList;
import java.util.List;

public class Pietanza {

    private String nome;
    private String categoria;
    private double costo;
    private List<Ingrediente> listaIngredienti = new ArrayList<>();

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

    public List<Ingrediente> getListaIngredienti() {
        return listaIngredienti;
    }

    public void addIngrediente(Ingrediente e) {
        listaIngredienti.add(e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome; ").append(nome);
        sb.append("Categoria: ").append(categoria);
        sb.append("Costo: ").append(costo);
        sb.append("Lista ingredienti: ").append(listaIngredienti);
        return sb.toString();
    }

    public double getKcalTot() {
        double kcalTot = 0;
        for (Ingrediente ingrediente : listaIngredienti) {
            kcalTot += ingrediente.getKcal();
        }
        return kcalTot;
    }

}
