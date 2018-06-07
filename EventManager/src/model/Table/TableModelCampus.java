/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Campus;

/**
 *
 * @author MAGNO
 */
public class TableModelCampus extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    List<Campus> list;

    public TableModelCampus(List<Campus> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getIdCampus();
            case 1:
                return list.get(rowIndex).getCampusName();
            case 2:
                return list.get(rowIndex).getCampusFantasyName();

            case 3:

                return list.get(rowIndex).getCampusCity();

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
                return "Campus";
            case 2:
                return "Nome Fantasia Campus";
            case 3:
                return "Cidade";

            default:
                return null;
        }
    }
}
