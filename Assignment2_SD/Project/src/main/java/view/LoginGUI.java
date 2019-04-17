package view;


import controller.LoginController;

import javax.swing.*;
import java.awt.*;


public class LoginGUI extends JFrame implements ILoginGUI{
    public LoginGUI(){
        setMinimumSize(new Dimension(200, 200));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("D.R.U.G Store Login");
        initComponents();


    }

    private void initComponents() {
        LoginController loginController = new LoginController(this);
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Chirodea Mihai
        textField1 = new JTextField();
        label1 = new JLabel();
        passwordField1 = new JPasswordField();
        label2 = new JLabel();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("USER / EMAIL:");

        //---- label2 ----
        label2.setText("PASSWORD:");

        //---- button1 ----
        button1.setText("LOGIN");
        button1.addActionListener(e-> loginController.login());

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap(43, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(label1)
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(button1, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                        .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                        .addComponent(passwordField1, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                                .addGap(122, 122, 122))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label1))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label2))
                                .addGap(18, 18, 18)
                                .addComponent(button1)
                                .addContainerGap(83, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Chirodea Mihai
    private JTextField textField1;
    private JLabel label1;
    private JPasswordField passwordField1;
    private JLabel label2;
    private JButton button1;
    public void showAdminView(Long logID){
        new AdminGUI(logID).setVisible(true);
        this.dispose();
    }

    public void showUserView(Long logID){
        new UserGUI(logID).setVisible(true);
        this.dispose();
    }
    public String getUsername(){
        return textField1.getText();
    }

    public String getPassword(){
        return new String(passwordField1.getPassword());
    }
    public void showErrorMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        LoginGUI loginView = new LoginGUI();
        loginView.setVisible(true);
   }
}
