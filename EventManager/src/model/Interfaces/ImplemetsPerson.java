/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Interfaces;

import java.util.List;
import model.Campus;
import model.Person;

/**
 *
 * @author MAGNO
 */
public interface ImplemetsPerson {

    public void insert(Person person);

    public void update(Person person);

    public void delete(int id);

    public List<Person> getPersonByName(String name);

    public List<Person> getAllPerson();

    public Person getOnePerson(int id);
}
