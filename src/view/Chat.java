/*
 * Created by JFormDesigner on Tue May 31 22:39:41 ICT 2022
 */

package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class Chat extends JFrame {
    private static String IPClient = "", nameUser = "", dataUser = "";
    private static int portClient = 0;
    private static JList<String> listActive;
    private static int portServer;
    private String name;
    static DefaultListModel<String> model = new DefaultListModel<>();

    public Chat() {
        initComponents();
    }
    public Chat(String arg, int arg1, String name, String msg, int port_Server) throws Exception {
        IPClient = arg;
        portClient = arg1;
        nameUser = name;
        dataUser = msg;
        portServer = port_Server;
        System.out.println("Port Server Main UI: " + portServer);

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Chat frame = new Chat();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        textField1 = new JTextField();
        label2 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(255, 153, 0));

            //---- label1 ----
            label1.setText("HIKKYWANNAFLY CHAT");
            label1.setForeground(Color.white);
            label1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 22));

            //---- label3 ----
            label3.setIcon(new ImageIcon(getClass().getResource("/chat.png")));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(label3)
                        .addGap(18, 18, 18)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(33, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label1)
                            .addComponent(label3))
                        .addContainerGap(15, Short.MAX_VALUE))
            );
        }

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }

        //---- label2 ----
        label2.setIcon(new ImageIcon(getClass().getResource("/icons8-email-send-35.png")));

        //---- button1 ----
        button1.setText("Connect");

        //---- button2 ----
        button2.setText("File");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(button2)
                            .addGap(0, 400, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 553, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(label2)
                            .addGap(27, 27, 27))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addGap(0, 11, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JTextField textField1;
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
