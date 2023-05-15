package com.snva;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);
        ArrayList<Book> books = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DatasourceAccess.getDataSource().getConnection();
            books = BookAccess.getAllBooks(connection);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
        session.setAttribute("bookList", books);
        response.sendRedirect("bookInfo.jsp");
    }
}
