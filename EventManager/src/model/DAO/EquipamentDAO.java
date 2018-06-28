/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import Configurations.ConfigurationsMySQL;
import model.Interfaces.ImplementsEquipament;
import Database.DatabaseGeneric;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Equipaments;
import model.Person;
import model.Type;

/**
 *
 * @author felipe
 */
public class EquipamentDAO extends DatabaseGeneric implements ImplementsEquipament {

    public ArrayList<Equipaments> list;

    public EquipamentDAO() {
        super(new ConfigurationsMySQL(), "equipaments");
    }

    @Override
    public void insert(Equipaments equipaments) {
        Map<Object, Object> mapObj = new HashMap<>();

        mapObj.put("EquipamentsName", equipaments.getEquipamentsName());
        mapObj.put("EquipamentsType", equipaments.getEquipamentsType().getIdType());
        // mapObj.put("idEquipament", equipaments.getEventequipamentCollection());
        //    mapObj.put("idEquipaments", equipaments.getIdEquipaments());

        this.genericInsert(mapObj);
    }

    @Override
    public void update(Equipaments equipaments) {
        Map<Object, Object> mapObj = new HashMap<>();
        Map<Object, Object> mapConditions = new HashMap<>();
        mapConditions.put("idEquipaments", equipaments.getIdEquipaments());
        mapObj.put("EquipamentsName", equipaments.getEquipamentsName());
        mapObj.put("EquipamentsType", equipaments.getEquipamentsType().getIdType());
        //      mapObj.put("idEquipament", equipaments.getEventequipamentCollection());

        this.genericUpdate(mapObj, mapConditions);
    }

    @Override
    public void delete(int id) {
        Map<Object, Object> mapConditions = new HashMap<>();
        mapConditions.put("idEquipaments", id);
        this.genericDelete(mapConditions);
    }

    @Override
    public List<Equipaments> getEquipamentsByName(String name) {
        this.list = new ArrayList<>();
        try {
            ResultSet rs = this.getLike("name", name);
            while (rs.next()) {
                Equipaments eq = new Equipaments();
                eq.setIdEquipaments(rs.getInt(1));
                eq.setEquipamentsName(rs.getString("EquipamentsName"));
                Type t = new Type();
                t.setIdType(rs.getInt("EquipamentsType"));
                eq.setEquipamentsType(t);

                list.add(eq);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao obter um equipamento: \n\n\n\n" + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Equipaments> getAllEquipaments() {
        list = new ArrayList<>();
        ResultSet rs = this.getAll();
        try {
            while (rs.next()) {
                Equipaments eq = new Equipaments();
                eq.setIdEquipaments(rs.getInt("idEquipaments"));
                eq.setEquipamentsName(rs.getString("EquipamentsName"));
                Type t = new Type();
                t.setIdType(rs.getInt("EquipamentsType"));
                eq.setEquipamentsType(t);

                list.add(eq);

            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar uma pessoa pelo nome: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Equipaments getOneEquipaments(int id) {
        ResultSet rs = this.getOne(id);
        Equipaments eq = new Equipaments();
        try {
            eq.setIdEquipaments(rs.getInt(1));
            eq.setEquipamentsName(rs.getString("EquipamentsName"));
           Type t = new Type();
                t.setIdType(rs.getInt("EquipamentsType"));
                eq.setEquipamentsType(t);

            return eq;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um equipamento pelo id: " + ex.getMessage());
        }
        return null;
    }
}
