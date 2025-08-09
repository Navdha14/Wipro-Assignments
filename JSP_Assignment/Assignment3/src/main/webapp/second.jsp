<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
    String name = (String) session.getAttribute("name");
    String password = (String) session.getAttribute("password");
%>
<html>
<head>
    <title>Display Session Data</title>
</head>
<body>
    <h2>Data Retrieved from Session</h2>
    <p><strong>Name:</strong> <%= name %></p>
    <p><strong>Password:</strong> <%= password %></p>
</body>
</body>
</html>