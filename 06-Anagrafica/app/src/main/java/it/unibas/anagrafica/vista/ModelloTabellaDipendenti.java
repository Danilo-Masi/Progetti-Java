package it.unibas.anagrafica.vista;

import it.unibas.anagrafica.modello.Dipendente;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaDipendenti extends AbstractTableModel {

    private List<Dipendente> listaDipendenti = new ArrayList<>();

    public List<Dipendente> getListaDipendenti() {
        return listaDipendenti;
    }

    public void setListaDipendenti(List<Dipendente> listaDipendenti) {
        this.listaDipendenti = listaDipendenti;
    }

    @Override
    public int getRowCount() {
        return this.listaDipendenti.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Dipendente dipendente = this.listaDipendenti.get(rowIndex);
        if (columnIndex == 0) {
            return dipendente.getCodiceFiscale();
        }
        if (columnIndex == 1) {
            return dipendente.getNome();
        }
        if (columnIndex == 2) {
            return dipendente.getCognome();
        }
        if (columnIndex == 3) {
            DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
            return df.format(dipendente.getDataAssunzione().getTime());
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 3) {
            return Calendar.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Codice Fiscale";
        }
        if (columnIndex == 1) {
            return "Nome";
        }
        if (columnIndex == 2) {
            return "Cognome";
        }
        if (columnIndex == 3) {
            return "Data Assunzione";
        }
        return "";
    }

    public void aggiornaContenuto() {
        this.fireTableDataChanged();
    }

}
