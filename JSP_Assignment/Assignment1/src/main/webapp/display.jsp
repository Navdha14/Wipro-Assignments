<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Display Details</title>
</head>
<body>
    <h2>Submitted Details</h2>
    
    <p><strong>Name:</strong> <%= request.getParameter("name") %></p>
    <p><strong>Password:</strong> <%= request.getParameter("password") %></p>

    <br><a href="form.jsp">Go Back</a>
</body>
</html>
