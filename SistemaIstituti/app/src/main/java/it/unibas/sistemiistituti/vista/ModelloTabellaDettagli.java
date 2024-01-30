package it.unibas.sistemiistituti.vista;

import it.unibas.sistemiistituti.modello.DatiMese;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaDettagli extends AbstractTableModel {

    List<DatiMese> listaDatiMese = new ArrayList<>();

    public List<DatiMese> getListaDatiMese() {
        return listaDatiMese;
    }

    public void setListaDatiMese(List<DatiMese> listaDatiMese) {
        this.listaDatiMese = listaDatiMese;
    }

    @Override
    public int getRowCount() {
        return listaDatiMese.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Mese";
        }
        if (column == 1) {
            return "Numero classi";
        }
        return "";
    }

    public void aggiornaTabella() {
        this.fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DatiMese datiMese = listaDatiMese.get(rowIndex);
        if (columnIndex == 0) {
            int mese = datiMese.getMese(); 
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.MONTH, mese);

            SimpleDateFormat sd = new SimpleDateFormat("MMMM");
            String nomeMese = sd.format(calendar.getTime());
            return nomeMese;
        } else if (columnIndex == 1) {
            return datiMese.getNumeroClassi();
        }
        return null;
    }
}
