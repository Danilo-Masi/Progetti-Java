package it.unibas.ingressiaule.vista;

import it.unibas.ingressiaule.modello.Accesso;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaAccessi extends AbstractTableModel {

    List<Accesso> listaAccessi = new ArrayList<>();

    public List<Accesso> getListaAccessi() {
        return listaAccessi;
    }

    public void setListaAccessi(List<Accesso> listaAccessi) {
        this.listaAccessi = listaAccessi;
    }

    @Override
    public int getRowCount() {
        return this.listaAccessi.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Accesso accesso = this.listaAccessi.get(rowIndex);
        if (columnIndex == 0) {
            return accesso.getMatricola();
        }
        if (columnIndex == 1) {
            return accesso.getNomeStudente();
        }
        if (columnIndex == 2) {
            return accesso.getMotivazione();
        }
        if (columnIndex == 3) {
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT);
            return df.format(accesso.getData().getTime());
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Matricola";
        }
        if (column == 1) {
            return "Nome";
        }
        if (column == 2) {
            return "Motivazione";
        }
        if (column == 3) {
            return "Data";
        }
        return "";
    }

    public void aggiornaTabella() {
        this.fireTableDataChanged();
    }
}
