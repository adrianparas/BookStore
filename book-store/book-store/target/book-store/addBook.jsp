<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
      <title>Add Book</title>
      <link rel="stylesheet" type="text/css" href="css/style.css"/>
  </head>
  <body>
    <h1>Book Store</h1>
    <h2 id="newBook">Add New Book</h2>
    <br>
    <form method="post" action="addBook">
        <h2>New Book Form</h2>
        Title: <input type="text" name="bookTitle" required><br><br>
        Author: <input type="text" name="bookAuthor" required><br><br>
        Price: <input type="number" step="0.01" name="bookPrice" required><br><br>
        <input type="submit">
        &emsp; <a href="bookInfo.jsp">Home</a>
    </form>
  </body>
</html>
