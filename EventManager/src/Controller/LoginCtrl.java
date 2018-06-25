/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import model.DAO.PersonDAO;
import model.Person;

/**
 *
 * @author MAGNO
 */
public class LoginCtrl {
    
    public Person p;
    
    PersonDAO dao;
    
    public Person loginPerson(String email, String senha)
    {
        dao = new PersonDAO();
        p = new Person();
        p = dao.login(email);
        if(p == null)
        {
            System.out.println("nulo no ctrl");
            return null;
        }
        else
        {
            if(senha.equals(p.getPersonPassword()))
            {
                System.out.println(p.getPersonPassword());
                System.out.println(senha);
                System.out.println("person deu boom");
                return p;
            }
            else
            {
                System.out.println(p.getPersonPassword());
                System.out.println("senha errada");
                return null;
            }
        }       
    }
    
}
