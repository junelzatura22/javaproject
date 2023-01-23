/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class Users extends DBCOnnection implements UsersFunctions {

    private byte id;
    private String Name;
    private String Position;
    private String username;
    private String password;
    private String image;

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    //Getter and Setter
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean isUserRegister(String _username, String _password) {
        super.dbConnection();
        boolean isRegester = false;
        String sql = UsersFunctions._ISUSERREG_QUERY.replace("@@@", _username).replace("***", _password);
        //Or you can do it like this
//        String sql = "SELECT * FROM users u where username = '"+_username+"' and password = '"+_password+"'";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            isRegester = rs.next();
            //if verified, then load setter id
            this.setId(rs.getByte("id"));

            pst.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(sql + "\n" + e.getMessage());
        }
        return isRegester;
    }

    @Override
    public void getUserInfo(byte _userId) {//start
        super.dbConnection();
        String sql = UsersFunctions._LOADDATABYUSER_QUERY.replace("@@@", String.valueOf(_userId));
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                this.setId(rs.getByte("id"));
                this.setName(rs.getString("Name"));
                this.setPosition(rs.getString("Position"));
                this.setUsername(rs.getString("username"));
                this.setPassword(rs.getString("password"));
                this.setImage(rs.getString("image"));
            }

            pst.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(sql + "\n" + e.getMessage());
        }
    }//end

}
