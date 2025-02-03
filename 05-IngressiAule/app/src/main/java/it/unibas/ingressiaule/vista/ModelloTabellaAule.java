package it.unibas.ingressiaule.vista;

import it.unibas.ingressiaule.modello.Aula;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaAule extends AbstractTableModel {

    private List<Aula> listaAule = new ArrayList<>();

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
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aula aula = this.listaAule.get(rowIndex);
        if (columnIndex == 0) {
            return aula.getCodice();
        }
        if (columnIndex == 1) {
            return aula.getNome();
        }
        if (columnIndex == 2) {
            return aula.getPiano();
        }
        if (columnIndex == 3) {
            return aula.getListaAccessi().size();
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 2 || columnIndex == 3) {
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Codice";
        }
        if (columnIndex == 1) {
            return "Nome";
        }
        if (columnIndex == 2) {
            return "Piano";
        }
        if (columnIndex == 3) {
            return "Num. accessi";
        }
        return "";
    }

    public void aggiornaContenuto() {
        this.fireTableDataChanged();
    }

}
