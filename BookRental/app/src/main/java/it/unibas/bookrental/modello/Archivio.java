package it.unibas.bookrental.modello;

import it.unibas.bookrental.Applicazione;
import it.unibas.bookrental.Costanti;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Archivio {

    private static Logger logger = LoggerFactory.getLogger(Archivio.class);

    private List<Utente> listaUtenti = new ArrayList<>();

    public Archivio() {
    }

    public List<Utente> getListaUtenti() {
        return listaUtenti;
    }

    //Metodo per aggiungere un utente alla lista degli utenti
    public void aggiungiUtente(Utente utente) {
        this.listaUtenti.add(utente);
    }

    //Metodo per ricercare gli utenti
    public List<Utente> cercaUtenti(String nome, String cognome) {
        List<Utente> listaFiltrata = new ArrayList<>();
        for (Utente utente : listaUtenti) {
            if (nome.isEmpty() && !cognome.isEmpty()) {
                if (utente.getCognome().equalsIgnoreCase(cognome)) {
                    listaFiltrata.add(utente);
                }
            } else if (!nome.isEmpty() && cognome.isEmpty()) {
                if (utente.getNome().equalsIgnoreCase(nome)) {
                    listaFiltrata.add(utente);
                }
            } else if (!nome.isEmpty() && !cognome.isEmpty()) {
                if (utente.getNome().equalsIgnoreCase(nome) && utente.getCognome().equalsIgnoreCase(cognome)) {
                    listaFiltrata.add(utente);
                }
            } else {
                listaFiltrata.addAll(listaUtenti);
            }
        }
        return listaFiltrata;
    }

    //Metodo per impostare i DatiLibro nella tabella
    public List<DatiLibro> impostaDatiLibro(List<Libro> listaLibriUtente) {

        Map<String, DatiLibro> mappaDatiLibro = new HashMap<>();

        for (Libro libro : listaLibriUtente) {

            String autore = libro.getAutore();
            logger.debug("Autore: " + autore);

            DatiLibro datiLibro = (DatiLibro) mappaDatiLibro.get(autore);
            logger.debug("Dati libro: " + datiLibro);

            if (datiLibro == null) {
                int contaLibriDaResituire = 0;
                if (libro.getDataFinePrestito() == null) {
                    contaLibriDaResituire++;
                }
                datiLibro = new DatiLibro(autore, 1, contaLibriDaResituire);
                mappaDatiLibro.put(autore, datiLibro);
            } else {
                datiLibro.setNumLibriNoleggiati(datiLibro.getNumLibriNoleggiati() + 1);
            }

        }
        List<DatiLibro> listaDatiLibro = new ArrayList<>(mappaDatiLibro.values());
        return listaDatiLibro;
    }

    //Metodo per verificare se un deyerminato utente ha piu di 3 libri ancora da restituire
    public void verificaTroppiPrestiti() {
        Utente utenteSelezionato = (Utente) Applicazione.getInstance().getModello().getBeans(Costanti.UTENTE_SELEZIONATO);
        for (Utente utente : listaUtenti) {
            if (utente.getNome().equalsIgnoreCase(utenteSelezionato.getNome())) {
                if (utente.getNumeroLibriNonResituiti() > 3) {
                    for (Libro libro : utenteSelezionato.getListaLibri()) {
                        Calendar cal = Calendar.getInstance();
                        //DA COMPLETARE
                    }
                }
            }
        }
    }

}
