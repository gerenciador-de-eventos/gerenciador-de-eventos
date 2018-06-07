/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configurations;

/**
 *
 * @author felipe
 */
public class ConfigurationsMySQL extends Configurations {

    public ConfigurationsMySQL() {
        super.TYPE = "mysql";
        super.HOST = "localhost";
        super.USER = "root";
        //super.PASS = ""; //magno
        super.PASS = "root"; //felipe
        super.PORT = "3306";
        super.BASE = "event_manager";
        super.DRIV = "com.mysql.jdbc.Driver";
    }

}
