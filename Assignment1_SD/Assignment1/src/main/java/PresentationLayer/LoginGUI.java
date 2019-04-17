/*
 * Created by JFormDesigner on Sun Mar 17 14:49:19 EET 2019
 */

package PresentationLayer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import BusinessLayer.*;



/**
 * @author Chirodea Mihai
 */
public class LoginGUI extends JFrame {
    public LoginGUI() {
        initComponents();
        this.setTitle("Bank Application Login");
        JOptionPane.showMessageDialog(this, "NOTICE: To reset database, press right arrow key!");

    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        String user = textField1.getText();
        String password = new String(passwordField1.getPassword());
        Login credentials = new Login();
        credentials.setPassword(password);
        credentials.setUser(user);
        if(credentials.login() == 1){
            if(credentials.getType() == 1){
                UserGUI gui = new UserGUI(credentials.getLogId());
                gui.setVisible(true);

            }else if(credentials.getType() == 0){
                AdminGUI gui = new AdminGUI(credentials.getLogId());
                gui.setVisible(true);
            }
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Error: User / Password incorrect!");
        }

        //AdminGUI gui = new AdminGUI();

    }

    private void buttonKeyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            Login.initialiseDB();
        }
    }

    private void initComponents() {
       this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Chirodea Mihai
        textField1 = new JTextField();
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });
        label1 = new JLabel();
        passwordField1 = new JPasswordField();
        passwordField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                buttonKeyPressed(e);
            }
        });
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
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main( String[] args )
    {
        //DAO db = DAO.getInstance();
        //db.initializeDB();
        LoginGUI gui = new LoginGUI();
        gui.setVisible(true);

    }
}
