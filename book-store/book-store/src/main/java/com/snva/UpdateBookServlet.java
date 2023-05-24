package com.snva;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String oldTitle = request.getParameter("oldBookTitle");
        System.out.println(oldTitle.isEmpty());
        String newTitle = request.getParameter("newBookTitle");
        String author = request.getParameter("bookAuthor");
        double price = Double.parseDouble(request.getParameter("bookPrice"));
        try {
            Connection connection = DatasourceAccess.getDataSource().getConnection();
            BookDAO.updateBook(newTitle, oldTitle, author, price, connection);
            session.setAttribute("bookList", BookDAO.getAllBooks(connection));
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("bookInfo.jsp");
    }

    
    
}
