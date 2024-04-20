package it.unibas.banktransactions.modello;

import it.unibas.banktransactions.Costanti;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    Logger logger = (Logger) LoggerFactory.getLogger(Archivio.class);

    List<ContoCorrente> listaContiCorrente = new ArrayList<>();

    public Archivio() {
    }

    public List<ContoCorrente> getListaContiCorrente() {
        return listaContiCorrente;
    }

    public void aggiungiContoCorrente(ContoCorrente contoCorrente) {
        listaContiCorrente.add(contoCorrente);
    }

    //Metodo per cercare i conti corrente che sono stati sottoscritti prima della data odierna
    public List<ContoCorrente> cercaContiSottoscritti(String criterio) {
        List<ContoCorrente> listaFiltrata = new ArrayList<>();
        Calendar dataOdierna = Calendar.getInstance();
        for (ContoCorrente contoCorrente : listaContiCorrente) {
            if (contoCorrente.getDataSottoscrizione().before(dataOdierna)) {
                listaFiltrata.add(contoCorrente);
            }
        }
        if (criterio.equalsIgnoreCase(Costanti.NOME_CRESCENTE)) {
            Collections.sort(listaFiltrata, new ComparatoreNomeCrescente());
        } else {
            Collections.sort(listaFiltrata, new ComparatoreDataCrescente());
        }
        logger.debug(listaFiltrata.toString());
        return listaFiltrata;
    }

    //Metodo che verifica se ci sono più conto correnti con lo stesso nome e cognome sottoscritti nella stessa data
    public boolean verificaArchivio() {
        int size = listaContiCorrente.size();
        for (int i = 0; i < size - 1; i++) {
            ContoCorrente contoCorrente1 = listaContiCorrente.get(i);
            logger.info("Primo indice: " + i);
            logger.info("Primo conto: " + contoCorrente1.getCredenzialiIntestario());
            for (int j = i + 1; j < size; j++) {
                ContoCorrente contoCorrente2 = listaContiCorrente.get(j);
                logger.info("Secondo indice: " + j);
                logger.info("Secondo conto: " + contoCorrente2.getCredenzialiIntestario());
                if (contoCorrente1.getCredenzialiIntestario().trim().equalsIgnoreCase(contoCorrente2.getCredenzialiIntestario().trim())
                        && contoCorrente1.getDataSottoscrizione().equals(contoCorrente2.getDataSottoscrizione())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    //Metodo che divide i movimenti per tipologia e conta il numero di operazioni per tipologia
    public List<DatiMovimento> mostraDatiTabella(List<Movimento> listaMovimenti) {
        Map<String, DatiMovimento> mappaDivisoria = new HashMap<>();
        for (Movimento movimento : listaMovimenti) {
            String tipologia = movimento.getTipologia();
            DatiMovimento datiMovimento = mappaDivisoria.get(tipologia);
            if(datiMovimento == null) {
                mappaDivisoria.put(tipologia, datiMovimento);
            }
            datiMovimento.setNumeroOperazioni(datiMovimento.getNumeroOperazioni() + 1);
        }
        List<DatiMovimento> listaDatiMovimento = new ArrayList<>(mappaDivisoria.values());
        //Collections.sort(listaMovimenti, new ComparatoreOperazioniDescrescente());
        return listaDatiMovimento;
    }

}
