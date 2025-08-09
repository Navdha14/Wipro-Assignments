package controller;

import dao.StudentDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;
import java.util.List;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {

    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action == null) {
                listStudents(request, response);
            } else {
                switch (action) {
                    case "new":
                        showNewForm(request, response);
                        break;
                    case "insert":
                        insertStudent(request, response);
                        break;
                    case "delete":
                        deleteStudent(request, response);
                        break;
                    case "edit":
                        showEditForm(request, response);
                        break;
                    case "update":
                        updateStudent(request, response);
                        break;
                    default:
                        listStudents(request, response);
                        break;
                }
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String search = request.getParameter("search");
        List<Student> list;
        if (search != null && !search.trim().isEmpty()) {
            list = studentDAO.searchStudentsByName(search);
        } else {
            list = studentDAO.getAllStudents();
        }
        request.setAttribute("studentList", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listStudents.jsp");
        dispatcher.forward(request, response);
    }


    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addStudent.jsp");
        dispatcher.forward(request, response);
    }

    private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        
        if (!isValidInput(name, email, course)) {
            response.getWriter().println("Invalid input. Please go back and enter valid details.");
            return;
        }
        
        Student student = new Student(name, email, course);
        studentDAO.addStudent(student);
        response.sendRedirect("StudentController");
    }


    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student existingStudent = studentDAO.getStudentById(id);
        request.setAttribute("student", existingStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editStudent.jsp");
        dispatcher.forward(request, response);
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        
        if (!isValidInput(name, email, course)) {
            response.getWriter().println("Invalid input. Please go back and enter valid details.");
            return;
        }
        
        Student student = new Student(id, name, email, course);
        studentDAO.updateStudent(student);
        response.sendRedirect("StudentController");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDAO.deleteStudent(id);
        response.sendRedirect("StudentController");
    }
    
    private boolean isValidInput(String name, String email, String course) {
        return name.matches("^[A-Za-z\\s]{2,30}$") &&
               email.matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$") &&
               course.matches("^[A-Za-z\\s]{2,50}$");
    }
}
