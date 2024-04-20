package it.unibas.banktransactions.vista;

import it.unibas.banktransactions.modello.ContoCorrente;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaContiCorrente extends AbstractTableModel {

    private List<ContoCorrente> listaContiCorrente = new ArrayList<>();

    public List<ContoCorrente> getListaContiCorrente() {
        return listaContiCorrente;
    }

    public void setListaContiCorrente(List<ContoCorrente> listaContiCorrente) {
        this.listaContiCorrente = listaContiCorrente;
    }

    @Override
    public int getRowCount() {
        return this.listaContiCorrente.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ContoCorrente contoCorrente = this.listaContiCorrente.get(rowIndex);
        if (columnIndex == 0) {
            return contoCorrente.getIban();
        } else if (columnIndex == 1) {
            return contoCorrente.getCredenzialiIntestario();
        } else {
            DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
            return df.format(contoCorrente.getDataSottoscrizione().getTime());
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "IBAN";
        } else if (column == 1) {
            return "Nome intestatario";
        } else {
            return "Data sottoscrizione";
        }
    }

    public void aggiornaTabella() {
        this.fireTableDataChanged();
    }

}
