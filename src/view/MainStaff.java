/*
 * Created by JFormDesigner on Tue May 31 19:25:31 ICT 2022
 */

package view;

import java.awt.*;
import java.awt.event.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import model.BookDAO;
import model.OOP.Book;
import model.XMLController;
import server.rmi.IServer;

/**
 * @author Hikkywannafly
 */
public class MainStaff extends JFrame {
    String serviceName = "rmi://localhost:3308/test";
    IServer serverIMP;
    public MainStaff() throws RemoteException {
        try {
            serverIMP = (IServer) Naming.lookup(serviceName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        pushData(serverIMP.getAll());
    }

    private void label3MouseClicked(MouseEvent e) {
        // TODO add your code here
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }

    private void button4MouseClicked(MouseEvent e) throws RemoteException, ParserConfigurationException, TransformerException {
        System.out.println("da an");

        int choose= JOptionPane.showConfirmDialog(this, "Do you want to explore"  , "Confirm", JOptionPane.YES_NO_OPTION);
        if(choose != JOptionPane.YES_OPTION){

            return;
        }
        else{
            try{
                serverIMP.createXML(serverIMP.getAll());
                System.out.println("co chay");
                JOptionPane.showMessageDialog(null,"Successful");
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(this,"Error: "+ ex.getMessage());
            }

        }
    }

    private void button6MouseClicked(MouseEvent e) throws RemoteException {
        // TODO add your code here
        AddBook ab = new AddBook();
        pushData(serverIMP.getAll());
        ab.setVisible(true);
        this.dispose();


    }

    private void button8MouseClicked() {
        // TODO add your code here
        int row = table1.getSelectedRow();

        int ids= (int) table1.getValueAt(row, 0);
        String name = (String) table1.getValueAt(row, 1);
        System.out.println(ids);

        try{
            if(ids == 0 ){
                JOptionPane.showMessageDialog(this,"There are no items to choose from");
            }
            else{
                int choose= JOptionPane.showConfirmDialog(this, "Do you want to delete?" + name , "Confirm", JOptionPane.YES_NO_OPTION);
                if(choose != JOptionPane.YES_OPTION){
                    return;
                }
                else{
                    Book book = new Book(ids);
                    serverIMP.delete(book);
                    pushData(serverIMP.getAll());
                }
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(this,"Failed!" + ex.getMessage());
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        tabbedPane1 = new JTabbedPane();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        panel1 = new JPanel();
        label1 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        panel2 = new JPanel();
        textField1 = new JTextField();
        button2 = new JButton();
        panel3 = new JPanel();
        button3 = new JButton();
        button4 = new JButton();
        panel4 = new JPanel();
        button6 = new JButton();
        button8 = new JButton();
        panel5 = new JPanel();
        button7 = new JButton();
        panel6 = new JPanel();
        button5 = new JButton();
        scrollPane3 = new JScrollPane();
        textArea1 = new JTextArea();
        textField2 = new JTextField();
        button9 = new JButton();
        label2 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();

        //======== tabbedPane1 ========
        {
            tabbedPane1.setFont(new Font("Segoe UI", Font.BOLD, 14));

            //======== scrollPane1 ========
            {

                //---- table1 ----
                table1.setModel(new DefaultTableModel(
                    new Object[][] {
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                    },
                    new String[] {
                        "ID", "Name", "\tType", "Date created", "Quantity", "Borrow", "Price"
                    }
                ));
                {
                    TableColumnModel cm = table1.getColumnModel();
                    cm.getColumn(0).setMinWidth(25);
                    cm.getColumn(0).setMaxWidth(30);
                    cm.getColumn(0).setPreferredWidth(7);
                    cm.getColumn(2).setMinWidth(100);
                    cm.getColumn(2).setMaxWidth(250);
                    cm.getColumn(2).setPreferredWidth(3);
                    cm.getColumn(3).setMinWidth(25);
                    cm.getColumn(4).setMinWidth(45);
                    cm.getColumn(4).setMaxWidth(60);
                    cm.getColumn(5).setMinWidth(45);
                    cm.getColumn(5).setMaxWidth(60);
                }
                table1.setFont(new Font("JetBrains Mono ExtraBold", Font.PLAIN, 14));
                scrollPane1.setViewportView(table1);
                table1.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent mouseEvent) {
                        JTable table =(JTable) mouseEvent.getSource();
                        Point point = mouseEvent.getPoint();
                        int row = table.rowAtPoint(point);
                        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {

                            EditBook ed = new EditBook();
                            ed.setVisible(true);
                            System.out.println("hello kk");
                            int row1 = table1.getSelectedRow();
                            int ids= (int) table1.getValueAt(row1, 0);
                            String name = String.valueOf(table1.getValueAt(row1, 1));
                            String type = String.valueOf(table1.getValueAt(row1, 2));
                            String date = String.valueOf(table1.getValueAt(row1, 3));
                            int quantity = (int) table1.getValueAt(row1, 4);
                            int borrow = (int) table1.getValueAt(row1, 5);
                            float price = (float) table1.getValueAt(row1, 6);
                            System.out.println(price);
                            ed.id = ids;
                            ed.comboBox1.setSelectedItem(type);
                            ed.textField1.setText(name);
                            ed.textField3.setText(date);
                            ed.textField3.setEnabled(false);
                            ed.textField4.setText(String.valueOf(quantity));
                            ed.textField6.setText(String.valueOf(borrow));
                            ed.textField5.setText(String.valueOf(price));
                            dispose();

                        }
                    }
                });
            }
            tabbedPane1.addTab("Book", scrollPane1);

            //======== scrollPane2 ========
            {

                //---- table2 ----
                table2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                scrollPane2.setViewportView(table2);
            }
            tabbedPane1.addTab("User", scrollPane2);
        }

        //======== panel1 ========
        {
            panel1.setBackground(new Color(255, 153, 0));

            //---- label1 ----
            label1.setText("HIKKYWANNAFLY HOME MAIN");
            label1.setFont(new Font("FantasqueSansMono NF", Font.BOLD, 28));
            label1.setBackground(Color.white);
            label1.setForeground(Color.white);

            //---- label3 ----
            label3.setIcon(new ImageIcon(getClass().getResource("/exit.png")));
            label3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    label3MouseClicked(e);
                }
            });

