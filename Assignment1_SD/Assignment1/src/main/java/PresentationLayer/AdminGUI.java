/*
 * Created by JFormDesigner on Sun Mar 17 12:26:40 EET 2019
 */

package PresentationLayer;

import BusinessLayer.Employee;
import BusinessLayer.Report;

import javax.swing.table.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 * @author unknown
 */
public class AdminGUI extends JFrame {
    public AdminGUI(int log) {
        initComponents();
        this.setTitle("Bank Application Admin");
        this.logId = log;
        this.accountBTNMouseClicked(null);
        setTableValues();


    }


    private void accountBTNMouseClicked(MouseEvent e) {
        // TODO add your code here
        //---- nameLabel ----
        nameLabel.setText("NAME");

        //---- pidLabel ----
        pidLabel.setText("PID");

        //---- addressLabel ----
        addressLabel.setText("ADDRESS");

        //---- phoneLabel ----
        phoneLabel.setText("PHONE");
        userLabel.setText("USERNAME");
        passwordLabel.setText("PASSWORD");
        action = 1;
        infoAcc();
        setTableValues();
    }

    private void infoAcc() {
        nameLabel.setVisible(true);
        pidLabel.setVisible(true);
        addressLabel.setVisible(true);
        phoneLabel.setVisible(true);
        name.setVisible(true);
        pid.setVisible(true);
        address.setVisible(true);
        phone.setVisible(true);
        addcrBTN.setVisible(true);
        updateBTN.setVisible(true);
        delBTN.setVisible(true);
        genBTN.setVisible(false);
        searchBox.setVisible(true);
        searchField.setVisible(true);
        searchBTN.setVisible(true);
        this.repaint();
    }


    private void setTableValues() {
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        dtm.setRowCount(0);
        ArrayList<Employee> emps = Employee.getE();
        for(Employee emp : emps){
            if(emp.getType() == 1){
                dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Normal"});
            }else if(emp.getType() == 0){
                dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Admin"});
            }else{
                dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Outlaw"});
            }

        }
    }

    private void addcrBTNMouseClicked(MouseEvent e) {
        // TODO add your code here
        Employee emp = new Employee();
        emp.setName(name.getText());
        emp.setPid(pid.getText());
        emp.setAddress(address.getText());
        emp.setPhone(phone.getText());
        emp.setUsername(userField.getText());
        emp.setPassword(passwordField.getText());
        if(!(pid.getText().matches("[0-9]+"))){
            JOptionPane.showMessageDialog(this, "Error: Invalid input PID!");
            return;
        }
        if(!(phone.getText().matches("[0-9]+"))){
            JOptionPane.showMessageDialog(this, "Error: Invalid input PHONE!");
            return;
        }
        if(typeField.getText().toLowerCase().equals("admin")){
            emp.setType(0);
        }else if(typeField.getText().toLowerCase().equals("normal")){
            emp.setType(1);
        }else{
            JOptionPane.showMessageDialog(this, "Error: Invalid Type!");
            return;
        }
        emp.addEmployee();
        Report newRer = new Report();
        newRer.setUserid(logId);
        newRer.setAction("Add Employee -> PID : " +emp.getPid());
        newRer.setDate(LocalDate.now().toString());
        newRer.addReport();
        reseter();
    }

    private void table1MouseClicked(MouseEvent e) {
        // TODO add your code here

        id = (Integer)table1.getValueAt(table1.getSelectedRow(),0);
        if(action == 1){
            name.setText((String)table1.getValueAt(table1.getSelectedRow(),1));
            pid.setText((String)table1.getValueAt(table1.getSelectedRow(),2));
            address.setText((String)table1.getValueAt(table1.getSelectedRow(),3));
            phone.setText((String)table1.getValueAt(table1.getSelectedRow(),4));
            userField.setText((String)table1.getValueAt(table1.getSelectedRow(),5));
            passwordField.setText((String)table1.getValueAt(table1.getSelectedRow(),6));
            typeField.setText((String)table1.getValueAt(table1.getSelectedRow(),7));
        }else{
            name.setText("");
            pid.setText("");
            address.setText("");
            phone.setText("");
            userField.setText("");
            passwordField.setText("");
            typeField.setText("");
        }


    }

