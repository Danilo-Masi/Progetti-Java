package it.unibas.appfilm.vista;

import it.unibas.appfilm.modello.DatiFilm;
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

    public void aggiornaTabella() {
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return listaDatiFilm.size();
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
        }
        if (columnIndex == 1) {
            return datiFilm.getNumeroAttori();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Nazione";
        }
        if (column == 1) {
            return "Numero Attori";
        }
        return "";
    }

}
