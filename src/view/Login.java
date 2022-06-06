/*
 * Created by JFormDesigner on Tue May 31 15:06:27 ICT 2022
 */

package view;

import model.AccountDAO;
import model.Encryption;
import model.OOP.Account;
import model.OOP.Peer;
import server.rmi.IServer;

import java.awt.*;
import java.awt.event.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.rmi.Naming;
import java.util.Random;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author hikkywannafly
 */
public class Login extends JFrame {
    String nameAccount;
    static int portServer = 8080;
    String serviceName = "rmi://localhost:3308/test";
    IServer serverIMP;
    Encryption encryption;
    public Login() {
        try {
            serverIMP = (IServer) Naming.lookup(serviceName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
    }

    private void regisMouseClicked(MouseEvent e) {
        // TODO add your code here
        Regis re = new Regis();
        re.setVisible(true);
        this.dispose();
    }

    private void btnOkMouseClicked(MouseEvent e) {
        // TODO add your code here

        try{
            String name = tf1.getText();
            String password = tfp.getText();
            System.out.println(password);
            Account account = new Account(name,password);
            if(name.isBlank() || password.isBlank()){
                JOptionPane.showMessageDialog(null, "Password and  email not empty");

                return;
            }
            System.out.println(serverIMP.checkLogin(account));
            if(serverIMP.checkLogin(account)){
                nameAccount = tf1.getText();
                serverChat();
//                MainStaff ms = new MainStaff();
//                ms.setVisible(true);

                this.dispose();

            }
            else{
                JOptionPane.showMessageDialog(null, "Password and  email not right");
            }


        }
        catch(Exception ex){

        }


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label2 = new JLabel();
        label3 = new JLabel();
        tf1 = new JTextField();
        btnOk = new JButton();
        tfp = new JPasswordField();
        radioButton1 = new JRadioButton();
        regis = new JLabel();
        panel1 = new JPanel();
        label1 = new JLabel();

        //======== this ========
        setBackground(new Color(153, 153, 255));
        var contentPane = getContentPane();

        //---- label2 ----
        label2.setText("USER NAME");

        //---- label3 ----
        label3.setText("PASSWORD");

        //---- btnOk ----
        btnOk.setText("OK");
        btnOk.setForeground(Color.white);
        btnOk.setBackground(new Color(255, 153, 0));
        btnOk.setBorder(null);
        btnOk.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnOkMouseClicked(e);
            }
        });

        //---- radioButton1 ----
        radioButton1.setText("Admin");

        //---- regis ----
        regis.setText("Register");
        regis.setForeground(new Color(0, 153, 255));
        regis.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                regisMouseClicked(e);
            }
        });

        //======== panel1 ========
        {
            panel1.setBackground(new Color(255, 153, 0));

            //---- label1 ----
            label1.setText("HIKKYWANNAFLY LOGIN");
            label1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
            label1.setForeground(Color.white);
            label1.setBackground(new Color(102, 255, 102));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(55, Short.MAX_VALUE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 12, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tf1, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(regis)
                            .addGap(241, 241, 241)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(btnOk, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(radioButton1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(10, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(tfp, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(tf1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                    .addGap(24, 24, 24)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(tfp, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(radioButton1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addComponent(regis))
                    .addContainerGap(19, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    public void serverChat(){
        try {
            Random rd = new Random();
            int portPeer = 10000 + rd.nextInt() % 1000;

            InetAddress ipServer = InetAddress.getByName(Inet4Address.getLocalHost().getHostAddress());
            System.out.println("Ip server : " + ipServer );
            String IPClient = String.valueOf(ipServer);
            Socket socketClient = new Socket(ipServer, portServer);
            String name = nameAccount;
            Peer p = new Peer(name, portPeer);
            System.out.println("hello 0 " + p.getName() + p.getPort());
            ObjectOutputStream serverOutputStream = new ObjectOutputStream(socketClient.getOutputStream());
            serverOutputStream.writeObject(p);

            serverOutputStream.flush();
            ObjectInputStream serverInputStream = new ObjectInputStream(socketClient.getInputStream());

            socketClient.close();


            System.out.println("Port Server Login: " + portServer);
            System.out.println("Port Client Login: " + portPeer ) ;
            new MainStaff(IPClient, portPeer, nameAccount, portServer);

        } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Some Thing Error");
            ex.printStackTrace();
        }

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label2;
    private JLabel label3;
    private JTextField tf1;
    private JButton btnOk;
    private JPasswordField tfp;
    private JRadioButton radioButton1;
    private JLabel regis;
    private JPanel panel1;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            Login l = new Login();
            l.setVisible(true);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
