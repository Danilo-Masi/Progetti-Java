package it.unibas.companydetails.vista;

import it.unibas.companydetails.modello.Azienda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaAziende extends AbstractTableModel {

    private List<Azienda> listaAziende = new ArrayList<>();

    public List<Azienda> getListaAziende() {
        return listaAziende;
    }

    public void setListaAziende(List<Azienda> listaAziende) {
        this.listaAziende = listaAziende;
    }

    @Override
    public int getRowCount() {
        return this.listaAziende.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Azienda azienda = this.listaAziende.get(rowIndex);
        if (columnIndex == 0) {
            return azienda.getPartitaIva();
        }
        if (columnIndex == 1) {
            return azienda.getDenominazione();
        }
        if (columnIndex == 2) {
            return azienda.getListaDipendenti().size();
        }
        return "";
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
            return "P.IVA";
        }
        if (column == 1) {
            return "Denominazione";
        }
        if (column == 2) {
            return "Num. Dipendenti";
        }
        return "";
    }

    public void aggiornaTabella() {
        this.fireTableDataChanged();
    }

}
