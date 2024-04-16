package it.unibas.bookrental.vista;

import it.unibas.bookrental.modello.DatiLibro;
import it.unibas.bookrental.modello.Libro;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaLibri extends AbstractTableModel {

    List<DatiLibro> listaLibri = new ArrayList<>();

    public List<DatiLibro> getListaLibri() {
        return listaLibri;
    }

    public void setListaLibri(List<DatiLibro> listaLibri) {
        this.listaLibri = listaLibri;
    }

    @Override
    public int getRowCount() {
        return this.listaLibri.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DatiLibro datiLibro = this.listaLibri.get(rowIndex);
        if (columnIndex == 0) {
            return datiLibro.getAutore();
        }
        if (columnIndex == 1) {
            return datiLibro.getNumLibriNoleggiati();
        }
        if (columnIndex == 2) {
            return datiLibro.getNumLibriDaResituire();
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return String.class;
        }
        return Integer.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Autore";
        }
        if (column == 1) {
            return "Numero totale di libri noleggiati";
        }
        if (column == 2) {
            return "Numero totale di libri da restituire";
        }
        return "";
    }

    public void aggiornaTabella() {
        this.fireTableDataChanged();
    }

}
