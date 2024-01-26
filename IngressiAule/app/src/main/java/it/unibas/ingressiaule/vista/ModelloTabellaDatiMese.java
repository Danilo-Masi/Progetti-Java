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

    private List<DatiAccessiMese> datiMese = new ArrayList<>();

    public List<DatiAccessiMese> getDatiMese() {
        return datiMese;
    }

    public void setDatiMese(List<DatiAccessiMese> datiMese) {
        this.datiMese = datiMese;
    }

    @Override
    public int getRowCount() {
        return this.datiMese.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int column) {
        DatiAccessiMese datiAccessiMese = this.datiMese.get(rowIndex);
        if (column == 0) {
            int mese = datiAccessiMese.getMese();
            Calendar calendar = new GregorianCalendar(1970, mese, 1);
            DateFormat df = new SimpleDateFormat("MMMM");
            return df.format(calendar.getTime());
        }
        if (column == 1) {
            return datiAccessiMese.getTipologia();
        }
        if (column == 2) {
            return datiAccessiMese.getTempoTotale();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Mese";
        }
        if (column == 1) {
            return "Motivazione";
        }
        if (column == 2) {
            return "Tempo permanenza";
        }
        return "";
    }

    void aggiornaTabella() {
        this.fireTableDataChanged();
    }

}
