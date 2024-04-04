package it.unibas.mastermind.vista;

import it.unibas.mastermind.modello.Risposta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaRisposte extends AbstractTableModel {

    private List<Risposta> listaRisposte = new ArrayList<>();

    public void setListaRisposte(List<Risposta> listaRisposte) {
        this.listaRisposte = listaRisposte;
    }

    @Override
    public int getRowCount() {
        return this.listaRisposte.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 1) {
            return String.class;
        }
        return Integer.class;

    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Num. tentivo";
        }
        if (column == 1) {
            return "Combinazione";
        }
        if (column == 2) {
            return "Pallini neri";
        }
        if (column == 3) {
            return "Pallini bianchi";
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Risposta risposta = this.listaRisposte.get(rowIndex);
        if (columnIndex == 0) {
            return rowIndex + 1;
        }
        if (columnIndex == 1) {
            return risposta.getTentativo().toString();
        }
        if (columnIndex == 2) {
            return risposta.getPalliniNeri();
        }
        if (columnIndex == 3) {
            return risposta.getPalliniBianchi();
        }
        return "";
    }

    public void aggiornaContenuto() {
        this.fireTableDataChanged();
    }

}
