/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author user
 */
public interface LecturerFunctions {

    public void insertLecturer();

    public void updateLecturer();

    public void showLecturers();

    public void searchLecturer(String _searchKey);

    public void deleteLecturer();

    //show result to lecture
    public void showLecuterToLecture();

    public static String _INSERT_LEC = "insert into lecturer(lec_id,lec_fname,lec_mname,lec_lname,lec_address,"
            + "lec_email,lec_addedby,lec_dateAdded) values(?,?,?,?,?,?,?,?)";
    public static String _UPDATE_LEC = "update lecturer set lec_fname= ?,lec_mname = ?,lec_lname = ?,lec_address =?,"
            + "lec_email = ?,lec_addedby = ? where lec_id = ?";

    public static String _SHOW_LECTURERS = "select * from lecturer order by lec_dateAdded desc";
    public static String _DELETE_LECTURE = "delete from lecturer where lec_id = ?";
    public static String _SEARCH_LECTURER = "select * from lecturer where concat(lec_fname,' ',lec_lname) like '%key%'";

    //For Reporting function
    public int getTotalStudent(String schoolYear, String lecturerID);
    public static String GET_TOTALSTUDENTS = "SELECT lec_id,count(lec_id) as totalStudent\n"
            + "FROM enrollment e,lecture l,lecturer lec,course c,student stud, subjects subs,room ro\n"
            + "where e.e_lecture = l.lectureid\n"
            + "and subs.sub_code = l.subject\n"
            + "and lec.lec_id = l.lecturer\n"
            + "and c.courseid = e.e_course\n"
            + "and ro.rid = e.e_room\n"
            + "and stud.studentid = e.e_student and e.e_schoolyear = 'YK' and lec_id = 'MYTEACHER'\n"
            + "group by lec_id order by c_name asc";

    //count all total subjects handled
    public int getTotalSubjects(String schoolYear, String lecturerID);
    public static String GET_TOTALSUBJECTS = "SELECT lec_id,count(lec_id) as totalSubjects\n"
            + "FROM enrollment e,lecture l,lecturer lec,course c,student stud, subjects subs,room ro\n"
            + "where e.e_lecture = l.lectureid\n"
            + "and subs.sub_code = l.subject\n"
            + "and lec.lec_id = l.lecturer\n"
            + "and c.courseid = e.e_course\n"
            + "and ro.rid = e.e_room\n"
            + "and stud.studentid = e.e_student and e.e_schoolyear = 'YK' and lec_id = 'MYTEACHER'\n"
            + "group by lec_id,lectureid order by c_name asc";

    //show subjects tough by lecturer
    public void showSubjectTough(String schoolYear, String lecturerID, String semester);
    public static String SHOW_SUBJECTS_TEACH = "   SELECT sub_code,count(lec_id) as totalStudents\n"
            + "            FROM enrollment e,lecture l,lecturer lec,course c,student stud, subjects subs,room ro\n"
            + "            where e.e_lecture = l.lectureid\n"
            + "            and subs.sub_code = l.subject\n"
            + "            and lec.lec_id = l.lecturer\n"
            + "            and c.courseid = e.e_course\n"
            + "            and ro.rid = e.e_room\n"
            + "            and stud.studentid = e.e_student and e.e_schoolyear = 'MYSCHOOLYEAR' and lec_id = 'MYTEACHER' \n"
            + "            and e.e_semester = 'MYSEMESTER'\n"
            + "            group by lec_id,lectureid order by c_name asc";
    //show all farmer summary
    public void teacherSummarry(String schoolYear, String lecturerID, String semester);
    public static String SHOW_ALLSUMMARY_TEACH = "SELECT sub_code, sub_description,time as timeStart,timeend, date as dateSched, sub_unit,rname,count(lec_id) as totalStudents\n"
            + " FROM enrollment e,lecture l,lecturer lec,course c,student stud, subjects subs,room ro \n"
            + " where e.e_lecture = l.lectureid\n"
            + " and subs.sub_code = l.subject\n"
            + " and lec.lec_id = l.lecturer\n"
            + " and c.courseid = e.e_course\n"
            + " and ro.rid = e.e_room\n"
            + " and stud.studentid = e.e_student and e.e_schoolyear = 'MYSCHOOLYEAR' and lec_id = 'MYTEACHER'\n"
            + " and e.e_semester = 'MYSEMESTER'\n"
            + " group by lec_id,lectureid order by c_name asc";

}//end class
