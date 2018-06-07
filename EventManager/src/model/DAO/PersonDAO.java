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
import model.Interfaces.ImplemetsPerson;
import model.Person;

public class PersonDAO extends DatabaseGeneric implements ImplemetsPerson {

    public ArrayList<Person> list;

    public PersonDAO() {
        super(new ConfigurationsMySQL(), "person");
    }

    @Override
    public void insert(Person person) {
        Map<Object, Object> mapObj = new HashMap<>();

        mapObj.put("PersonName", person.getPersonName());
        mapObj.put("PersonPassword", person.getPersonPassword());
        mapObj.put("PersonCPF", person.getPersonCPF());

        this.genericInsert(mapObj);
    }

    @Override
    public void update(Person person) {
        Map<Object, Object> mapObj = new HashMap<>();
        Map<Object, Object> mapConditions = new HashMap<>();
        mapConditions.put("idPerson", person.getIdPerson());
        mapObj.put("PersonName", person.getPersonName());
        mapObj.put("PersonPassword", person.getPersonPassword());
        mapObj.put("PersonCPF", person.getPersonCPF());

        this.genericUpdate(mapObj, mapConditions);
    }

    @Override
    public void delete(int id) {
        Map<Object, Object> mapConditions = new HashMap<>();
        mapConditions.put("idPerson", id);
        this.genericDelete(mapConditions);
    }

    @Override
    public List<Person> getPersonByName(String name) {
        this.list = new ArrayList<>();
        try {
            ResultSet rs = this.getLike("name", name);
            while (rs.next()) {
                Person p = new Person();
                p.setIdPerson(rs.getInt(1));
                p.setPersonName(rs.getString("PersonName"));
                p.setPersonPassword(rs.getString("PersonPassword"));
                p.setPersonCPF(rs.getString("PersonCPF"));
                list.add(p);
            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Houve um erro ao obter uma pessoa: \n\n\n\n" + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Person> getAllPerson() {
        list = new ArrayList<>();
        ResultSet rs = this.getAll();
        try {
            while (rs.next()) {
                Person p = new Person();
                p.setIdPerson(rs.getInt("idPerson"));
                p.setPersonName(rs.getString("PersonName"));
                p.setPersonPassword(rs.getString("PersonPassword"));
                p.setPersonCPF(rs.getString("PersonCPF"));
                list.add(p);

            }
            return list;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar uma pessoa pelo nome: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Person getOnePerson(int id) {
        ResultSet rs = this.getOne(id);
        Person p = new Person();
        try {
            p.setIdPerson(rs.getInt(1));
            p.setPersonName(rs.getString("PersonName"));
            p.setPersonPassword(rs.getString("PersonPassword"));
            p.setPersonCPF(rs.getString("PersonCPF"));
            return p;
        } catch (SQLException ex) {
            System.out.println("Erro ao retornar uma pessoa pelo id: " + ex.getMessage());
        }
        return null;
    }
}
