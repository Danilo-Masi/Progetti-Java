package it.unibas.comuni.modello;

import java.util.ArrayList;
import java.util.List;

public class Archivio {

    private String dataAggiornamento;
    private List<Comune> listaComuni = new ArrayList<>();

    public String getDataAggiornamento() {
        return dataAggiornamento;
    }

    public void setDataAggiornamento(String dataAggiornamento) {
        this.dataAggiornamento = dataAggiornamento;
    }

    public List<Comune> getListaComuni() {
        return listaComuni;
    }

    public void setListaComuni(List<Comune> listaComuni) {
        this.listaComuni = listaComuni;
    }
    

}
