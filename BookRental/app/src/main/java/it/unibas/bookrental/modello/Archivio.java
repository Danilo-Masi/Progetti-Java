package it.unibas.bookrental.modello;

import it.unibas.bookrental.Applicazione;
import it.unibas.bookrental.Costanti;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

    //Metodo per ricercare gli utenti (CASO D'USO 2)
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

    //Metodo per impostare i DatiLibro nella tabella (CASO D'USO 3)
    public List<DatiLibro> impostaDatiLibro(List<Libro> listaLibriUtente) {
        //Creiamo una mappa dove inserire tutti i libri che ha noleggiato l'utente e 
        //come key prende la stringa del nome dell'autore e come value prende DatiLibro
        Map<String, DatiLibro> mappaDatiLibro = new HashMap<>();
        for (Libro libro : listaLibriUtente) {
            //Recuperiamo l'autore del determinato libro
            String autore = libro.getAutore();
            //Chiediamo alla map di restituici il suo valore passandoli come key d'accesso l'autore
            DatiLibro datiLibro = (DatiLibro) mappaDatiLibro.get(autore);
            //Verichiamo che la map ci restituisca un valore se la key è presente e null se la key non è presente
            if (datiLibro == null) {
                int conta = 0;
                //Verifichiamo se il libro in questione ha una data di fine prestito
                if (libro.getDataFinePrestito() == null) {
                    conta++;
                }
                //Creiamo un nuovo oggetto DatiLibro con le varie proprietà, il numLibriNoleggiati è 1, in quanto
                //non essendoci nella map significa che l'utente noleggia questo libro
                datiLibro = new DatiLibro(autore, 1, conta);
                //Impostiamo questo nuovo autore nella map
                mappaDatiLibro.put(autore, datiLibro);
            } else {
                //Se l'autore è gia presente, aumentiamo il numero di noleggi
                datiLibro.setNumLibriNoleggiati(datiLibro.getNumLibriNoleggiati() + 1);
                //Verifchiamo anche qui se il libro ha una data di fine prestito, se non dovesse esserci
                //incrementiamo di 1 il numero di libri da restituire
                if (libro.getDataFinePrestito() == null) {
                    datiLibro.setNumLibriDaResituire(datiLibro.getNumLibriDaResituire() + 1);
                }
            }
        }
        List<DatiLibro> listaDatiLibro = new ArrayList<>(mappaDatiLibro.values());
        return listaDatiLibro;
    }

    //Metodo che verifica se un utente ha più di 3 libri da restituire (CASO D'USO 3)
    private boolean contaLibriDaRestituire(List<Libro> listaLibri) {
        int conta = 0;
        for (Libro libro : listaLibri) {
            Calendar dataFinePrestito = libro.getDataFinePrestito();
            if (dataFinePrestito == null) {
                conta++;
            }
        }
        return conta > 3;
    }

    //Metodo che dopo aver verificato che l'utente ha più di 3 libri in prestito 
    //Imposta quello che ha la data di inizio noleggio più lontana come restituito nella data odierna (CASO D'USO 3)
    public void impostaDataFineNoleggio() {
        Utente utenteSelezionato = (Utente) Applicazione.getInstance().getModello().getBeans(Costanti.UTENTE_SELEZIONATO);
        List<Libro> listaLibriUtente = utenteSelezionato.getListaLibri();
        boolean verifica = contaLibriDaRestituire(listaLibriUtente);
        //ListaProvvisoria conterra la lista di tutti i Libri che non hanno ancora una dataFinePrestito
        List<Libro> listaProvvisoria = new ArrayList<>();
        if (verifica) {
            for (Libro libro : listaLibriUtente) {
                Calendar dataFinePrestito = libro.getDataFinePrestito();
                if (dataFinePrestito == null) {
                    listaProvvisoria.add(libro);
                }
            }
        }
        logger.debug(listaProvvisoria.toString());
        //Impostiamo un nuova data per paragonarla alle altre presenti nella lista e
        //trovare la data di inizio prestito più lontana
        Calendar dataDaReimpostare = Calendar.getInstance();
        //Cicliamo attraverso tutta la lista di libri che non hanno una dataFinePrestito
        for (Libro libro : listaProvvisoria) {
            Calendar dataInizioPrestito = libro.getDataInizioPrestito();
            //Verifica se la dataInizioPrestito del i-esimo libro sia prima della attuale dataDaReimpostare
            //e la imposta come nuova dataDaReimpostare
            if (dataInizioPrestito.before(dataDaReimpostare)) {
                dataDaReimpostare = dataInizioPrestito;
            }
        }
        Calendar oggi = Calendar.getInstance();
        for (Libro libro : listaProvvisoria) {
            //Prende il libro che ha la dataInizioPrestito impostata prima e reimposta 
            //la datFinePrestito come la data odierna
            if (libro.getDataInizioPrestito().equals(dataDaReimpostare)) {
                libro.getDataFinePrestito().setTime(oggi.getTime());
            }
        }
    }

    // Metodo che verifica se nell'archivio di tutti i libri presi in prestito piu di 6 mesi fa ci sono tutti di diversi autori
    // o qualche autore si ripete (CASO D'USO 4)
    public boolean verificaArchivio() {
        boolean verifica = false;
        //Impostiamo la data da equiparare ovvero 6 mesi fa
        Calendar cal = Calendar.getInstance();
        Date dataOdierna = cal.getTime();
        dataOdierna.setMonth(dataOdierna.getMonth() - 6);
        logger.debug("Data da comparare: " + dataOdierna.toString());
        //Impostiamo una lista provvisoria dove immagazzinare tutti i libri presi in 
        //prestito più di 6 mesi fa
        List<Libro> listaProvvisoria = new ArrayList<>();
        for (Utente utente : listaUtenti) {
            for (Libro libro : utente.getListaLibri()) {
                Date dataLibro = libro.getDataInizioPrestito().getTime();
                logger.debug("Data libro: " + dataLibro.toString());
                if (dataLibro.before(dataOdierna)) {
                    listaProvvisoria.add(libro);
                }
            }
        }
        //Creaiamo una mappa che ordina in base all'autore tutti i libri presi in prestito più di 6 mesi fa
        Map<String, Libro> mappaLibriPerAutore = new HashMap<>();
        for (Libro libro : listaProvvisoria) {
            //Recuperiamo l'autore del determinato libro
            String autore = libro.getAutore();
            //Chiediamo alla map di restituici il suo valore passandoli come key d'accesso l'autore
            libro = mappaLibriPerAutore.get(autore);
            //Verifichiamo se esistono altri libri con la stessa key ovvero con lo stesso autore, in tal caso possiamo
            //restituire già true in quanto la richiesta è stata soddisfatta, altrimenti continuiamo a ciclare gli altri libri
            if (libro != null) {
                return true;
            } else {
                mappaLibriPerAutore.put(autore, libro);
            }
        }
        return verifica;
    }

}
