package it.unibas.agenziaviaggi.vista;

import it.unibas.agenziaviaggi.modello.Agenzia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaAgenzie extends AbstractTableModel {

    List<Agenzia> agenzie = new ArrayList<>();

    public List<Agenzia> getAgenzie() {
        return agenzie;
    }

    public void setAgenzie(List<Agenzia> agenzie) {
        this.agenzie = agenzie;
    }

    @Override
    public int getRowCount() {
        return this.agenzie.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Agenzia agenzia = this.agenzie.get(rowIndex);
        if (columnIndex == 0) {
            return agenzia.getCodice();
        }
        if (columnIndex == 1) {
            return agenzia.getNome();
        }
        if (columnIndex == 2) {
            return agenzia.getCittà();
        }
        if (columnIndex == 3) {
            return agenzia.isPrenotazioneOnline();
        }
        return "";
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
            return "Città";
        }
        if (columnIndex == 3) {
            return "Prenotazione online";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 4) {
            return Boolean.class;
        }
        return String.class;
    }

    public void aggiornaTabella() {
        this.fireTableDataChanged();
    }

}
