<%@ page import="java.util.*, model.Student" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    List<Student> students = (List<Student>) request.getAttribute("studentList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
</head>
<body>
	 <h2>Registered Students</h2>
	 <form action="StudentController" method="get">
    <input type="text" name="search" placeholder="Search by name">
    <input type="submit" value="Search">
	</form>
	 <br>
    <table border="1" cellpadding="8" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Course</th>
            <th>Actions</th>
        </tr>
        <%
            if (students != null) {
                for (Student s : students) {
        %>
        <tr>
            <td><%=s.getId()%></td>
            <td><%=s.getName()%></td>
            <td><%=s.getEmail()%></td>
            <td><%=s.getCourse()%></td>
            <td>
                <a href="StudentController?action=edit&id=<%=s.getId()%>">Edit</a> |
                <a href="StudentController?action=delete&id=<%=s.getId()%>" onclick="return confirm('Are you sure?');">Delete</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <br>
    <a href="index.jsp">Back to Home</a>
</body>
</html>