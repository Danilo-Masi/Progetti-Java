package it.unibas.comuni.vista;

import it.unibas.comuni.modello.DatiProvincia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaDatiProvince extends AbstractTableModel {

    private List<DatiProvincia> listaDatiProvince = new ArrayList<>();

    public List<DatiProvincia> getListaDatiProvince() {
        return listaDatiProvince;
    }

    public void setListaDatiProvince(List<DatiProvincia> listaDatiProvince) {
        this.listaDatiProvince = listaDatiProvince;
    }

    @Override
    public int getRowCount() {
        return listaDatiProvince.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DatiProvincia datiProvincia = this.listaDatiProvince.get(rowIndex);
        if (columnIndex == 0) {
            return datiProvincia.getProvincia();
        }
        if (columnIndex == 1) {
            return datiProvincia.getTotalePopolazione();
        }
        if (columnIndex == 2) {
            return datiProvincia.getNumeroComuni();
        }
        if (columnIndex == 3) {
            return datiProvincia.getMediaPopolazione();
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return String.class;
        }
        if (columnIndex == 3) {
            return Double.class;
        }
        return Integer.class;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Provincia";
        }
        if (columnIndex == 1) {
            return "N.Abitanti";
        }
        if (columnIndex == 2) {
            return "N.comuni";
        }
        if (columnIndex == 3) {
            return "Media Popolazione";
        }
        return "";
    }

    public void aggiornaContenuto() {
        this.fireTableDataChanged();
    }

}
