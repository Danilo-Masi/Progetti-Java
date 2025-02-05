package it.unibas.compravenditeauto.vista;

import it.unibas.compravenditeauto.modello.Auto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaAuto extends AbstractTableModel {

    List<Auto> listaAuto = new ArrayList<>();

    public List<Auto> getListaAuto() {
        return listaAuto;
    }

    public void setListaAuto(List<Auto> listaAuto) {
        this.listaAuto = listaAuto;
    }

    @Override
    public int getRowCount() {
        return this.listaAuto.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Auto auto = this.listaAuto.get(rowIndex);
        if (columnIndex == 0) {
            return auto.getTarga();
        }
        if (columnIndex == 1) {
            return auto.getModello();
        }
        if (columnIndex == 2) {
            return auto.getAnno();
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return String.class;
        }
        if (columnIndex == 1) {
            return String.class;
        }
        if (columnIndex == 2) {
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Targa";
        }
        if (columnIndex == 1) {
            return "Modello";
        }
        if (columnIndex == 2) {
            return "Anno";
        }
        return "";
    }

    public void aggiornaContenuto() {
        this.fireTableDataChanged();
    }

}
