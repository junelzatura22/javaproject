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
public interface LectureFunctions {

    public void insertLecture();

    public void updateLecture();

    public void showLecture();

    public void searchLecture(String _searchKey);

    public void deleteLecture();


    public String INSERT_LECTURE = "insert into lecture(lecturer,subject,time,date,addedby,dateadded,timeend) values (?,?,?,?,?,?,?)";
    public String UPDATE_LECTURE = "update lecture set lecturer = ?,subject = ?,time = ?,date = ?,addedby = ? ,timeend = ? where lectureid = ?";
    public String DELETE_LECTURE = "delete from lecture where lectureid = ?";
    public String SHOW_LECTURE = "SELECT sub_code, sub_description,sub_unit,lec_id, concat(lec_fname,' ',lec_mname,' ',lec_lname) as fullname,\n"
            + "lectureid, time, date,dateadded,timeend,lec_id\n"
            + "FROM lecture l, lecturer le, subjects s\n"
            + "where l.lecturer = le.lec_id\n"
            + "and l.subject = s.sub_code order by dateadded desc limit 100";
            
    public String SEARCH_LECTURE = "SELECT sub_code, sub_description,sub_unit,lec_id, concat(lec_fname,' ',lec_mname,' ',lec_lname) as fullname,\n"
            + "lectureid, time, date,dateadded,timeend,lec_id\n"
            + "FROM lecture l, lecturer le, subjects s\n"
            + "where l.lecturer = le.lec_id\n"
            + "and l.subject = s.sub_code "
            + "and concat(lec_fname,' ',lec_mname,' ',lec_lname,' ',sub_description,' ',sub_code) like '%key%' order by dateadded desc limit 100";
            
    

          

}
