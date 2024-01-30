package it.unibas.sistemiistituti.modello;

import java.util.ArrayList;
import java.util.List;

public class Istituto {

    private String codice;
    private String nome;
    private String grado;
    private List<Classe> listaClassi = new ArrayList<>();

    public Istituto(String codice, String nome, String grado) {
        this.codice = codice;
        this.nome = nome;
        this.grado = grado;
    }

    public String getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public String getGrado() {
        return grado;
    }

    public List<Classe> getListaClassi() {
        return listaClassi;
    }

    public void aggiungiClasse(Classe classe) {
        this.listaClassi.add(classe);
    }

    public int getPopolositaElementari() {
        int conta = 0;
        for (Classe classe : listaClassi) {
            conta += classe.getNumeroIscritti();
        }

        return conta / listaClassi.size();
    }

}
