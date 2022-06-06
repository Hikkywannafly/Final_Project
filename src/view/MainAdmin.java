/*
 * Created by JFormDesigner on Sun Jun 05 10:33:22 ICT 2022
 */

package view;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

/**
 * @author unknown
 */
public class MainAdmin extends JFrame {
    public MainAdmin() {
        initComponents();
    }

    private void button4MouseClicked() {
        // TODO add your code here
        ConfigView cv = new ConfigView();
        cv.setVisible(true);
    }
//    public void updateChat_receive(String msg) {
//        textArea1.append(msg);
//    }
//
//    public void updateChat_send(String msg) {
//        textArea1.append("You" + msg);
//    }


    private void label2MouseClicked() {
        // TODO add your code here
    }


    private void button3MouseClicked() {
        // TODO add your code here
    }

    private void button5MouseClicked() {
        // TODO add your code here
    }

    private void button2MouseClicked() {
        // TODO add your code here
    }

    private void button1MouseClicked() {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        label1 = new JLabel();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        textField1 = new JTextField();
        label2 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        comboBox1 = new JComboBox<>();
        textField2 = new JTextField();
        scrollPane2 = new JScrollPane();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(new Color(255, 153, 0));

            //---- label1 ----
            label1.setText("HIKKYWANNAFLY ADMINSTRATOR");
            label1.setForeground(Color.white);
            label1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 22));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap(15, Short.MAX_VALUE)
                        .addComponent(label1)
                        .addContainerGap())
            );
        }

        //======== panel2 ========
        {
            panel2.setBorder(new TitledBorder(null, "Server", TitledBorder.LEADING, TitledBorder.ABOVE_TOP,
                new Font("Segoe UI Black", Font.ITALIC, 14), Color.pink));
            panel2.setForeground(new Color(102, 0, 0));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(textArea1);
            }

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                        .addContainerGap())
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                        .addGap(17, 17, 17))
            );
        }

        //---- label2 ----
        label2.setIcon(new ImageIcon(getClass().getResource("/icons8-email-send-35.png")));

        //---- button1 ----
        button1.setText("B");
        button1.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
        button1.setForeground(Color.black);
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked();
            }
        });

        //---- button2 ----
        button2.setText("I");
        button2.setFont(new Font("Segoe UI Black", Font.ITALIC, 14));
        button2.setForeground(Color.black);
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked();
            }
        });

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "RED",
            "BLUE"
        }));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportBorder(new TitledBorder(null, "Working", TitledBorder.LEADING, TitledBorder.ABOVE_TOP,
                new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 14), Color.green));
        }

        //---- button3 ----
        button3.setText("INFO");
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button3MouseClicked();
            }
        });

        //---- button4 ----
        button4.setText("Config");
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button4MouseClicked();
            }
        });

        //---- button5 ----
        button5.setText("About");
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button5MouseClicked();
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textField2))
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(button3)
                            .addGap(27, 27, 27)
                            .addComponent(button4)
                            .addGap(33, 33, 33)
                            .addComponent(button5))
                        .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(30, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button1)
                                .addComponent(button2)
                                .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(button5)
                                .addComponent(button3)
                                .addComponent(button4))
                            .addGap(26, 26, 26))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addContainerGap())))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JLabel label1;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private  static JTextArea textArea1;
    private JTextField textField1;
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    private JComboBox<String> comboBox1;
    private JTextField textField2;
    private JScrollPane scrollPane2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        MainAdmin l = new MainAdmin();
                        l.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
