package it.unibas.agenziaviaggi.vista;

import it.unibas.agenziaviaggi.modello.Pacchetto;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaPacchetti extends AbstractTableModel {

    List<Pacchetto> pacchetti = new ArrayList<>();

    public List<Pacchetto> getPacchetti() {
        return pacchetti;
    }

    public void setPacchetti(List<Pacchetto> pacchetti) {
        this.pacchetti = pacchetti;
    }

    @Override
    public int getRowCount() {
        return this.pacchetti.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pacchetto pacchetto = this.pacchetti.get(rowIndex);
        if (columnIndex == 0) {
            return pacchetto.getDestinazione();
        }
        if (columnIndex == 1) {
            return pacchetto.getImporto();
        }
        if (columnIndex == 2) {
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
            return df.format(pacchetto.getDataPartenza().getTime());
        }
        if (columnIndex == 3) {
            return pacchetto.getDurata();
        }
        if (columnIndex == 4) {
            pacchetto.getTipologia();
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 1) {
            return Double.class;
        }
        if (columnIndex == 2) {
            return Calendar.class;
        }
        if (columnIndex == 3) {
            return Integer.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Destinazione";
        }
        if (columnIndex == 1) {
            return "Importo";
        }
        if (columnIndex == 2) {
            return "Data partenza";
        }
        if (columnIndex == 3) {
            return "Durata";
        }
        if (columnIndex == 4) {
            return "Tipologia";
        }
        return "";
    }

    public void aggiornaTabella() {
        this.fireTableDataChanged();
    }

}
