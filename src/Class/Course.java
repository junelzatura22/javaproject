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
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author user
 */
public class Course extends DBCOnnection implements CourseFunctions {

    private byte courseid;
    private String c_name;
    private String c_description;
    private String c_department;
    private byte c_addedby;

    private Vector data;

    public byte getCourseid() {
        return courseid;
    }

    public void setCourseid(byte courseid) {
        this.courseid = courseid;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_description() {
        return c_description;
    }

    public void setC_description(String c_description) {
        this.c_description = c_description;
    }

    public String getC_department() {
        return c_department;
    }

    public void setC_department(String c_department) {
        this.c_department = c_department;
    }

    public byte getC_addedby() {
        return c_addedby;
    }

    public void setC_addedby(byte c_addedby) {
        this.c_addedby = c_addedby;
    }

    public Vector getData() {
        return data;
    }

    public void setData(Vector data) {
        this.data = data;
    }

    public Course() {

    }

    public Course(String c_name) {
        this.c_name = c_name;
    }

    /*Insert user data*/
    @Override
    public void insertCourse() {//Start
        super.dbConnection();
        try {
            String sql = CourseFunctions.INSERT_COURSE;
            pst = con.prepareStatement(sql);
            pst.setString(1, c_name);
            pst.setString(2, c_description);
            pst.setString(3, c_department);
            pst.setByte(4, c_addedby);
            pst.executeUpdate();
            pst.close();
            Comp.message("Successfully Added New Course!");
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }//End

    /*update course*/
    @Override
    public void updateCourse() {//Start
        super.dbConnection();
        try {
            String sql = CourseFunctions.UPDATE_COURSE;
            pst = con.prepareStatement(sql);
            pst.setString(1, c_name);
            pst.setString(2, c_description);
            pst.setString(3, c_department);
            pst.setByte(4, c_addedby);
            pst.setByte(5, courseid);
            pst.executeUpdate();
            pst.close();
            Comp.message("Course was successfully Updated!");
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }//ENd

    /*show courses by ascending*/
    @Override
    public void showCourse() {//Start
        this.setData(new Vector());
        super.dbConnection();
        byte rowCounter = 0;
        try {
            String sql = CourseFunctions.SHOW_COURSE;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                rowCounter++;//increment
                Vector row = new Vector();
                row.add(" " + rowCounter + ". ");
                row.add(rs.getByte("courseid"));
                row.add(rs.getString("c_name"));
                row.add(rs.getString("c_description"));
                row.add(rs.getString("c_department"));
                row.add(rs.getByte("c_addedby"));

                this.getData().add(row);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
            e.printStackTrace();
        }
    }//end

    /*show courses by searching course name*/
    @Override
    public void searchCourse(String _searchKey) {//Start 
        this.setData(new Vector());
        super.dbConnection();
        byte rowCounter = 0;
        try {
            String sql = CourseFunctions.SEARCH_COURSE.replace("key", _searchKey);
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                rowCounter++;//increment
                Vector row = new Vector();
                row.add(" " + rowCounter + ". ");
                row.add(rs.getByte("courseid"));
                row.add(rs.getString("c_name"));
                row.add(rs.getString("c_description"));
                row.add(rs.getString("c_department"));
                row.add(rs.getByte("c_addedby"));
                this.getData().add(row);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }

    }//end

    /*delete course - note it will not be deleted because it is in restrict not cascade*/
    @Override
    public void deleteCourse() {//starts
        super.dbConnection();
        try {
            String sql = CourseFunctions.DELETE_COURSE;
            pst = con.prepareStatement(sql);
            pst.setByte(1, courseid);
            pst.executeUpdate();
            pst.close();
            Comp.message("Course was successfully deleted!");
        } catch (SQLException e) {
           Comp.message("Invalid!...\nNote: you can\'t delete once it is being used!\nPlease contact System Administrator!");
        }
    }//end

    /*show courses by ascending*/
    @Override
    public ArrayList<Course> addListToList() {//Start
        super.dbConnection();
        ArrayList<Course> courseList = new ArrayList<>();
        try {
            Course cour;
            String sql = CourseFunctions.SHOW_COURSE;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String courseDesc = rs.getString("c_name") + "-" + rs.getString("c_department");
                cour = new Course(courseDesc);
                courseList.add(cour);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
            e.printStackTrace();
        }
        return courseList;
    }//end

    @Override
    public int getCourseId(String courseName) {//start
        super.dbConnection();
        byte courseID = 0;
        try {
            String sql = CourseFunctions.GET_SOURCE_ID.replace("key", courseName);
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                courseID = rs.getByte("courseid");
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
        return courseID;
    }//end

    //Get Course Summary
    @Override
    public ArrayList<Course> loadCourseSummary(String schoolYear, String semester) {

        super.dbConnection();
        byte rowCounter = 0;
        ArrayList<Course> courList = new ArrayList();
        Course course;
        try {
            String sql = CourseFunctions.LOAD_COURSESUM.replace("MYSEMESTER", semester).replace("MYSCHOOLYEAR", schoolYear);
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                rowCounter++;//increment

                String space = "  ", details;
                details = rowCounter + "." + space + "" + rs.getString("c_name")
                        + space + rs.getString("e_yearlevel")
                        + space + " Reg: " + rs.getString("registeredPerCourse");
                course = new Course(details);
                courList.add(course);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
        return courList;
    }

}
