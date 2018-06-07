/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Place;

/**
 *
 * @author MAGNO
 */
public class TableModelPlace extends AbstractTableModel {
     private static final long serialVersionUID = 1L;

    List<Place> list;

    public TableModelPlace(List<Place> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getIdPlace();
            case 1:
                return list.get(rowIndex).getPlaceName();
            case 2:
                return list.get(rowIndex).getPlaceCampus();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Sala";
            case 2:
                return "Local";
           
            default:
                return null;
        }
    }
}
