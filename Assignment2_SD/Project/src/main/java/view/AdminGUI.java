package view;


import controller.AdminController;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

class AdminGUI extends JFrame implements IAdminGUI{
    AdminController adm = new AdminController(this);
    AdminGUI(Long logID) {
        this.logID = logID;
        initComponents();
        this.setTitle("D.R.U.G Admin Panel");
        this.setMinimumSize(new Dimension(500, 400));
        adm.showInfo();
    }

    private void initComponents() {
        table2 = new JTable();
        table2.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null},
                },
                new String[] {
                        "ID", "WALLET","TYPE","USERNAME", "PASSWORD"
                }
        ) {
            Class<?>[] columnTypes = new Class<?>[] {
                    Long.class, Float.class, String.class, String.class, String.class
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
                adm.tableClick(2);
            }
        });
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Chirodea Mihai
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        name = new JTextField();
        type = new JTextField();
        price = new JTextField();
        infoBTN = new JButton();
        logoutBTN = new JButton();
        stock = new JTextField();
        nameLabel = new JLabel();
        typeLabel = new JLabel();
        priceLabel = new JLabel();
        stockLabel = new JLabel();
        searchField = new JTextField();
        searchBTN = new JButton();
        searchBox = new JComboBox<>();
        genRBTN = new JButton();
        accountBTN = new JButton();
        addcrBTN = new JButton();
        updateBTN = new JButton();
        delBTN = new JButton();


        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                    new Object[][] {
                            {null, null, null, null, null},
                    },
                    new String[] {
                            "ID", "NAME", "TYPE", "PRICE", "STOCK"
                    }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                        Long.class, String.class, String.class,Float.class, Integer.class
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
                    adm.tableClick(1);
                }
            });
            scrollPane1.setViewportView(table1);
        }

        //---- infoBTN ----
        infoBTN.setText("Add / Update / Delete");
        infoBTN.addActionListener(e -> adm.showInfo());

        //---- logoutBTN ----
        logoutBTN.setText("Logout");
        logoutBTN.addActionListener(e -> {new LoginGUI().setVisible(true);this.dispose();});

        //---- nameLabel ----
        nameLabel.setText("NAME");

        //---- typeLabel ----
        typeLabel.setText("TYPE");

        //---- priceLabel ----
        priceLabel.setText("PRICE");

        //---- stockLabel ----
        stockLabel.setText("STOCK");

        //---- searchBTN ----
        searchBTN.setText("SEARCH");
        searchBTN.addActionListener(e->adm.search(table1.isVisible()));
        //---- searchBox ----

        //---- genRBTN ----
        genRBTN.setText("Generate Report");



        //---- accountBTN ----
        accountBTN.setText("Create/Update/Delete");
        accountBTN.addActionListener(e -> adm.showAccount());

        //---- addcrBTN ----
        addcrBTN.setText("Add/Create");
        addcrBTN.addActionListener(e->adm.addCreate(table1.isVisible()));


        //---- updateBTN ----
        updateBTN.setText("Update");
        updateBTN.addActionListener(e->adm.update(table1.isVisible()));

        //---- delBTN ----
        delBTN.setText("Delete");
        delBTN.addActionListener(e->adm.delete(table1.isVisible()));

        genRBTN.addActionListener(e-> adm.report());

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
                                                                .addComponent(price)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(priceLabel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(60, 60, 60))
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                        .addComponent(name)
                                                                        .addComponent(type))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                                                                        .addComponent(typeLabel, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                                                                .addGap(15, 15, 15)))
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(searchBox, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(searchField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(searchBTN, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(stock)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(stockLabel, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
                                                .addGap(151, 151, 151))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                                                .addComponent(addcrBTN, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(updateBTN, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(delBTN, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                                                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                                                .addComponent(infoBTN, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(accountBTN, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(genRBTN, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
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
                                        .addComponent(typeLabel)
                                        .addComponent(type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchBTN)
                                        .addComponent(price, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(priceLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(stock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(stockLabel))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(addcrBTN)
                                        .addComponent(updateBTN)
                                        .addComponent(delBTN))
                                .addGap(18, 46, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(infoBTN)
                                        .addComponent(accountBTN)
                                        .addComponent(logoutBTN)
                                        .addComponent(genRBTN))
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private JTable table2;
    private Long logID;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Chirodea Mihai
    private JScrollPane scrollPane1;
    private JTable table1;
    private JTextField name;
    private JTextField type;
    private JTextField price;
    private JButton infoBTN;
    private JButton logoutBTN;
    private JTextField stock;
    private JLabel nameLabel;
    private JLabel typeLabel;
    private JLabel priceLabel;
    private JLabel stockLabel;
    private JTextField searchField;
    private JButton searchBTN;
    private JComboBox<String> searchBox;
    private JButton genRBTN;
    private JButton accountBTN;
    private JButton addcrBTN;
    private JButton updateBTN;
    private JButton delBTN;


    @Override
    public String getWalletName() {
        return name.getText();
    }

    @Override
    public String getDrugAccType() {
        return type.getText();
    }

    @Override
    public String getUsernamePrice() {
        return price.getText();
    }

    @Override
    public String getPasswordStock() {
        return stock.getText();
    }

    @Override
    public Long getLog() {
        return this.logID;
    }

    @Override
    public Object getSearch() {
        return searchBox.getSelectedItem();
    }

    @Override
    public String getSearchField() {
        return searchField.getText();
    }

    @Override
    public void setWalletName(String moneyUsr) {
        this.name.setText(moneyUsr);
    }

    @Override
    public void setDrugAccType(String accDrug) {
        this.type.setText(accDrug);
    }

    @Override
    public void setUsernamePrice(String priceUsr) {
        this.price.setText(priceUsr);
    }

    @Override
    public void setPasswordStock(String stockPass) {
        this.stock.setText(stockPass);
    }



    @Override
    public void showDrugView() {
        table1.setVisible(true);
        table2.setVisible(false);
        scrollPane1.setViewportView(table1);
        //---- nameLabel ----
        nameLabel.setText("NAME");

        //---- typeLabel ----
        typeLabel.setText("TYPE");

        //---- priceLabel ----
        priceLabel.setText("PRICE");

        //---- stockLabel ----
        stockLabel.setText("STOCK");
        setWalletName("");
        setDrugAccType("");
        setUsernamePrice("");
        setPasswordStock("");
        searchBox.setModel(new DefaultComboBoxModel<>(new String[] {
                "ID",
                "NAME",
                "TYPE",
                "PRICE",
                "STOCK"
        }));

    }

    @Override
    public void showUserView() {
        table1.setVisible(false);
        table2.setVisible(true);
        scrollPane1.setViewportView(table2);
        //---- nameLabel ----
        nameLabel.setText("WALLET");

        //---- typeLabel ----
        typeLabel.setText("TYPE");

        //---- priceLabel ----
        priceLabel.setText("USERNAME");

        //---- stockLabel ----
        stockLabel.setText("PASSWORD");
        setWalletName("");
        setDrugAccType("");
        setUsernamePrice("");
        setPasswordStock("");
        searchBox.setModel(new DefaultComboBoxModel<>(new String[] {
                "ID",
                "WALLET",
                "TYPE",
                "USERNAME",
                "PASSWORD"
        }));
    }

//    @Override
//    public DefaultTableModel getCurrentView() {
//        if(table1.isVisible()){
//            return (DefaultTableModel) table1.getModel();
//        }else{
//            return (DefaultTableModel) table2.getModel();
//        }
//    }

    @Override
    public DefaultTableModel getView(int sel) {
        if(sel == 1){
            return (DefaultTableModel) table1.getModel();
        }else{
            return (DefaultTableModel) table2.getModel();
        }
    }

    @Override
    public Object getRowAt(int ind) {
        if(table1.isVisible()){
            if(table1.getSelectedRow() == -1) {
                showErrorMessage("Error: No DRUG selected!");
            }
            return table1.getValueAt(table1.getSelectedRow(), ind);
        }else{
            if(table2.getSelectedRow() == -1) {
                showErrorMessage("Error: No user selected!");
            }
            return table2.getValueAt(table2.getSelectedRow(), ind);
        }
    }

    @Override
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }



    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

