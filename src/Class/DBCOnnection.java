/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author user
 */
public class DBCOnnection {//start class

    public Connection con;
    public PreparedStatement pst = null;
    public ResultSet rs = null;

    //Setter and Getter
    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    //Variables
    private static final String _CONURL_ = "jdbc:mysql://localhost/minienrollment";
    private static final String _DRIVER_ = "com.mysql.cj.jdbc.Driver";

    //create connection
    public void dbConnection() {//Starty
        //sync connection
        synchronized (_CONURL_) {//start
            try {
                Class.forName(_DRIVER_);//driver
                setCon(DriverManager.getConnection(_CONURL_, "root", ""));
            } catch (Exception e) {
            }
        }//end
    }//end

}//end class
