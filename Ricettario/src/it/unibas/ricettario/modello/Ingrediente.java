package it.unibas.ricettario.modello;

public class Ingrediente {

    private String nome;
    private int quantita;
    private boolean allergene;
    private int kcal100gr;

    public Ingrediente(String nome, int quantita, boolean allergene, int kcal100gr) {
        this.nome = nome;
        this.quantita = quantita;
        this.allergene = allergene;
        this.kcal100gr = kcal100gr;
    }

    //Calcola le kcal generali dell'ingrediente
    public double getKcal() {
        return this.quantita * this.kcal100gr / 100.0;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantita() {
        return quantita;
    }

    public boolean isAllergene() {
        return allergene;
    }

    public int getKcal100gr() {
        return kcal100gr;
    }
    
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("nome=").append(nome);
        sb.append(", quantita=").append(quantita);
        sb.append(", allergene=").append(allergene);
        sb.append(", kcal100gr=").append(kcal100gr);
        return sb.toString();
    }

}
