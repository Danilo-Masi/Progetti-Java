package it.unibas.comuni.vista;

import it.unibas.comuni.modello.DatiProvincia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaDatiProvince extends AbstractTableModel {

    List<DatiProvincia> province = new ArrayList<>();

    public List<DatiProvincia> getProvince() {
        return province;
    }

    public void setProvince(List<DatiProvincia> province) {
        this.province = province;
    }

    @Override
    public int getRowCount() {
        return this.province.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DatiProvincia provincia = this.province.get(rowIndex);
        if (columnIndex == 0) {
            return provincia.getProvincia();
        }
        if (columnIndex == 1) {
            return provincia.getNumeroComuni();
        }
        if (columnIndex == 2) {
            return provincia.getTotalePopolazione();
        }
        if (columnIndex == 3) {
            return provincia.getMediaPopolazione();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Provincia";
        }
        if (columnIndex == 1) {
            return "Numero comuni";
        }
        if (columnIndex == 2) {
            return "Tot popolazione";
        }
        if (columnIndex == 3) {
            return "Media popolazione";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        if (columnIndex == 1 || columnIndex == 2) {
            return Integer.class;
        }
        if (columnIndex == 3) {
            return Double.class;
        }
        return String.class;
    }

    public void aggiornaTabella() {
        this.fireTableDataChanged();
    }

}
