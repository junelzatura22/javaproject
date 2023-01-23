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
public interface SubjectsFunctions {

    public void insertSubjects();

    public void updateSubjects();

    public void showSubjects();

    public void searchSubjects(String _searchKey);

    public void deleteSubjects();

    public void showSubjectByDept(String _searchKey);
    //load to list

    public static String _INSERT_SUBJECT_ = "insert into subjects(sub_code,sub_description,sub_unit,sub_addedby,sub_dateAdded,sub_department) values(?,?,?,?,?,?)";
    public static String _UPDATE_SUBJECT_ = "update subjects set sub_description = ?,sub_unit=?,sub_addedby=?,sub_department = ?"
            + " where sub_code = ?";
    public static String _SHOW_SUBJECT_ = "select * from subjects order by sub_description asc";
    public static String _SEARCH_SUBJECT_ = "select * from subjects where sub_description like '%key%' order by sub_description asc";

    public static String _DELETE_SUBJECT_ = "delete from subjects where sub_code = ?";
    public static String _SHOW_SUBJECT_SEARCH_ = "SELECT * FROM subjects s where sub_department = 'key'";
    //get total subject
    public void totalStudentPerSubject(String inclusiverYear, String semester);
      public static String GEN_LOAD_SUBJECTS = "SELECT concat(subject,' (',time,'-',timeend,', ',date,') ') as subjects,\n"
            + "count(c_description) as totalStudent\n"
            + "\n"
            + "\n"
            + "FROM enrollment e,lecture l,lecturer lec,course c,student stud, subjects subs,room ro\n"
            + "\n"
            + "where e.e_lecture = l.lectureid\n"
            + "and subs.sub_code = l.subject\n"
            + "and lec.lec_id = l.lecturer\n"
            + "and c.courseid = e.e_course\n"
            + "and ro.rid = e.e_room\n"
            + "\n"
            + "and stud.studentid = e.e_student and e.e_schoolyear = 'YK' and e.e_semester  = 'MYSEMESTER'\n"
            + "group by l.lectureid order by c_name asc";

}//end
