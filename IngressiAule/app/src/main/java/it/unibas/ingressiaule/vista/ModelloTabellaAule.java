package it.unibas.ingressiaule.vista;

import it.unibas.ingressiaule.modello.Aula;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaAule extends AbstractTableModel {

    List<Aula> listaAule = new ArrayList<>();

    public List<Aula> getListaAule() {
        return listaAule;
    }

    public void setListaAule(List<Aula> listaAule) {
        this.listaAule = listaAule;
    }

    @Override
    public int getRowCount() {
        return this.listaAule.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aula aula = this.listaAule.get(rowIndex);
        if (columnIndex == 0) {
            return aula.getCodice();
        }
        if (columnIndex == 1) {
            return aula.getNomeAula();
        }
        if (columnIndex == 2) {
            return aula.getPiano();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Codice";
        }
        if (column == 1) {
            return "Nome aula";
        }
        if (column == 2) {
            return "Piano";
        }
        return "";
    }

    public void aggiornaTabella() {
        this.fireTableDataChanged();
    }

}
