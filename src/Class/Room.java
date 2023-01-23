/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import HELRER.Comp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author user
 */
public class Room extends DBCOnnection implements RoomFunctions {

    private int rid;
    private String rname;
    private String rinstalledlocation;
    private String remarks;
    private Vector data;

    //getter and setter
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getRinstalledlocation() {
        return rinstalledlocation;
    }

    public void setRinstalledlocation(String rinstalledlocation) {
        this.rinstalledlocation = rinstalledlocation;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Vector getData() {
        return data;
    }

    public void setData(Vector data) {
        this.data = data;
    }

    public Room(String name) {
        this.rname = name;
    }

    public Room() {

    }

    @Override
    public ArrayList<Room> loadRoom() {
        super.dbConnection();
        ArrayList<Room> roomList = new ArrayList();
        String sql = "select * from room";
        try {
            Room room;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                room = new Room(rs.getString("rname") + ", " + rs.getString("rinstalledlocation"));
                roomList.add(room);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
        return roomList;
    }

    @Override
    public int getRoomId(String roomName) {

        super.dbConnection();
        byte roomId = 0;
        try {
            String sql = RoomFunctions.GET_ROOM_ID.replace("key", roomName);
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                roomId = rs.getByte("rid");
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
        return roomId;

    }

}
