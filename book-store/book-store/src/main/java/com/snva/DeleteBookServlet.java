package com.snva;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String title = request.getParameter("bookTitle");
        try {
            Connection connection = DatasourceAccess.getDataSource().getConnection();
            BookAccess.deleteBook(title, connection);
            session.setAttribute("bookList", BookAccess.getAllBooks(connection));
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("bookInfo.jsp");
    }
}
