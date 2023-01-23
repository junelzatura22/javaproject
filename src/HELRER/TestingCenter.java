/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HELRER;

/**
 *
 * @author user
 */
public class TestingCenter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//       
//        DatabaseConnection con = new DatabaseConnection();
//        
//       con.getConnectToDbHost();

//    System.out.println(con.getCON_DIR_());
//    System.out.println(Users.quel((byte)10));
//        String[] mos = {"Jan", "Feb", "Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
//        for (int x = 0; x < mos.length; x++) {
//            if (mos[x].equals("May")) {
//                System.out.println(mos[x] + " was found on index " + x);
//                break;
//            }
//        }
//        System.out.println(Functions.getCurrentIndexOfStringDate("Jan"));
        // Decode base64 to get bytes
//        String formate = "1. LEC-102, JUAN DELA CRUZ";
//        String getLecturerID = formate.substring(formate.indexOf(".") + 2, formate.indexOf(","));
//        String getLecturerName = formate.substring(formate.indexOf(",") + 2, formate.length());
//
//        System.out.println("Lecturer ID:" + getLecturerID);
//        System.out.println("Lecturer Name:" + getLecturerName);
        String format = "1:30 AM";

        System.out.println("HOUR:" + hourLabel(format, "hour"));
        System.out.println("MINUTES:" + hourLabel(format, "minute"));
        System.out.println("HOURLABEL:" + hourLabel(format, "--"));

    }

    private static String hourLabel(String timeText, String key) {
        String getTime;

        switch (key.toLowerCase()) {
            case "hour":
                getTime = timeText.substring(0, timeText.indexOf(":"));
                break;
            case "minute":
                getTime = timeText.substring(timeText.indexOf(":") + 1, timeText.indexOf(":") + 3);
                break;
            default:
                getTime = timeText.substring(timeText.length() - 2, timeText.length());
                break;
        }
        return getTime;
    }
}
