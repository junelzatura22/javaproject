/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import HELRER.Comp;
import java.util.Vector;

/**
 *
 * @author user
 */
public class Lecture extends DBCOnnection implements LectureFunctions {

    private int lectureid;
    private String lecturer;
    private String subject;
    private String time;
    private String timeend;
    private String date;
    private byte addedby;
    private String dateadded;
    private Vector data;

    public int getLectureid() {
        return lectureid;
    }

    public void setLectureid(int lectureid) {
        this.lectureid = lectureid;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public byte getAddedby() {
        return addedby;
    }

    public void setAddedby(byte addedby) {
        this.addedby = addedby;
    }

    public String getDateadded() {
        return dateadded;
    }

    public void setDateadded(String dateadded) {
        this.dateadded = dateadded;
    }

    public Vector getData() {
        return data;
    }

    public void setData(Vector data) {
        this.data = data;
    }

    public String getTimeend() {
        return timeend;
    }

    public void setTimeend(String timeend) {
        this.timeend = timeend;
    }

    /*Insert*/
    @Override
    public void insertLecture() {//Start function
        super.dbConnection();
        String sql = Lecture.INSERT_LECTURE;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, lecturer);
            pst.setString(2, subject);
            pst.setString(3, time);
            pst.setString(4, date);
            pst.setByte(5, addedby);
            pst.setString(6, dateadded);
            pst.setString(7, timeend);
            pst.executeUpdate();
            pst.close();
            Comp.message("Successfully Added Lecture Schedule!");
        } catch (Exception e) {
            Comp.message(e.getMessage());
        }
    }//End function

    /*Update*/
    @Override
    public void updateLecture() {//Start
        super.dbConnection();
        String sql = Lecture.UPDATE_LECTURE;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, lecturer);
            pst.setString(2, subject);
            pst.setString(3, time);
            pst.setString(4, date);
            pst.setByte(5, addedby);
            pst.setString(6, timeend);
            pst.setInt(7, lectureid);
            pst.executeUpdate();
            pst.close();
            Comp.message("Successfully Added Lecture Schedule!");
        } catch (Exception e) {
            Comp.message(e.getMessage());
        }
    }//End

    /*show lecture*/
    @Override
    public void showLecture() {//Start function
        super.dbConnection();
        this.setData(new Vector());
        byte rowCounter = 0;
        String sql = Lecture.SHOW_LECTURE;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                rowCounter++;
                Vector row = new Vector();
                row.add(" " + rowCounter + ". ");
                row.add(rs.getString("sub_code"));
                row.add(rs.getString("sub_description"));
                row.add(rs.getString("sub_unit"));
                row.add(rs.getString("fullname"));
                row.add(rs.getByte("lectureid"));
                row.add(rs.getString("time"));
                row.add(rs.getString("timeend"));
                row.add(rs.getString("date"));
                row.add(rs.getString("dateadded"));
                row.add(rs.getString("lec_id"));

                this.getData().add(row);
            }
            pst.close();
            rs.close();
        } catch (Exception e) {
            Comp.message(e.getMessage());
        }
    }//end function

    /*Function*/
    @Override
    public void searchLecture(String _searchKey) {//start function
        super.dbConnection();
        this.setData(new Vector());
        byte rowCounter = 0;
        String sql = Lecture.SEARCH_LECTURE.replace("key", _searchKey);
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                rowCounter++;
                Vector row = new Vector();
                row.add(" " + rowCounter + ". ");
                row.add(rs.getString("sub_code"));
                row.add(rs.getString("sub_description"));
                row.add(rs.getString("sub_unit"));
                row.add(rs.getString("fullname"));
                row.add(rs.getByte("lectureid"));
                row.add(rs.getString("time"));
                row.add(rs.getString("timeend"));
                row.add(rs.getString("date"));
                row.add(rs.getString("dateadded"));
                row.add(rs.getString("lec_id"));

                this.getData().add(row);
            }
            pst.close();
            rs.close();
        } catch (Exception e) {
            Comp.message(e.getMessage());
        }
    }//end function

    /*Delete*/
    @Override
    public void deleteLecture() {//Start
        super.dbConnection();
        String sql = Lecture.DELETE_LECTURE;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, lectureid);
            pst.executeUpdate();
            pst.close();
            Comp.message("Successfully Deleted!");
        } catch (Exception e) {
            Comp.message("Invalid!...\nNote: you can\'t delete once it is being used!\nPlease contact System Administrator!");
        }
    }//End function

    


}
