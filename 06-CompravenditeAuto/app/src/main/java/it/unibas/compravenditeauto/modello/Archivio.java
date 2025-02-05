package it.unibas.compravenditeauto.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class Archivio {

    private List<Auto> listaAuto = new ArrayList<>();

    public List<Auto> getListaAuto() {
        return listaAuto;
    }

    public void setListaAuto(List<Auto> listaAuto) {
        this.listaAuto = listaAuto;
    }

    public void aggiungiAuto(Auto auto) {
        this.listaAuto.add(auto);
    }

    public List<Auto> cercaAuto(Calendar data, String ordinamento) {
        List<Auto> listaFiltarta = new ArrayList<>();
        for (Auto auto : listaAuto) {
            for (Operazione operazione : auto.getListaOperazioni()) {
                if (operazione.getDataOperazione().getTime().before(data.getTime())) {
                    listaFiltarta.add(auto);
                }
            }
        }
        if (ordinamento.equalsIgnoreCase(Costanti.ORDINAMENTO_CRESCENTE)) {
            Collections.sort(listaFiltarta, new ComparatoreNomeCrescente());
        } else {
            Collections.sort(listaFiltarta, new ComparatoreNomeDecrescente());
        }
        return listaFiltarta;
    }

}
