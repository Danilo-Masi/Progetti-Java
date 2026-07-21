package it.unibas.ingressiaule.vista;

import it.unibas.ingressiaule.modello.DatiAccessiMese;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaDatiMese extends AbstractTableModel {

    List<DatiAccessiMese> datiMese = new ArrayList<>();

    public List<DatiAccessiMese> getDatiMese() {
        return datiMese;
    }

    public void setDatiMese(List<DatiAccessiMese> datiMese) {
        this.datiMese = datiMese;
    }

    @Override
    public int getRowCount() {
        return datiMese.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DatiAccessiMese datoMese = this.datiMese.get(rowIndex);
        if (columnIndex == 0) {
            int mese = datoMese.getMese();
            Calendar calendar = new GregorianCalendar(1970, mese, 1);
            DateFormat df = new SimpleDateFormat("MMMM");
            return df.format(calendar.getTime());
        }
        if (columnIndex == 1) {
            return datoMese.getTipologia();
        }
        if (columnIndex == 2) {
            return datoMese.getTempoTotale();
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
            return "Mese";
        }
        if (columnIndex == 1) {
            return "Motivazione";
        }
        if (columnIndex == 2) {
            return "Tempo permanenza";
        }
        return "";
    }

    public void aggiornaContenuto() {
        this.fireTableDataChanged();
    }

}
