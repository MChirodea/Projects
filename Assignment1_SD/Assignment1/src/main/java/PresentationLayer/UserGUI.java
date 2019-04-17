/*
 * Created by JFormDesigner on Sun Mar 17 12:26:40 EET 2019
 */

package PresentationLayer;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

import BusinessLayer.*;

/**
 * @author unknown
 */
class UserGUI extends JFrame {
    UserGUI(int log) {
        initComponents();
        this.setTitle("Bank Application Employee");
        this.logID = log;
        action = 1;
        infoBTNMouseClicked(null);

    }

    private void infoBTNMouseClicked(MouseEvent e) {
        // TODO add your code here

        action = 1;
        //---- nameLabel ----
        nameLabel.setText("NAME");

        //---- pidLabel ----
        pidLabel.setText("PID");

        //---- addressLabel ----
        addressLabel.setText("PIN");

        //---- phoneLabel ----
        phoneLabel.setText("ADDRESS");

        table1.setVisible(true);
        table2.setVisible(false);
        scrollPane1.setViewportView(table1);
        searchBox.setModel(new DefaultComboBoxModel<>(new String[] {
                "ID",
                "NAME",
                "PID",
                "PIN",
                "ADDRESS"
        }));
        infoAcc();
        setTableValues();

    }

    private void setTableValues() {
        if(action == 1){
            DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
            dtm.setRowCount(0);
            ArrayList<ClientAcc> clients = ClientAcc.getC();
            for(ClientAcc client : clients){
                dtm.addRow(new Object[] {client.getId(), client.getName(), client.getPid(), client.getPin(), client.getAddress()});
            }
        }else{
            if(action == 2 || action == 3 || action == 4){
                DefaultTableModel dtm = (DefaultTableModel) table2.getModel();
                dtm.setRowCount(0);
                ArrayList<AccountType> accounts = AccountType.getA();
                for(AccountType account: accounts){
                    dtm.addRow(new Object[] {account.getId(),account.getIdn(),account.getType(),account.getMoney(),account.getCreationD()});
                }
            }
        }

    }

    private void accountBTNMouseClicked(MouseEvent e) {
        // TODO add your code here
        action = 2;
        //---- nameLabel ----
        nameLabel.setText("IDN");

        //---- pidLabel ----
        pidLabel.setText("TYPE");

        //---- addressLabel ----
        addressLabel.setText("AMMOUNT");

        //---- phoneLabel ----
        phoneLabel.setText("CREATION DATE");

        table1.setVisible(false);
        table2.setVisible(true);
        scrollPane1.setViewportView(table2);
        searchBox.setModel(new DefaultComboBoxModel<>(new String[] {
                "ID",
                "IDN",
                "TYPE",
                "MONEY",
                "DOC"
        }));

        infoAcc();
        phoneLabel.setVisible(false);
        phone.setVisible(false);
        setTableValues();
    }

    private void addcrBTNMouseClicked(MouseEvent e) {
        if(action == 1){
            if(!(cnp.getText().matches("[0-9]+"))){
                JOptionPane.showMessageDialog(this, "Error: Invalid input PID!");
                return;
            }
            if(!(address.getText().matches("[0-9]+"))){
                JOptionPane.showMessageDialog(this, "Error: Invalid input PIN!");
                return;
            }
            ClientAcc newClient = new ClientAcc();
            newClient.setName(name.getText());
            newClient.setPid(cnp.getText());
            newClient.setPin(address.getText());
            newClient.setAddress(phone.getText());
            newClient.clientAdd();

            Report newRer = new Report();
            newRer.setUserid(logID);
            newRer.setAction("Add Client -> PID : " +newClient.getPid());
            newRer.setDate(LocalDate.now().toString());
            newRer.addReport();
            setTableValues();
            name.setText("");
            cnp.setText("");
            address.setText("");
            phone.setText("");
        }else{
            if(action == 2){
                if(!(name.getText().matches("[0-9]+"))){
                    JOptionPane.showMessageDialog(this, "Error: Invalid input IDN!");
                    return;
                }
                if(!(address.getText().matches("[0-9]+"))){
                    JOptionPane.showMessageDialog(this, "Error: Invalid input AMMOUNT!");
                    return;
                }
                AccountType newAccount = new AccountType();
                newAccount.setIdn(Integer.parseInt(name.getText()));
                newAccount.setType(cnp.getText());
                newAccount.setMoney(Float.parseFloat(address.getText()));
                newAccount.setCreationD(LocalDate.now().toString());
                newAccount.accountAdd();
                Report newRer = new Report();
                newRer.setUserid(logID);
                newRer.setAction("Add Account -> CID : " +newAccount.getIdn());
                newRer.setDate(LocalDate.now().toString());
                newRer.addReport();
                setTableValues();
                name.setText("");
                cnp.setText("");
                address.setText("");
                phone.setText("");
            }
        }


    }

