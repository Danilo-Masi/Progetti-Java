package it.unibas.bookrental.vista;

import it.unibas.bookrental.modello.Utente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaUtenti extends AbstractTableModel {

    List<Utente> listaUtenti = new ArrayList<>();

    public List<Utente> getListaUtenti() {
        return listaUtenti;
    }

    public void setListaUtenti(List<Utente> listaUtenti) {
        this.listaUtenti = listaUtenti;
    }

    @Override
    public int getRowCount() {
        return this.listaUtenti.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Utente utente = this.listaUtenti.get(rowIndex);
        if (columnIndex == 0) {
            return utente.getNomeUtente();
        }
        if (columnIndex == 1) {
            return utente.getNome();
        }
        if (columnIndex == 2) {
            return utente.getCognome();
        }
        if (columnIndex == 3) {
            return utente.getListaLibri().size();
        }
        if (columnIndex == 4) {
            return utente.getNumeroLibriNonResituiti();
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 3 || columnIndex == 4) {
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Usurname";
        }
        if (columnIndex == 1) {
            return "Nome";
        }
        if (columnIndex == 2) {
            return "Cognome";
        }
        if (columnIndex == 3) {
            return "Libri in prestito";
        }
        if (columnIndex == 4) {
            return "Libri non restituiti";
        }
        return "";
    }

    public void aggiornaTabella() {
        this.fireTableDataChanged();
    }

}
