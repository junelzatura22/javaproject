/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public interface RoomFunctions {
    
    
    //load room details
    public static String SHOW_ROOM = "SELECT * FROM room r";
    public ArrayList<Room> loadRoom();
    //Get the ID of room
    public static String GET_ROOM_ID = "SELECT * FROM room r where rname = 'key'";
    public int getRoomId(String roomName);
    
    
}
