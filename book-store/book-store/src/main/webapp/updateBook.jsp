<%@ page import="com.snva.Book" %>
<%@ page import="java.util.*" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Book</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
    <h1>Book Store</h1>
    <h2>Update Book</h2>
    <br>
    <%-- Retrieve book details from the session --%>
    <%
        String bookTitle = request.getParameter("bookTitle");
        request.setAttribute("bookTitle", bookTitle);
    %>
    <form method="post" action="updateBook">
        <input type="hidden" name="oldBookTitle" value="${bookTitle}">
        Title: <input type="text" name="newBookTitle" autocomplete="off" required><br><br>
        Author: <input type="text" name="bookAuthor" autocomplete="off" required><br><br>
        Price: <input type="number" step="0.01" name="bookPrice" autocomplete="off" required><br><br>
        <input type="submit" value="Update">
    </form>
    <br>
    <a href="bookInfo.jsp">Back to Book List</a>
</body>
</html>