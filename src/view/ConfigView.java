/*
 * Created by JFormDesigner on Sun Jun 05 14:47:03 ICT 2022
 */

package view;



import model.OOP.Peer;
import server.socket.ServerSK;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Hikkywannafly
 */
public class ConfigView extends JFrame {
    static ServerSK server;
    public static int port = 8080;

    public ConfigView() {
        try {
            initComponents();
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(this, "Some thing were worng");
            e.printStackTrace();
        }
    }

    static void displayUser() {
        textArea1.setText("");
        ArrayList<Peer> list = server.getListUser();
        for (int i = 0; i < list.size(); i++) {
            textArea1.append((i + 1) + "\t" + list.get(i).getName() + "\n");
        }

    }
    public static void decreaseUser(){
        int number = Integer.parseInt(textField2.getText());
        textField2.setText(Integer.toString(number - 1));
        displayUser();
    }
    public static void updateUser(){
        int number = Integer.parseInt(textField2.getText());
        textField2.setText(Integer.toString(number + 1));
        displayUser();
    }
    private void button1MouseClicked() {
        // TODO add your code here
        try {
            server = new ServerSK(port);
            label6.setText("<html><font color='green'>RUNNING...</font></html>");

        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null,"Error server");
            e1.printStackTrace();
        }
    }

    private void button2MouseClicked() throws IOException {
        // TODO add your code here
        try {
              server.closeServer();
              label6.setText("<html><font color='red'>OFF</font></html>");
        } catch (Exception e1) {
            label6.setText("<html><font color='red'>OFF</font></html>");
            e1.printStackTrace();
        }
    }

    private void initComponents() throws UnknownHostException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        panel1 = new JPanel();
        label3 = new JLabel();
        panel2 = new JPanel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        textField1.setEditable(false);
        textField2.setText(String.valueOf(port));
        textField1.setText(Inet4Address.getLocalHost().getHostAddress());
        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label1 ----
                label1.setText("IP Address");

                //---- label2 ----
                label2.setText("Port");

                //======== panel1 ========
                {
                    panel1.setBackground(new Color(204, 153, 255));

                    //---- label3 ----
                    label3.setText("SERVER CONFIG");
                    label3.setForeground(Color.white);
                    label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD));

                    GroupLayout panel1Layout = new GroupLayout(panel1);
                    panel1.setLayout(panel1Layout);
                    panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(label3)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label3)
                                .addContainerGap(14, Short.MAX_VALUE))
                    );
                }

                //======== panel2 ========
                {
                    panel2.setBackground(new Color(102, 204, 255));
                    panel2.setBorder(new TitledBorder(null, "Server Information", TitledBorder.LEADING, TitledBorder.BELOW_TOP,
                        new Font("Segoe UI Black", Font.ITALIC, 14), Color.orange));

                    //---- label4 ----
                    label4.setText("Status");
                    label4.setForeground(new Color(51, 0, 51));
                    label4.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));

                    //---- label5 ----
                    label5.setText("USER NUMBER");
                    label5.setForeground(new Color(51, 0, 51));
                    label5.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));

                    //---- label6 ----
                    label6.setFont(new Font("Arial Black", Font.BOLD, 16));

                    //---- label7 ----
                    label7.setFont(new Font("Segoe UI Black", Font.BOLD, 16));

                    GroupLayout panel2Layout = new GroupLayout(panel2);
                    panel2.setLayout(panel2Layout);
                    panel2Layout.setHorizontalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(label4)
                                        .addGap(81, 81, 81)
                                        .addComponent(label6, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addComponent(label5)
                                        .addGap(18, 18, 18)
                                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(34, Short.MAX_VALUE))
                    );
                    panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(label4)
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addGroup(panel2Layout.createParallelGroup()
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(label5)
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label7, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38))))
                    );
                }

                //---- button1 ----
                button1.setText("Start");
                button1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button1MouseClicked();
                    }
                });

                //---- button2 ----
                button2.setText("Stop");
                button2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            button2MouseClicked();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                //======== scrollPane1 ========
                {

                    //---- textArea1 ----
                    textArea1.setBackground(new Color(51, 51, 51));
                    scrollPane1.setViewportView(textArea1);
                    textArea1.setBackground(Color.BLACK);
                    textArea1.setForeground(Color.WHITE);
                    textArea1.setFont(new Font("Courier New", Font.PLAIN, 18));


                }

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(button1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button2)
                            .addGap(35, 35, 35))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addComponent(label1)
                                        .addComponent(label2))
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)))
                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(1, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2))
                            .addGap(18, 18, 18)
                            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button1)
                                .addComponent(button2))
                            .addGap(0, 0, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.NORTH);
        }
        contentPane.add(dialogPane, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JLabel label2;
    private static JTextField textField1;
    private static JTextField textField2;
    private JPanel panel1;
    private JLabel label3;
    private JPanel panel2;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane1;
    private static JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
