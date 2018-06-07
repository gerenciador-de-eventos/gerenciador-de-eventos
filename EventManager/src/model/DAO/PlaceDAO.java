/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import Configurations.ConfigurationsMySQL;
import Database.DatabaseGeneric;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Interfaces.ImplemetsPlace;
import model.Place;

/**
 *
 * @author MAGNO
 */
public class PlaceDAO extends DatabaseGeneric implements ImplemetsPlace {

    public ArrayList<Place> list;

    public PlaceDAO() {
        super(new ConfigurationsMySQL(), "Place");
    }

    @Override
    public void insert(Place p) {
        Map<Object, Object> mapObj = new HashMap<>();

        mapObj.put("PlaceCampus", p.getPlaceCampus());
        mapObj.put("PlaceName", p.getPlaceName());

        this.genericInsert(mapObj);
    }

    @Override
    public void update(Place p) {
        Map<Object, Object> mapObj = new HashMap<>();
        Map<Object, Object> mapConditions = new HashMap<>();
        mapConditions.put("idPlace", p.getIdPlace());
        mapObj.put("PlaceCampus", p.getPlaceCampus());
        mapObj.put("PlaceName", p.getPlaceName());

        this.genericUpdate(mapObj, mapConditions);
    }

    @Override
    public void delete(int id) {
        Map<Object, Object> mapConditions = new HashMap<>();
        mapConditions.put("idPlace", id);
        this.genericDelete(mapConditions);
    }

    @Override
    public List<Place> getCampusByName(String name) {
        this.list = new ArrayList<>();
        try {
            ResultSet rs = this.getLike("name", name);
            while (rs.next()) {
                Place c = new Place();
                c.setIdPlace(rs.getInt(1));
                c.setPlaceName(rs.getString("PlaceName"));
                c.setPlaceCampus(rs.getString("PlaceCampus"));
                list.add(c);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao obter um campus: \n\n\n\n" + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Place> getAllCampus() {
    list = new ArrayList<>();
        ResultSet rs = this.getAll();
        try {
            while (rs.next()) {
                Place c = new Place();
               
                c.setIdPlace(rs.getInt("idPlace"));
                c.setPlaceName(rs.getString("PlaceName"));
                c.setPlaceCampus(rs.getString("PlaceCampus"));

                list.add(c);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um Local pelo nome: " + ex.getMessage());
        }
        return null; 
    }

    @Override
    public Place getOneCampus(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.   
    }

}
