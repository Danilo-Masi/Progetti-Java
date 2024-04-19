package it.unibas.companydetails.modello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    Logger logger = LoggerFactory.getLogger(Archivio.class);

    public List<Azienda> listaAziende = new ArrayList<>();

    public Archivio() {
    }

    public List<Azienda> getListaAziende() {
        return listaAziende;
    }

    //Metodo per aggiungere una azienda nella lista delle aziende
    public void aggiungiAzienda(Azienda azienda) {
        this.listaAziende.add(azienda);
    }

    //Metodo per cercare le aziende in base alla citta impostata dall'utente
    public List<Azienda> cercaAziendePerCitta(String citta) {
        List<Azienda> listaFiltrata = new ArrayList<>();
        for (Azienda azienda : listaAziende) {
            if (azienda.getCittaSede().equalsIgnoreCase(citta)) {
                listaFiltrata.add(azienda);
            }
        }
        Collections.sort(listaFiltrata, new ComparatoreCrescente());
        return listaFiltrata;
    }

    //Metodo che verifica se nell'azienda selezionata ci sono dipendenti duplicati
    public boolean cercaDipendentiDuplicati(List<Dipendente> listaDipendentiAzienda) {
        for (int i = 0; i < listaDipendentiAzienda.size() - 1; i++) {
            Dipendente d1 = listaDipendentiAzienda.get(i);
            logger.debug(d1.toString());
            for (int j = i + 1; j < listaDipendentiAzienda.size(); j++) {
                Dipendente d2 = listaDipendentiAzienda.get(j);
                logger.debug(d2.toString());
                if (d1.getCodiceFiscale().equalsIgnoreCase(d2.getCodiceFiscale())) {
                    return true;
                }
            }
        }
        return false;
    }

    //Metodo che verifica se ci sono dipendenti con lo stesso codice fiscale
    public boolean cercaDipendentiStessoCodice(Dipendente dipendenteVerifica, List<Dipendente> listaDipendenti) {
        for (Dipendente dipendente : listaDipendenti) {
            if (dipendente.getCodiceFiscale().equalsIgnoreCase(dipendenteVerifica.getCodiceFiscale())) {
                return true;
            }
        }
        return false;
    }

    //DA COMPLETARE ************************************+
    public boolean verificaArchivio() {
        List<Dipendente> listaTuttiDipendenti = new ArrayList<>();
        for (Azienda azienda : listaAziende) {
            listaTuttiDipendenti.addAll(azienda.getListaDipendenti());
        }
        Map<String, List<Dipendente>> mappaPerRegione = new HashMap<>();
        for (Dipendente dipendente : listaTuttiDipendenti) {
            String regioneResidenza = dipendente.getRegioneResidenza();
            List<Dipendente> listaDipentiRegione = mappaPerRegione.get(regioneResidenza);
            if (listaDipentiRegione == null) {
                mappaPerRegione.put(regioneResidenza, listaDipentiRegione);
            }
        }
        List<Object> listaBho = new ArrayList<>(mappaPerRegione.values());
        logger.debug(listaBho.toString());
        return false;
    }

}
