package model;


import model.OOP.Account;

import javax.swing.*;
import java.sql.*;


public class AccountDAO implements IDatabase {

    public AccountDAO() {
    }

    public static  Connection getConnection() {
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
    public  boolean checkLogin(Account Account){
        String query = "SELECT password FROM accounttbl WHERE email = '" +Account.getEmail() +"'";

        try{
            Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            boolean next = rs.next();
            String passInfo = rs.getString("password");
            boolean result = Account.getPassword().equals(Encryption.decrypt(passInfo, Account.getEmail()));
            return next && result;
            }

        catch(Exception ex){
                ex.printStackTrace();
        }

        return false;
    }
    public  boolean checkRegister(Account Account){
        String query = "INSERT INTO accounttbl (name, password, email, address) VALUES (?, ?, ? , ?)";
        try{
            Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1,Account.getName());
            stmt.setString(2,Account.EncryptPassword());
            stmt.setString(3,Account.getEmail());
            stmt.setString(4,Account.getAddress());
//            stmt.setString(5,Account.getPhone());
            stmt.executeUpdate();
            return true;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
