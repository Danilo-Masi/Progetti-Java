package it.unibas.anagrafica.vista;

import it.unibas.anagrafica.modello.Azienda;
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
            return azienda.getDenominazione();
        }
        if (columnIndex == 1) {
            return azienda.getPartitaIVA();
        }
        if (columnIndex == 2) {
            return azienda.getCittaSede();
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Denominazione";
        }
        if (columnIndex == 1) {
            return "Partita IVA";
        }
        if (columnIndex == 2) {
            return "Città Sede";
        }
        return "";
    }

    public void aggiornaContenuto() {
        this.fireTableDataChanged();
    }

}
