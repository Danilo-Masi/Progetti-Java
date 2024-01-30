package it.unibas.sistemiistituti.vista;

import it.unibas.sistemiistituti.modello.Istituto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaIstituti extends AbstractTableModel {

    List<Istituto> istituti = new ArrayList<>();

    public List<Istituto> getIstituti() {
        return istituti;
    }

    public void setIstituti(List<Istituto> istituti) {
        this.istituti = istituti;
    }

    @Override
    public int getRowCount() {
        return this.istituti.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Istituto istituto = this.istituti.get(rowIndex);
        if (columnIndex == 0) {
            return istituto.getCodice();
        }
        if (columnIndex == 1) {
            return istituto.getNome();
        }
        if (columnIndex == 2) {
            return istituto.getGrado();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Codice";
        }
        if (column == 1) {
            return "Nome";
        }
        if (column == 2) {
            return "Grado";
        }
        return "";
    }

    public void aggiornaTabella() {
        this.fireTableDataChanged();
    }

}
