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
public interface StudentFunctions {

    //insert
    public void insertStudent();
    public static String INSERT_STUDENT = "insert into student(studentid,stud_fname,stud_mname,stud_lname,stud_bod,stud_address,stud_addedby,stud_status,stud_dateAdded) values (?,?,?,?,?,?,?,?,?)";

    //end insert
    //update
    public void updateStudent();
    public static String UPDATE_STUDENT = "update student set stud_fname = ?,stud_mname= ?,stud_lname=?,"
            + "stud_bod=?,stud_address=?,stud_addedby=?,stud_status=? where studentid = ?";

    //end update
   
    //show
    //show using arraylist
    public ArrayList<Student> showStudents();

 
    public static String SHOW_STUDENT = "select * from student order by stud_lname asc limit 100";

    //end show
    //search
    public void searchStudent(String key);
    public static String SEARCH_STUDENT = "select * from student where concat(studentid,' ',stud_fname,' ',stud_lname) like '%key%' order by stud_lname asc limit 100";
    //end searcj
    //Start get the last registration
    public String getLastRegisteredStudent();
    public static String GET_LAST_REGSTUDS = "select studentid from student order by stud_dateAdded desc";
    //Start get the last registration
    
    public String getStudentStatus(String studentNum);
    public String IS_STUDENTACTIVE = "select stud_status from student where studentid = 'MESTUDENT'";

}//End class