    private void delBTNMouseClicked(MouseEvent e) {
        // TODO add your code here
        Employee.deleteEmployee(id);
        Report newRer = new Report();
        newRer.setUserid(logId);
        newRer.setAction("Delete Employee : " +id);
        newRer.setDate(LocalDate.now().toString());
        newRer.addReport();
        reseter();

    }

    private void searchBTNMouseClicked(MouseEvent e) {
        // TODO add your code here
        DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
        ArrayList<Employee> clients = Employee.getE();
        dtm.setRowCount(0);
        String searchItem =(String) searchBox.getSelectedItem();
        for(Employee emp : clients ) {
            switch (searchItem) {
                case "ID":
                    if (searchField.getText().equals("") || Integer.parseInt(searchField.getText()) == emp.getId()) {
                        if(emp.getType() == 1){
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Normal"});
                        }else if(emp.getType() == 0){
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Admin"});
                        }else{
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Outlaw"});
                        }
                    }
                    break;
                case "NAME":
                    if (searchField.getText().equals("") ||emp.getName().contains(searchField.getText())) {
                        if(emp.getType() == 1){
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Normal"});
                        }else if(emp.getType() == 0){
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Admin"});
                        }else{
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Outlaw"});
                        }

                    }
                    break;
                case "PID":
                    if (searchField.getText().equals("") ||emp.getPid().contains(searchField.getText())) {
                        if(emp.getType() == 1){
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Normal"});
                        }else if(emp.getType() == 0){
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Admin"});
                        }else{
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Outlaw"});
                        }

                    }
                    break;
                case "ADDRESS":
                    if (searchField.getText().equals("") ||emp.getAddress().contains(searchField.getText())) {
                        if(emp.getType() == 1){
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Normal"});
                        }else if(emp.getType() == 0){
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Admin"});
                        }else{
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Outlaw"});
                        }

                    }
                    break;
                case "PHONE":
                    if (searchField.getText().equals("") ||emp.getPhone().contains(searchField.getText())) {
                        if(emp.getType() == 1){
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Normal"});
                        }else if(emp.getType() == 0){
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Admin"});
                        }else{
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Outlaw"});
                        }

                    }
                    break;
                case "USERNAME":
                    if (searchField.getText().equals("") ||emp.getUsername().contains(searchField.getText())) {
                        if(emp.getType() == 1){
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Normal"});
                        }else if(emp.getType() == 0){
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Admin"});
                        }else{
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Outlaw"});
                        }

                    }
                    break;
                case "PASSWORD":
                    if (searchField.getText().equals("") ||emp.getPassword().contains(searchField.getText())) {
                        if(emp.getType() == 1){
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Normal"});
                        }else if(emp.getType() == 0){
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Admin"});
                        }else{
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Outlaw"});
                        }

                    }
                    break;
                case "TYPE":
                    if(searchField.getText().equals("")){
                        if(emp.getType() == 1){
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Normal"});
                        }else if(emp.getType() == 0){
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Admin"});
                        }else{
                            dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Outlaw"});
                        }
                    }else{
                        if (searchField.getText().toLowerCase().contains("normal")) {
                            if(emp.getType() == 1){
                                dtm.addRow(new Object[] {emp.getId(),emp.getName(),emp.getPid(),emp.getAddress(),emp.getPhone(),emp.getUsername(),emp.getPassword(),"Normal"});
                            }
                        }else if (searchField.getText().toLowerCase().contains("admin")) {
                            if (emp.getType() == 0) {
                                dtm.addRow(new Object[]{emp.getId(), emp.getName(), emp.getPid(), emp.getAddress(), emp.getPhone(), emp.getUsername(), emp.getPassword(), "Admin"});

                            }

                        }
                    break;
                }
            }
        }
    }

