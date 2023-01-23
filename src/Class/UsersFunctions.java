/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author user
 */
public interface UsersFunctions {
    
    /*Check user if registered*/
    public boolean isUserRegister(String _username, String password);
    /*get user id if registerd*/
    public void getUserInfo(byte _userId);
 

   //Query
    public static final String _ISUSERREG_QUERY = "SELECT * FROM users u where username = '@@@' and password = '***'";
    public static final String _LOADDATABYUSER_QUERY = "SELECT * FROM users u where id = @@@";
    
}
