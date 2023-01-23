/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HELRER;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import org.edisoncor.gui.util.WindowDragger;

/**
 *
 * @author user
 */
public class Comp {

    private final String _FRAMEIMAGE = "/Asset/enrollment.png";//Static frame Image

    /*Center JDialog to Screen*/
    public static void centerJDialog(JDialog dialog) {//Start Function
        Rectangle rec = dialog.getBounds();//Get Bounderies
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//Get the dimension of screen
        //Center Screen
        dialog.setLocation((dim.width - rec.width) / 2, (dim.height - rec.height) / 2);
    }//End Function

    /*Center JDialog to Screen*/
    public static void centerJDialogToPanel(JPanel panel, JDialog dialog) {//Start Function
        Rectangle rec = dialog.getBounds();//Get Bounderies
        Dimension dim = panel.getSize();//Get the dimension of screen
        //Center Screen
        dialog.setLocation((dim.width - rec.width) / 2, (dim.height - rec.height) / 2);
        dialog.show();

    }//End Function

    public void frameIcon(JDialog dialog) {//Start Function 
        dialog.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(_FRAMEIMAGE)));
    }//End Function

    public void frameIcon(JFrame frame) {//Start Function 
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(_FRAMEIMAGE)));
    }//End Function

    /*Prompt your message*/
    public static void message(String _message) {//Start
        JOptionPane.showMessageDialog(null, _message);
    }//End

    public static void increptedChar(JPasswordField pw) {
        pw.setEchoChar('*');
    }

    /*Center JFrame to Screen*/
    public static void centerJFrame(JFrame frame) {//Start Function
        Rectangle rec = frame.getBounds();//Get Bounderies
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//Get the dimension of screen
        //Center Screen
        frame.setLocation((dim.width - rec.width) / 2, (dim.height - rec.height) / 2);
    }//End Function

    /*Movable frame*/
    public static void movableFrame(JFrame frame, JPanel panel) {
        WindowDragger drag = new WindowDragger(frame, panel);
    }

    public static void close(JFrame frame) {
        Object[] options = {"YES", "NO"};
        int x = JOptionPane.showOptionDialog(null, "Are you sure you want to exit (Yes/No)?", frame.getTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
        if (x == JOptionPane.YES_OPTION) {
            System.exit(1);
        }
    }

    public static void minimize(JFrame frame) {
        frame.setState(Frame.ICONIFIED);
    }

    //JTABLE =========================================
    public static void keySizeCell(String[] length, JTable table) {
        for (String length1 : length) {
            String[] newString = length1.split(":");
            int col = Integer.parseInt(newString[0]);
            int size = Integer.parseInt(newString[1]);
            setColSize(table, col, size);
        }
    }

    public static void setColSize(javax.swing.JTable table, int col, int size) {
        table.getColumnModel().getColumn(col).setPreferredWidth(size);
        table.getColumnModel().getColumn(col).setMinWidth(size);
        table.getColumnModel().getColumn(col).setMaxWidth(size);
    }

    public static void setTableHeader(String[] data, DefaultTableModel model) {
        for (String data1 : data) {
            model.addColumn(data1);
        }
    }

    public static void setHideTableColumn(JTable table, int[] col) {
        if (col != null) {
            for (int hide : col) {
                TableColumn hidden = table.getColumnModel().getColumn(hide);
                hidden.setMinWidth(0);
                hidden.setPreferredWidth(0);
                hidden.setMaxWidth(0);
            }
        }
    }

    public static void tableAddOnss(JTable table, JScrollPane jScrollPane) {
        table.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        table.setGridColor(new java.awt.Color(0, 0, 153));
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(false);
        table.setRowHeight(25);
        table.setOpaque(false);

        JTableHeader header = table.getTableHeader();
        header.setFont(new java.awt.Font("Arial", 1, 11));
        header.setForeground(Color.darkGray);

        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        table.setGridColor(new java.awt.Color(204, 204, 204));
        table.setSelectionBackground(new java.awt.Color(51, 195, 251));
        jScrollPane.setViewportView(table);
    }
    //JTABLE =========================================

    public static void refreshPanel(JPanel panelHolder, JPanel panel) {
        panelHolder.removeAll();
        panelHolder.add(panel);
        panelHolder.repaint();
        panelHolder.revalidate();
    }
}
