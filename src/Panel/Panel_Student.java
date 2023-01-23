/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panel;

import Class.Student;
import Dialog.Dialog_newStudent;
import Dialog.Dialog_updateStudent;
import HELRER.Comp;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Panel_Student extends javax.swing.JPanel {

    /**
     * Creates new form Panel_dashboard
     */
    public Panel_Student() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table_student = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        l_totalstuds = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_refresh = new javax.swing.JButton();
        f_search = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(887, 585));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        Table_student.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(Table_student);

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Arial Narrow", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/Add_16x16.png"))); // NOI18N
        jButton1.setText("New Student");
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        l_totalstuds.setBackground(new java.awt.Color(51, 0, 102));
        l_totalstuds.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        l_totalstuds.setForeground(new java.awt.Color(255, 255, 255));
        l_totalstuds.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_totalstuds.setText("Total Students : 0");
        l_totalstuds.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        l_totalstuds.setOpaque(true);

        jButton2.setBackground(new java.awt.Color(36, 98, 206));
        jButton2.setFont(new java.awt.Font("Arial Narrow", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/Edit_16x16.png"))); // NOI18N
        jButton2.setText("Update");
        jButton2.setContentAreaFilled(false);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("Arial Narrow", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/Find_24x24.png"))); // NOI18N
        jLabel2.setText("SEARCH (ID, Lastname, Firstname): ");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setOpaque(true);

        btn_refresh.setBackground(new java.awt.Color(243, 45, 63));
        btn_refresh.setFont(new java.awt.Font("Arial Narrow", 1, 11)); // NOI18N
        btn_refresh.setForeground(new java.awt.Color(255, 255, 255));
        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Asset/Synchronize_16x16.png"))); // NOI18N
        btn_refresh.setText("Refresh");
        btn_refresh.setContentAreaFilled(false);
        btn_refresh.setOpaque(true);
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        f_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                f_searchKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f_search, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_totalstuds, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_refresh, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_totalstuds, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_refresh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(f_search, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addStudent();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        //
    }//GEN-LAST:event_formKeyPressed

    private void f_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_f_searchKeyPressed
        //

    }//GEN-LAST:event_f_searchKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        updateStudent();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        load();
        f_search.setText("");
        f_search.requestFocus();
    }//GEN-LAST:event_btn_refreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_student;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JTextField f_search;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_totalstuds;
    // End of variables declaration//GEN-END:variables

    Student student = new Student();

    private byte _userId;
    private String _yearInclusive;

    public String getYearInclusive() {
        return _yearInclusive;
    }

    public void setYearInclusive(String _yearInclusive) {
        this._yearInclusive = _yearInclusive;
    }

    public byte getUserId() {
        return _userId;//active
    }

    public void setUserId(byte _userId) {
        this._userId = _userId;
    }

    public void loadUserCredentials() {
        _userId = getUserId();
        //Year Level
        String[] newYearLevel = getYearInclusive().split("-");
        _yearInclusive = newYearLevel[0];

    }

    private void init() {
        loadTable();
        load();

        f_search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    String searchKey = f_search.getText().trim();
                    if (!searchKey.equals("")) {
                        searh(searchKey);
                    } else {
                        load();
                    }
                }

            }

        });

    }

    //Load Data
    DefaultTableModel model = new DefaultTableModel() {
        //rol and col not editable
        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }
    };

    /*Set Custom Table Function*/
    private void loadTable() {
        Table_student = new JTable(model);
        String rowHeader[] = {"#", "STUD ID", "FIRSTNAME", "MIDDLENAME", "LASTNAME", "BOD", "ADDRESS", "ADDEDBY", "STATUS"};
        Comp.setTableHeader(rowHeader, model);//Helper class  
        int[] hidCol = {7};
        Comp.setHideTableColumn(Table_student, hidCol);
        String keySize[] = {"0:50", "1:70", "2:120", "3:120", "4:120", "5:95", "6:150", "7:180", "8:90"};
        Comp.keySizeCell(keySize, Table_student);
        Comp.tableAddOnss(Table_student, jScrollPane1);
    }

    public void load() {

        model.setRowCount(0);
        ArrayList<Student> listArr = student.showStudents();
        Object[] rowData = new Object[9];
        for (int x = 0; x < listArr.size(); x++) {
            rowData[0] = student.showStudents().get(x).getRowCounter();
            rowData[1] = student.showStudents().get(x).getStudentid();
            rowData[2] = student.showStudents().get(x).getStud_fname();
            rowData[3] = student.showStudents().get(x).getStud_mname();
            rowData[4] = student.showStudents().get(x).getStud_lname();
            rowData[5] = student.showStudents().get(x).getStud_bod();
            rowData[6] = student.showStudents().get(x).getStud_address();
            rowData[7] = student.showStudents().get(x).getStud_addedby();
            rowData[8] = student.showStudents().get(x).getStud_status();
            model.addRow(rowData);
        }
        l_totalstuds.setText("Total Students : " + Table_student.getRowCount());
    }

    public void search(String key) {

        model.setRowCount(0);
        student.searchStudent(key);
        for (Object data : student.getData()) {
            model.addRow((Vector) data);

        }
        l_totalstuds.setText("Total Student(s) : " + Table_student.getRowCount());
    }

    private void addStudent() {
        Dialog_newStudent addStuds = new Dialog_newStudent(null, true);
        addStuds.setUserId(_userId);
        addStuds.setYearLevel(_yearInclusive);
        addStuds.loadUserCredentials();
        addStuds.show();
        //reload when dispose
        load();
    }

    private void updateStudent() {

        int row = Table_student.getSelectedRow();
        if (row == -1) {
            Comp.message("Please select data to update!");
        } else {

            String stud_fname_ = Table_student.getModel().getValueAt(row, 2).toString();
            String studentid_ = Table_student.getModel().getValueAt(row, 1).toString();
            String stud_mname_ = Table_student.getModel().getValueAt(row, 3).toString();
            String stud_lname_ = Table_student.getModel().getValueAt(row, 4).toString();
            String stud_status_ = Table_student.getModel().getValueAt(row, 8).toString();
            String stud_address_ = Table_student.getModel().getValueAt(row, 6).toString();
            String stud_bod_ = Table_student.getModel().getValueAt(row, 5).toString();
            byte stud_addedby_ = _userId;

            Dialog_updateStudent upStuds = new Dialog_updateStudent(null, true);
            upStuds.setUserId(stud_addedby_);
            upStuds.setStud_address_(stud_address_);
            upStuds.setStud_fname_(stud_fname_);
            upStuds.setStud_lname_(stud_lname_);
            upStuds.setStud_mname_(stud_mname_);
            upStuds.setStud_status_(stud_status_);
            upStuds.setStud_bod_(stud_bod_);
            upStuds.setStudentid_(studentid_);
            upStuds.loadUserCredentials();
            upStuds.show();
            //reload when dispose
            String searchKey = f_search.getText().trim();
            if (!searchKey.equals("")) {
                searh(searchKey);
            } else {
                load();
            }
        }
    }

    //Search Student
    private void searh(String key) {//start
        model.setRowCount(0);
        student.searchStudent(key);
        for (Object o : student.getData()) {
            model.addRow((Vector) o);
        }
        l_totalstuds.setText("Total Student(s) : " + Table_student.getRowCount());
    }//end
//
}
