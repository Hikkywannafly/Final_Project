/*
 * Created by JFormDesigner on Sat Jun 04 09:35:41 ICT 2022
 */

package view;

import model.OOP.Book;
import model.XMLController;
import server.rmi.IServer;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author unknown
 */
public class XMLView extends JDialog {
    String serviceName = "rmi://localhost:3308/test";
    IServer serverIMP;
    public XMLView() {
        try {
            serverIMP = (IServer) Naming.lookup(serviceName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
    }
    private void button1MouseClicked(MouseEvent e)  {
        // TODO add your code here
        try{
            FileDialog fd = new FileDialog(this, "Open", FileDialog.LOAD);
            fd.setVisible(true);
            if (fd.getFile() != null) {
                filename = fd.getFile();
                fileaddress = fd.getDirectory();
                this.setTitle(filename);
                if(filename.endsWith(".xml")){
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
                    System.out.println(filename);
                    System.out.println(fileaddress);
                    pushData(serverIMP.readXMl("C://Users//Hiki_ne//Desktop//"+filename));
                    scrollPane1.setViewportView(table1);
                    System.out.println("Successfully");
                    

                }
                else{
                    JOptionPane.showMessageDialog(null, "Must be file have directory .xml");
                }

            }




        }
        catch(Exception ex) {
            JOptionPane.showMessageDialog(this,"Error: " +ex.getMessage());
        }

    }

        private void okButtonMouseClicked(MouseEvent e){
        this.dispose();
        }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        buttonBar = new JPanel();
        button1 = new JButton();
        okButton = new JButton();
        labelText = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //======== scrollPane1 ========
//                here
                {

                    labelText.setText("Not thing at here :((");
                    labelText.setFont(new Font("Arial", Font.BOLD, 40));
                    scrollPane1.setViewportView(labelText);

                }

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                            .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                            .addContainerGap())
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0};

                //---- button1 ----
                button1.setText("Import");
                button1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        button1MouseClicked(e);
                    }
                });
                buttonBar.add(button1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- okButton ----
                okButton.setText("Cancel");
                okButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        okButtonMouseClicked(e);
                    }
                });
                buttonBar.add(okButton, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel buttonBar;
    private JButton button1;
    private JButton okButton;
    private JLabel labelText;
    String filename;
    String fileaddress;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public void  pushData (java.util.List<Book> BL){
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
}
