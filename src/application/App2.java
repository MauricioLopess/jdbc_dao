package application;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class App2 {
    public static void main(String[] args) throws Exception {
       
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDaoJDBC = DaoFactory.createDepartmentDaoJDBC();

        System.out.println("=== TEST 1: department findAll ===");
        List<Department> deps = departmentDaoJDBC.findAll();
        for(Department dep : deps){
            System.out.println(dep);
        }

        System.out.println("\n=== TEST 2: department findById ===");
        Department dep = departmentDaoJDBC.findById(3);
        System.out.println(dep);

        // System.out.println("\n=== TEST 3: department insert ===");
        // System.out.print("Enter name for new department ");
        // String name = sc.nextLine().toString();
        // dep = new Department(null, name);
        // departmentDaoJDBC.insert(dep);
        // System.out.println("Inserted! New ID = " + dep.getId());

        System.out.println("\n=== TEST 4: department update ===");
        dep = departmentDaoJDBC.findById(3);
        dep.setName("Style");
        departmentDaoJDBC.update(dep);
        System.out.println("Updated!");

        System.out.println("\n=== TEST 5: department deleteById ===");
        System.out.print("Set ID to delete a department: ");
        int id = sc.nextInt();
        departmentDaoJDBC.deleteById(id);
        System.out.print("Delete completed!");

        sc.close();
    }
}
