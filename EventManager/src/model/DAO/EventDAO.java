/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import Configurations.ConfigurationsMySQL;
import Database.DatabaseGeneric;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Event;
import model.Interfaces.ImplementsEvents;

/**
 *
 * @author felipe
 */
public class EventDAO extends DatabaseGeneric implements ImplementsEvents{

     public ArrayList<Event> list;

    public EventDAO() {
        super(new ConfigurationsMySQL(), "event");
    }
    
    @Override
    public void insert(Event event) {
     Map<Object, Object> mapObj = new HashMap<>();

        mapObj.put("EventName", event.getEventName());
       // mapObj.put("PersonDateBorn", event.getPersonDateBorn());
      
        this.genericInsert(mapObj);   }

    @Override
    public void update(Event event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> getEventByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> getAllEvents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Event getOneEvent(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
