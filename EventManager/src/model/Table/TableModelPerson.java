/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Campus;
import model.Person;

/**
 *
 * @author MAGNO
 */
public class TableModelPerson extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    List<Person> list;

    public TableModelPerson(List<Person> list) {
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
                return list.get(rowIndex).getIdPerson();
            case 1:
                return list.get(rowIndex).getPersonName();
            case 2:
                return list.get(rowIndex).getPersonPassword();

            case 3:

                return list.get(rowIndex).getPersonCPF();

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
                return "Password";
            case 3:
                return "CPF";

            default:
                return null;
        }
    }
}
