package client;

import model.Department;
import service.DepartmentService;
import exception.DepartmentNotFoundException;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentService service = new DepartmentService();

        while (true) {
            System.out.println("====== Department Management =====");
            System.out.println("1. Add Department");
            System.out.println("2. Get Department by ID");
            System.out.println("3. Get All Departments");
            System.out.println("4. Update Department");
            System.out.println("5. Delete Department");
            System.out.println("6. Exit");
            System.out.println("===================================");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Location: ");
                        String loc = sc.nextLine();
                        service.addDepartment(new Department(id, name, loc));
                        System.out.println("Department added!");
                        System.out.println();
                        break;
                    case 2:
                        System.out.print("Enter ID: ");
                        Department dept = service.getDepartmentById(sc.nextInt());
                        System.out.println(dept);
                        System.out.println();
                        break;
                    case 3:
                        List<Department> list = service.getAllDepartments();
                        System.out.println();
                        list.forEach(System.out::println);
                        System.out.println();
                        break;
                    case 4:
                        System.out.print("Enter ID to update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new location: ");
                        String newLoc = sc.nextLine();
                        service.updateDepartment(new Department(uid, newName, newLoc));
                        System.out.println("Department updated!");
                        System.out.println();
                        break;
                    case 5:
                        System.out.print("Enter ID to delete: ");
                        service.deleteDepartment(sc.nextInt());
                        System.out.println("Department deleted!");
                        System.out.println();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        sc.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (DepartmentNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
