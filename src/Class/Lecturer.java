/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import HELRER.Comp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author user
 */
public class Lecturer extends DBCOnnection implements LecturerFunctions {

//    lec_id,lec_fname,lec_mname,lec_lname,lec_address,lec_email,lec_addedby,lec_dateAdded
    private String lec_id;
    private String lec_fname;
    private String lec_mname;
    private String lec_lname;
    private String lec_address;
    private String lec_email;
    private byte lec_addedby;
    private String lec_dateAdded;
    private Vector data;

    public String getLec_id() {
        return lec_id;
    }

    public void setLec_id(String lec_id) {
        this.lec_id = lec_id;
    }

    public String getLec_fname() {
        return lec_fname;
    }

    public void setLec_fname(String lec_fname) {
        this.lec_fname = lec_fname;
    }

    public String getLec_mname() {
        return lec_mname;
    }

    public void setLec_mname(String lec_mname) {
        this.lec_mname = lec_mname;
    }

    public String getLec_lname() {
        return lec_lname;
    }

    public void setLec_lname(String lec_lname) {
        this.lec_lname = lec_lname;
    }

    public String getLec_address() {
        return lec_address;
    }

    public void setLec_address(String lec_address) {
        this.lec_address = lec_address;
    }

    public String getLec_email() {
        return lec_email;
    }

    public void setLec_email(String lec_email) {
        this.lec_email = lec_email;
    }

    public byte getLec_addedby() {
        return lec_addedby;
    }

    public void setLec_addedby(byte lec_addedby) {
        this.lec_addedby = lec_addedby;
    }

    public String getLec_dateAdded() {
        return lec_dateAdded;
    }

    public void setLec_dateAdded(String lec_dateAdded) {
        this.lec_dateAdded = lec_dateAdded;
    }

    public Vector getData() {
        return data;
    }

    public void setData(Vector data) {
        this.data = data;
    }

    public Lecturer() {
    }

    public Lecturer(String lec_id, String lec_fname, String lec_mname, String lec_lname, String lec_address, String lec_email, byte lec_addedby, String lec_dateAdded) {
        this.lec_id = lec_id;
        this.lec_fname = lec_fname;
        this.lec_mname = lec_mname;
        this.lec_lname = lec_lname;
        this.lec_address = lec_address;
        this.lec_email = lec_email;
        this.lec_addedby = lec_addedby;
        this.lec_dateAdded = lec_dateAdded;
    }

