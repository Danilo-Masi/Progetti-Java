package it.unibas.appfilm.modello;

public class Attore {

    private String nomeECognome;
    private String nazionalita;
    private int dataNascita;

    public Attore(String nomeECognome, String nazionalita, int dataNascita) {
        this.nomeECognome = nomeECognome;
        this.nazionalita = nazionalita;
        this.dataNascita = dataNascita;
    }

    public String getNomeECognome() {
        return nomeECognome;
    }

    public void setNomeECognome(String nomeECognome) {
        this.nomeECognome = nomeECognome;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    public int getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(int dataNascita) {
        this.dataNascita = dataNascita;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("nomeECognome: ").append(nomeECognome);
        return sb.toString();
    }
    
    

}
