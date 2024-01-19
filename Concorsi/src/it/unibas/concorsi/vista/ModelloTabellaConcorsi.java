package it.unibas.concorsi.vista;

import it.unibas.concorsi.modello.Concorso;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaConcorsi extends AbstractTableModel {
    
    public List<Concorso> listaConcorsi = new ArrayList<>();
    
    public List<Concorso> getListaConcorsi() {
        return listaConcorsi;
    }
    
    public void setListaConcorsi(List<Concorso> listaConcorsi) {
        this.listaConcorsi = listaConcorsi;
    }
    
    @Override
    public int getRowCount() {
        return this.listaConcorsi.size();
    }
    
    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Concorso concorso = this.listaConcorsi.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return concorso.getCodice();
            case 1:
                return concorso.getDescrizione();
            case 2:
                return concorso.getNumeroPosti();
            case 3:
                DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
                return df.format(concorso.getDataOra().getTime());
            default:
                break;
        }
        return "";
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return Integer.class;
            case 3:
                return String.class;
            default:
                break;
        }
        return String.class;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Codice";
            case 1:
                return "Descrizione";
            case 2:
                return "N.posti";
            case 3:
                return "Data e ora";
            default:
                break;
        }
        return "";
    }
    
    public void aggiornaContenuto() {
        this.fireTableDataChanged();
    }
    
}
