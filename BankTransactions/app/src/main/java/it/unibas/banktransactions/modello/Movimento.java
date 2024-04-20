package it.unibas.banktransactions.modello;

import java.util.Calendar;

public class Movimento {

    private Calendar data;
    private double importo;
    private String tipologia;

    public Movimento(Calendar data, double importo, String tipologia) {
        this.data = data;
        this.importo = importo;
        this.tipologia = tipologia;
    }

    public Calendar getData() {
        return data;
    }

    public double getImporto() {
        return importo;
    }

    public String getTipologia() {
        return tipologia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Data movimento: ").append(data);
        sb.append("Importo movimento: ").append(importo);
        sb.append("Tipologia movimento: ").append(tipologia);
        return sb.toString();
    }

}
