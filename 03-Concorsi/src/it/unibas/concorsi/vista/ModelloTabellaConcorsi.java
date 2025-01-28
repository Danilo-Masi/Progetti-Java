package it.unibas.concorsi.vista;

import it.unibas.concorsi.modello.Concorso;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaConcorsi extends AbstractTableModel {

    private List<Concorso> listaConcorsi = new ArrayList<>();

    public List<Concorso> getListaConcorsi() {
        return listaConcorsi;
    }

    public void setListaConcorsi(List<Concorso> listaConcorsi) {
        this.listaConcorsi = listaConcorsi;
    }

    @Override
    public int getRowCount() {
        return this.listaConcorsi.size();

    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Concorso concorso = this.listaConcorsi.get(rowIndex);
        if (columnIndex == 0) {
            return concorso.getCodice();
        }
        if (columnIndex == 1) {
            return concorso.getDescrizione();
        }
        if (columnIndex == 2) {
            return concorso.getNumeroPosti();
        }
        if (columnIndex == 3) {
            return concorso.getDataOra();
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 2) {
            return Integer.class;
        }
        if (columnIndex == 3) {
            return Calendar.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Codice";
        }
        if (columnIndex == 1) {
            return "Descrizione";
        }
        if (columnIndex == 2) {
            return "Num.posti";
        }
        if (columnIndex == 3) {
            return "Data e ora";
        }
        return "";
    }

    public void aggiornaContenuto() {
        this.fireTableDataChanged();
    }

}
