package it.unibas.travelagency.vista;

import it.unibas.travelagency.modello.Pacchetto;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaPacchetti extends AbstractTableModel {

    public List<Pacchetto> listaPacchetti = new ArrayList<>();

    public List<Pacchetto> getListaPacchetti() {
        return listaPacchetti;
    }

    public void setListaPacchetti(List<Pacchetto> listaPacchetti) {
        this.listaPacchetti = listaPacchetti;
    }

    @Override
    public int getRowCount() {
        return this.listaPacchetti.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pacchetto pacchetto = this.listaPacchetti.get(rowIndex);
        if (columnIndex == 0) {
            return pacchetto.getTipologia().toUpperCase();
        }
        if (columnIndex == 1) {

            DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
            return df.format(pacchetto.getDataPartenza().getTime());
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 1) {
            return Calendar.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Tipologia";
        }
        if (column == 1) {
            return "Data di partenza";
        }
        return "";
    }

    public void aggiornaTabella() {
        this.fireTableDataChanged();
    }
}
