package it.unibas.comuni.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperatoreDatiProvincia {

    public List<DatiProvincia> calcolaDatiProvince(List<Comune> listaComuni, int numeroProvince) {
        Map<String, DatiProvincia> mappaProvince = new HashMap<>();
        for (Comune comune : listaComuni) {
            DatiProvincia datiProvincia = mappaProvince.get(comune.getProvincia());
            if (datiProvincia == null) {
                datiProvincia = new DatiProvincia(comune.getProvincia());
                mappaProvince.put(comune.getProvincia(), datiProvincia);
            }
            datiProvincia.setNumeroComuni(datiProvincia.getNumeroComuni() + 1);
            datiProvincia.setTotalePopolazione(datiProvincia.getTotalePopolazione() + comune.getPopolazione());
        }
        List<DatiProvincia> listaDatiProvincia = new ArrayList<>(mappaProvince.values());
        Collections.sort(listaDatiProvincia);
        if (listaDatiProvincia.size() > numeroProvince) {
            listaDatiProvincia = listaDatiProvincia.subList(0, numeroProvince);
        }
        return listaDatiProvincia;
    }

}
