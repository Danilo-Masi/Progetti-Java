package it.unibas.ricettario.vista;

import it.unibas.ricettario.modello.Pietanza;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaPietanze extends AbstractTableModel {

    private List<Pietanza> pietanze = new ArrayList<>();

    public List<Pietanza> getPietanze() {
        return pietanze;
    }

    public void setPietanze(List<Pietanza> pietanze) {
        this.pietanze = pietanze;
    }

    //Imposta il numero di righe della tabella
    @Override
    public int getRowCount() {
        return this.pietanze.size();
    }

    //Imposta il numero di colonne della tabella
    @Override
    public int getColumnCount() {
        return 3;
    }

    //Imposta il valore per la determinata colonna
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pietanza pietanza = this.pietanze.get(rowIndex);
        if (columnIndex == 0) {
            return pietanza.getNome();
        } else if (columnIndex == 1) {
            return pietanza.getIngredienti().size();
        } else if (columnIndex == 2) {
            return pietanza.contieneAllergeni();
        }
        return "";
    }

    //Metodo per sovrascrivere i nomi delle colonne
    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Nome";
        } else if (column == 1) {
            return "Numero ingredienti";
        } else if (column == 2) {
            return "Contiene allegeni";
        }
        return "";
    }
    
    //Metodo per capire il tipo di dato restituito
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return String.class;
        } else if (columnIndex == 1) {
            return Integer.class;
        } else if (columnIndex == 2) {
            return Boolean.class;
        }
        return String.class;
    }

    //Metodo per forzare il ricaricamento dei dati della tabella
    public void aggiornaContenuto() {
        this.fireTableDataChanged();
    }

}
