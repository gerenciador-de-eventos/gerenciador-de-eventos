/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Equipaments;
import model.Person;

/**
 *
 * @author felipe
 */
public class TableModelEquipament extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    List<Equipaments> list;

    public TableModelEquipament(List<Equipaments> list) {
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
                return list.get(rowIndex).getIdEquipaments();
            case 1:
                return list.get(rowIndex).getEquipamentsName();
            case 2:
                return list.get(rowIndex).getEquipamentsType();

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
                return "Name";
            case 2:
                return "Type";

            default:
                return null;
        }
    }
}
