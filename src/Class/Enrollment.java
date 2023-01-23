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
public class Enrollment extends DBCOnnection implements EnrollmentFunctions {//Start class

    private int e_id;
    private int e_lecture;
    private int e_course;
    private String e_student;
    private String e_dateenroll;
    private byte e_addedby;
    private String e_yearLevel;
    private String e_semester;
    private String e_schoolyear;
    private int e_room;

    private Vector data;

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public int getE_lecture() {
        return e_lecture;
    }

    public void setE_lecture(int e_lecture) {
        this.e_lecture = e_lecture;
    }

    public int getE_course() {
        return e_course;
    }

    public void setE_course(int e_course) {
        this.e_course = e_course;
    }

    public String getE_student() {
        return e_student;
    }

    public void setE_student(String e_student) {
        this.e_student = e_student;
    }

    public String getE_dateenroll() {
        return e_dateenroll;
    }

    public void setE_dateenroll(String e_dateenroll) {
        this.e_dateenroll = e_dateenroll;
    }

    public byte getE_addedby() {
        return e_addedby;
    }

    public void setE_addedby(byte e_addedby) {
        this.e_addedby = e_addedby;
    }

    public String getE_yearLevel() {
        return e_yearLevel;
    }

    public void setE_yearLevel(String e_yearLevel) {
        this.e_yearLevel = e_yearLevel;
    }

    public String getE_semester() {
        return e_semester;
    }

    public void setE_semester(String e_semester) {
        this.e_semester = e_semester;
    }

    public String getE_schoolyear() {
        return e_schoolyear;
    }

    public void setE_schoolyear(String e_schoolyear) {
        this.e_schoolyear = e_schoolyear;
    }

    public int getE_room() {
        return e_room;
    }

    public void setE_room(int e_room) {
        this.e_room = e_room;
    }

    public Vector getData() {
        return data;
    }

    public void setData(Vector data) {
        this.data = data;
    }

