/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Event;

/**
 *
 * @author felipe
 */
public class TableModelEvent extends AbstractTableModel {

    private static final long serialVersionUID = 1L;

    List<Event> list;

    public TableModelEvent(List<Event> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getIdEvent(); //mudar id e completar
            case 1:
                return list.get(rowIndex).getEventName();
            case 2:
                return list.get(rowIndex).getEventResponsible();
            case 3:
              return list.get(rowIndex).getEventDate();
            case 4:
                return list.get(rowIndex).getEventCampus();
            case 5:
//               return list.get(rowIndex).getEventPlaces();
            //add eventPlaces
            case 6:
                return list.get(rowIndex).getEventequipamentCollection();
                //acho que nao vai funcionar
            case 7:
         //   return list.get(rowIndex).getEventequipamentCollection();;
                case 8:
              // return list.get(rowIndex).getEventequipamentCollection();
                 case 9:
         //    return list.get(rowIndex).getEventequipamentCollection();
              
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
                return "Responsible";
            case 3:
                return "Date of Event";
            case 4:
                return "Campus";
            case 5:
                return "Places";
            case 6:
                return "Microphone";
            case 7:
                return "Notebook";
            case 8:
                return "Projector";
            case 9:
                return "Trainee";

            default:
                return null;
        }
    }
}
