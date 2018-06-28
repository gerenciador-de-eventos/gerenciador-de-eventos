/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kamil
 */
public class Conexao {
    
    private static final String URL      = "jdbc:mysql://localhost:3306/event_manager";
    private static final String DRIVER   = "com.mysql.jdbc.Driver";
    private static final String USER     = "root";
    private static final String PASS = "";
    
    public static Connection getConnection(){
        try{
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
                        
        }catch(ClassNotFoundException | SQLException ex){
            throw new RuntimeException("Erro na conexao"+ex);
            
        }
    }
    
}
