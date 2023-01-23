/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import HELRER.Comp;
import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author user
 */
public class Student extends DBCOnnection implements StudentFunctions {

    private byte rowCounter;
    private String studentid;
    private String stud_fname;
    private String stud_mname;
    private String stud_lname;
    private String stud_bod;
    private String stud_address;
    private byte stud_addedby;
    private String stud_status;
    private String stud_dateAdded;

    public String getStud_dateAdded() {
        return stud_dateAdded;
    }

    public void setStud_dateAdded(String stud_dateAdded) {
        this.stud_dateAdded = stud_dateAdded;
    }

    private Vector data;

    //counter row
    public byte getRowCounter() {
        return rowCounter;
    }

    public void setRowCounter(byte rowCounter) {
        this.rowCounter = rowCounter;
    }

    //count row
    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getStud_fname() {
        return stud_fname;
    }

    public void setStud_fname(String stud_fname) {
        this.stud_fname = stud_fname;
    }

    public String getStud_mname() {
        return stud_mname;
    }

    public void setStud_mname(String stud_mname) {
        this.stud_mname = stud_mname;
    }

    public String getStud_lname() {
        return stud_lname;
    }

    public void setStud_lname(String stud_lname) {
        this.stud_lname = stud_lname;
    }

    public String getStud_bod() {
        return stud_bod;
    }

    public void setStud_bod(String stud_bod) {
        this.stud_bod = stud_bod;
    }

    public String getStud_address() {
        return stud_address;
    }

    public void setStud_address(String stud_address) {
        this.stud_address = stud_address;
    }

    public byte getStud_addedby() {
        return stud_addedby;
    }

    public void setStud_addedby(byte stud_addedby) {
        this.stud_addedby = stud_addedby;
    }

    public String getStud_status() {
        return stud_status;
    }

    public void setStud_status(String stud_status) {
        this.stud_status = stud_status;
    }

    public Vector getData() {
        return data;
    }

    public void setData(Vector data) {
        this.data = data;
    }

    public Student(byte rowCounter, String studentid, String stud_fname, String stud_mname, String stud_lname, String stud_bod, String stud_address, byte stud_addedby, String stud_status) {
        this.rowCounter = rowCounter;
        this.studentid = studentid;
        this.stud_fname = stud_fname;
        this.stud_mname = stud_mname;
        this.stud_lname = stud_lname;
        this.stud_bod = stud_bod;
        this.stud_address = stud_address;
        this.stud_addedby = stud_addedby;
        this.stud_status = stud_status;
    }

    public Student() {

    }

    /*insert student*/
    @Override
    public void insertStudent() {//Start
        super.dbConnection();
        String query = StudentFunctions.INSERT_STUDENT;
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, studentid);
            pst.setString(2, stud_fname);
            pst.setString(3, stud_mname);
            pst.setString(4, stud_lname);
            pst.setString(5, stud_bod);
            pst.setString(6, stud_address);
            pst.setByte(7, stud_addedby);
            pst.setString(8, stud_status);
            pst.setString(9, stud_dateAdded);
            pst.executeUpdate();
            pst.close();
            Comp.message("Successfully added new student!");
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }//end

    @Override
    public void updateStudent() {//Start
        super.dbConnection();
        String query = StudentFunctions.UPDATE_STUDENT;
        try {
            pst = con.prepareStatement(query);
            pst.setString(1, stud_fname);
            pst.setString(2, stud_mname);
            pst.setString(3, stud_lname);
            pst.setString(4, stud_bod);
            pst.setString(5, stud_address);
            pst.setByte(6, stud_addedby);
            pst.setString(7, stud_status);
            pst.setString(8, studentid);
            pst.executeUpdate();
            pst.close();
            Comp.message("Successfully updated student record!");
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }//end

    @Override
    public void searchStudent(String key) {//Start
        this.setData(new Vector());
        super.dbConnection();
        String query = StudentFunctions.SEARCH_STUDENT.replace("key", key);
        byte rowCounter = 0;
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                rowCounter++;
                Vector row = new Vector();
                row.add(" " + rowCounter + ". ");
                row.add(rs.getString("studentid"));
                row.add(rs.getString("stud_fname"));
                row.add(rs.getString("stud_mname"));
                row.add(rs.getString("stud_lname"));
                row.add(rs.getString("stud_bod"));
                row.add(rs.getString("stud_address"));
                row.add(rs.getByte("stud_addedby"));
                row.add(rs.getString("stud_status"));
                this.getData().add(row);
            }
            rs.close();
            pst.close();

        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }//end

    @Override
    public ArrayList<Student> showStudents() {

        super.dbConnection();
        ArrayList<Student> list = new ArrayList<>();

        String query = StudentFunctions.SHOW_STUDENT;
        byte count = 0;
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            Student student;
            while (rs.next()) {
                count++;
                student = new Student(count, rs.getString("studentid"), rs.getString("stud_fname"),
                        rs.getString("stud_mname"), rs.getString("stud_lname"), rs.getString("stud_bod"), rs.getString("stud_address"),
                        rs.getByte("stud_addedby"), rs.getString("stud_status"));
                list.add(student);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
        return list;
    }

    @Override
    public String getLastRegisteredStudent() {//Start function
        super.dbConnection();
        String query = StudentFunctions.GET_LAST_REGSTUDS;
        String lastRegStuds = "";
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            if (rs.next()) {
                lastRegStuds = rs.getString("studentid");
            } else {
                lastRegStuds = "NONE";
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
        return lastRegStuds;
    }//end function

    @Override
    public String getStudentStatus(String _studNumer) {
        super.dbConnection();
        String query = StudentFunctions.IS_STUDENTACTIVE.replace("MESTUDENT", _studNumer);
        String status = "";
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            if (rs.next()) {
                status = rs.getString("stud_status");
            } else {
                status = "";
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
        return status;
    }

}