    private void updateBTNMouseClicked(MouseEvent e) {
        if(action == 1){
            if(!(cnp.getText().matches("[0-9]+"))){
                JOptionPane.showMessageDialog(this, "Error: Invalid input PID!");
                return;
            }
            if(!(address.getText().matches("[0-9]+"))){
                JOptionPane.showMessageDialog(this, "Error: Invalid input PIN!");
                return;
            }
            ClientAcc newClient = new ClientAcc();
            newClient.setName(name.getText());
            newClient.setPid(cnp.getText());
            newClient.setPin(address.getText());
            newClient.setAddress(phone.getText());
            newClient.setId(id);
            newClient.clientUpdate();
            Report newRer = new Report();
            newRer.setUserid(logID);
            newRer.setAction("Update Client -> PID : " +newClient.getPid());
            newRer.setDate(LocalDate.now().toString());
            newRer.addReport();
        }else{
            if(action == 2){
                if(!(name.getText().matches("[0-9]+"))){
                    JOptionPane.showMessageDialog(this, "Error: Invalid input IDN!");
                    return;
                }
                if(!(address.getText().matches("[0-9]+"))){
                    JOptionPane.showMessageDialog(this, "Error: Invalid input AMMOUNT!");
                    return;
                }
                AccountType newAccount = new AccountType();
                newAccount.setId(id);
                newAccount.setIdn(Integer.parseInt(name.getText()));
                newAccount.setType(cnp.getText());
                newAccount.setMoney(Float.parseFloat(address.getText()));
                newAccount.setCreationD(phone.getText());
                newAccount.accountUpdate();
                Report newRer = new Report();
                newRer.setUserid(logID);
                newRer.setAction("Update Account -> CID : " +newAccount.getIdn());
                newRer.setDate(LocalDate.now().toString());
                newRer.addReport();
            }
        }

        setTableValues();
        name.setText("");
        cnp.setText("");
        address.setText("");
        phone.setText("");

    }

    private void delBTNMouseClicked(MouseEvent e) {
        if(action == 1){
            Report newRer = new Report();
            newRer.setUserid(logID);
            newRer.setAction("Delete Client -> ID : " +id);
            newRer.setDate(LocalDate.now().toString());
            newRer.addReport();
           ClientAcc.clientDelete(id);
        }else{
            Report newRer = new Report();
            newRer.setUserid(logID);
            newRer.setAction("Delete Account -> CID : " +id);
            newRer.setDate(LocalDate.now().toString());
            newRer.addReport();
            AccountType.accountDelete(id);
        }

        setTableValues();
        name.setText("");
        cnp.setText("");
        address.setText("");
        phone.setText("");

    }

    private void logoutBTNMouseClicked(MouseEvent e) {
        LoginGUI gui = new LoginGUI();
        Report newRer = new Report();
        newRer.setUserid(logID);
        newRer.setAction("Logout");
        newRer.setDate(LocalDate.now().toString());
        newRer.addReport();
        gui.setVisible(true);
        this.dispose();

    }

