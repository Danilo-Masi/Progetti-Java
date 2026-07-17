package it.unibas.comuni.modello;

public class Comune {

    private int codice;
    private String nome;
    private String regione;
    private String provincia;
    private int popolazione;

    public int getCodice() {
        return codice;
    }

    public String getNome() {
        return nome;
    }

    public String getRegione() {
        return regione;
    }

    public String getProvincia() {
        return provincia;
    }

    public int getPopolazione() {
        return popolazione;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Codice: ").append(codice);
        sb.append("Nome: ").append(nome);
        sb.append("Regione: ").append(regione);
        sb.append("Provincia: ").append(provincia);
        sb.append("Popolazione: ").append(popolazione);
        return sb.toString();
    }

}
