package it.unibas.appfilm.vista;

import it.unibas.appfilm.modello.Attore;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaAttori extends AbstractTableModel {

    List<Attore> attori = new ArrayList<>();

    public List<Attore> getAttori() {
        return attori;
    }

    public void setAttori(List<Attore> attori) {
        this.attori = attori;
    }

    @Override
    public int getRowCount() {
        return this.attori.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Attore attore = this.attori.get(rowIndex);
        if (columnIndex == 0) {
            return attore.getNomeECognome();
        }
        if (columnIndex == 1) {
            return attore.getNazionalita();
        }
        if (columnIndex == 2) {
            return attore.getDataNascita();
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 2) {
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Nome e cognome";
        }
        if (column == 1) {
            return "Nazionalità";
        }
        if (column == 2) {
            return "Anno di nascita";
        }
        return "";
    }

    public void aggiornaTabella() {
        this.fireTableDataChanged();
    }

}
