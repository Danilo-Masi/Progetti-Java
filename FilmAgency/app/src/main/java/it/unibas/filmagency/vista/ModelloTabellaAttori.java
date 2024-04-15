package it.unibas.filmagency.vista;

import it.unibas.filmagency.modello.DatiFilm;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaAttori extends AbstractTableModel {

    List<DatiFilm> listaDatiFilm = new ArrayList<>();

    public List<DatiFilm> getListaDatiFilm() {
        return listaDatiFilm;
    }

    public void setListaDatiFilm(List<DatiFilm> listaDatiFilm) {
        this.listaDatiFilm = listaDatiFilm;
    }

    @Override
    public int getRowCount() {
        return this.listaDatiFilm.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DatiFilm datiFilm = this.listaDatiFilm.get(rowIndex);
        if (columnIndex == 0) {
            return datiFilm.getNazione();
        } else {
            return datiFilm.getNumeroAttori();
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 1) {
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Nazionalità";
        } else {
            return "Numero attori";
        }
    }

    public void aggiornaTabella() {
        this.fireTableDataChanged();
    }

}
