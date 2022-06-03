/*
 * Created by JFormDesigner on Fri Jun 03 11:36:44 ICT 2022
 */

package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class EditBook extends JDialog {
    public EditBook(Window owner) {
        super(owner);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        contentPanel2 = new JPanel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        textField3 = new JTextField();
        label5 = new JLabel();
        textField4 = new JTextField();
        label6 = new JLabel();
        textField5 = new JTextField();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();
        label1 = new JLabel();

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

                //======== contentPanel2 ========
                {
                    contentPanel2.setForeground(Color.white);

                    //---- label2 ----
                    label2.setText("Name");
                    label2.setFont(new Font("Segoe UI", Font.PLAIN, 14));

                    //---- textField1 ----
                    textField1.setFont(new Font("Segoe UI", Font.BOLD, 14));

                    //---- label3 ----
                    label3.setText("Type");
                    label3.setFont(new Font("Segoe UI", Font.PLAIN, 14));

                    //---- textField2 ----
                    textField2.setFont(new Font("Segoe UI", Font.BOLD, 14));

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

                    GroupLayout contentPanel2Layout = new GroupLayout(contentPanel2);
                    contentPanel2.setLayout(contentPanel2Layout);
                    contentPanel2Layout.setHorizontalGroup(
                        contentPanel2Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, contentPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPanel2Layout.createParallelGroup()
                                    .addComponent(label3)
                                    .addComponent(label2)
                                    .addComponent(label4)
                                    .addComponent(label5)
                                    .addComponent(label6))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField1)
                                    .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28))
                    );
                    contentPanel2Layout.setVerticalGroup(
                        contentPanel2Layout.createParallelGroup()
                            .addGroup(contentPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label2))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(textField3, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label4))
                                .addGap(18, 18, 18)
                                .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(textField4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label5))
                                .addGap(18, 18, 18)
                                .addGroup(contentPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(textField5, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label6))
                                .addContainerGap(46, Short.MAX_VALUE))
                    );
                }

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(contentPanel2, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(29, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(contentPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);

            //---- label1 ----
            label1.setText("EDIT BOOK");
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
    private JPanel contentPanel2;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JTextField textField2;
    private JLabel label4;
    private JTextField textField3;
    private JLabel label5;
    private JTextField textField4;
    private JLabel label6;
    private JTextField textField5;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
