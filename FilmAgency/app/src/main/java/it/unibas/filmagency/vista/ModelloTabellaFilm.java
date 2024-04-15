package it.unibas.filmagency.vista;

import it.unibas.filmagency.modello.Film;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaFilm extends AbstractTableModel {

    private List<Film> listaFilm = new ArrayList<>();

    public List<Film> getListaFilm() {
        return listaFilm;
    }

    public void setListaFilm(List<Film> listaFilm) {
        this.listaFilm = listaFilm;
    }

    @Override
    public int getRowCount() {
        return this.listaFilm.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Film film = this.listaFilm.get(rowIndex);
        if (columnIndex == 0) {
            return film.getNomeFilm();
        }
        if (columnIndex == 1) {
            DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
            return df.format(film.getDataUscita().getTime());
        }
        if (columnIndex == 2) {
            return film.getRegista();
        }
        if (columnIndex == 3) {
            return film.getGenere();
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 1) {
            return Calendar.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Nome";
        }
        if (columnIndex == 1) {
            return "Data di uscita";
        }
        if (columnIndex == 2) {
            return "Regista";
        }
        if (columnIndex == 3) {
            return "Genere";
        }
        return "";
    }

    public void aggiornaTabella() {
        this.fireTableDataChanged();
    }

}
