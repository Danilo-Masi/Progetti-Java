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

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getPopolazione() {
        return popolazione;
    }

    public void setPopolazione(int popolazione) {
        this.popolazione = popolazione;
    }

}
