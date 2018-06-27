/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Interfaces;

import java.util.List;
import model.Event;

/**
 *
 * @author felipe
 */
public interface ImplementsEvents {
    
     public void insert(Event event);

    public void update(Event event);

    public void delete(int id);

    public List<Event> getEventByName(String name);

    public List<Event> getAllEvents();

    public Event getOneEvent(int id);
    
}