    private void searchBTNMouseClicked(MouseEvent e) {
        if(action == 1){
            DefaultTableModel dtm = (DefaultTableModel) table1.getModel();
            ArrayList<ClientAcc> clients = ClientAcc.getC();
            dtm.setRowCount(0);
            String searchItem =(String) searchBox.getSelectedItem();
            for(ClientAcc client : clients) {
                switch (searchItem) {
                    case "ID":
                        if (searchField.getText().equals("") || Integer.parseInt(searchField.getText()) == client.getId()) {
                            dtm.addRow(new Object[]{client.getId(), client.getName(), client.getPid(), client.getPin(), client.getAddress()});
                        }
                        break;
                    case "NAME":
                        if (searchField.getText().equals("") ||client.getName().contains(searchField.getText())) {
                            dtm.addRow(new Object[]{client.getId(), client.getName(), client.getPid(), client.getPin(), client.getAddress()});
                        }
                        break;
                    case "PID":
                        if (searchField.getText().equals("") ||client.getPid().contains(searchField.getText())) {
                            dtm.addRow(new Object[]{client.getId(), client.getName(), client.getPid(), client.getPin(), client.getAddress()});
                        }
                        break;
                    case "PIN":
                        if (searchField.getText().equals("") ||client.getPin().contains(searchField.getText())) {
                            dtm.addRow(new Object[]{client.getId(), client.getName(), client.getPid(), client.getPin(), client.getAddress()});
                        }
                        break;
                    case "ADDRESS":
                        if (searchField.getText().equals("") ||client.getAddress().contains(searchField.getText())) {
                            dtm.addRow(new Object[]{client.getId(), client.getName(), client.getPid(), client.getPin(), client.getAddress()});
                        }
                        break;
            }
        }
        }else{
            if(action == 2 || action == 3){
                DefaultTableModel dtm = (DefaultTableModel) table2.getModel();
                ArrayList<AccountType> clients = AccountType.getA();
                dtm.setRowCount(0);
                String searchItem =(String) searchBox.getSelectedItem();
                for(AccountType account : clients) {
                    switch (searchItem) {
                        case "ID":
                            if (searchField.getText().equals("") ||Integer.parseInt(searchField.getText()) == account.getId()) {
                                dtm.addRow(new Object[] {account.getId(),account.getIdn(),account.getType(),account.getMoney(),account.getCreationD()});
                            }
                            break;
                        case "IDN":
                            if (searchField.getText().equals("") ||Integer.parseInt(searchField.getText()) == account.getIdn()) {
                                dtm.addRow(new Object[] {account.getId(),account.getIdn(),account.getType(),account.getMoney(),account.getCreationD()});
                            }
                            break;
                        case "TYPE":
                            if (searchField.getText().equals("") ||account.getType().contains(searchField.getText())) {
                                dtm.addRow(new Object[] {account.getId(),account.getIdn(),account.getType(),account.getMoney(),account.getCreationD()});
                            }
                            break;
                        case "MONEY":
                            if (searchField.getText().equals("") ||Float.parseFloat(searchField.getText()) == account.getMoney()) {
                                dtm.addRow(new Object[] {account.getId(),account.getIdn(),account.getType(),account.getMoney(),account.getCreationD()});
                            }
                            break;
                        case "DOC":
                            if (searchField.getText().equals("") ||account.getCreationD().contains(searchField.getText())) {
                                dtm.addRow(new Object[] {account.getId(),account.getIdn(),account.getType(),account.getMoney(),account.getCreationD()});
                            }
                            break;
                    }
                }
            }else{
                if(action == 4 ){
                    DefaultTableModel dtm = (DefaultTableModel) table2.getModel();
                    ArrayList<AccountType> clients = AccountType.getA();
                    dtm.setRowCount(0);
                    String searchItem =(String) searchBox.getSelectedItem();
                    for(AccountType account : clients) {
                        switch (searchItem) {
                            case "ID":
                                if (searchField.getText().equals("") ||Integer.parseInt(searchField.getText()) == account.getId()) {
                                    dtm.addRow(new Object[] {account.getId(),account.getIdn(),account.getType(),account.getMoney(),account.getCreationD()});
                                }
                                break;
                            case "IDN":
                                if (searchField.getText().equals("") ||Integer.parseInt(searchField.getText()) == account.getIdn()) {
                                    dtm.addRow(new Object[] {account.getId(),account.getIdn(),account.getType(),account.getMoney(),account.getCreationD()});
                                }
                                break;
                            case "TYPE":
                                if (searchField.getText().equals("") ||account.getType().contains(searchField.getText())) {
                                    dtm.addRow(new Object[] {account.getId(),account.getIdn(),account.getType(),account.getMoney(),account.getCreationD()});
                                }
                                break;
                            case "MONEY":
                                if (searchField.getText().equals("") ||Float.parseFloat(searchField.getText()) == account.getMoney()) {
                                    dtm.addRow(new Object[] {account.getId(),account.getIdn(),account.getType(),account.getMoney(),account.getCreationD()});
                                }
                                break;
                            case "DOC":
                                if (searchField.getText().equals("") ||searchField.getText().equals("") ||account.getCreationD().contains(searchField.getText())) {
                                    dtm.addRow(new Object[] {account.getId(),account.getIdn(),account.getType(),account.getMoney(),account.getCreationD()});
                                }
                                break;
                            case "UTILITY CODES":
                                if (account.getIdn() == 5 || account.getIdn() == 6) {
                                    dtm.addRow(new Object[] {account.getId(),account.getIdn(),account.getType(),account.getMoney(),account.getCreationD()});
                                }
                                break;
                        }
                    }
                }
            }
        }
    }

