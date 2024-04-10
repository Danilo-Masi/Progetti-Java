package it.unibas.travelagency.vista;

import it.unibas.travelagency.modello.Agenzia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaAgenzie extends AbstractTableModel {

    public List<Agenzia> listaAgenzie = new ArrayList<>();

    public List<Agenzia> getListaAgenzie() {
        return listaAgenzie;
    }

    public void setListaAgenzie(List<Agenzia> listaAgenzie) {
        this.listaAgenzie = listaAgenzie;
    }

    @Override
    public int getRowCount() {
        return this.listaAgenzie.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int column) {
        Agenzia agenzia = this.listaAgenzie.get(rowIndex);
        if (column == 0) {
            return agenzia.getCodiceUnivoco();
        }
        if (column == 1) {
            return agenzia.getNome();
        }
        if (column == 2) {
            return agenzia.getCitta();
        }
        if (column == 3) {
            return agenzia.isPrenotazioneOnline();
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 3) {
            return Boolean.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Codice";
        }
        if (column == 1) {
            return "Nome agenzia";
        }
        if (column == 2) {
            return "Città";
        }
        if (column == 3) {
            return "Prenotazioni online";
        }
        return "";
    }

    public void aggiornaTabella() {
        this.fireTableDataChanged();
    }

}
