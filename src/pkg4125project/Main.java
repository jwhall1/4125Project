package pkg4125project;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author John Hall and Corey Maryan
 */

public class Main extends javax.swing.JFrame {
    Connection conn;
            
    public Main() {
        initComponents();
        
        try{
        	/**
        	 *	replace url, username, password
        	 */
            String url = "jdbc:oracle:thin:@dbsvcs.cs.uno.edu:1521:orcl";
            String username = "name";
            String password = "pass";
            conn = DriverManager.getConnection(url,username,password);
            Statement statement = conn.createStatement();
            ResultSet company = statement.executeQuery("SELECT distinct comp_id FROM COMPANY");
            while(company.next()){
                String value = company.getString("comp_id");
                companyCombo.addItem(value);
            }
            companyCombo.addItem("add/remove");
            ResultSet sector = statement.executeQuery("SELECT distinct primary_sector from COMPANY");
            while(sector.next()){
                String value = sector.getString("primary_sector");
                sectorCombo.addItem(value);
            }
            ResultSet person = statement.executeQuery("SELECT distinct per_id FROM PERSON");
            while(person.next()){
                String value = person.getString("per_id");
                personCombo.addItem(value);
            }
            personCombo.addItem("add/remove");
            ResultSet job = statement.executeQuery("SELECT distinct job_code FROM job");
            while(job.next()){
                String value = job.getString("job_code");
                jobCombo.addItem(value);
            }
            jobCombo.addItem("add/remove");
            ResultSet position = statement.executeQuery("SELECT distinct pos_code FROM job_profile");
            while(position.next()){
                String value = position.getString("pos_code");
                positionCombo.addItem(value);
            }
            positionCombo.addItem("add/remove");
            ResultSet course = statement.executeQuery("SELECT distinct course_code FROM course");
            while(course.next()){
                String value = course.getString("course_code");
                courseCombo.addItem(value);
            }   
            courseCombo.addItem("add/remove");
            
            
         }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        questionGroup = new javax.swing.ButtonGroup();
        sqlLabel = new javax.swing.JLabel();
        sqlTextField = new javax.swing.JTextField();
        companyCombo = new javax.swing.JComboBox<>();
        personCombo = new javax.swing.JComboBox<>();
        questionOne = new javax.swing.JRadioButton();
        questionTwo = new javax.swing.JRadioButton();
        questionFour = new javax.swing.JRadioButton();
        questionThree = new javax.swing.JRadioButton();
        questionFive = new javax.swing.JRadioButton();
        courseCombo = new javax.swing.JComboBox<>();
        jobCombo = new javax.swing.JComboBox<>();
        questionSix = new javax.swing.JRadioButton();
        questionSeven = new javax.swing.JRadioButton();
        questionNine = new javax.swing.JRadioButton();
        questionEight = new javax.swing.JRadioButton();
        positionCombo = new javax.swing.JComboBox<>();
        questionTen = new javax.swing.JRadioButton();
        questionEleven = new javax.swing.JRadioButton();
        questionTwelve = new javax.swing.JRadioButton();
        questionThirteen = new javax.swing.JRadioButton();
        questionFourteen = new javax.swing.JRadioButton();
        questionFifteen = new javax.swing.JRadioButton();
        questionSixteen = new javax.swing.JRadioButton();
        questionSeventeen = new javax.swing.JRadioButton();
        questionEightteen = new javax.swing.JRadioButton();
        questionNineteen = new javax.swing.JRadioButton();
        questionTwenty = new javax.swing.JRadioButton();
        questionTwentyone = new javax.swing.JRadioButton();
        questionTwentytwo = new javax.swing.JRadioButton();
        questionTwentythree = new javax.swing.JRadioButton();
        questionTwentyfour = new javax.swing.JRadioButton();
        questionTwentyfive = new javax.swing.JRadioButton();
        questionTwentysix = new javax.swing.JRadioButton();
        questionTwentyseven = new javax.swing.JRadioButton();
        questionTwentyeight = new javax.swing.JRadioButton();
        questionTwentynine = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        questionThirty = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        sectorCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sqlDisplay = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        kText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INFORMATION SYSTEM");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1366, 720));
        setResizable(false);

        sqlLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sqlLabel.setText("SQL > :");

        sqlTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqlTextFieldActionPerformed(evt);
            }
        });

        companyCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<select company>" }));
        companyCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyComboActionPerformed(evt);
            }
        });

        personCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<select person>" }));
        personCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personComboActionPerformed(evt);
            }
        });

        questionGroup.add(questionOne);
        questionOne.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionOne.setText("01.) List a company's workers by name.");
        questionOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionOneActionPerformed(evt);
            }
        });

        questionGroup.add(questionTwo);
        questionTwo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionTwo.setText("02.) List a company's staff by salary in descending order.");
        questionTwo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        questionTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionTwoActionPerformed(evt);
            }
        });

        questionGroup.add(questionFour);
        questionFour.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionFour.setText("04.) Find all jobs a person is currently holding.");
        questionFour.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        questionFour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionFourActionPerformed(evt);
            }
        });

        questionGroup.add(questionThree);
        questionThree.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionThree.setText("03.) List companies' labor costs(salaries & wages by 1920 hours) in descending order.");
        questionThree.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        questionThree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionThreeActionPerformed(evt);
            }
        });

        questionGroup.add(questionFive);
        questionFive.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionFive.setText("05.) List a persons skills in readable format.");
        questionFive.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        questionFive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionFiveActionPerformed(evt);
            }
        });

        courseCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<select course>" }));
        courseCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseComboActionPerformed(evt);
            }
        });

        jobCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<select job>" }));
        jobCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobComboActionPerformed(evt);
            }
        });

        questionGroup.add(questionSix);
        questionSix.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionSix.setText("06.) List skill gap of worker between his/her jobs and skills.");
        questionSix.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        questionSix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionSixActionPerformed(evt);
            }
        });

        questionGroup.add(questionSeven);
        questionSeven.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionSeven.setText("07.) List the req skills of a job profile in readable format.");
        questionSeven.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        questionSeven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionSevenActionPerformed(evt);
            }
        });

        questionGroup.add(questionNine);
        questionNine.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionNine.setText("09.) Find courses which can cover a given skill set.");
        questionNine.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        questionNine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionNineActionPerformed(evt);
            }
        });

        questionGroup.add(questionEight);
        questionEight.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionEight.setText("08.) List a person's missing skills for specific job in readable format.");
        questionEight.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        questionEight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionEightActionPerformed(evt);
            }
        });

        positionCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<select profile>" }));
        positionCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionComboActionPerformed(evt);
            }
        });

        questionGroup.add(questionTen);
        questionTen.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionTen.setText("10.) List courses(id and title) that teaches missing skills for a person to persue a  specific job. ");
        questionTen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        questionTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionTenActionPerformed(evt);
            }
        });

        questionGroup.add(questionEleven);
        questionEleven.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionEleven.setText("11.) Suppose the skill gap of a worker and a course can cover req for a job,\n        Find the \"quickest\" solution (course and completion data).");
        questionEleven.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        questionEleven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionElevenActionPerformed(evt);
            }
        });

        questionGroup.add(questionTwelve);
        questionTwelve.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionTwelve.setText("12.) Find course sets with min number of courses to cover given skill set.");
        questionTwelve.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        questionTwelve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionTwelveActionPerformed(evt);
            }
        });

        questionGroup.add(questionThirteen);
        questionThirteen.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionThirteen.setText("13.) List course sets to cover missing skills for a person to persue specific job. ");
        questionThirteen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        questionThirteen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionThirteenActionPerformed(evt);
            }
        });

        questionGroup.add(questionFourteen);
        questionFourteen.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionFourteen.setText("14.) Find the cheapest course choices to cover skill gap by showing the courses to take and the total cost.");
        questionFourteen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        questionFourteen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionFourteenActionPerformed(evt);
            }
        });

        questionGroup.add(questionFifteen);
        questionFifteen.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionFifteen.setText("15.) List all the job profiles that a person is qualified.");
        questionFifteen.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        questionFifteen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionFifteenActionPerformed(evt);
            }
        });

        questionGroup.add(questionSixteen);
        questionSixteen.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionSixteen.setText("16.) Find the job with the highest pay rate for a person according to his/her skill qualification.");
        questionSixteen.setMaximumSize(new java.awt.Dimension(279, 21));
        questionSixteen.setMinimumSize(new java.awt.Dimension(279, 21));
        questionSixteen.setPreferredSize(new java.awt.Dimension(400, 31));
        questionSixteen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionSixteenActionPerformed(evt);
            }
        });

        questionGroup.add(questionSeventeen);
        questionSeventeen.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionSeventeen.setText("17.) List all the names along with the emails of the persons who are qualified for a job profile.");
        questionSeventeen.setMaximumSize(new java.awt.Dimension(279, 21));
        questionSeventeen.setMinimumSize(new java.awt.Dimension(279, 21));
        questionSeventeen.setPreferredSize(new java.awt.Dimension(400, 31));
        questionSeventeen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionSeventeenActionPerformed(evt);
            }
        });

        questionGroup.add(questionEightteen);
        questionEightteen.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionEightteen.setText("18.) \"Missing-One\" skill list for a specific job.");
        questionEightteen.setMaximumSize(new java.awt.Dimension(279, 21));
        questionEightteen.setMinimumSize(new java.awt.Dimension(279, 21));
        questionEightteen.setPreferredSize(new java.awt.Dimension(400, 31));
        questionEightteen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionEightteenActionPerformed(evt);
            }
        });

        questionGroup.add(questionNineteen);
        questionNineteen.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionNineteen.setText("19.) List SkillID and number of people in missing-one list in ascending of people counts.");
        questionNineteen.setMaximumSize(new java.awt.Dimension(279, 21));
        questionNineteen.setMinimumSize(new java.awt.Dimension(279, 21));
        questionNineteen.setPreferredSize(new java.awt.Dimension(400, 31));
        questionNineteen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionNineteenActionPerformed(evt);
            }
        });

        questionGroup.add(questionTwenty);
        questionTwenty.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionTwenty.setText("20.) List the persons who miss the least number of skills for job profile.");
        questionTwenty.setMaximumSize(new java.awt.Dimension(279, 21));
        questionTwenty.setMinimumSize(new java.awt.Dimension(279, 21));
        questionTwenty.setPreferredSize(new java.awt.Dimension(400, 31));
        questionTwenty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionTwentyActionPerformed(evt);
            }
        });

        questionGroup.add(questionTwentyone);
        questionTwentyone.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionTwentyone.setText("21.) \"Missing-k\" list, num of missing skills for people missing up to k skills.");
        questionTwentyone.setMaximumSize(new java.awt.Dimension(279, 21));
        questionTwentyone.setMinimumSize(new java.awt.Dimension(279, 21));
        questionTwentyone.setPreferredSize(new java.awt.Dimension(400, 31));
        questionTwentyone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionTwentyoneActionPerformed(evt);
            }
        });

        questionGroup.add(questionTwentytwo);
        questionTwentytwo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionTwentytwo.setText("22.) Find every skill that is needed by at least one person in given \"missing-k\" list.");
        questionTwentytwo.setMaximumSize(new java.awt.Dimension(279, 21));
        questionTwentytwo.setMinimumSize(new java.awt.Dimension(279, 21));
        questionTwentytwo.setPreferredSize(new java.awt.Dimension(400, 31));
        questionTwentytwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionTwentytwoActionPerformed(evt);
            }
        });

        questionGroup.add(questionTwentythree);
        questionTwentythree.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionTwentythree.setText("23.) Find all people who once held a job of a specific job-profile idendtifier.");
        questionTwentythree.setMaximumSize(new java.awt.Dimension(279, 21));
        questionTwentythree.setMinimumSize(new java.awt.Dimension(279, 21));
        questionTwentythree.setPreferredSize(new java.awt.Dimension(400, 31));
        questionTwentythree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionTwentythreeActionPerformed(evt);
            }
        });

        questionGroup.add(questionTwentyfour);
        questionTwentyfour.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionTwentyfour.setText("24.) Find all the unemployed people who once held a job of the given job profile.");
        questionTwentyfour.setMaximumSize(new java.awt.Dimension(279, 21));
        questionTwentyfour.setMinimumSize(new java.awt.Dimension(279, 21));
        questionTwentyfour.setPreferredSize(new java.awt.Dimension(400, 31));
        questionTwentyfour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionTwentyfourActionPerformed(evt);
            }
        });

        questionGroup.add(questionTwentyfive);
        questionTwentyfive.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionTwentyfive.setText("25.) Find biggest employer(num of employees or total costs paid to employees).");
        questionTwentyfive.setMaximumSize(new java.awt.Dimension(279, 21));
        questionTwentyfive.setMinimumSize(new java.awt.Dimension(279, 21));
        questionTwentyfive.setPreferredSize(new java.awt.Dimension(400, 31));
        questionTwentyfive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionTwentyfiveActionPerformed(evt);
            }
        });

        questionGroup.add(questionTwentysix);
        questionTwentysix.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionTwentysix.setText("26.) Find biggest sector(num of employees or total costs paid to employees). ");
        questionTwentysix.setMaximumSize(new java.awt.Dimension(279, 21));
        questionTwentysix.setMinimumSize(new java.awt.Dimension(279, 21));
        questionTwentysix.setPreferredSize(new java.awt.Dimension(400, 31));
        questionTwentysix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionTwentysixActionPerformed(evt);
            }
        });

        questionGroup.add(questionTwentyseven);
        questionTwentyseven.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionTwentyseven.setText("27.) Find ratio between people whose earnings increase/decrease; Find avg rate.");
        questionTwentyseven.setMaximumSize(new java.awt.Dimension(279, 21));
        questionTwentyseven.setMinimumSize(new java.awt.Dimension(279, 21));
        questionTwentyseven.setPreferredSize(new java.awt.Dimension(400, 31));
        questionTwentyseven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionTwentysevenActionPerformed(evt);
            }
        });

        questionGroup.add(questionTwentyeight);
        questionTwentyeight.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionTwentyeight.setText("28.) Find job profiles with most openings due to lack of qualified workers.");
        questionTwentyeight.setMaximumSize(new java.awt.Dimension(279, 21));
        questionTwentyeight.setMinimumSize(new java.awt.Dimension(279, 21));
        questionTwentyeight.setPreferredSize(new java.awt.Dimension(400, 31));
        questionTwentyeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionTwentyeightActionPerformed(evt);
            }
        });

        questionGroup.add(questionTwentynine);
        questionTwentynine.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionTwentynine.setText("29.) Find courses to train jobless people toward job profiles with most openenings due to lack of qualified workers.");
        questionTwentynine.setMaximumSize(new java.awt.Dimension(279, 21));
        questionTwentynine.setMinimumSize(new java.awt.Dimension(279, 21));
        questionTwentynine.setPreferredSize(new java.awt.Dimension(400, 31));
        questionTwentynine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionTwentynineActionPerformed(evt);
            }
        });

        resultTable.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        resultTable.setPreferredSize(new java.awt.Dimension(400, 600));
        jScrollPane1.setViewportView(resultTable);

        questionGroup.add(questionThirty);
        questionThirty.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        questionThirty.setText("30.) List courses a person needs to take in order  to be qualified for specific job profile.");
        questionThirty.setMaximumSize(new java.awt.Dimension(279, 21));
        questionThirty.setMinimumSize(new java.awt.Dimension(279, 21));
        questionThirty.setPreferredSize(new java.awt.Dimension(400, 31));
        questionThirty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionThirtyActionPerformed(evt);
            }
        });

        jButton1.setText("Business Process");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        sectorCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<sector>" }));
        sectorCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectorComboActionPerformed(evt);
            }
        });

        jLabel2.setText("Select a 'Key' from the following combo boxes to use for the corresponding queries.");

        jLabel3.setText("   Click to go to Business Application    ");

        sqlDisplay.setColumns(1);
        sqlDisplay.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        sqlDisplay.setRows(50);
        sqlDisplay.setTabSize(10);
        jScrollPane2.setViewportView(sqlDisplay);

        jLabel1.setText("Query Results");

        jLabel4.setText("Query Log");

        jLabel5.setText("<=K");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(questionThree, javax.swing.GroupLayout.PREFERRED_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(questionTwo, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(questionOne, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(questionFifteen, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(questionFourteen, javax.swing.GroupLayout.PREFERRED_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(questionThirteen, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(questionTwelve, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(questionTen, javax.swing.GroupLayout.PREFERRED_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(questionNine, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(questionEight, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(questionSeven, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(questionSix, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(questionFive, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(questionEleven, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(companyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sectorCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(personCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jobCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(questionFour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(questionTwentyseven, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                                .addComponent(questionTwentysix, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(questionTwentyfive, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(questionTwentyfour, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(questionTwentythree, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(questionTwentytwo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(questionTwenty, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(questionNineteen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(questionEightteen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(questionSeventeen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(questionSixteen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(questionTwentyone, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(kText, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel5)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(questionThirty, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(questionTwentynine, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(questionTwentyeight, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(positionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(courseCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sqlLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sqlTextField)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {questionEight, questionFifteen, questionFive, questionFourteen, questionNine, questionOne, questionSeven, questionSix, questionTen, questionThirteen, questionThree, questionTwelve, questionTwo});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(companyCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(personCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jobCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courseCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(positionCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(sectorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(questionSixteen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(questionOne))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(questionTwo)
                            .addComponent(questionSeventeen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(questionThree)
                            .addComponent(questionEightteen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(questionFour)
                            .addComponent(questionNineteen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(questionFive)
                            .addComponent(questionTwenty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(questionSix)
                            .addComponent(questionTwentyone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(questionSeven)
                            .addComponent(questionTwentytwo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(questionEight)
                            .addComponent(questionTwentythree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(questionNine)
                            .addComponent(questionTwentyfour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(questionTen)
                            .addComponent(questionTwentyfive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(questionEleven)
                            .addComponent(questionTwentysix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(questionTwelve)
                            .addComponent(questionTwentyseven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(questionThirteen)
                            .addComponent(questionTwentyeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(questionFourteen)
                            .addComponent(questionTwentynine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(questionFifteen)
                            .addComponent(questionThirty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sqlLabel)
                            .addComponent(sqlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {questionEight, questionEleven, questionFifteen, questionFive, questionFour, questionFourteen, questionNine, questionSeven, questionSix, questionTen, questionThirteen, questionThree, questionTwelve, questionTwo});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sqlTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqlTextFieldActionPerformed
        resultTable.removeAll();
    
        try{    
            Statement statement = this.conn.createStatement();
            String Query = sqlTextField.getText();
            statement.execute(Query);
            JOptionPane.showMessageDialog(null, "successfully executed");
            getResult(Query);
            sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        
        
        //String Query = sqlTextField.getText();
        //getResult(Query);
        

    }//GEN-LAST:event_sqlTextFieldActionPerformed

    private void companyComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyComboActionPerformed
        String item = ""+companyCombo.getSelectedItem()+"";
        switch (item) {
            case "<select company>":
                JOptionPane.showMessageDialog(null, "select a company");
                break;
            
            case "add/remove":
                new AddCompany(conn).setVisible(true);
                companyCombo.setSelectedItem("<select company>");
                break;
                
            default:
                resultTable.removeAll();
                String Query = "select * from company where comp_id = '"+item+"'";         
                getResult(Query);
                break;
        }
    }//GEN-LAST:event_companyComboActionPerformed

    private void questionOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionOneActionPerformed
        if(companyCombo.getSelectedItem().equals("<select company>")){
            JOptionPane.showMessageDialog(null, "Select a Company");
        }else
        resultTable.removeAll();
        String Query = 
"select per_name\n" +
"from person natural join occupation\n" +
"where comp_id = '"+companyCombo.getSelectedItem()+"' and occ_status = 'employed'";
        getResult(Query);
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
      
    }//GEN-LAST:event_questionOneActionPerformed

    public void getResult(String query){
        resultTable.removeAll();
        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel dtm = new DefaultTableModel();
            int numOfCol = rsmd.getColumnCount();
            for(int i = 1; i <= numOfCol; i++){
                dtm.addColumn(rsmd.getColumnName(i));
            }
            while(rs.next()){
                String[] obj = new String[numOfCol];
                for(int i = 1; i <= numOfCol; i++){
                    obj[i-1] = rs.getString(i);
                }
                dtm.addRow(obj);
            }
            resultTable.setModel(dtm);
        }catch(SQLException e){
           //JOptionPane.showMessageDialog(null, e.toString());
        }
    }                                            
                                            

   
    private void questionTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionTwoActionPerformed
        if(companyCombo.getSelectedItem().equals("<select company>")){
            JOptionPane.showMessageDialog(null, "Select a Company");
        }else
        resultTable.removeAll();
        String Query = 
"select per_name,pay_rate\n" +
"from person natural join occupation natural join job\n" +
"where occ_status = 'employed' and comp_id = '"+companyCombo.getSelectedItem()+"'\n" +
"order by (pay_rate) desc";
        getResult(Query);
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
        
    }//GEN-LAST:event_questionTwoActionPerformed

    private void questionThreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionThreeActionPerformed
        resultTable.removeAll();
        String Query = 
"with total_salary as(\n" +
"   select sum (pay_rate) as t_salary,comp_id\n" +
"   from job natural join occupation\n" +
"   where job_type = 'salary' and occ_status = 'employed'\n" +
"   group by comp_id),\n" +
"total_wages as(\n" +
"   select sum(pay_rate) as t_wages,comp_id\n" +
"   from job natural join occupation\n" +
"   where job_type = 'wage' and occ_status = 'employed'\n" +
"   group by comp_id)\n" +
"select (t_wages+t_salary) as total_cost,comp_id\n" +
"from total_salary natural join total_wages\n" +
"order by total_cost desc";
        getResult(Query);
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
       
    }//GEN-LAST:event_questionThreeActionPerformed

    private void questionFourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionFourActionPerformed
        if(personCombo.getSelectedItem().equals("<select person>")){
            JOptionPane.showMessageDialog(null, "Select a Person");
        }else
        resultTable.removeAll();
        String Query = 
"select job_code\n" +
"from occupation\n" +
"where per_id = '"+personCombo.getSelectedItem()+"' and occ_status = 'employed'";
        getResult(Query);
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
        
    }//GEN-LAST:event_questionFourActionPerformed

    private void personComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personComboActionPerformed
        resultTable.removeAll();
        String item = ""+personCombo.getSelectedItem()+"";
        switch (item) {
            case "<select person>":
                JOptionPane.showMessageDialog(null, "select a person");
                break;
            case "add/remove":
                new AddPerson(conn).setVisible(true);
                personCombo.setSelectedItem("<select person>");
                break;
            default:
                String Query = "select * from person where per_id = '"+item+"'";
                getResult(Query);
                break;
        }
        
    }//GEN-LAST:event_personComboActionPerformed

    private void questionFiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionFiveActionPerformed
        if(personCombo.getSelectedItem().equals("<select person>")){
            JOptionPane.showMessageDialog(null, "Select a Person");
        }else
        resultTable.removeAll();
        String Query = 
"select sk_title,sk_description\n" +
"from person_skills natural join skills\n" +
"where per_id = '"+personCombo.getSelectedItem()+"'";
        getResult(Query);
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);

    }//GEN-LAST:event_questionFiveActionPerformed

    private void jobComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobComboActionPerformed
        resultTable.removeAll();
        String item = ""+jobCombo.getSelectedItem()+"";
        switch (item) {
            case "<select job>":
                JOptionPane.showMessageDialog(null, "select a job");
                break;
            case "add/remove":
                try{
                    new AddJob(conn).setVisible(true);
                    jobCombo.setSelectedItem("<select job>");
                }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.toString());
                }
                break;
            default:
                String Query = "select * from job where job_code = '"+item+"'";
                getResult(Query);
                break;
        }
        
    }//GEN-LAST:event_jobComboActionPerformed

    private void courseComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseComboActionPerformed
     
        resultTable.removeAll();
        String item = ""+courseCombo.getSelectedItem()+"";
        switch (item) {
            case "<select course>":
                JOptionPane.showMessageDialog(null, "select a course");
                break;
            case "add/remove":
                new AddCourse(conn).setVisible(true);
                courseCombo.setSelectedItem("<select course>");
                break;        
            default:
                String Query = "select * from course where course_code = '"+item+"'";
                getResult(Query);
                break;
        }
        
    }//GEN-LAST:event_courseComboActionPerformed

    private void questionSixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionSixActionPerformed
        if(personCombo.getSelectedItem().equals("<select person>")){
            JOptionPane.showMessageDialog(null, "Select a Person");
        }else
        resultTable.removeAll();
        String Query = 
"with person_jobs (job_code)as(\n" +
"   select  job_code\n" +
"   from occupation\n" +
"   where per_id = '"+personCombo.getSelectedItem()+"' and occ_status = 'employed')\n" +
"(select sk_code\n" +
"from job_profile_skills natural join person_jobs natural join job)\n" +
"minus\n" +
"(select sk_code\n" +
"from person_skills\n" +
"where per_id = '"+personCombo.getSelectedItem()+"')";     
        getResult(Query);
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
    }//GEN-LAST:event_questionSixActionPerformed

    private void questionSevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionSevenActionPerformed
        if(positionCombo.getSelectedItem().equals("<select profile>")){
            JOptionPane.showMessageDialog(null, "Select a profile");
        }else
        resultTable.removeAll();
        String Query = 
"select sk_code,sk_description\n" +
"from job_profile_skills natural join skills\n" +
"where pos_code = '"+positionCombo.getSelectedItem()+"'";
        getResult(Query);
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
    }//GEN-LAST:event_questionSevenActionPerformed

    private void questionEightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionEightActionPerformed
        if(jobCombo.getSelectedItem().equals("<select job>")){
            JOptionPane.showMessageDialog(null, "Select a Person and Job");
        }
        else if(personCombo.getSelectedItem().equals("<select person>")){
            JOptionPane.showMessageDialog(null, "Select a Person and Job");
        }else
        resultTable.removeAll();
        String Query = 
"(select sk_code,sk_description\n" +
"from job_profile_skills natural join skills natural join job\n" +
"where job_code = '"+jobCombo.getSelectedItem()+"') \n" +
"minus \n" +
"(select sk_code,sk_description\n" +
"from person_skills natural join skills\n" +
"where per_id = '"+personCombo.getSelectedItem()+"')";            
        getResult(Query);
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
    }//GEN-LAST:event_questionEightActionPerformed

    private void positionComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionComboActionPerformed
        
        resultTable.removeAll();
        String item = ""+positionCombo.getSelectedItem()+"";
        switch (item) {
            case "<select profile>":
                JOptionPane.showMessageDialog(null, "select a profile");
                break;
            case "add/remove":
                new AddJobProfile(conn).setVisible(true);
                positionCombo.setSelectedItem("<select position>");
                break;
            default:
                String Query = "select * from profile where pos_code = '"+item+"'";
                getResult(Query);
                break;
        }
    }//GEN-LAST:event_positionComboActionPerformed

    private void questionNineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionNineActionPerformed
        if(positionCombo.getSelectedItem().equals("<select profile>")){
            JOptionPane.showMessageDialog(null, "Select a profile");
        }else
        resultTable.removeAll();
        String Query = 
"with skills_sets as(\n" +
"   select sk_code\n" +
"   from job_profile_skills\n" +
"   where pos_code = '"+positionCombo.getSelectedItem()+"'\n" +
")\n" +
"select C.course_code\n" +
"from course C\n" +
"where not exists(select *\n" +
"	from skills_sets\n" +
"	minus\n" +
"	select sk_code\n" +
"	from course_skills \n" +
"	where course_skills.course_code = C.course_code)";             
        getResult(Query);
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
    }//GEN-LAST:event_questionNineActionPerformed

    private void questionTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionTenActionPerformed
        if(jobCombo.getSelectedItem().equals("<select job>")){
            JOptionPane.showMessageDialog(null, "Select a Person and Job");
        }
        else if(personCombo.getSelectedItem().equals("<select person>")){
            JOptionPane.showMessageDialog(null, "Select a Person and Job");
        }else
        resultTable.removeAll();
        String Query = 
"with skills_sets as(\n" +
"   select sk_code\n" +
"   from job_profile_skills natural join job\n" +
"   where job_code = '"+jobCombo.getSelectedItem()+"'\n" +
"   minus\n" +
"   select sk_code\n" +
"   from person_skills\n" +
"   where per_id = '"+personCombo.getSelectedItem()+"'\n" +
"),\n" +
"the_course_skills as(\n" +
"   select distinct C.course_code,C.title\n" +
"   from course C\n" +
"   where not exists(select *\n" +
"       from skills_sets\n" +
"       minus\n" +
"       select sk_code\n" +
"       from course_skills\n" +
"       where course_skills.course_code = C.course_code\n" +
"))\n" +
"select *\n" +
"from the_course_skills";
        getResult(Query);
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
    }//GEN-LAST:event_questionTenActionPerformed

    private void questionElevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionElevenActionPerformed
        if(jobCombo.getSelectedItem().equals("<select job>")){
            JOptionPane.showMessageDialog(null, "Select a Person and Job");
        }
        else if(personCombo.getSelectedItem().equals("<select person>")){
            JOptionPane.showMessageDialog(null, "Select a Person and Job");
        }else
        resultTable.removeAll();
        String Query = 
"with person_needs as (\n" +
"   (select sk_code\n" +
"   from job_profile_skills natural join job\n" +
"   where job_code = '"+jobCombo.getSelectedItem()+"') \n" +
"   minus\n" +
"   (select sk_code\n" +
"   from person_skills\n" +
"   where per_id = '"+personCombo.getSelectedItem()+"')\n" +
"),\n" +
"the_course_skills as(\n" +
"   select distinct C.course_code,S.sec_year\n" +
"   from course C, section S\n" +
"   where not exists(select *\n" +
"       from person_needs\n" +
"       minus\n" +
"       select sk_code\n" +
"       from course_skills natural join section\n" +
"       where course_code = C.course_code and sec_year = S.sec_year\n"+
"))\n" +
"select course_code,sec_year\n" +
"from the_course_skills\n" +
"where sec_year >= 2016";
        getResult(Query);
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
    }//GEN-LAST:event_questionElevenActionPerformed

    private void questionTwelveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionTwelveActionPerformed
        if(positionCombo.getSelectedItem().equals("<select profile>")){
            JOptionPane.showMessageDialog(null, "Select a Profile");
        }else
        resultTable.removeAll();
        String Query = 
"with job_set as(\n" +
"	select job_code,sk_code\n" +
"	from job natural join job_profile_skills\n" +
"	where pos_code = '"+positionCombo.getSelectedItem()+"'\n" +
"),\n" +
"course_sets as(\n" +
"	select course_code as A,null as B,null as C\n" +
"	from course\n" +
"	union\n" +
"	select A.course_code as A,B.course_code as B,null as C\n" +
"	from course A,course B\n" +
"	where A.course_code < B.course_code\n" +
"	union\n" +
"	select A.course_code as A,B.course_code as B,C.course_code as C\n" +
"	from course A,course B,course C\n" +
"	where A.course_code < B.course_code and B.course_code < C.course_code),\n" +
"course_set_skills as(\n" +
"	select A,B,C,sk_code\n" +
"	from course_skills,course_sets\n" +
"	where course_sets.A = course_skills.course_code or\n" +
"		  course_sets.B = course_skills.course_code or\n" +
"		  course_sets.C = course_skills.course_code\n" +
"),\n" +
"good_sets as (\n" +
"	select *\n" +
"	from(\n" +
"		(select A,B,C from course_set_skills)\n" +
"		minus\n" +
"	(select A,B,C\n" +
"		from(select A,B,C,sk_code\n" +
"		from(select A,B,C\n" +
"		from course_set_skills),\n" +
"	(select *\n" +
"		from job_set)\n" +
"		minus\n" +
"	select A,B,C,sk_code\n" +
"	from course_set_skills)))),\n" +
"count_em as(\n" +
"	select A,B,C,\n" +
"	case\n" +
"	when B is null then 1\n" +
"	when C is null then 2\n" +
"	else 3\n" +
"	end as number_of_courses\n" +
"	from good_sets)\n" +
"select A,B,C,number_of_courses\n" +
"from count_em\n" +
"where number_of_courses = (select min(number_of_courses) from count_em)";
        getResult(Query);
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
    }//GEN-LAST:event_questionTwelveActionPerformed

    private void questionThirteenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionThirteenActionPerformed
        if(jobCombo.getSelectedItem().equals("<select job>")){
            JOptionPane.showMessageDialog(null, "Select a Person and Job");
        }
        else if(personCombo.getSelectedItem().equals("<select person>")){
            JOptionPane.showMessageDialog(null, "Select a Person and Job");
        }
        else
        resultTable.removeAll();
        String Query = 
"with person_needs as (\n" +
"   (select sk_code,sk_description\n" +
"   from job_profile_skills natural join job natural join skills\n" +
"   where job_code = '"+jobCombo.getSelectedItem()+"') \n" +
"   minus\n" +
"   (select sk_code,sk_description\n" +
"   from person_skills natural join skills\n" +
"   where per_id = '"+personCombo.getSelectedItem()+"')\n" +
"),\n" +
"course_sets as(\n" +
"   select course_code as A,null as B,null as C\n" +
"   from course\n" +
"   union\n" +
"   select A.course_code as A,B.course_code as B,null as C\n" +
"   from course A,course B\n" +
"   where A.course_code < B.course_code\n" +
"   union\n" +
"   select A.course_code as A,B.course_code as B,C.course_code as C\n" +
"   from course A,course B,course C\n" +
"   where A.course_code < B.course_code and B.course_code < C.course_code),\n" +
"course_set_skills as(\n" +
"   select A,B,C,sk_code\n" +
"   from course_skills,course_sets\n" +
"   where course_sets.A = course_skills.course_code or\n" +
"       course_sets.B = course_skills.course_code or\n" +
"       course_sets.C = course_skills.course_code\n" +
"),\n" +
"good_sets as (\n" +
"   select *\n" +
"   from(\n" +
"       (select A,B,C from course_set_skills)\n" +
"       minus\n" +
"   (select A,B,C\n" +
"       from(select A,B,C,sk_code\n" +
"       from(select A,B,C\n" +
"       from course_set_skills),\n" +
"   (select *\n" +
"       from person_needs)\n" +
"       minus\n" +
"   select A,B,C,sk_code\n" +
"       from course_set_skills)))),\n" +
"count_em as(\n" +
"   select A,B,C,\n" +
"   case\n" +
"   when B is null then 1\n" +
"   when C is null then 2\n" +
"   else 3\n" +
"   end as number_of_courses\n" +
"from good_sets)\n" +
"select A,B,C,number_of_courses\n" +
"from count_em\n" +
"where number_of_courses = (select min(number_of_courses) from count_em)";
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
        getResult(Query);    }//GEN-LAST:event_questionThirteenActionPerformed

    private void questionFourteenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionFourteenActionPerformed
        if(personCombo.getSelectedItem().equals("<select person>")){
            JOptionPane.showMessageDialog(null, "Select a Person and Job");
        }
        else if(jobCombo.getSelectedItem().equals("<select job>")){
            JOptionPane.showMessageDialog(null, "Select a Person and Job");
        }
        else
        resultTable.removeAll();
        String Query = 
"with person_needs as (\n" +
"   (select sk_code,sk_description\n" +
"   from job_profile_skills natural join job natural join skills\n" +
"   where job_code = '"+jobCombo.getSelectedItem()+"') \n" +
"   minus \n" +
"   (select sk_code,sk_description\n" +
"   from person_skills natural join skills\n" +
"   where per_id = '"+personCombo.getSelectedItem()+"')\n" +
"),\n" +
"course_sets as(\n" +
"   select course_code as A,null as B,null as C\n" +
"   from course\n" +
"   union\n" +
"   select A.course_code as A,B.course_code as B,null as C\n" +
"   from course A,course B\n" +
"   where A.course_code < B.course_code\n" +
"   union\n" +
"   select A.course_code as A,B.course_code as B,C.course_code as C\n" +
"   from course A,course B,course C\n" +
"   where A.course_code < B.course_code and B.course_code < C.course_code),\n" +
"course_set_skills as(\n" +
"   select A,B,C,sk_code\n" +
"   from course_skills,course_sets\n" +
"   where course_sets.A = course_skills.course_code or\n" +
"       course_sets.B = course_skills.course_code or\n" +
"       course_sets.C = course_skills.course_code\n" +
"),\n" +
"good_sets as (\n" +
"   select *\n" +
"   from(\n" +
"       (select A,B,C from course_set_skills)\n" +
"       minus\n" +
"       (select A,B,C\n" +
"       from(select A,B,C,K.sk_code\n" +
"       from course_set_skills K,\n" +
"       (select *\n" +
"           from person_needs)\n" +
"           minus\n" +
"	select A,B,C,sk_code\n" +
"	from course_set_skills)))),\n" +
"courses_total as(\n" +
"   select A,B,C,A as course_code\n" +
"   from good_sets\n" +
"   union\n" +
"   select A,B,C,B as course_code\n" +
"   from good_sets\n" +
"   union\n" +
"   select A,B,C,C as course_code\n" +
"   from good_sets\n" +
"),\n" +
"associated_cost as(\n" +
"   select A,B,C,sum(retail_price) as total_cost\n" +
"   from courses_total natural join course\n" +
"   group by A,B,C)	\n" +
"select A,B,C,total_cost\n" +
"from associated_cost\n" +
"where total_cost = (select min(total_cost) from associated_cost)";
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
        getResult(Query);    }//GEN-LAST:event_questionFourteenActionPerformed

    private void questionFifteenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionFifteenActionPerformed
        if(personCombo.getSelectedItem().equals("<select person>")){
            JOptionPane.showMessageDialog(null, "Select a Person");
        }else
        resultTable.removeAll();
        String Query = 
"with persons_skills as(\n" +
"	select sk_code\n" +
"	from person_skills\n" +
"	where per_id = '"+personCombo.getSelectedItem()+"'\n" +
"),\n" +
"persons_certificates as(\n" +
"	select cert_code\n" +
"	from person_certificates\n" +
"	where per_id = '"+personCombo.getSelectedItem()+"'\n" +
")\n" +
"select pos_code,title\n" +
"from job_profile T\n" +
"where not exists(select sk_code\n" +
"       from job_profile_skills\n" +
"       where T.pos_code = pos_code\n" +
"       minus\n" +
"       select sk_code\n" +
"       from persons_skills)\n" +
"	and\n" +
"	not exists(select cert_code\n" +
"           from profile_certificates\n" +
"           where T.pos_code = pos_code\n" +
"           minus\n" +
"           select cert_code\n" +
"           from persons_certificates)";                

        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
        getResult(Query);    }//GEN-LAST:event_questionFifteenActionPerformed

    private void questionSixteenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionSixteenActionPerformed
        if(personCombo.getSelectedItem().equals("<select person>")){
            JOptionPane.showMessageDialog(null, "Select a Person");
        }else
        resultTable.removeAll();
        String Query = 
"with persons_skills as(\n" +
"	select sk_code\n" +
"	from person_skills\n" +
"	where per_id = '"+personCombo.getSelectedItem()+"'\n" +
"),\n" +
"persons_certificates as(\n" +
"	select cert_code\n" +
"	from person_certificates\n" +
"	where per_id = '"+personCombo.getSelectedItem()+"'\n" +
"),\n" +
"qualified_for as(\n" +
"	select pos_code,title\n" +
"	from job_profile T\n" +
"	where not exists(select sk_code\n" +
"           from job_profile_skills\n" +
"           where T.pos_code = pos_code\n" +
"           minus\n" +
"           select sk_code\n" +
"           from persons_skills)\n" +
"       and\n" +
"       not exists(select cert_code\n" +
"           from profile_certificates\n" +
"           where T.pos_code = pos_code\n" +
"           minus\n" +
"           select cert_code\n" +
"           from persons_certificates)),\n" +
"jobs_qualified_for as(\n" +
"	select distinct job_code\n" +
"	from qualified_for natural join job),\n" +
"them as (\n" +
"	select distinct job_code,(case\n" +
"           when job_type = 'salary' then pay_rate\n" +
"           when job_type = 'wage' then pay_rate\n" +
"           else null\n" +
"           end) as max_payment\n" +
"       from jobs_qualified_for natural join job),\n" +
"max as (select max(max_payment)\n" +
"from them)\n" +
"select job_code,max_payment\n" +
"from them\n" +
"where max_payment = (select * from max)";                
                
                
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
        getResult(Query);    }//GEN-LAST:event_questionSixteenActionPerformed

    private void questionSeventeenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionSeventeenActionPerformed
        if(positionCombo.getSelectedItem().equals("<select profile>")){
            JOptionPane.showMessageDialog(null, "Select a Profile");
        }else
        resultTable.removeAll();
        String Query = 
"with required_skills as(\n" +
"   select sk_code\n" +
"   from job_profile_skills\n" +
"   where pos_code = '"+positionCombo.getSelectedItem()+"'),\n" +
"required_certificates as(\n" +
"   select cert_code\n" +
"   from profile_certificates\n" +
"   where pos_code = '"+positionCombo.getSelectedItem()+"'\n" +
")\n" +
"select per_name,email\n" +
"from person P\n" +
"where not exists(\n" +
"   select sk_code\n" +
"   from required_skills\n" +
"   minus\n" +
"   select sk_code\n" +
"   from person_skills\n" +
"   where P.per_id = per_id) and not exists(\n" +
"       select cert_code\n" +
"       from required_certificates\n" +
"       minus\n" +
"       select cert_code\n" +
"       from person_certificates\n" +
"       where P.per_id = per_id\n" +
")";              
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
        getResult(Query);    }//GEN-LAST:event_questionSeventeenActionPerformed

    private void questionEightteenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionEightteenActionPerformed
        if(jobCombo.getSelectedItem().equals("<select job>")){
            JOptionPane.showMessageDialog(null, "Select a Job");
        }else
        resultTable.removeAll();
        String Query = 
"with skill_codes as(\n" +
"   select sk_code\n" +
"   from job_profile_skills natural join job\n" +
"   where job_code = '"+jobCombo.getSelectedItem()+"'\n" +
"),\n" +
"people_missing as (\n" +
"   select per_id,sk_code" +
"   from person, skill_codes\n" +
"   minus\n" +
"   select per_id, sk_code\n" +
"   from person_skills),\n" +
"num_missing as(\n" +
"   select per_id, count(sk_code) as num\n" +
"   from people_missing\n" +
"   group by per_id\n" +
")\n" +
"select per_id, num\n" +
"from num_missing\n" +
"where  num = 1\n";
        
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
        getResult(Query);    }//GEN-LAST:event_questionEightteenActionPerformed

    private void questionNineteenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionNineteenActionPerformed
        if(positionCombo.getSelectedItem().equals("<select profile>")){
            JOptionPane.showMessageDialog(null, "Select a Profile");
        }else{    
        resultTable.removeAll();
        String Query = 
"with skill_codes as(\n" +
"   select sk_code\n" +
"   from job_profile_skills\n" +
"   where pos_code = '"+positionCombo.getSelectedItem()+"'\n" +
"),\n" +
"people_missing as (\n" +
"   select per_id, sk_code\n" +
"   from person, skill_codes\n" +
"   minus\n" +
"   select per_id, sk_code\n" +
"   from person_skills),\n" +
"people_missing_skill_count as(\n" +
"   select per_id, count(sk_code) as skills_missing\n" +
"   from people_missing\n" +
"   group by per_id)\n" +
"select count(per_id) as people_count, sk_code\n" +
"from people_missing_skill_count natural join people_missing\n" +
"where skills_missing = 1\n" +
"group by sk_code\n" +
"order by (people_count)\n";
             
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
        getResult(Query);    }//GEN-LAST:event_questionNineteenActionPerformed
    }
    private void questionTwentyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionTwentyActionPerformed
        if(positionCombo.getSelectedItem().equals("<select profile>")){
            JOptionPane.showMessageDialog(null, "Select a Profile");
        }else
        resultTable.removeAll();
        String Query = 
"with skill_codes as(\n" +
"	select sk_code\n" +
"	from job_profile_skills\n" +
"	where pos_code = '"+positionCombo.getSelectedItem()+"'\n" +
"),\n" +
"people_missing as (\n" +
"	select per_id,sk_code\n" +
"	from person,skill_codes\n" +
"	minus\n" +
"	select per_id,sk_code\n" +
"	from person_skills),\n" +
"num_skills_missing as (\n" +
"	select per_id,count(sk_code) as num_missing\n" +
"	from people_missing\n" +
"	group by per_id),\n" +
"least_missing as(\n" +
"	select min(num_missing) as the_least\n" +
"	from num_skills_missing\n" +
")\n" +
"select per_id,num_missing\n" +
"from least_missing,num_skills_missing\n" +
"where num_missing = the_least";
        
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
        getResult(Query);    }//GEN-LAST:event_questionTwentyActionPerformed

    private void questionTwentyoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionTwentyoneActionPerformed
        if(positionCombo.getSelectedItem().equals("<select profile>")){
            JOptionPane.showMessageDialog(null, "Select a Profile");
        }else
        resultTable.removeAll();
        String Query = 
"with skill_codes as(\n" +
"   select sk_code\n" +
"   from job_profile_skills\n" +
"   where pos_code = '"+positionCombo.getSelectedItem()+"'\n" +
"),\n" +
"people_missing as (\n" +
"   select per_id,sk_code" +
"   from person,skill_codes" +
"   minus\n" +
"   select per_id, sk_code\n" +
"   from person_skills)," +
"num_skills_missing as(" +
"   select per_id,count(sk_code) as num_missing\n" +
"   from people_missing\n" +
"   group by per_id)\n" +
"select per_id,num_missing\n" +
"from num_skills_missing\n" +
"where num_missing <= '"+kText.getText()+"'\n" +
"order by (num_missing) asc";
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
        getResult(Query);    }//GEN-LAST:event_questionTwentyoneActionPerformed

    private void questionTwentytwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionTwentytwoActionPerformed
        if(positionCombo.getSelectedItem().equals("<select profile>")){
            JOptionPane.showMessageDialog(null, "Select a Profile");
        }else
        resultTable.removeAll();
        String Query = 
"with skill_codes as(\n" +
"   select sk_code\n" +
"   from job_profile_skills\n" +
"   where pos_code = '"+positionCombo.getSelectedItem()+"'\n" +
"),\n" +
"people_missing as (\n" +
"   select per_id, sk_code\n" +
"   from person,skill_codes \n" +
"   minus\n" +
"   select per_id, sk_code\n" +
"   from person_skills),\n" +
"num_skills_missing as(\n" +
"   select per_id, count(sk_code) as num_missing\n" +
"   from people_missing\n" +
"   group by per_id)\n" +
"select count(per_id) as people_count, sk_code\n" +
"from num_skills_missing natural join people_missing\n" +
"where num_missing = '"+kText.getText()+"'\n" +
"group by sk_code \n" +
"order by (people_count) desc\n";
        
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
        getResult(Query);    }//GEN-LAST:event_questionTwentytwoActionPerformed

    private void questionTwentythreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionTwentythreeActionPerformed
        if(positionCombo.getSelectedItem().equals("<select profile>")){
            JOptionPane.showMessageDialog(null, "Select a Profile");
        }else
        resultTable.removeAll();
        String Query = 
"select distinct per_id,per_name\n" +
"from occupation natural join job natural join person\n" +
"where pos_code = '"+positionCombo.getSelectedItem()+"'";
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
        getResult(Query);    }//GEN-LAST:event_questionTwentythreeActionPerformed

    private void questionTwentyfourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionTwentyfourActionPerformed
        if(positionCombo.getSelectedItem().equals("<select profile>")){
            JOptionPane.showMessageDialog(null, "Select a Profile");
        }else
        resultTable.removeAll();
        String Query = 
"with unemployed as(\n" +
"   select per_id\n" +
"   from person\n" +
"   minus\n" +
"   select distinct per_id\n" +
"   from occupation\n" +
"   where occ_status = 'employed'\n" +
")\n" +
"select distinct per_id,job_code,pos_code\n" +
"from occupation natural join job natural join unemployed\n" +
"where pos_code = '"+positionCombo.getSelectedItem()+"'";
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
        getResult(Query);    }//GEN-LAST:event_questionTwentyfourActionPerformed
        
    private void questionTwentyfiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionTwentyfiveActionPerformed
        resultTable.removeAll();
        String Query = 
"with employer_count as (select count(pay_rate) as num_employees,comp_id\n" +
"   from job natural join occupation\n" +
"   where occ_status = 'employed'\n" +
"   group by comp_id)\n" +
"select comp_id,num_employees\n" +
"from employer_count\n" +
"order by (num_employees) desc";
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
        getResult(Query);    }//GEN-LAST:event_questionTwentyfiveActionPerformed

    private void questionTwentysixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionTwentysixActionPerformed
        resultTable.removeAll();
        String Query = 
"with employer_count as ( \n" +
"	select count(pay_rate) as num_employees,comp_id\n" +
"	from job natural join occupation\n" +
"	where occ_status = 'employed'\n" +
"	group by comp_id),\n" +
"count_per_sector as(\n" +
"	select primary_sector,sum(num_employees) as sector_employee_count\n" +
"	from employer_count natural join company\n" +
"	group by primary_sector),\n" +
"max_count as(\n" +
"	select max(sector_employee_count) as the_max\n" +
"	from count_per_sector\n" +
")\n" +
"select primary_sector\n" +
"from max_count,count_per_sector\n" +
"where the_max = sector_employee_count";                
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
        getResult(Query);    }//GEN-LAST:event_questionTwentysixActionPerformed

    private void questionTwentysevenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionTwentysevenActionPerformed
        
        if(sectorCombo.getSelectedItem().equals("<sector>")){
            JOptionPane.showMessageDialog(null, "Select a Sector");
        }else
        resultTable.removeAll();
        String Query = 
"with previous_salary as(\n" +
"   select distinct max(pay_rate) as past_pay,per_id\n" +
"   from occupation natural join job natural join company\n" +
"   where occ_status = 'unemployed' and primary_sector = '"+sectorCombo.getSelectedItem()+"'\n" +
"   group by per_id\n" +
"),\n" +
"current_salary as(\n" +
"   select distinct max(pay_rate) as now_pay,per_id\n" +
"   from occupation natural join job natural join company\n" +
"   where occ_status = 'employed' and primary_sector = '"+sectorCombo.getSelectedItem()+"'\n" +
"   group by per_id\n" +
"),\n" +
"decrease_people as(\n" +
"   select count(per_id) as decrease\n" +
"   from previous_salary natural join current_salary\n" +
"   where now_pay < past_pay\n" +
"),\n" +
"increase_people as(\n" +
"   select count(per_id) as increase\n" +
"   from previous_salary natural join current_salary\n" +
"   where now_pay > past_pay\n" +
")\n" +
"select sum(increase) as increase_ratio,sum(decrease) as decrease_ratio\n" +
"from increase_people natural join decrease_people";
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
        getResult(Query);    }//GEN-LAST:event_questionTwentysevenActionPerformed

    private void questionTwentyeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionTwentyeightActionPerformed
        resultTable.removeAll();
        String Query = 
"with unemployed_people as(\n" +
"	select per_id\n" +
"	from person\n" +
"	minus\n" +
"	select distinct per_id\n" +
"	from occupation\n" +
"	where occ_status = 'employed'\n" +
"	),\n" +
"employed_people as(\n" +
"	select distinct per_id\n" +
"	from occupation\n" +
"	where occ_status = 'employed'\n" +
"),\n" +
"job_openings as(\n" +
"	select distinct job_code\n" +
"	from (\n" +
"           select job_code\n" +
"           from unemployed_people natural join occupation\n" +
"           minus\n" +
"           select job_code\n" +
"           from employed_people natural join occupation\n" +
")),\n" +
"profile_num_jobs as(\n" +
"   select pos_code,count(job_code) as num_jobs_open\n" +
"   from job_openings natural join job\n" +
"   group by pos_code\n" +
"),\n" +
"qualified_people as(\n" +
"	select pos_code,count(per_id) as num_qualified\n" +
"	from profile_num_jobs J,person P\n" +
"	where not exists(\n" +
"       select sk_code\n" +
"       from profile_num_jobs natural join job_profile_skills\n" +
"       where J.pos_code = pos_code\n" +
"       minus\n" +
"       select distinct sk_code\n" +
"       from profile_num_jobs natural join job_profile_skills natural join person_skills\n" +
"       where P.per_id = per_id\n" +
"	)\n" +
"	group by pos_code),\n" +
"lacking as (\n" +
"	select pos_code, (num_jobs_open - num_qualified) as lack_qualified\n" +
"	from qualified_people natural join profile_num_jobs),\n" +
"max_lacking as(\n" +
"	select max(lack_qualified) as max_lack\n" +
"	from lacking\n" +
")\n" +
"select pos_code\n" +
"from lacking,max_lacking\n" +
"where lack_qualified = max_lack";
        
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
        getResult(Query);    }//GEN-LAST:event_questionTwentyeightActionPerformed

    private void questionTwentynineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionTwentynineActionPerformed
        resultTable.removeAll();
        String Query = 
"with unemployed_people as(\n" +
"	select per_id\n" +
"	from person\n" +
"	minus\n" +
"	select distinct per_id\n" +
"	from occupation\n" +
"	where occ_status = 'employed'\n" +
"	),\n" +
"employed_people as(\n" +
"	select distinct per_id\n" +
"	from occupation\n" +
"	where occ_status = 'employed'\n" +
"),\n" +
"job_openings as(\n" +
"	select distinct job_code\n" +
"	from (\n" +
"       select job_code\n" +
"       from unemployed_people natural join occupation\n" +
"       minus\n" +
"       select job_code\n" +
"       from employed_people natural join occupation\n" +
"	)),\n" +
"profile_num_jobs as(\n" +
"	select pos_code,count(job_code) as num_jobs_open\n" +
"	from job_openings natural join job\n" +
"	group by pos_code\n" +
"),\n" +
"qualified_people as(\n" +
"	select pos_code,count(per_id) as num_qualified\n" +
"	from profile_num_jobs J,person P\n" +
"	where not exists(\n" +
"       select sk_code\n" +
"       from profile_num_jobs natural join job_profile_skills\n" +
"       where J.pos_code = pos_code\n" +
"       minus\n" +
"       select distinct sk_code\n" +
"       from profile_num_jobs natural join job_profile_skills natural join person_skills\n" +
"       where P.per_id = per_id\n" +
"	)\n" +
"	group by pos_code),\n" +
"lacking as (\n" +
"	select pos_code, (num_jobs_open - num_qualified) as lack_qualified\n" +
"	from qualified_people natural join profile_num_jobs),\n" +
"max_lacking as(\n" +
"	select max(lack_qualified) as max_lack\n" +
"	from lacking\n" +
"),\n" +
"max_lacking_job as(\n" +
"	select pos_code\n" +
"	from lacking,max_lacking\n" +
"	where lack_qualified = max_lack),\n" +
"course_sets as(\n" +
"	select course_code as A,null as B,null as C\n" +
"	from course\n" +
"	union\n" +
"	select A.course_code as A,B.course_code as B,null as C\n" +
"	from course A,course B\n" +
"	where A.course_code < B.course_code\n" +
"	union\n" +
"	select A.course_code as A,B.course_code as B,C.course_code as C\n" +
"	from course A,course B,course C\n" +
"	where A.course_code < B.course_code and B.course_code < C.course_code),\n" +
"course_set_skills as(\n" +
"	select A,B,C,sk_code\n" +
"	from course_skills,course_sets\n" +
"	where course_sets.A = course_skills.course_code or\n" +
"		  course_sets.B = course_skills.course_code or\n" +
"		  course_sets.C = course_skills.course_code)\n" +
"select *\n" +
"from (\n" +
"	(select A,B,C,pos_code\n" +
"           from course_set_skills,max_lacking_job)\n" +
"           minus\n" +
"               (select A,B,C,pos_code\n" +
"                   from(\n" +
"                   select A,B,C,pos_code,sk_code\n" +
"                   from(select A,B,C\n" +
"                   from course_set_skills),\n" +
"                   (select pos_code,sk_code\n" +
"                   from max_lacking_job natural join job_profile_skills)\n" +
"                   minus\n" +
"                   select A,B,C,pos_code,sk_code\n" +
"                   from course_set_skills,max_lacking_job)))";
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
        getResult(Query);    }//GEN-LAST:event_questionTwentynineActionPerformed

    private void questionThirtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionThirtyActionPerformed
        if(personCombo.getSelectedItem().equals("<select person>")){
            JOptionPane.showMessageDialog(null, "Select a Person and Profile");
        }
        else if(positionCombo.getSelectedItem().equals("<select profile>")){
            JOptionPane.showMessageDialog(null, "Select a Person and Profile");
        }else
        resultTable.removeAll();
        String Query = 
"with this_guys_skills as(\n" +
"   select sk_code\n" +
"   from person_skills\n" +
"   where per_id = '"+personCombo.getSelectedItem()+"'\n" +
"),\n" +
"this_guys_courses as(" +
"   select course_code\n" +
"   from takes\n" +
"   where per_id = '"+personCombo.getSelectedItem()+"'\n" +
"),\n" +
"needed_skills as(\n" +
"   select sk_code\n" +
"   from job_profile_skills\n" +
"   where pos_code = '"+positionCombo.getSelectedItem()+"'\n" +
"   minus\n" +
"   select sk_code\n" +
"   from this_guys_skills\n" +
"),\n" +
"courses_needed as(\n" +
"   select course_code\n" +
"   from needed_skills natural join course_skills\n" +
")\n" +
"select distinct course_code\n" +
"from courses_needed C\n" +
"where not exists(\n" +
"   select course_code\n" +
"   from this_guys_courses\n" +
"   where C.course_code = course_code)\n";
                
                
        sqlDisplay.append("\n------------------------------------------------------------\n"+Query);
        getResult(Query);
    }//GEN-LAST:event_questionThirtyActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new BusinessProcess(conn).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sectorComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectorComboActionPerformed
        resultTable.removeAll();
        String item = ""+sectorCombo.getSelectedItem()+"";
        switch (item) {
            case "<sector>":
                JOptionPane.showMessageDialog(null, "select a sector");
                break;
            default:
                String Query = "select * from company where primary_sector = '"+item+"'";
                getResult(Query);
                break;
        }
    }//GEN-LAST:event_sectorComboActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> companyCombo;
    private javax.swing.JComboBox<String> courseCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jobCombo;
    private javax.swing.JTextField kText;
    private javax.swing.JComboBox<String> personCombo;
    private javax.swing.JComboBox<String> positionCombo;
    private javax.swing.JRadioButton questionEight;
    private javax.swing.JRadioButton questionEightteen;
    private javax.swing.JRadioButton questionEleven;
    private javax.swing.JRadioButton questionFifteen;
    private javax.swing.JRadioButton questionFive;
    private javax.swing.JRadioButton questionFour;
    private javax.swing.JRadioButton questionFourteen;
    private javax.swing.ButtonGroup questionGroup;
    private javax.swing.JRadioButton questionNine;
    private javax.swing.JRadioButton questionNineteen;
    private javax.swing.JRadioButton questionOne;
    private javax.swing.JRadioButton questionSeven;
    private javax.swing.JRadioButton questionSeventeen;
    private javax.swing.JRadioButton questionSix;
    private javax.swing.JRadioButton questionSixteen;
    private javax.swing.JRadioButton questionTen;
    private javax.swing.JRadioButton questionThirteen;
    private javax.swing.JRadioButton questionThirty;
    private javax.swing.JRadioButton questionThree;
    private javax.swing.JRadioButton questionTwelve;
    private javax.swing.JRadioButton questionTwenty;
    private javax.swing.JRadioButton questionTwentyeight;
    private javax.swing.JRadioButton questionTwentyfive;
    private javax.swing.JRadioButton questionTwentyfour;
    private javax.swing.JRadioButton questionTwentynine;
    private javax.swing.JRadioButton questionTwentyone;
    private javax.swing.JRadioButton questionTwentyseven;
    private javax.swing.JRadioButton questionTwentysix;
    private javax.swing.JRadioButton questionTwentythree;
    private javax.swing.JRadioButton questionTwentytwo;
    private javax.swing.JRadioButton questionTwo;
    private javax.swing.JTable resultTable;
    private javax.swing.JComboBox<String> sectorCombo;
    private javax.swing.JTextArea sqlDisplay;
    private javax.swing.JLabel sqlLabel;
    private javax.swing.JTextField sqlTextField;
    // End of variables declaration//GEN-END:variables
}
