package com.snva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookAccess {
    public static ArrayList<Book> getAllBooks(Connection connection) {
        ArrayList<Book> books = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM book");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String name = rs.getString(2);
                String author = rs.getString(3);
                double price = rs.getDouble(4);
                books.add(new Book(name, author, price));
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static void deleteBook(String title, Connection connection) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM book WHERE title = ?");
            ps.setString(1, title);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
