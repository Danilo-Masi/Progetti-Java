package it.unibas.compravenditeauto.modello;

import java.util.ArrayList;
import java.util.List;

public class Auto {

    private String targa;
    private String modello;
    private int anno;
    private List<Operazione> listaOperazioni = new ArrayList<>();

    public Auto(String targa, String modello, int anno) {
        this.targa = targa;
        this.modello = modello;
        this.anno = anno;
    }

    public String getTarga() {
        return targa;
    }

    public String getModello() {
        return modello;
    }

    public int getAnno() {
        return anno;
    }

    public List<Operazione> getListaOperazioni() {
        return listaOperazioni;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Targa: ").append(targa);
        sb.append("Modello: ").append(modello);
        sb.append("Anno prima immatricolazione: ").append(anno);
        sb.append("Lista operazioni: ").append(listaOperazioni);
        return sb.toString();
    }

    public void aggiungiOperazione(Operazione operazione) {
        this.listaOperazioni.add(operazione);
    }

}
