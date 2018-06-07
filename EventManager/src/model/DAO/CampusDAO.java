package model.DAO;

import Configurations.ConfigurationsMySQL;
import Database.DatabaseGeneric;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Campus;
import model.Interfaces.ImplemetsCampus;

public class CampusDAO extends DatabaseGeneric implements ImplemetsCampus {

    public ArrayList<Campus> list;

    public CampusDAO() {
        super(new ConfigurationsMySQL(), "Campus");
    }

    @Override
    public void insert(Campus campus) {
        Map<Object, Object> mapObj = new HashMap<>();

        mapObj.put("CampusName", campus.getCampusName());
        mapObj.put("CampusFantasyName", campus.getCampusFantasyName());
        mapObj.put("CampusCity", campus.getCampusCity());

        this.genericInsert(mapObj);
    }

    @Override
    public void update(Campus campus) {
        Map<Object, Object> mapObj = new HashMap<>();
        Map<Object, Object> mapConditions = new HashMap<>();
        mapConditions.put("idCampus", campus.getIdCampus());
        mapObj.put("CampusName", campus.getCampusName());
        mapObj.put("CampusFantasyName", campus.getCampusFantasyName());
        mapObj.put("CampusCity", campus.getCampusCity());

        this.genericUpdate(mapObj, mapConditions);
    }

    @Override
    public void delete(int id) {
        Map<Object, Object> mapConditions = new HashMap<>();
        mapConditions.put("idCampus", id);
        this.genericDelete(mapConditions);
    }

    @Override
    public List<Campus> getCampusByName(String name) {
        this.list = new ArrayList<>();
        try {
            ResultSet rs = this.getLike("name", name);
            while (rs.next()) {
                Campus c = new Campus();
                c.setIdCampus(rs.getInt(1));
                c.setCampusName(rs.getString("CampusName"));
                c.setCampusFantasyName(rs.getString("CampusFantasyName"));
                c.setCampusCity(rs.getString("CampusCity"));
                list.add(c);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao obter um campus: \n\n\n\n" + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Campus> getAllCampus() {
        list = new ArrayList<>();
        ResultSet rs = this.getAll();
        try {
            while (rs.next()) {
                Campus c = new Campus();
                c.setIdCampus(rs.getInt("idCampus"));
                c.setCampusName(rs.getString("CampusName"));
                c.setCampusFantasyName(rs.getString("CampusFantasyName"));
                c.setCampusCity(rs.getString("CampusCity"));

                list.add(c);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um campus pelo nome: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Campus getOneCampus(int id) {
        ResultSet rs = this.getOne(id);
        Campus c = new Campus();
        try {
            c.setIdCampus(rs.getInt(1));

            c.setCampusName(rs.getString("CampusName"));
            c.setCampusFantasyName(rs.getString("CampusFantasyName"));
            c.setCampusCity(rs.getString("CampusCity"));
            return c;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar um pokemon pelo id: " + ex.getMessage());
        }
        return null;
    }
}
