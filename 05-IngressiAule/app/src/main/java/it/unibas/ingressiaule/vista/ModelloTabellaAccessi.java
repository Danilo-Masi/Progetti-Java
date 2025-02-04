package it.unibas.ingressiaule.vista;

import it.unibas.ingressiaule.modello.Accesso;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Accesso accesso = this.listaAccessi.get(rowIndex);
        if (columnIndex == 0) {
            return accesso.getMatricolaStudente();
        }
        if (columnIndex == 1) {
            return accesso.getNomeStudente();
        }
        if (columnIndex == 2) {
            return accesso.getMinutiPermanenza();
        }
        if (columnIndex == 3) {
            return accesso.getMotivazione();
        }
        if (columnIndex == 4) {
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT);
            return df.format(accesso.getData().getTime());
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
        if (columnIndex == 3) {
            return String.class;
        }
        if (columnIndex == 4) {
            return Calendar.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Matricola";
        }
        if (columnIndex == 1) {
            return "Nome";
        }
        if (columnIndex == 2) {
            return "Minuti permanenza";
        }
        if (columnIndex == 3) {
            return "Motivazione";
        }
        if (columnIndex == 4) {
            return "Data";
        }
        return "";
    }

    public void aggiornaContenuto() {
        this.fireTableDataChanged();
    }

}
