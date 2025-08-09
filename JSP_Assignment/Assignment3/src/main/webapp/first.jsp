<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
    String name = request.getParameter("name");
    String password = request.getParameter("password");

    // Store in session
    session.setAttribute("name", name);
    session.setAttribute("password", password);
%>
<html>
<head>
    <title>Session Stored</title>
</head>
<body>
    <h2>Details Stored in Session</h2>
    <p>Click the link below to view your data:</p>
    <a href="second.jsp">Go to Second Page</a>
</body>
</html>