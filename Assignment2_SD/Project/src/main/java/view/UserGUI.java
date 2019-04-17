package view;

import controller.UserController;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

class UserGUI extends JFrame implements IUserGUI{
    UserController usr = new UserController(this);
    UserGUI(Long logID) {
        this.logID = logID;
        initComponents();
        this.setTitle("Welcome to the D.R.U.G store!");
        this.setMinimumSize(new Dimension(500, 400));
        usr.updateTable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Chirodea Mihai
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        ammount = new JTextField();
        buyBTN = new JButton();
        logoutBTN = new JButton();
        ammountLabel = new JLabel();
        searchField = new JTextField();
        searchBTN = new JButton();
        searchBox = new JComboBox<>();


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
                        Integer.class, String.class, String.class, Float.class, Integer.class
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

                }
            });
            scrollPane1.setViewportView(table1);
        }

        //---- buyBTN ----
        buyBTN.setText("Buy Drug");
       buyBTN.addActionListener(e->usr.buy());

        //---- logoutBTN ----
        logoutBTN.setText("Logout");
        logoutBTN.addActionListener(e->{new LoginGUI().setVisible(true);this.dispose();});

        //---- ammountLabel ----
        ammountLabel.setText("AMMOUNT");

        //---- searchBTN ----
        searchBTN.setText("SEARCH");
        searchBTN.addActionListener(e->usr.search());

        //---- searchBox ----
        searchBox.setModel(new DefaultComboBoxModel<>(new String[] {
                "ID",
                "NAME",
                "TYPE",
                "PRICE",
                "STOCK"
        }));






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
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGap(60, 60, 60))
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                        .addComponent(ammount))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(ammountLabel, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                                                                .addGap(15, 15, 15)))
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(searchBox, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(searchField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(searchBTN, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGap(151, 151, 151))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))
                                                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                                                .addComponent(buyBTN, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
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
                                        .addComponent(ammount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ammountLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(searchBTN))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE))
                                .addGap(18, 46, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(buyBTN)
                                        .addComponent(logoutBTN))
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Chirodea Mihai
    private Long logID;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JTextField ammount;
    private JButton buyBTN;
    private JButton logoutBTN;
    private JLabel ammountLabel;
    private JTextField searchField;
    private JButton searchBTN;
    private JComboBox<String> searchBox;

    @Override
    public String getAmmount() {
        return ammount.getText();
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
    public Object getRowAt(int ind) {
        if(table1.getSelectedRow() == -1) {
            showErrorMessage("Error: No DRUG selected!");
        }
        return table1.getValueAt(table1.getSelectedRow(), ind);
    }


    @Override
    public DefaultTableModel getView() {
        return (DefaultTableModel) table1.getModel();
    }

    @Override
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public Long getLog() {
        return this.logID;
    }

    @Override
    public void setAmount(String amount) {
        ammount.setText(amount);
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

