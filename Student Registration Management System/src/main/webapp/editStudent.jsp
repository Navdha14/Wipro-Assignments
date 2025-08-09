<%@ page import="model.Student" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    Student student = (Student) request.getAttribute("student");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
</head>
<body>
	<h2>Edit Student</h2>
    <form action="StudentController?action=update" method="post">
        <input type="hidden" name="id" value="<%=student.getId()%>">
        Name: <input type="text" name="name" value="<%=student.getName()%>" required><br><br>
        Email: <input type="email" name="email" value="<%=student.getEmail()%>" required><br><br>
        Course: <input type="text" name="course" value="<%=student.getCourse()%>" required><br><br>
        <input type="submit" value="Update Student">
    </form>
    <br>
    <a href="index.jsp">Back to Home</a>
</body>
</html>