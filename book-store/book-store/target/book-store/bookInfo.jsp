<%@ page import="com.snva.Book" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Book Store</title>
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
    </head>
    <body>
        <h1>Book Store</h1>
        <h2><a href="addBook.jsp">Add New Book</a></h2>
        <br>
        <h2>List of Books</h2>
        <table>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                <th colspan="2">Action</th>
            </tr>          
            <c:forEach items="${bookList}" var="book">
                <tr>
                    <td>${book.getTitle()}</td>
                    <td>${book.getAuthor()}</td>
                    <td>$${book.getPrice()}</td>
                    <td>
                        <form method="post" action="deleteBook">
                            <input type="hidden" name="bookTitle" value="${book.getTitle()}">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="updateBook.jsp">
                            <input type="hidden" name="bookTitle" value="${book.getTitle()}">
                            <input type="submit" value="Edit">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
