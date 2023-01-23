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
public interface CourseFunctions {

    public void insertCourse();

    public void updateCourse();

    public void showCourse();

    public void searchCourse(String _searchKey);

    public void deleteCourse();
//    private String c_name;
//    private String c_description;
//    private String c_department;
//    private byte c_addedby;
    public String INSERT_COURSE = "insert into course(c_name,c_description,c_department,c_addedby) values(?,?,?,?)";
    public String UPDATE_COURSE = "update course set c_name=?,c_description=?,c_department=?,c_addedby=? where courseid = ?";
    public String SHOW_COURSE = "select * from course order by c_name asc";
    public String SEARCH_COURSE = "select * from course where c_name like '%key%' order by c_name asc";

    public String DELETE_COURSE = "delete from course where courseid = ?";

    //load the course to jcombo 
    public ArrayList<Course> addListToList();
    public String GET_SOURCE_ID = "select courseid from course where c_name = 'key'";

    public int getCourseId(String courseName);

    //Course summary registration
    public ArrayList<Course> loadCourseSummary(String schoolYear, String semester);
    public static String LOAD_COURSESUM = "SELECT c_name, e_yearlevel,count(c_name) as registeredPerCourse\n"
            + "FROM enrollment e,lecture l,lecturer lec,course c,student stud, subjects subs,room ro\n"
            + "where e.e_lecture = l.lectureid\n"
            + "and subs.sub_code = l.subject\n"
            + "and lec.lec_id = l.lecturer\n"
            + "and c.courseid = e.e_course\n"
            + "and ro.rid = e.e_room\n"
            + "and stud.studentid = e.e_student and e.e_schoolyear = 'MYSCHOOLYEAR'\n"
            + "and e.e_semester = 'MYSEMESTER'\n"
            + "group by c_name,e_yearlevel order by c_name asc";

}
