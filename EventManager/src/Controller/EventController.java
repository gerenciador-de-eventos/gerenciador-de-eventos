/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import model.DAO.EventDAO;
import model.Event;
import model.Interfaces.ImplementsEvents;
import model.Table.TableModelEvent;
import view.EventJframe;

/**
 *
 * @author felipe
 */
public class EventController {
 
    private final EventJframe panel;
    private final ImplementsEvents implementsEvent;
    private List<Event> list;

    public EventController(EventJframe panel) {
        this.panel = panel;
        implementsEvent = new EventDAO();
        list = implementsEvent.getAllEvents();
    }

    public void reset() {
        panel.getTxtId().setText("");
        panel.getTxtName().setText("");
        
       panel.getJDataChooserDateEvent().setCalendar(Calendar.getInstance());
     
       panel.getJComboBoxCampus().setSelectedIndex(0); //
       
        panel.getTableEvent().clearSelection();
    }

    public void setTable() {
        list = implementsEvent.getAllEvents();
        panel.getTableEvent().setModel(new TableModelEvent(list));
    }

    public void getDataField() {
        int row = panel.getTableEvent().getSelectedRow();
        if (row != -1) {
            panel.getTxtId().setText(String.valueOf(list.get(row).getIdEvent()));
            panel.getTxtName().setText(list.get(row).getEventName());
            panel.getTxtResponsible().setText(list.get(row).getEventResponsible());
            panel.getJComboBoxTrainee().setSelectedItem(list.get(row).getEventTrainee());
            panel.getJComboBoxCampus().setSelectedItem(list.get(row).getEventCampus());
        //    panel.getJComboBoxPlace().setSelectedItem(list.get(row).getEventPlace);
            
            panel.getJDataChooserDateEvent().setDate(list.get(row).getEventDate());

        }
    }

    public void insert() {
        Event event = new Event();
        event.setEventName(panel.getTxtName().getText());
        event.setEventResponsible(panel.getTxtResponsible().getText());
        event.setEventDate(panel.getJDataChooserDateEvent().getDate());
        event.setEventCampus(panel.getJComboBoxCampus().getSelectedItem().toString());
       event.setEventClass(panel.getJComboBoxPlace().getSelectedItem().toString());
     //event.setEventHour(eventHour);
     event.setEventTrainee(panel.getJComboBoxTrainee().getSelectedItem().toString());
     
        implementsEvent.insert(event);
    }

    /**
     *
     */
    public void update() {

        Event event = new Event();
        event.setIdEvent(Integer.parseInt(panel.getTxtId().getText()));
          event.setEventName(panel.getTxtName().getText());
        event.setEventResponsible(panel.getTxtResponsible().getText());
        event.setEventDate(panel.getJDataChooserDateEvent().getDate());
        event.setEventCampus(panel.getJComboBoxCampus().getSelectedItem().toString());
       event.setEventClass(panel.getJComboBoxPlace().getSelectedItem().toString());
     //event.setEventHour(eventHour);
     event.setEventTrainee(panel.getJComboBoxTrainee().getSelectedItem().toString());
     
        implementsEvent.insert(event);
    }

    public void delete() {
        if (panel.getTxtId().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Sem dados para deletar.", null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        int row = Integer.parseInt(panel.getTxtId().getText());
        implementsEvent.delete(row);
    }

    public void getData() {
        if (panel.getTxtName().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(panel, "Digite um nome de campus para buscar.", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        String name = panel.getTxtName().getText();
        implementsEvent.getEventByName(name);
        this.filterTable(name);
    }

    public void filterTable(String name) {
        list = implementsEvent.getEventByName(name);
        panel.getTableEvent().setModel(new TableModelEvent(list));
    }
}