    private void trprBTNMouseClicked(MouseEvent e) {
        if(!(name.getText().matches("[0-9]+"))){
            JOptionPane.showMessageDialog(this, "Error: Invalid input FROM ACCOUNT!");
            return;
        }
        if(!(cnp.getText().matches("[0-9]+"))){
            JOptionPane.showMessageDialog(this, "Error: Invalid input TO ACCOUNT!");
            return;
        }
        if(!(address.getText().matches("[0-9]+"))){
            JOptionPane.showMessageDialog(this, "Error: Invalid input AMMOUNT!");
            return;
        }
        int id1 = Integer.parseInt(name.getText());
        int id2 = Integer.parseInt(cnp.getText());

        float money = Float.parseFloat(address.getText());
        if(action == 4 && (id2 != 5 && id2 != 6 && id1 != 5 && id1 != 6)){
                JOptionPane.showMessageDialog(this, "Error: Invalid utility code!");
                return;
        }

        if(money <= 0.0f){
            JOptionPane.showMessageDialog(this, "Error: Invalid transfer sum!");
            return;
        }else{
             int flag = AccountType.transfer(id1,id2,money);
            Report newRer = new Report();
            newRer.setUserid(logID);
            newRer.setAction("Transfer "+id1 +" -> " +id2 +" " +money);
            newRer.setDate(LocalDate.now().toString());
            newRer.addReport();
             if(flag == 1){
                JOptionPane.showMessageDialog(this, "Error: Not enough funds!");

             }else{
                JOptionPane.showMessageDialog(this, "Notice: Transaction successful!");
                setTableValues();
             }
        }
    }


    private void table1MouseClicked(MouseEvent e) {
        this.id = (Integer)table1.getValueAt(table1.getSelectedRow(),0);
        name.setText((String)table1.getValueAt(table1.getSelectedRow(),1));
        cnp.setText((String)table1.getValueAt(table1.getSelectedRow(),2));
        address.setText((String)table1.getValueAt(table1.getSelectedRow(),3));
        phone.setText((String)table1.getValueAt(table1.getSelectedRow(),4));
    }

    private void table2MouseClicked(MouseEvent e) {
        if(action == 2){
            this.id = (Integer)table2.getValueAt(table2.getSelectedRow(),0);
            int idn = (Integer) table2.getValueAt(table2.getSelectedRow(),1);
            name.setText(Integer.toString(idn));
            cnp.setText((String)table2.getValueAt(table2.getSelectedRow(),2));
            float money = (Float)table2.getValueAt(table2.getSelectedRow(),3);
            address.setText(Float.toString(money));
            phone.setText((String)table2.getValueAt(table2.getSelectedRow(),4));
        }

    }

    private void infoAcc() {
        nameLabel.setVisible(true);
        pidLabel.setVisible(true);
        addressLabel.setVisible(true);
        phoneLabel.setVisible(true);
        name.setVisible(true);
        cnp.setVisible(true);
        address.setVisible(true);
        phone.setVisible(true);
        addcrBTN.setVisible(true);
        updateBTN.setVisible(true);
        delBTN.setVisible(true);
        trprBTN.setVisible(false);
        searchBox.setVisible(true);
        searchField.setVisible(true);
        searchBTN.setVisible(true);
    }

    private void transferBTNMouseClicked(MouseEvent e) {
        // TODO add your code here
        action = 3;
        nameLabel.setText("FROM ACCOUNT");
        pidLabel.setText("TO ACCOUNT");
        processTransferAddon();
        searchBox.setModel(new DefaultComboBoxModel<>(new String[] {
                "ID",
                "PID",
                "TYPE",
                "MONEY",
                "DOC"
        }));
        name.setText("");
        cnp.setText("");
        address.setText("");
        phone.setText("");
        setTableValues();
    }

    private void processBTNMouseClicked(MouseEvent e) {
        // TODO add your code here
        action = 4;
        nameLabel.setText("FROM ACCOUNT");
        pidLabel.setText("UTILITY CODE");
        processTransferAddon();
        searchBox.setModel(new DefaultComboBoxModel<>(new String[] {
                "ID",
                "PID",
                "TYPE",
                "MONEY",
                "DOC",
                "UTILITY CODES"
        }));
        setTableValues();
    }

