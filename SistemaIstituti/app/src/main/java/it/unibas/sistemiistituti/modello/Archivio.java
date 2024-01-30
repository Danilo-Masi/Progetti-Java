package it.unibas.sistemiistituti.modello;

import it.unibas.sistemiistituti.Costanti;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Archivio {
    
    private List<Istituto> listaIstituti = new ArrayList<>();
    
    public List<Istituto> getListaIstituti() {
        return listaIstituti;
    }
    
    public void setListaIstituti(List<Istituto> listaIstituti) {
        this.listaIstituti = listaIstituti;
    }
    
    public void aggiungiIstituto(Istituto istituto) {
        this.listaIstituti.add(istituto);
    }

    //Metodo per ricercare gli istituti in base al grado selezionato dall'utente
    public List<Istituto> cercaPerGrado(String grado, String ordinamento) {
        List<Istituto> listaFiltrata = new ArrayList<>();
        for (Istituto istituto : listaIstituti) {
            if (istituto.getGrado().equalsIgnoreCase(grado)) {
                listaFiltrata.add(istituto);
            }
        }
        if (ordinamento.equals(Costanti.ORDINAMENTO_CRESCENTE)) {
            Collections.sort(listaFiltrata, new ComparatoreClassiCrescente());
        } else {
            Collections.sort(listaFiltrata, new ComparatoreClassiDecrescente());
        }
        return listaFiltrata;
    }
    
    public List<DatiMese> calcolaCalcolaClassiPerMese(List<Classe> listaClassi) {
        Map<Integer, DatiMese> mappaDatiMese = new HashMap<>();
        
        for (Classe classe : listaClassi) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(classe.getDataInizioLezioni().getTime());
            int mese = calendar.get(Calendar.MONTH);
            
            DatiMese datiMese = mappaDatiMese.get(mese);
            if (datiMese == null) {
                datiMese = new DatiMese(mese);
                mappaDatiMese.put(mese, datiMese);
            }
            
            datiMese.setNumeroClassi(datiMese.getNumeroClassi() + 1);
        }
        
        List<DatiMese> listaDatiMese = new ArrayList<>(mappaDatiMese.values());
        Collections.sort(listaDatiMese, new DatiMese());
        return listaDatiMese;
    }

    //Metodo che verifica chi ha la media piu alta di alunni tra i diversi gradi
    public String verificaArchivio() {
        
        return "";
    }
    
}
