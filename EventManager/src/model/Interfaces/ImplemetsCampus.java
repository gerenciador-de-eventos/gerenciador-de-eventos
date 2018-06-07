/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Interfaces;

import java.util.List;
import model.Campus;

/**
 *
 * @author MAGNO
 */
public interface ImplemetsCampus {
    public void insert(Campus campus);
    
    public void update(Campus campus);
    
    public void delete(int id);
    
    public List<Campus> getCampusByName(String name);
    
    public List<Campus> getAllCampus();
    
    public Campus getOneCampus(int id);
}