    private void processTransferAddon() {
        addressLabel.setText("AMMOUNT");
        nameLabel.setVisible(true);
        pidLabel.setVisible(true);
        addressLabel.setVisible(true);
        phoneLabel.setVisible(false);
        name.setVisible(true);
        cnp.setVisible(true);
        address.setVisible(true);
        phone.setVisible(false);
        addcrBTN.setVisible(false);
        updateBTN.setVisible(false);
        delBTN.setVisible(false);
        trprBTN.setVisible(true);
        searchBox.setVisible(true);
        searchField.setVisible(true);
        searchBTN.setVisible(true);
        table1.setVisible(false);
        table2.setVisible(true);
        scrollPane1.setViewportView(table2);
    }


    private void initComponents() {
        table2 = new JTable();
        table2.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, "", null},
                },
                new String[] {
                        "ID", "IDN", "TYPE", "MONEY", "DOC"
                }
        ) {
            Class<?>[] columnTypes = new Class<?>[] {
                    Integer.class, String.class, String.class, String.class, String.class
            };
            boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false
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
        table2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                table2MouseClicked(e);
            }
        });
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Chirodea Mihai
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        name = new JTextField();
        cnp = new JTextField();
        address = new JTextField();
        infoBTN = new JButton();
        logoutBTN = new JButton();
        phone = new JTextField();
        nameLabel = new JLabel();
        pidLabel = new JLabel();
        addressLabel = new JLabel();
        phoneLabel = new JLabel();
        searchField = new JTextField();
        searchBTN = new JButton();
        searchBox = new JComboBox<>();
        transferBTN = new JButton();
        processBTN = new JButton();
        accountBTN = new JButton();
        addcrBTN = new JButton();
        updateBTN = new JButton();
        delBTN = new JButton();
        trprBTN = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, "", null},
                },
                new String[] {
                    "ID", "NAME", "PID", "ADDRESS", "PHONE"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Integer.class, String.class, String.class, String.class, String.class
                };
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false
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
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    table1MouseClicked(e);
                }
            });
            scrollPane1.setViewportView(table1);
        }

        //---- infoBTN ----
        infoBTN.setText("Add / Update/Delete");
        infoBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                infoBTNMouseClicked(e);
            }
        });

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
            "PHONE"
        }));

        //---- transferBTN ----
        transferBTN.setText("Transfer Accounts");
        transferBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                transferBTNMouseClicked(e);
            }
        });

        //---- processBTN ----
        processBTN.setText("Process Bill");
        processBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                processBTNMouseClicked(e);
            }
        });

        //---- accountBTN ----
        accountBTN.setText("Create/Update/Delete");
        accountBTN.addMouseListener(new MouseAdapter() {
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

        //---- trprBTN ----
        trprBTN.setText("Transfer/Process");
        trprBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                trprBTNMouseClicked(e);
            }
        });

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
                                        .addComponent(name)
                                        .addComponent(cnp))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                        .addComponent(pidLabel, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                                    .addGap(15, 15, 15)))
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(searchBox, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchBTN, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(phone)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(phoneLabel, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                            .addGap(151, 151, 151))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(addcrBTN, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(updateBTN, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(delBTN, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(trprBTN, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                    .addComponent(infoBTN, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(accountBTN, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(transferBTN, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(processBTN)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                            .addComponent(logoutBTN)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(searchBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(nameLabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(searchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(pidLabel)
                        .addComponent(cnp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(searchBTN)
                        .addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(addressLabel))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(phoneLabel))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(addcrBTN)
                        .addComponent(updateBTN)
                        .addComponent(delBTN)
                        .addComponent(trprBTN))
                    .addGap(18, 46, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(infoBTN)
                        .addComponent(accountBTN)
                        .addComponent(logoutBTN)
                        .addComponent(processBTN)
                        .addComponent(transferBTN))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private JTable table2;
    private int action;
    private int id;
    private int logID;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Chirodea Mihai
    private JScrollPane scrollPane1;
    private JTable table1;
    private JTextField name;
    private JTextField cnp;
    private JTextField address;
    private JButton infoBTN;
    private JButton logoutBTN;
    private JTextField phone;
    private JLabel nameLabel;
    private JLabel pidLabel;
    private JLabel addressLabel;
    private JLabel phoneLabel;
    private JTextField searchField;
    private JButton searchBTN;
    private JComboBox<String> searchBox;
    private JButton transferBTN;
    private JButton processBTN;
    private JButton accountBTN;
    private JButton addcrBTN;
    private JButton updateBTN;
    private JButton delBTN;
    private JButton trprBTN;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
