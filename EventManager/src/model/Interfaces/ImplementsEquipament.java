/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Interfaces;

import java.util.List;
import model.Equipaments;

/**
 *
 * @author felipe
 */
public interface ImplementsEquipament {

    public void insert(Equipaments equipaments);

    public void update(Equipaments equipaments);

    public void delete(int id);

    public List<Equipaments> getEquipamentsByName(String name);

    public List<Equipaments> getAllEquipaments();

    public Equipaments getOneEquipaments(int id);

}
