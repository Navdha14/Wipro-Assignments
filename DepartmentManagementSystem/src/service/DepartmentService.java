package service;

import dao.DepartmentDAO;
import dao.DepartmentDAOImpl;
import exception.DepartmentNotFoundException;
import model.Department;

import java.util.List;

public class DepartmentService {
    private DepartmentDAO dao = new DepartmentDAOImpl();

    public void addDepartment(Department dept) {
        dao.addDepartment(dept);
    }

    public Department getDepartmentById(int id) throws DepartmentNotFoundException {
        return dao.getDepartmentById(id);
    }

    public List<Department> getAllDepartments() {
        return dao.getAllDepartments();
    }

    public void updateDepartment(Department dept) throws DepartmentNotFoundException {
        dao.updateDepartment(dept);
    }

    public void deleteDepartment(int id) throws DepartmentNotFoundException {
        dao.deleteDepartment(id);
    }
}
