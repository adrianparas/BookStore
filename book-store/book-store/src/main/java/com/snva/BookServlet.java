package com.snva;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);
        String title = request.getParameter("bookTitle");
        String author = request.getParameter("bookAuthor");
        double price = Double.parseDouble(request.getParameter("bookPrice"));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DatasourceAccess.getDataSource().getConnection();
            addBook(title, author, price, connection);
            session.setAttribute("bookList", BookAccess.getAllBooks(connection));
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }  
        response.sendRedirect("bookInfo.jsp");
    }

    public void addBook(String title, String author, double price, Connection connection) throws SQLException {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO book (title, author, price) VALUES (?, ?, ?)");
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setDouble(3, price);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