    private void updateBTNMouseClicked(MouseEvent e) {
        // TODO add your code here
        if(!(pid.getText().matches("[0-9]+"))){
            JOptionPane.showMessageDialog(this, "Error: Invalid input PID!");
            return;
        }
        if(!(phone.getText().matches("[0-9]+"))){
            JOptionPane.showMessageDialog(this, "Error: Invalid input PHONE!");
            return;
        }
        Employee emp = new Employee();
        emp.setName(name.getText());
        emp.setPid(pid.getText());
        emp.setAddress(address.getText());
        emp.setPhone(phone.getText());
        emp.setUsername(userField.getText());
        emp.setPassword(passwordField.getText());
        if(typeField.getText().toLowerCase().equals("admin")){
            emp.setType(0);
        }else if(typeField.getText().toLowerCase().equals("normal")){
            emp.setType(1);
        }else{
            JOptionPane.showMessageDialog(this, "Error: Invalid Type!");
            return;
        }
        emp.setId(id);
        emp.updateEmployee();
        Report newRer = new Report();
        newRer.setUserid(logId);
        newRer.setAction("Update Employee -> PID : " +emp.getPid());
        newRer.setDate(LocalDate.now().toString());
        newRer.addReport();
        reseter();

    }

    private void reseter() {
        setTableValues();
        name.setText("");
        pid.setText("");
        address.setText("");
        phone.setText("");
        userField.setText("");
        passwordField.setText("");
        typeField.setText("");
    }

    private void transferBTNMouseClicked(MouseEvent e) {
        // TODO add your code here
        setTableValues();
        action = 2;
        nameLabel.setText("FROM DAY");
        pidLabel.setText("FROM MONTH");
        addressLabel.setText("FROM YEAR");
        phoneLabel.setText("TO DAY");
        userLabel.setText("TO MONTH");
        passwordLabel.setText("TO YEAR");
        typeField.setVisible(false);
        typeLabel.setVisible(false);
        addcrBTN.setVisible(false);
        updateBTN.setVisible(false);
        delBTN.setVisible(false);
        genBTN.setVisible(true);
        name.setText("");
        pid.setText("");
        address.setText("");
        phone.setText("");
        userField.setText("");
        passwordField.setText("");
        setTableValues();
    }


    private void logoutBTNMouseClicked(MouseEvent e) {
        LoginGUI gui = new LoginGUI();
        Report newRer = new Report();
        newRer.setUserid(logId);
        newRer.setAction("Logout");
        newRer.setDate(LocalDate.now().toString());
        newRer.addReport();
        gui.setVisible(true);
        this.dispose();

    }

