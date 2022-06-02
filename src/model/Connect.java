package model;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connect implements IDatabase {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connectionURL, userName, password);
            System.out.println(" Connected database successful");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: Connect Database");
        }
        return connection;
    }
}
