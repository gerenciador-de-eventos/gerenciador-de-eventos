/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Interfaces;

import java.util.List;
import model.Place;

/**
 *
 * @author MAGNO
 */
public interface ImplemetsPlace {
        public void insert(Place p);
    
    public void update(Place p);
    
    public void delete(int id);
    
    public List<Place> getCampusByName(String name);
    
    public List<Place> getAllCampus();
    
    public Place getOneCampus(int id);
}
