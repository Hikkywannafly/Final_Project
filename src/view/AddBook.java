/*
 * Created by JFormDesigner on Thu Jun 02 21:32:18 ICT 2022
 */

package view;

import java.awt.event.*;

import model.OOP.Book;
import server.rmi.IServer;

import java.awt.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class AddBook extends JDialog {
    String serviceName = "rmi://localhost:3308/test";
    IServer serverIMP;
    public AddBook() {
        try {
            serverIMP = (IServer) Naming.lookup(serviceName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
    }

    private void okButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        try{
            String name = textField1.getText();
            String type = comboBox1.getSelectedItem().toString();
            int quantity = Integer.parseInt(textField4.getText());
            int borrow = 0;
            float price = Float.parseFloat(textField5.getText());
            //
            if(name.isBlank() || type.isBlank() || quantity == 0 || price == 0 ){
                JOptionPane.showMessageDialog(null,"Not allow null");
                return;
            }else{
                Book book = new Book(name,type, quantity, borrow,price);
                try{
                    if(serverIMP.insert(book)){
                        JOptionPane.showMessageDialog(null, " Successfully!");
                        MainStaff ms = new MainStaff();
                        ms.setVisible(true);
                        this.dispose();
                        return;
                    }
                    else{
                        JOptionPane.showMessageDialog(null, " Failed!");

                    }

                }
                catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, " Failed! " +  ex.getMessage());
                }
            }

        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, " Failed! " +  ex.getMessage());
        }



    }
    private void cancelButtonMouseClicked() throws RemoteException {
        // TODO add your code here
        MainStaff ms = new MainStaff();
        ms.setVisible(true);
        this.dispose();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        textField3 = new JTextField();
        label5 = new JLabel();
        textField4 = new JTextField();
        label6 = new JLabel();
        textField5 = new JTextField();
        comboBox1 = new JComboBox<>();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();
        label1 = new JLabel();
        String date= String.valueOf(LocalDate.now());
        textField3.setText(date);
        textField3.setEditable(false);
        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBackground(new Color(255, 153, 0));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setForeground(Color.white);

                //---- label2 ----
                label2.setText("Name");
                label2.setFont(new Font("Segoe UI", Font.PLAIN, 14));

                //---- textField1 ----
                textField1.setFont(new Font("Segoe UI", Font.BOLD, 14));

                //---- label3 ----
                label3.setText("Type");
                label3.setFont(new Font("Segoe UI", Font.PLAIN, 14));

                //---- label4 ----
                label4.setText("\tDate_created");
                label4.setFont(new Font("Segoe UI", Font.PLAIN, 14));

                //---- textField3 ----
                textField3.setFont(new Font("Segoe UI", Font.BOLD, 14));

                //---- label5 ----
                label5.setText("\tQuantity");
                label5.setFont(new Font("Segoe UI", Font.PLAIN, 14));

                //---- textField4 ----
                textField4.setFont(new Font("Segoe UI", Font.BOLD, 14));

                //---- label6 ----
                label6.setText("Price");
                label6.setFont(new Font("Segoe UI", Font.PLAIN, 14));

                //---- textField5 ----
                textField5.setFont(new Font("Segoe UI", Font.BOLD, 14));

                //---- comboBox1 ----
                comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
                    "Action and Adventure.",
                    "Classics.",
                    "Comic Book or Graphic Novel.",
                    "Detective and Mystery.",
                    "Fantasy.",
                    "Historical Fiction.",
                    "Horror.",
                    "Literary Fiction."
                }));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label3)
                                .addComponent(label2)
                                .addComponent(label4)
                                .addComponent(label5)
                                .addComponent(label6))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(textField1)
                                        .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
                                    .addGap(28, 28, 28))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(label3)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label4))
                            .addGap(18, 18, 18)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label5))
                            .addGap(18, 18, 18)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label6))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("OK");
                okButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        okButtonMouseClicked(e);
                    }
                });
                buttonBar.add(okButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            cancelButtonMouseClicked();
                        } catch (RemoteException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                buttonBar.add(cancelButton, new GridBagConstraints(1, 0, 3, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);

            //---- label1 ----
            label1.setText("ADD NEW BOOK");
            label1.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
            label1.setForeground(Color.white);
            dialogPane.add(label1, BorderLayout.NORTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField3;
    private JLabel label5;
    private JTextField textField4;
    private JLabel label6;
    private JTextField textField5;
    private JComboBox<String> comboBox1;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
