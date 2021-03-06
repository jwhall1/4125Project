/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4125project;
import java.sql.*;
import java.util.ArrayList;
import static javafx.scene.input.KeyCode.J;
import javax.swing.*;
/**
 *
 * @author Jay
 */
public class BusinessProcess extends javax.swing.JFrame {
    Connection conn;
    
    public BusinessProcess(Connection conn) {
        initComponents();
        this.conn = conn;
        try{
            Statement statement = conn.createStatement();
            ResultSet company = statement.executeQuery("SELECT distinct comp_id FROM COMPANY");
            while(company.next()){
                String value = company.getString("comp_id");
                companyCombo.addItem(value);
            }
            ResultSet job = statement.executeQuery("select job_code from job");
            while(job.next()){
                String value = job.getString("job_code");
                jobCombo.addItem(value);
            }
            ResultSet person = statement.executeQuery("select distinct per_id from person");
            while(person.next()){
                String value = person.getString("per_id");
                personCombo.addItem(value);
            }
            ResultSet course = statement.executeQuery("SELECT distinct course_code from section");
            while(course.next()){
                String value = course.getString("course_code");
                classCombo.addItem(value);
            }
            ResultSet cert = statement.executeQuery("select distinct cert_code from certificate");
            while(cert.next()){
                String value = cert.getString("cert_code");
                certCombo.addItem(value);
            }
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.toString());
        }    
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        companyCombo = new javax.swing.JComboBox<>();
        employeeCombo = new javax.swing.JComboBox<>();
        addEmployee = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        personCombo = new javax.swing.JComboBox<>();
        classCombo = new javax.swing.JComboBox<>();
        addClass = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        certCombo = new javax.swing.JComboBox<>();
        addCert = new javax.swing.JButton();
        sectionCombo = new javax.swing.JComboBox<>();
        yearCombo = new javax.swing.JComboBox<>();
        jobCombo = new javax.swing.JComboBox<>();
        employedBox = new javax.swing.JCheckBox();

        setTitle("BUSINESS PROCESS");
        setBounds(new java.awt.Rectangle(200, 100, 0, 0));
        setResizable(false);

        jLabel1.setText(" accepts new");

        companyCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<company>" }));
        companyCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyComboActionPerformed(evt);
            }
        });

        employeeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<employee>" }));
        employeeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeComboActionPerformed(evt);
            }
        });

        addEmployee.setText("add employee");
        addEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeActionPerformed(evt);
            }
        });

        jLabel5.setText("  takes ");

        personCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<person>" }));

        classCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<class>" }));
        classCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classComboActionPerformed(evt);
            }
        });

        addClass.setText("add class");
        addClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClassActionPerformed(evt);
            }
        });

        jLabel8.setText("  earns");

        certCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<certification>" }));

        addCert.setText("add certification");
        addCert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCertActionPerformed(evt);
            }
        });

        sectionCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<section>" }));
        sectionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectionComboActionPerformed(evt);
            }
        });

        yearCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<year>" }));
        yearCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearComboActionPerformed(evt);
            }
        });

        jobCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<job>" }));
        jobCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobComboActionPerformed(evt);
            }
        });

        employedBox.setText("override");
        employedBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employedBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(companyCombo, 0, 140, Short.MAX_VALUE)
                    .addComponent(personCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(classCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sectionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(yearCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(certCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(employeeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jobCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(employedBox)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addCert, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(addClass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(companyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addEmployee)
                    .addComponent(jLabel1)
                    .addComponent(employeeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jobCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employedBox))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(personCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(classCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addClass)
                    .addComponent(sectionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(certCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCert))
                .addContainerGap(237, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void companyComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyComboActionPerformed
        try{
            employeeCombo.removeAllItems();
            Statement statement = conn.createStatement();
            ResultSet employee = statement.executeQuery("select distinct per_id from person minus select per_id from person natural join occupation where comp_id = '"+companyCombo.getSelectedItem()+"'");
            while(employee.next()){
                String value = employee.getString("per_id");
                employeeCombo.addItem(value);
            }    
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
 
        
    }//GEN-LAST:event_companyComboActionPerformed

    private void sectionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectionComboActionPerformed
        
        try{
            yearCombo.removeAllItems();
            Statement statement = conn.createStatement();
            ResultSet year = statement.executeQuery("select sec_year from section where course_code = '"+classCombo.getSelectedItem()+"' and sec_no = '"+sectionCombo.getSelectedItem()+"'");
            while(year.next()){
                String value = year.getString("sec_year");
                yearCombo.addItem(value);
            }    
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_sectionComboActionPerformed

    private void classComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classComboActionPerformed
        if(classCombo.getSelectedItem().equals("<class>")){
            JOptionPane.showMessageDialog(null, "select a class");
        }else
        try{
            sectionCombo.removeAllItems();
            Statement statement = conn.createStatement();
            ResultSet section = statement.executeQuery("SELECT distinct sec_no FROM section where course_code = '"+classCombo.getSelectedItem()+"'");
            while(section.next()){
                String value = section.getString("sec_no");
                sectionCombo.addItem(value);
            }
           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_classComboActionPerformed

    private void yearComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearComboActionPerformed
        
    }//GEN-LAST:event_yearComboActionPerformed

    private void addEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeActionPerformed
        ArrayList<String> missingSkills = new ArrayList<>();
        try{
            Statement statement = conn.createStatement();
            String Query = 
"(select sk_code,sk_description\n" +
"from job_profile_skills natural join skills natural join job\n" +
"where job_code = '"+jobCombo.getSelectedItem()+"') \n" +
"minus \n" +
"(select sk_code,sk_description\n" +
"from person_skills natural join skills\n" +
"where per_id = '"+employeeCombo.getSelectedItem()+"')";            
            ResultSet skills = statement.executeQuery(Query);
            while(skills.next()){
                String value = skills.getString("sk_code");
                missingSkills.add(value);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        if(missingSkills.size() <= 0 || employedBox.isSelected()){
            try{    
                Statement statement = conn.createStatement();
                String Query = "INSERT INTO OCCUPATION (PER_ID, JOB_CODE, COMP_ID, OCC_STATUS) VALUES ('"+employeeCombo.getSelectedItem()+"','"+jobCombo.getSelectedItem()+"','"+companyCombo.getSelectedItem()+"','employed')";
                statement.execute(Query);
                JOptionPane.showMessageDialog(null, "Successfully Added");
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }else{
            for(int i = 0; i < missingSkills.size(); i++){
                JOptionPane.showMessageDialog(null, "per_id # " + employeeCombo.getSelectedItem() + " missing req skill " + missingSkills.get(i));
            }
        }    
        employedBox.setSelected(false);
        missingSkills.clear();
    }//GEN-LAST:event_addEmployeeActionPerformed

    private void addClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClassActionPerformed
        try{    
            Statement statement = conn.createStatement();
            String Query = "insert into takes (per_id, sec_no, course_code, sec_year) values ('"+personCombo.getSelectedItem()+"','"+sectionCombo.getSelectedItem()+"','"+classCombo.getSelectedItem()+"','"+yearCombo.getSelectedItem()+"')";
            statement.execute(Query);
            JOptionPane.showMessageDialog(null, "Class Successfully Added");            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Class Not Needed");
        }
        ArrayList<String> list = new ArrayList<>();
        try{
            Statement statement = conn.createStatement();
            String Query = "select sk_code from course_skills where course_code = '"+classCombo.getSelectedItem()+"'";
            ResultSet skills = statement.executeQuery(Query);
            while(skills.next()){
                String value = skills.getString("sk_code");
                list.add(value);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }    
        for(int i = 0; i < list.size(); i++){
            try{
                Statement statement = conn.createStatement();
                statement.executeQuery("insert into person_skills (per_id, sk_code) values ('"+personCombo.getSelectedItem()+"','"+list.get(i)+"')");
                JOptionPane.showMessageDialog(null, "skill " + list.get(i) + " added successfully");
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, personCombo.getSelectedItem()+" already has skill "+list.get(i));
            }
        }
        list.clear();
             
        
    }//GEN-LAST:event_addClassActionPerformed

    private void addCertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCertActionPerformed
        try{    
            Statement statement = conn.createStatement();
            String Query = "insert into person_certificates (per_id, cert_code) values ('"+personCombo.getSelectedItem()+"','"+certCombo.getSelectedItem()+"')";
            statement.execute(Query);
            JOptionPane.showMessageDialog(null, "Successfully Added");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_addCertActionPerformed

    private void employeeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeComboActionPerformed
        try{
            jobCombo.removeAllItems();
            Statement statement = conn.createStatement();
            ResultSet job = statement.executeQuery("select distinct job_code from occupation where comp_id = '"+companyCombo.getSelectedItem()+"'");
            while(job.next()){
                String value = job.getString("job_code");
                jobCombo.addItem(value);
            }    
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_employeeComboActionPerformed

    private void jobComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobComboActionPerformed

    private void employedBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employedBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employedBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BusinessProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BusinessProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BusinessProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BusinessProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    String url = "jdbc:oracle:thin:@dbsvcs.cs.uno.edu:1521:orcl";
                    String username = "cmaryan";
                    String password = "tpmFR3NV";
                    Connection conn = DriverManager.getConnection(url,username,password);
                    new BusinessProcess(conn).setVisible(true);
                }catch(SQLException e){
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCert;
    private javax.swing.JButton addClass;
    private javax.swing.JButton addEmployee;
    private javax.swing.JComboBox<String> certCombo;
    private javax.swing.JComboBox<String> classCombo;
    private javax.swing.JComboBox<String> companyCombo;
    private javax.swing.JCheckBox employedBox;
    private javax.swing.JComboBox<String> employeeCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox<String> jobCombo;
    private javax.swing.JComboBox<String> personCombo;
    private javax.swing.JComboBox<String> sectionCombo;
    private javax.swing.JComboBox<String> yearCombo;
    // End of variables declaration//GEN-END:variables
}
