/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import HELRER.Comp;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author user
 */
public class Subjects extends DBCOnnection implements SubjectsFunctions {

    //sub_code,sub_description,sub_unit,sub_addedby,sub_dateAdded,sub_department
    private String sub_code;
    private String sub_description;
    private String sub_unit;
    private byte sub_addedby;
    private String sub_dateAdded;
    private String sub_department;
    private Vector data;

    public String getSub_code() {
        return sub_code;
    }

    public void setSub_code(String sub_code) {
        this.sub_code = sub_code;
    }

    public String getSub_description() {
        return sub_description;
    }

    public void setSub_description(String sub_description) {
        this.sub_description = sub_description;
    }

    public String getSub_unit() {
        return sub_unit;
    }

    public void setSub_unit(String sub_unit) {
        this.sub_unit = sub_unit;
    }

    public byte getSub_addedby() {
        return sub_addedby;
    }

    public void setSub_addedby(byte sub_addedby) {
        this.sub_addedby = sub_addedby;
    }

    public String getSub_dateAdded() {
        return sub_dateAdded;
    }

    public void setSub_dateAdded(String sub_dateAdded) {
        this.sub_dateAdded = sub_dateAdded;
    }

    public Vector getData() {
        return data;
    }

    public void setData(Vector data) {
        this.data = data;
    }

    public String getSub_department() {
        return sub_department;
    }

    public void setSub_department(String sub_department) {
        this.sub_department = sub_department;
    }

    /*Insert Subject*/
    @Override
    public void insertSubjects() {//start
        super.dbConnection();
        String sql = SubjectsFunctions._INSERT_SUBJECT_;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, sub_code);
            pst.setString(2, sub_description);
            pst.setString(3, sub_unit);
            pst.setByte(4, sub_addedby);
            pst.setString(5, sub_dateAdded);
            pst.setString(6, sub_department);
            pst.executeUpdate();
            pst.close();
            Comp.message("Successfully Added Subject!");
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }//end

    /*Update subject*/
    @Override
    public void updateSubjects() {//Start
        super.dbConnection();
        String sql = SubjectsFunctions._UPDATE_SUBJECT_;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, sub_description);
            pst.setString(2, sub_unit);
            pst.setString(3, sub_dateAdded);
            pst.setString(4, sub_department);
            pst.setString(5, sub_code);
            pst.executeUpdate();
            pst.close();
            Comp.message("Successfully updated!");
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }//end

    /*show subjects*/
    @Override
    public void showSubjects() {//start
        super.dbConnection();
        this.setData(new Vector());
        String sql = SubjectsFunctions._SHOW_SUBJECT_;
        byte rowCounter = 0;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                rowCounter++;
                Vector row = new Vector();
                row.add(" " + rowCounter + ". ");//0
                row.add(rs.getString("sub_code"));//1
                row.add(rs.getString("sub_description"));//2
                row.add(rs.getString("sub_unit"));//3
                row.add(rs.getString("sub_dateAdded"));//4
                row.add(rs.getString("sub_department"));//5      
                row.add(rs.getByte("sub_addedby"));//6
                this.getData().add(row);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }//end

    @Override
    public void searchSubjects(String _searchKey) {//Start
        super.dbConnection();
        this.setData(new Vector());
        String sql = SubjectsFunctions._SEARCH_SUBJECT_.replace("key", _searchKey);
        byte rowCounter = 0;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                rowCounter++;
                Vector row = new Vector();
                row.add(" " + rowCounter + ". ");//0
                row.add(rs.getString("sub_code"));//1
                row.add(rs.getString("sub_description"));//2
                row.add(rs.getString("sub_unit"));//3
                row.add(rs.getString("sub_dateAdded"));//4
                row.add(rs.getString("sub_department"));//5      
                row.add(rs.getByte("sub_addedby"));//6
                this.getData().add(row);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }//end

    /*delete*/
    @Override
    public void deleteSubjects() {//start
        super.dbConnection();
        String sql = SubjectsFunctions._DELETE_SUBJECT_;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, sub_code);
            pst.executeUpdate();
            pst.close();
            Comp.message("Successfully deleted!");
        } catch (SQLException e) {
           Comp.message("Invalid!...\nNote: you can\'t delete once it is being used!\nPlease contact System Administrator!");
        }
    }//end

    @Override
    public void showSubjectByDept(String _searchKey) {
        super.dbConnection();
        this.setData(new Vector());
        String sql = SubjectsFunctions._SHOW_SUBJECT_SEARCH_.replace("key", _searchKey);
        byte rowCounter = 0;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                rowCounter++;
                Vector row = new Vector();
                row.add(" " + rowCounter + ". " +  rs.getString("sub_code") + ", " + rs.getString("sub_description"));//0
                this.getData().add(row);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }
    @Override
    public void totalStudentPerSubject(String schoolYear, String semester) {//start function
        this.setData(new Vector());
        super.dbConnection();
        String sql = SubjectsFunctions.GEN_LOAD_SUBJECTS.replace("YK", schoolYear).replace("MYSEMESTER", semester);
        byte countRow = 0;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                countRow++;
                Vector row = new Vector();

                String data = countRow + ". " + rs.getString("subjects") + ", " + " Reg{" + rs.getString("totalStudent") + "}";
                row.add(data);//   
                this.getData().add(row);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
    }//end function
}