            //---- label4 ----
            label4.setIcon(new ImageIcon(getClass().getResource("/bookshelf (1).png")));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 541, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 548, Short.MAX_VALUE)
                        .addComponent(label3)
                        .addGap(35, 35, 35))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addComponent(label3)
                                .addComponent(label1))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)))
                        .addContainerGap(14, Short.MAX_VALUE))
            );
        }

        //======== panel2 ========
        {
            panel2.setBorder(new TitledBorder(null, "Search", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.PLAIN, 14)));

            //---- button2 ----
            button2.setText("OK");

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button2)
                            .addComponent(textField1))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        //======== panel3 ========
        {
            panel3.setBorder(new TitledBorder(null, "XML Tool", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.PLAIN, 14)));

            //---- button3 ----
            button3.setText("EXPLORE");

            //---- button4 ----
            button4.setText("EXPORT");
            button4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        button4MouseClicked(e);
                    } catch (RemoteException ex) {
                        ex.printStackTrace();
                    } catch (ParserConfigurationException ex) {
                        ex.printStackTrace();
                    } catch (TransformerException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(button3, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(button4, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button4))
            );
        }

        //======== panel4 ========
        {
            panel4.setBorder(new TitledBorder(null, "Book", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.PLAIN, 14)));

            //---- button6 ----
            button6.setText("Add new");
            button6.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        button6MouseClicked(e);
                    } catch (RemoteException ex) {
                        ex.printStackTrace();
                    }

                }
            });

            //---- button8 ----
            button8.setText("Delete");
            button8.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button8MouseClicked();
                }
            });

            GroupLayout panel4Layout = new GroupLayout(panel4);
            panel4.setLayout(panel4Layout);
            panel4Layout.setHorizontalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(button6, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(button8, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
            );
            panel4Layout.setVerticalGroup(
                panel4Layout.createParallelGroup()
                    .addGroup(panel4Layout.createSequentialGroup()
                        .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button6)
                            .addComponent(button8))
                        .addGap(0, 0, Short.MAX_VALUE))
            );
        }

        //======== panel5 ========
        {
            panel5.setBorder(new TitledBorder(null, "User", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.PLAIN, 14)));

            //---- button7 ----
            button7.setText("Create");

            GroupLayout panel5Layout = new GroupLayout(panel5);
            panel5.setLayout(panel5Layout);
            panel5Layout.setHorizontalGroup(
                panel5Layout.createParallelGroup()
                    .addGroup(panel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(button7, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(15, Short.MAX_VALUE))
            );
            panel5Layout.setVerticalGroup(
                panel5Layout.createParallelGroup()
                    .addGroup(panel5Layout.createSequentialGroup()
                        .addComponent(button7)
                        .addGap(0, 0, Short.MAX_VALUE))
            );
        }

        //======== panel6 ========
        {
            panel6.setBorder(new TitledBorder(null, "General chat", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.PLAIN, 14)));

            //---- button5 ----
            button5.setText("Chat more");

            //======== scrollPane3 ========
            {

                //---- textArea1 ----
                textArea1.setFont(new Font("Arial", Font.BOLD, 14));
                scrollPane3.setViewportView(textArea1);
            }

            //---- button9 ----
            button9.setText("Send");

            GroupLayout panel6Layout = new GroupLayout(panel6);
            panel6.setLayout(panel6Layout);
            panel6Layout.setHorizontalGroup(
                panel6Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                        .addContainerGap(73, Short.MAX_VALUE)
                        .addComponent(button5)
                        .addGap(68, 68, 68))
                    .addGroup(panel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button9, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addComponent(scrollPane3)
            );
            panel6Layout.setVerticalGroup(
                panel6Layout.createParallelGroup()
                    .addGroup(panel6Layout.createSequentialGroup()
                        .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button9))
                        .addGap(43, 43, 43)
                        .addComponent(button5)
                        .addGap(0, 0, Short.MAX_VALUE))
            );
        }

        //---- label2 ----
        label2.setIcon(new ImageIcon(getClass().getResource("/chat.png")));
        label2.setText("Chat");
        label2.setToolTipText("Chat");
        label2.setFont(new Font("Arial Black", Font.BOLD, 14));
        label2.setForeground(new Color(255, 102, 0));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 954, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(panel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(7, 7, 7)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel5, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(label2)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)
                        .addComponent(panel6, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(11, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JScrollPane scrollPane1;
    public JTable table1;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JPanel panel1;
    private JLabel label1;
    private JLabel label3;
    private JLabel label4;
    private JPanel panel2;
    private JTextField textField1;
    private JButton button2;
    private JPanel panel3;
    private JButton button3;
    private JButton button4;
    private JPanel panel4;
    private JButton button6;
    private JButton button8;
    private JPanel panel5;
    private JButton button7;
    private JPanel panel6;
    private JButton button5;
    private JScrollPane scrollPane3;
    private JTextArea textArea1;
    private JTextField textField2;
    private JButton button9;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public void  pushData (List<Book> BL){
        List<Book> BookList = new ArrayList<>();
        BookList = BL;
        DefaultTableModel model;
        table1.getModel();
        model = (DefaultTableModel) table1.getModel();
        model.setRowCount(0);
        BookList.forEach(book ->{
            model.addRow(new Object [] {
                    book.getId(),book.getName(),book.getType(),book.getDate_created(),book.getQuantity(),book.getQuantity_borrow()
                    ,book.getPrice()
            });
        });

    }

    public static void main(String[] args) throws RemoteException {
        MainStaff ms = new MainStaff();
        ms.setVisible(true);
    }
}
