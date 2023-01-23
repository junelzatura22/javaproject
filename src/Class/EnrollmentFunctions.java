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
public interface EnrollmentFunctions {//Start Class
    //Insert Start

    public void insertEnrollment();
    public static String INSERT_ENROLLMENT = "insert into enrollment(e_lecture, e_course,e_student,e_dateenroll,"
            + "e_addedby,e_yearLevel,e_semester,e_schoolyear,e_room) \n"
            + "values(?,?,?,?,?,?,?,?,?)";

    //Insert End
    //Update Start
    public void updateEnrollment();
    public static String UPDATE_ENROLLMENT = "update enrollment set e_lecture = ?, e_course= ?,e_student= ?,e_dateenroll= ?,\n"
            + "e_addedby= ?,e_yearLevel= ?,e_semester= ?,e_schoolyear= ?,e_room = ? \n"
            + "where e_id = ?";

    //Update End
    //Show Enrollment Start
    //YK = year key
    public void showEnrollment(String _schoolYear, String semester);
    public static String SHOW_ENROLLMENT = "SELECT e_id,e_lecture, e_course, e_student, DATE_FORMAT(e_dateenroll,'%M %d, %Y') as dates, e_addedby,e_yearLevel, e_semester,e_schoolyear,\n"
            + "\n"
            + "            lecturer, concat(lec_fname,' ', SUBSTRING(lec_mname,1,1),'. ',lec_lname) as teacher,subject as subjects,time as timestart,\n"
            + "            date as schedule,dateadded,timeend,\n"
            + "\n"
            + "            sub_unit,sub_description,c_name,c_description, c_department,\n"
            + "\n"
            + "            concat(stud_fname,' ',SUBSTRING(stud_mname,1,1),'. ',stud_lname) as studFullname, stud_status,\n"
            + "\n"
            + "            e_room,rname, rinstalledlocation\n"
            + "\n"
            + "            FROM enrollment e,lecture l,lecturer lec,course c,student stud, subjects subs,room ro\n"
            + "\n"
            + "            where e.e_lecture = l.lectureid\n"
            + "            and subs.sub_code = l.subject\n"
            + "            and lec.lec_id = l.lecturer\n"
            + "            and c.courseid = e.e_course\n"
            + "            and ro.rid = e.e_room\n"
            + "\n"
            + "            and stud.studentid = e.e_student and e.e_schoolyear = 'YK' and e.e_semester = 'SEM' order by e_dateenroll desc limit 120";

//    
    //Show Enrollment End
    //Search Enrollment Start
    //YK = year key ; key = search key
    public void searchEnrollment(String _schoolYear, String key, String sem);
    public static String SEARCH_ENROLLMENT = "SELECT e_id,e_lecture, e_course, e_student, DATE_FORMAT(e_dateenroll,'%M %d, %Y') as dates, e_addedby,e_yearLevel, e_semester,e_schoolyear,\n"
            + "\n"
            + "            lecturer, concat(lec_fname,' ', SUBSTRING(lec_mname,1,1),'. ',lec_lname) as teacher,subject as subjects,time as timestart,\n"
            + "            date as schedule,dateadded,timeend,\n"
            + "\n"
            + "            sub_unit,sub_description,c_name,c_description, c_department,\n"
            + "\n"
            + "            concat(stud_fname,' ',SUBSTRING(stud_mname,1,1),'. ',stud_lname) as studFullname, stud_status,\n"
            + "\n"
            + "            e_room,rname, rinstalledlocation\n"
            + "\n"
            + "            FROM enrollment e,lecture l,lecturer lec,course c,student stud, subjects subs,room ro\n"
            + "\n"
            + "            where e.e_lecture = l.lectureid\n"
            + "            and subs.sub_code = l.subject\n"
            + "            and lec.lec_id = l.lecturer\n"
            + "            and c.courseid = e.e_course\n"
            + "            and ro.rid = e.e_room\n"
            + "\n"
            + "            and stud.studentid = e.e_student and e.e_schoolyear = 'YK'  and e.e_semester = 'SEM'"
            + "and concat(lec_lname,' ',e_student,' ',stud_lname,' ',c_name,' ',subject) like '%JAVA%' order by e_dateenroll desc limit 120";
    //lecture lastname,student number,stud_lname
    //Search Enrollment End

    //total enrolless per subject
    public void enrolleesSubject(String schoolYear, String sem);
    public static String GEN_LOAD_ENROLLESS = "SELECT c_name,concat(subject,' (',time,'-',timeend,', ',date,') ') as subjects,\n"
            + "concat(lec_fname,' ', SUBSTRING(lec_mname,1,1),'. ',lec_lname) as teacher,\n"
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
            + "and stud.studentid = e.e_student and e.e_schoolyear = 'YK'  and e.e_semester = 'SEM'\n"
            + "group by l.lectureid order by c_name asc";
    
    public void enrolleesSearch(String schoolYear, String key, String sem);
    public static String GENSEARCH_LOAD_ENROLLESS = "SELECT c_name,concat(subject,' (',time,'-',timeend,', ',date,') ') as subjects,\n"
            + "concat(lec_fname,' ', SUBSTRING(lec_mname,1,1),'. ',lec_lname) as teacher,\n"
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
            + "and stud.studentid = e.e_student and e.e_schoolyear = 'YK' and e.e_semester = 'SEM' \n "
            + "and concat(c_name,' ',lec_lname, ' ',subject) like '%JAVA%' "
            + "group by l.lectureid order by c_name asc";

    
    //generate all student from a course
    public void genStudentFromCourse(String _schoolyear, String sem);
    public static String GEN_REGISTERED_COURSE = "SELECT concat(c_name, '-',c_description ) as coursname,count(c_name) as totalStudent\n"
            + "                FROM enrollment e,lecture l,lecturer lec,course c,student stud, subjects subs,room ro\n"
            + "                where e.e_lecture = l.lectureid\n"
            + "                and subs.sub_code = l.subject\n"
            + "                and lec.lec_id = l.lecturer\n"
            + "                and c.courseid = e.e_course\n"
            + "                and ro.rid = e.e_room\n"
            + "                and stud.studentid = e.e_student and e.e_schoolyear = 'YK'  and e.e_semester = 'SEM'\n"
            + "                group by c_name order by c_name asc";
    
    public void genSearchStudentFromCourse(String _schoolyear, String key, String sem);
    public static String GENSEARCH_REGISTERED_COURSE = "SELECT concat(c_name, '-',c_description ) as coursname,count(c_name) as totalStudent\n"
            + "                FROM enrollment e,lecture l,lecturer lec,course c,student stud, subjects subs,room ro\n"
            + "                where e.e_lecture = l.lectureid\n"
            + "                and subs.sub_code = l.subject\n"
            + "                and lec.lec_id = l.lecturer\n"
            + "                and c.courseid = e.e_course\n"
            + "                and ro.rid = e.e_room\n"
            + "                and stud.studentid = e.e_student and e.e_schoolyear = 'YK'  and e.e_semester = 'SEM' and concat(c_name,' ',c_description) like '%JAVA%'\n"
            + "                group by c_name order by c_name asc";

}//End class

