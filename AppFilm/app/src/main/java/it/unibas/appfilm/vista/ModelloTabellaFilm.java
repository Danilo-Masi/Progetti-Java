package it.unibas.appfilm.vista;

import it.unibas.appfilm.modello.Film;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaFilm extends AbstractTableModel {

    List<Film> films = new ArrayList<>();

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    @Override
    public int getRowCount() {
        return this.films.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Film film = this.films.get(rowIndex);
        if (columnIndex == 0) {
            return film.getNomeFilm();
        }
        if (columnIndex == 1) {
            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
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
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Nome film";
        }
        if (columnIndex == 1) {
            return "Data uscita";
        }
        if (columnIndex == 2) {
            return "Regista";
        }
        if (columnIndex == 3) {
            return "Genere˙";
        }
        return "";
    }

    public void aggiornaTabella() {
        this.fireTableDataChanged();
    }

}
