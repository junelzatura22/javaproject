/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HELRER;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/**
 *
 * @author user
 */
public class Functions {

    public static final String _DIR_ = System.getProperty("user.dir");

    /*Hashing word*/
    public static String _hashWords(String wordToHash) {//Start function
        String newHassWord = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            //Get the hash's bytes 
            byte[] bytes = md.digest(wordToHash.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            newHassWord = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return newHassWord;
    }//End Function

    /*Image Icon*/
    private ImageIcon imageIcon;
    private Image image;

    /**/
    /**
     *
     * @param path
     * @param width
     * @param height
     * @param label
     */
    public void _imageProperties(String path, int width, int height, JLabel label) {
        imageIcon = new ImageIcon(path);
        image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon conex = new ImageIcon(image);
        label.setText("");
        label.setIcon(conex);
    }

//DATE===============================
    static Date date;

    public static String getTimeFormatSQL() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        date = new Date();
        return format.format(date);
    }

    public static String getTimeHHMMSS() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        date = new Date();
        return format.format(date);
    }

    public static Date curDate() {
        date = new Date();
        return date;
    }
//DATE===============================

    public static String quel(byte value) {
        String newLines = "";
        for (byte x = 0; x < value; x++) {
            newLines += "?,";
        }
        return newLines.substring(0, newLines.length() - 1);
    }

    //Setting automatic age
    public static void getAge(String bod, JTextField field) {
        try {
            //Target Format Feb-07-2021
            String newBod[] = bod.split("-");
            int year = Integer.parseInt(newBod[2]);
            int mos = Integer.parseInt(filterNumber(getCurrentIndexOfStringDate(newBod[0])));
            int day = Integer.parseInt(newBod[1]);
//            yyyy-MM-dd - curdate format
            String curDate[] = getTimeFormatSQL().split("-");
            int Curyear = Integer.parseInt(curDate[0]);
            int Curmos = Integer.parseInt(curDate[1]);
            int Curday = Integer.parseInt(curDate[2]);

            LocalDate dob = new LocalDate(year, mos, day);
            LocalDate dateToday = new LocalDate(Curyear, Curmos, Curday);

            Period period = new Period(dob, dateToday, PeriodType.yearMonthDay());

            int years = period.getYears();

            if (years == 0) {

                field.setText("");
            } else {
                field.setText(period.getYears() + "");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getCurrentIndexOfStringDate(String value) {
        int curIndex = 0;
        String[] mos = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (int x = 0; x < mos.length; x++) {
            if (mos[x].equals(value)) {
                curIndex = x;
                break;
            }
        }
        return (curIndex + 1);
    }

    public static String filterNumber(int num) {
        String curNum = num < 10 ? "0" + num : "" + num;
        return curNum;
    }

    public static void integer(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE)) {
        } else {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }

    public static void letters(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        if (Character.isDigit(c)
                || (c == KeyEvent.VK_BACK_SPACE)
                || (c == KeyEvent.VK_DELETE)
                || (c == KeyEvent.VK_SHIFT)
                || (c == KeyEvent.VK_SLASH)
                || (c == KeyEvent.VK_QUOTE)
                || (c == KeyEvent.VK_ALT)
                || (c == '*')
                || (c == '[')
                || (c == ']')
                || (c == '-')
                || (c == '_')
                || (c == '=')
                || (c == '+')
                || (c == '|')
                || (c == '?')
                || (c == '/')
                || (c == ';')
                || (c == ':')
                || (c == '"')
                || (c == '<')
                || (c == '>')
                || (c == ',')
                || (c == '.')
                || (c == '`')
                || (c == '~')) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }
    
    public static boolean checkEmail(JTextField field) {
        //Study good topic  
        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(field.getText());
        return matcher.matches();
    }

    
    
    
}
