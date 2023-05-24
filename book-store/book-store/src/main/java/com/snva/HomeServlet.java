package com.snva;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DatasourceAccess.getDataSource().getConnection();
            session.setAttribute("bookList", BookDAO.getAllBooks(connection));
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
        response.sendRedirect("bookInfo.jsp");
    }
}
