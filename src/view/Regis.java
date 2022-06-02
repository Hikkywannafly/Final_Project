/*
 * Created by JFormDesigner on Tue May 31 18:47:54 ICT 2022
 */

package view;

import model.AccountDAO;
import model.OOP.Account;
import server.rmi.IServer;
import server.rmi.SeverIMP;

import java.awt.*;
import java.awt.event.*;
import java.rmi.Naming;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

import static model.AccountDAO.*;

/**
 * @author unknown
 */
public class Regis extends JFrame {

    String serviceName = "rmi://localhost:3308/test";
    IServer serverIMP;
    public Regis() {
        try {
             serverIMP = (IServer) Naming.lookup(serviceName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
    }

    private void cancelButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        Login re = new Login();
        re.setVisible(true);
        this.dispose();
    }

    private void okButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        String name = tf1.getText();
        String email = tf2.getText();
        String password = passwordField1.getText();
        String address = tf4.getText();
        String phone = tf5.getText();
//        Account account = new Account(name,email,password,address);
//        AccountDAO.checkRegister(account);
        if(name.isBlank() || email.isBlank() || password.isBlank() || address.isBlank()){
        JOptionPane.showMessageDialog(null, "Not Allow null anyway ");
        return;
        }
        else{
            Account account = new Account(name,email,password,address);

            try{
                if(serverIMP.checkRegister(account)){
                    JOptionPane.showMessageDialog(null, "Sign up successfully!");
                    Login l = new Login();
                    l.setVisible(true);
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Sign up failed!");
                }
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());

            }

        }

    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label3 = new JLabel();
        tf1 = new JTextField();
        label4 = new JLabel();
        tf2 = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        tf4 = new JTextField();
        label7 = new JLabel();
        tf5 = new JTextField();
        passwordField1 = new JPasswordField();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();
        panel1 = new JPanel();
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label3 ----
                label3.setText("Name");

                //---- label4 ----
                label4.setText("Email");

                //---- label5 ----
                label5.setText("Password");

                //---- label6 ----
                label6.setText("Adress");

                //---- label7 ----
                label7.setText("Note");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label7, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label6, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label5))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(tf5, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                .addComponent(tf1, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                .addComponent(tf4, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                .addComponent(tf2, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                .addComponent(passwordField1, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                            .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(tf1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(tf2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                    .addGap(118, 118, 118)
                                    .addComponent(tf5, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGap(21, 21, 21)
                                            .addComponent(label5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                            .addGap(19, 19, 19)
                                            .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tf4, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                                    .addGap(22, 22, 22)
                                    .addComponent(label7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(34, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("OK");
                okButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        okButtonMouseClicked(e);
                    }
                });
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        cancelButtonMouseClicked(e);
                    }
                });
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(255, 153, 0));

            //---- label1 ----
            label1.setText("HIKKYWANNAFLY REGISTER");
            label1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
            label1.setForeground(Color.white);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(50, Short.MAX_VALUE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
            );
        }
        contentPane.add(panel1, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label3;
    private JTextField tf1;
    private JLabel label4;
    private JTextField tf2;
    private JLabel label5;
    private JLabel label6;
    private JTextField tf4;
    private JLabel label7;
    private JTextField tf5;
    private JPasswordField passwordField1;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    private JPanel panel1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            Regis l = new Regis();
            l.setVisible(true);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
