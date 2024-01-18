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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("nome=").append(nome);
        sb.append(", categoria=").append(categoria);
        sb.append(", costo=").append(costo);
        sb.append(", ingredienti=").append(ingredienti);
        return sb.toString();
    }

    //Metodo per aggiungere un ingrediente alla lista degli ingredienti
    public void aggiungiIngrediente(Ingrediente e) {
        ingredienti.add(e);
    }

    //Metodo per restituire le kcal di ogni ingrediente 
    public double getKcal() {
        double somma = 0.0;
        for (Ingrediente ingrediente : ingredienti) {
            somma += ingrediente.getKcal();
        }
        return somma;
    }

    //Metodo per verificare quali ingredienti hanno allgergeni
    public boolean contieneAllergeni() {
        for (Ingrediente ingrediente : ingredienti) {
            if (ingrediente.isAllergene()) {
                return true;
            }
        }
        return false;
    }

}
