package dao;

import model.Department;
import util.DBUtil;
import exception.DepartmentNotFoundException;

import java.sql.*;
import java.util.*;

public class DepartmentDAOImpl implements DepartmentDAO {

    public void addDepartment(Department dept) {
        String sql = "INSERT INTO department (deptid, deptname, location) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dept.getDeptId());
            ps.setString(2, dept.getDeptName());
            ps.setString(3, dept.getLocation());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Department getDepartmentById(int id) throws DepartmentNotFoundException {
        String sql = "SELECT * FROM department WHERE deptid = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Department(rs.getInt("deptid"), rs.getString("deptname"), rs.getString("location"));
            } else {
                throw new DepartmentNotFoundException("Department with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            throw new DepartmentNotFoundException("Database error: " + e.getMessage());
        }
    }

    public List<Department> getAllDepartments() {
        List<Department> list = new ArrayList<>();
        String sql = "SELECT * FROM department";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Department(rs.getInt("deptid"), rs.getString("deptname"), rs.getString("location")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateDepartment(Department dept) throws DepartmentNotFoundException {
        String sql = "UPDATE department SET deptname = ?, location = ? WHERE deptid = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dept.getDeptName());
            ps.setString(2, dept.getLocation());
            ps.setInt(3, dept.getDeptId());
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new DepartmentNotFoundException("Department with ID " + dept.getDeptId() + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDepartment(int id) throws DepartmentNotFoundException {
        String sql = "DELETE FROM department WHERE deptid = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new DepartmentNotFoundException("Department with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
