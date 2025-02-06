package it.unibas.compravenditeauto.vista;

import it.unibas.compravenditeauto.modello.Operazione;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaOperazioni extends AbstractTableModel {

    List<Operazione> listaOperazioni = new ArrayList<>();

    public List<Operazione> getListaOperazioni() {
        return listaOperazioni;
    }

    public void setListaOperazioni(List<Operazione> listaOperazioni) {
        this.listaOperazioni = listaOperazioni;
    }

    @Override
    public int getRowCount() {
        
    }

    @Override
    public int getColumnCount() {
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    }

}
