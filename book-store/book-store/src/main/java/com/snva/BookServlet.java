package com.snva;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
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
            BookDAO.addBook(title, author, price, connection);
            session.setAttribute("bookList", BookDAO.getAllBooks(connection));
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }  
        response.sendRedirect("bookInfo.jsp");
    }


}