    @Override
    public void insertEnrollment() {//Start
        super.dbConnection();
        String sql = EnrollmentFunctions.INSERT_ENROLLMENT;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, e_lecture);
            pst.setInt(2, e_course);
            pst.setString(3, e_student);
            pst.setString(4, e_dateenroll);
            pst.setByte(5, e_addedby);
            pst.setString(6, e_yearLevel);
            pst.setString(7, e_semester);
            pst.setString(8, e_schoolyear);
            pst.setInt(9, e_room);
            pst.executeUpdate();
            pst.close();
            Comp.message("Successfully Enrolled!");
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }//End

    @Override
    public void updateEnrollment() {//Start
        super.dbConnection();
        String sql = EnrollmentFunctions.UPDATE_ENROLLMENT;
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, e_lecture);
            pst.setInt(2, e_course);
            pst.setString(3, e_student);
            pst.setString(4, e_dateenroll);
            pst.setByte(5, e_addedby);
            pst.setString(6, e_yearLevel);
            pst.setString(7, e_semester);
            pst.setString(8, e_schoolyear);
            pst.setInt(9, e_room);
            pst.setInt(10, e_id);
            pst.executeUpdate();
            pst.close();
            Comp.message("Successfully Updated!");
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }//End

    @Override
    public void showEnrollment(String _schoolYear,String sem) {//Start
        this.setData(new Vector());
        super.dbConnection();
        String sql = EnrollmentFunctions.SHOW_ENROLLMENT.replace("YK", _schoolYear).replace("SEM", sem);
        byte countRow = 0;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                countRow++;
                Vector row = new Vector();
                row.add("  " + countRow + ". ");//0
                //ID's
                row.add(rs.getInt("e_id"));//1
                row.add(rs.getInt("e_lecture"));//2
                row.add(rs.getInt("e_course"));//3
                row.add(rs.getString("e_student"));//4
                //ID's
                row.add(rs.getString("dates"));//5
                row.add(rs.getString("c_name") + "-" + rs.getString("c_department"));//6
                row.add(rs.getString("studFullname"));//7
                row.add(rs.getString("teacher"));//8
                row.add(rs.getString("subjects"));//9
                row.add(rs.getString("schedule"));//10
                row.add(rs.getString("timestart"));//1
                row.add(rs.getString("timeend"));//12
                row.add(rs.getString("e_yearLevel"));//13
                row.add(rs.getString("e_semester"));//14
                row.add(rs.getString("e_schoolyear"));//15
                row.add(rs.getString("sub_unit"));//16
                row.add(rs.getString("sub_description"));//17
                //
                row.add(rs.getInt("e_room"));//18
                row.add(rs.getString("rname"));//19
                row.add(rs.getString("rinstalledlocation"));//20
                this.getData().add(row);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }//End

    @Override
    public void searchEnrollment(String _schoolYear, String key, String sem) {//Start
        this.setData(new Vector());
        super.dbConnection();
        String sql = EnrollmentFunctions.SEARCH_ENROLLMENT.replace("YK", _schoolYear).replace("JAVA", key).replace("SEM", sem);
        byte countRow = 0;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                countRow++;
                Vector row = new Vector();
                row.add("  " + countRow + ". ");//0
                //ID's
                row.add(rs.getInt("e_id"));//1
                row.add(rs.getInt("e_lecture"));//2
                row.add(rs.getInt("e_course"));//3
                row.add(rs.getString("e_student"));//4
                //ID's
                row.add(rs.getString("dates"));//5
                row.add(rs.getString("c_name") + "-" + rs.getString("c_department"));//6
                row.add(rs.getString("studFullname"));//7
                row.add(rs.getString("teacher"));//8
                row.add(rs.getString("subjects"));//9
                row.add(rs.getString("schedule"));//10
                row.add(rs.getString("timestart"));//1
                row.add(rs.getString("timeend"));//12
                row.add(rs.getString("e_yearLevel"));//13
                row.add(rs.getString("e_semester"));//14
                row.add(rs.getString("e_schoolyear"));//15
                row.add(rs.getString("sub_unit"));//16
                row.add(rs.getString("sub_description"));//17
                row.add(rs.getInt("e_room"));//18
                row.add(rs.getString("rname"));//19
                row.add(rs.getString("rinstalledlocation"));//20
                this.getData().add(row);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }//End

    @Override
    public void enrolleesSubject(String _schoolYear, String sem) {//start function
        this.setData(new Vector());
        super.dbConnection();
        String sql = EnrollmentFunctions.GEN_LOAD_ENROLLESS.replace("YK", _schoolYear).replace("SEM", sem);
        byte countRow = 0;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                countRow++;
                Vector row = new Vector();

                String data = countRow + ". " + rs.getString("c_name") + ": " + rs.getString("subjects") + ", " + rs.getString("teacher") + " Reg{" + rs.getString("totalStudent") + "}";
                row.add(data);//   
                this.getData().add(row);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }//end function

    @Override
    public void enrolleesSearch(String schoolYear, String key, String sem) {
        this.setData(new Vector());
        super.dbConnection();
        String sql = EnrollmentFunctions.GENSEARCH_LOAD_ENROLLESS.replace("YK", schoolYear).replace("JAVA", key).replace("SEM", sem);
        byte countRow = 0;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                countRow++;
                Vector row = new Vector();
                String data = countRow + ". " + rs.getString("c_name") + ": " + rs.getString("subjects") + ", " + rs.getString("teacher") + " Reg{" + rs.getString("totalStudent") + "}";
                row.add(data);//   
                this.getData().add(row);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }

    @Override
    public void genStudentFromCourse(String _schoolyear,String sem) {//start
        this.setData(new Vector());
        super.dbConnection();
        String sql = EnrollmentFunctions.GEN_REGISTERED_COURSE.replace("YK", _schoolyear).replace("SEM", sem);
        byte countRow = 0;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                countRow++;
                Vector row = new Vector();
                String data = countRow + ". " + rs.getString("coursname") + " Total Student(s): {" + rs.getString("totalStudent") + "}";
                row.add(data);//   
                this.getData().add(row);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }

    }//end

    @Override
    public void genSearchStudentFromCourse(String _schoolyear, String key,String sem) {
        this.setData(new Vector());
        super.dbConnection();
        String sql = EnrollmentFunctions.GENSEARCH_REGISTERED_COURSE.replace("YK", _schoolyear).replace("JAVA", key).replace("SEM", sem);
        byte countRow = 0;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                countRow++;
                Vector row = new Vector();
                String data = countRow + ". " + rs.getString("coursname") + " Total Student(s): {" + rs.getString("totalStudent") + "}";
                row.add(data);//   
                this.getData().add(row);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        } 
    }

}//end class