    /*use constructor*/
    @Override
    public void insertLecturer() {//start
        super.dbConnection();
        String sql = LecturerFunctions._INSERT_LEC;
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, getLec_id());
            pst.setString(2, getLec_fname());
            pst.setString(3, getLec_mname());
            pst.setString(4, getLec_lname());
            pst.setString(5, getLec_address());
            pst.setString(6, getLec_email());
            pst.setByte(7, getLec_addedby());
            pst.setString(8, getLec_dateAdded());
            pst.executeUpdate();
            pst.close();
            Comp.message("Successfully added new teacher!");
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }//end

    //use getter and setter function
    @Override
    public void updateLecturer() {
        super.dbConnection();
        String sql = LecturerFunctions._UPDATE_LEC;
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, lec_fname);
            pst.setString(2, lec_mname);
            pst.setString(3, lec_lname);
            pst.setString(4, lec_address);
            pst.setString(5, lec_email);
            pst.setByte(6, lec_addedby);
            pst.setString(7, lec_id);
            pst.executeUpdate();
            pst.close();
            Comp.message("Successfully Changed!");
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }//end

    @Override
    public void showLecturers() {
        this.setData(new Vector());
        super.dbConnection();
        String sql = LecturerFunctions._SHOW_LECTURERS;

        //row counter
        byte rowCounter = 0;
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                rowCounter++;

                Vector row = new Vector();
                String _lec_id = rs.getString("lec_id");
                String _lec_fname = rs.getString("lec_fname");
                String _lec_mname = rs.getString("lec_mname");
                String _lec_lname = rs.getString("lec_lname");
                String _lec_address = rs.getString("lec_address");
                String _lec_email = rs.getString("lec_email");
                byte _lec_addedby = rs.getByte("lec_addedby");
                String _lec_dateAdded = rs.getString("lec_dateAdded");
                row.add(" " + rowCounter + ". ");//count the row
                row.add(_lec_id);
                row.add(_lec_fname);
                row.add(_lec_mname);
                row.add(_lec_lname);
                row.add(_lec_address);
                row.add(_lec_email);
                row.add(_lec_addedby);
                row.add(_lec_dateAdded);
                this.getData().add(row);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }

    @Override
    public void deleteLecturer() {

        super.dbConnection();
        String sql = LecturerFunctions._DELETE_LECTURE;
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, lec_id);
            pst.executeUpdate();
            pst.close();
            Comp.message("Successfully Deleted!");
        } catch (SQLException e) {
            Comp.message("Invalid!...\nNote: you can\'t delete once it is being used!\nPlease contact System Administrator!");
        }
    }

    @Override
    public void searchLecturer(String _searchKey) {
        this.setData(new Vector());
        super.dbConnection();
        String sql = LecturerFunctions._SEARCH_LECTURER.replace("key", _searchKey);

        //row counter
        byte rowCounter = 0;
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                rowCounter++;
                Vector row = new Vector();
                String _lec_id = rs.getString("lec_id");
                String _lec_fname = rs.getString("lec_fname");
                String _lec_mname = rs.getString("lec_mname");
                String _lec_lname = rs.getString("lec_lname");
                String _lec_address = rs.getString("lec_address");
                String _lec_email = rs.getString("lec_email");
                byte _lec_addedby = rs.getByte("lec_addedby");
                String _lec_dateAdded = rs.getString("lec_dateAdded");
                row.add(" " + rowCounter + ". ");//count the row
                row.add(_lec_id);
                row.add(_lec_fname);
                row.add(_lec_mname);
                row.add(_lec_lname);
                row.add(_lec_address);
                row.add(_lec_email);
                row.add(_lec_addedby);
                row.add(_lec_dateAdded);
                this.getData().add(row);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }

    }//end

    @Override
    public void showLecuterToLecture() {
        this.setData(new Vector());
        super.dbConnection();
        String sql = LecturerFunctions._SHOW_LECTURERS;
        //row counter
        byte rowCounter = 0;
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                rowCounter++;

                Vector row = new Vector();
                String _lec_id = rs.getString("lec_id");
                String _lec_fname = rs.getString("lec_fname");
                String _lec_mname = rs.getString("lec_mname");
                String _lec_lname = rs.getString("lec_lname");

                String details = _lec_id + ", " + _lec_fname + " " + _lec_mname + " " + _lec_lname;
                row.add(" " + rowCounter + ". " + details);//count the row
                this.getData().add(row);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }

    @Override
    public int getTotalStudent(String schoolYear, String lecturerID) {

        super.dbConnection();
        String sql = LecturerFunctions.GET_TOTALSTUDENTS.replace("YK", schoolYear).replace("MYTEACHER", lecturerID);
        int getTotalStudents = 0;
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                getTotalStudents = rs.getInt("totalStudent");
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
        return getTotalStudents;
    }

    @Override
    public int getTotalSubjects(String schoolYear, String lecturerID) {
        super.dbConnection();
        String sql = LecturerFunctions.GET_TOTALSUBJECTS.replace("YK", schoolYear).replace("MYTEACHER", lecturerID);
        int getTotalSubjects = 0;
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                getTotalSubjects++;
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
        return getTotalSubjects;
    }

    @Override
    public void showSubjectTough(String schoolYear, String lecturerID, String semester) {
        this.setData(new Vector());
        super.dbConnection();
        String sql = LecturerFunctions.SHOW_SUBJECTS_TEACH.replace("MYSCHOOLYEAR", schoolYear).replace("MYTEACHER", lecturerID).replace("MYSEMESTER", semester);
        //row counter
        byte rowCounter = 0;
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                rowCounter++;
                Vector row = new Vector();
                String _sub_code = rs.getString("sub_code");
                String _totalStudents = rs.getString("totalStudents");
                String details = rowCounter + ". Subject: " + _sub_code + "       Total Student(s): " + _totalStudents;
                row.add(details);//count the row
                this.getData().add(row);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }

    @Override
    public void teacherSummarry(String schoolYear, String lecturerID, String semester) {
        this.setData(new Vector());
        super.dbConnection();
        String sql = LecturerFunctions.SHOW_ALLSUMMARY_TEACH.replace("MYSCHOOLYEAR", schoolYear).replace("MYTEACHER", lecturerID).replace("MYSEMESTER", semester);
        //row counter
        byte rowCounter = 0;
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                rowCounter++;
                Vector row = new Vector();
                String _sub_code = rs.getString("sub_code");
                String _sub_description = rs.getString("sub_description");
                String time = rs.getString("timeStart") + "-" + rs.getString("timeend");
                String _dateSched = rs.getString("dateSched");
                String _sub_unit = rs.getString("sub_unit");
                String _rname = rs.getString("rname");
                String _totalStudents = rs.getString("totalStudents");
                String space = "     ";
                String details = rowCounter + ". Subject: " + _sub_code + space + "Desc: " + _sub_description + space
                        + "Time: " + time + space + "Schedule: " + _dateSched + space + "Unit: " + _sub_unit + space
                        + "Room: " + _rname + space
                        + "Total Student(s): " + _totalStudents;
                row.add(details);//count the row
                this.getData().add(row);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }

    }

}
