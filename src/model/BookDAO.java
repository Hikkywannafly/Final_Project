package model;

import model.OOP.Book;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements IDatabase {

    public BookDAO() {

    }

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

    public  List<Book> getAll() {
        List<Book> bookList = new ArrayList<>();
        String query = "SELECT * FROM producttbl";
        try {
            Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Book book = new Book(rs.getInt("id"), rs.getString("name"), rs.getString("type"),
                        rs.getString("date_created"),
                        rs.getInt("quantity"), rs.getInt("quantity_borrow"), rs.getFloat("price"));
                bookList.add(book);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bookList;
    }

    public boolean insert(Book Book) {
        String query = "INSERT INTO producttbl(name, type, quantity, quantity_borrow, price) VALUES (?,?,?,?,?)";
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, Book.getName());
            ps.setString(2, Book.getType());
            ps.setInt(3, Book.getQuantity());
            ps.setInt(4, Book.getQuantity_borrow());
            ps.setFloat(5, Book.getPrice());
            ps.executeUpdate();
            return true;
        } catch (Exception ex) {

        }
        return false;
    }

    public  void update(Book Book) {
        String query = "UPDATE book SET  name = ?, type=? , quantity=?, quantity_borrow = ?,price = ? where id = " + Book.getId();
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, Book.getName());
            ps.setString(2, Book.getType());
            ps.setInt(3, Book.getQuantity());
            ps.setInt(4, Book.getQuantity_borrow());
            ps.setFloat(5, Book.getPrice());
            ps.executeUpdate();
        } catch (Exception ex) {

        }
    }

    public  void delete(Book Book) {
        String query = "delete from book where id='" + Book.getId() + "'";
        try {
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.executeUpdate();

        } catch (SQLException ex) {


            JOptionPane.showMessageDialog(null, "Some thing wear Wrong");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
