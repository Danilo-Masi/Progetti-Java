package it.unibas.banca.modello;

import java.util.Calendar;

public class Movimento {

    private Calendar data;
    private Double importo;
    private String tipologia;

    public Movimento(Calendar data, Double importo, String tipologia) {
        this.data = data;
        this.importo = importo;
        this.tipologia = tipologia;
    }

    public Calendar getData() {
        return data;
    }

    public Double getImporto() {
        return importo;
    }

    public String getTipologia() {
        return tipologia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Movimento{");
        sb.append("data=").append(data);
        sb.append(", importo=").append(importo);
        sb.append(", tipologia=").append(tipologia);
        sb.append('}');
        return sb.toString();
    }

}
