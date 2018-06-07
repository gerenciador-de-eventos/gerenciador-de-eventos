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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Campus campus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
         }
            catch (SQLException ex){
            System.out.println("Houve um erro ao obter um pokemon: \n\n\n\n" + ex.getMessage());
             }
        return null;
    }
    

    @Override
    public List<Campus> getAllCampus() {
        list = new ArrayList<>();
        ResultSet rs = this.getAll();
        try {
            while(rs.next()){
                Campus c = new Campus();
                c.setIdCampus(rs.getInt("idCampus"));
                c.setCampusName(rs.getString("CampusName"));
                c.setCampusFantasyName(rs.getString("CampusFantasyName"));
                
                

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