    private void genBTNMouseClicked(MouseEvent e) {
        // TODO add your code here
        if(!(name.getText().matches("[0-9]+"))){
            JOptionPane.showMessageDialog(this, "Error: Invalid input IDN!");
            return;
        }
        if(!(pid.getText().matches("[0-9]+"))){
            JOptionPane.showMessageDialog(this, "Error: Invalid input AMMOUNT!");
            return;
        }
        if(!(address.getText().matches("[0-9]+"))){
            JOptionPane.showMessageDialog(this, "Error: Invalid input IDN!");
            return;
        }
        if(!(phone.getText().matches("[0-9]+"))){
            JOptionPane.showMessageDialog(this, "Error: Invalid input AMMOUNT!");
            return;
        }
        if(!(userField.getText().matches("[0-9]+"))){
            JOptionPane.showMessageDialog(this, "Error: Invalid input IDN!");
            return;
        }
        if(!(passwordField.getText().matches("[0-9]+"))){
            JOptionPane.showMessageDialog(this, "Error: Invalid input AMMOUNT!");
            return;
        }
        if(name.getText().length() != 2 || pid.getText().length() != 2 || phone.getText().length() != 2 || userField.getText().length() != 2){
            JOptionPane.showMessageDialog(this, "Error: Invalid Format yyyy-mm-dd!");
            return;
        }
        LocalDate stD = LocalDate.parse(address.getText() +"-" +pid.getText() +"-" +name.getText());
        LocalDate enD = LocalDate.parse(passwordField.getText() +"-" +userField.getText() +"-" +phone.getText());
        Report.writeReports(stD,enD,id);
        setTableValues();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Chirodea Mihai
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        name = new JTextField();
        pid = new JTextField();
        address = new JTextField();
        logoutBTN = new JButton();
        phone = new JTextField();
        nameLabel = new JLabel();
        pidLabel = new JLabel();
        addressLabel = new JLabel();
        phoneLabel = new JLabel();
        searchField = new JTextField();
        searchBTN = new JButton();
        searchBox = new JComboBox<>();
        generateRBTN = new JButton();
        infoBTN = new JButton();
        addcrBTN = new JButton();
        updateBTN = new JButton();
        delBTN = new JButton();
        genBTN = new JButton();
        userField = new JTextField();
        passwordField = new JTextField();
        typeField = new JTextField();
        userLabel = new JLabel();
        passwordLabel = new JLabel();
        typeLabel = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null, null},
                },
                new String[] {
                    "ID", "NAME", "PID", "ADDRESS", "PHONE", "USERNAME", "PASSWORD", "TYPE"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
                };
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false, false, false, true
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            scrollPane1.setViewportView(table1);
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    table1MouseClicked(e);
                }
            });
        }

        //---- logoutBTN ----
        logoutBTN.setText("Log Out");
        logoutBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                logoutBTNMouseClicked(e);
            }
        });

        //---- nameLabel ----
        nameLabel.setText("NAME");

        //---- pidLabel ----
        pidLabel.setText("PID");

        //---- addressLabel ----
        addressLabel.setText("ADDRESS");

        //---- phoneLabel ----
        phoneLabel.setText("PHONE NR.");

        //---- searchBTN ----
        searchBTN.setText("SEARCH");
        searchBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                searchBTNMouseClicked(e);
            }
        });

        //---- searchBox ----
        searchBox.setModel(new DefaultComboBoxModel<>(new String[] {
            "ID",
            "NAME",
            "PID",
            "ADDRESS",
            "PHONE",
            "USERNAME",
            "PASSWORD",
            "TYPE"
        }));

        //---- generateRBTN ----
        generateRBTN.setText("Generate Report");
        generateRBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                transferBTNMouseClicked(e);
            }
        });

        //---- infoBTN ----
        infoBTN.setText("Create/Update/Delete");
        infoBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                accountBTNMouseClicked(e);
            }
        });

        //---- addcrBTN ----
        addcrBTN.setText("Add/Create");
        addcrBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addcrBTNMouseClicked(e);
            }
        });

        //---- updateBTN ----
        updateBTN.setText("Update");
        updateBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              updateBTNMouseClicked(e);
            }
        });

        //---- delBTN ----
        delBTN.setText("Delete");
        delBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                delBTNMouseClicked(e);
            }
        });

        //---- genBTN ----
        genBTN.setText("Generate");
        genBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               genBTNMouseClicked(e);
            }
        });

        //---- userLabel ----
        userLabel.setText("USERNAME");

        //---- passwordLabel ----
        passwordLabel.setText("PASSWORD");

        //---- typeLabel ----
        typeLabel.setText("TYPE");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING)
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(address)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                    .addGap(60, 60, 60))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(pid)
                                        .addComponent(name))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                        .addComponent(pidLabel, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                                    .addGap(15, 15, 15)))
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(searchBox, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchBTN, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(infoBTN, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(generateRBTN, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                            .addComponent(logoutBTN))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(addcrBTN, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(updateBTN, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(delBTN, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(genBTN, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 203, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(typeField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                                .addComponent(passwordField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                                .addComponent(userField, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                                .addComponent(phone))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(phoneLabel, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                .addComponent(userLabel, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                .addComponent(passwordLabel, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                .addComponent(typeLabel, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                            .addGap(151, 151, 151)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(searchBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameLabel)
                        .addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(searchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(pidLabel)
                        .addComponent(pid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(searchBTN)
                        .addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(addressLabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(phoneLabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(userField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(userLabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordLabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(typeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(typeLabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(addcrBTN)
                        .addComponent(updateBTN)
                        .addComponent(delBTN)
                        .addComponent(genBTN))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(logoutBTN)
                        .addComponent(infoBTN)
                        .addComponent(generateRBTN))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private int id;
    private int logId;
    private int action;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Chirodea Mihai
    private JScrollPane scrollPane1;
    private JTable table1;
    private JTextField name;
    private JTextField pid;
    private JTextField address;
    private JButton logoutBTN;
    private JTextField phone;
    private JLabel nameLabel;
    private JLabel pidLabel;
    private JLabel addressLabel;
    private JLabel phoneLabel;
    private JTextField searchField;
    private JButton searchBTN;
    private JComboBox<String> searchBox;
    private JButton generateRBTN;
    private JButton infoBTN;
    private JButton addcrBTN;
    private JButton updateBTN;
    private JButton delBTN;
    private JButton genBTN;
    private JTextField userField;
    private JTextField passwordField;
    private JTextField typeField;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JLabel typeLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
