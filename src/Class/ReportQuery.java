/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import HELRER.Comp;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class ReportQuery extends DBCOnnection {

    private String GET_TOTALSTUDENTS = "SELECT count(distinct(SWAPBASIS)) as totalCount\n"
            + "FROM enrollment e,lecture l,lecturer lec,course c,student stud, subjects subs,room ro\n"
            + "where e.e_lecture = l.lectureid\n"
            + "and subs.sub_code = l.subject\n"
            + "and lec.lec_id = l.lecturer\n"
            + "and c.courseid = e.e_course\n"
            + "and ro.rid = e.e_room\n"
            + "and stud.studentid = e.e_student and e.e_schoolyear = 'MYSCHOOLYEAR'\n"
            + "and e.e_semester = 'MYSEMESTER'\n"
            + "order by c_name asc";

    public int getTotalCount(String schoolYear, String semester, String swapBasis) {//Start function
        super.dbConnection();
        String query = GET_TOTALSTUDENTS.replace("MYSEMESTER", semester).replace("MYSCHOOLYEAR", schoolYear).replace("SWAPBASIS", swapBasis);
        int totalCount = 0;
        try {
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            if (rs.next()) {
                totalCount = rs.getInt("totalCount");
            } else {
                totalCount = 0;
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            Comp.message(e.getMessage());
        }
        return totalCount;
    }//end function

}
