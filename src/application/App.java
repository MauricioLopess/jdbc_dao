package application;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {
       
        Scanner sc = new Scanner(System.in);

        SellerDao sellerDaoJDBC = DaoFactory.createSellerDaoJDBC();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDaoJDBC.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> sellers = sellerDaoJDBC.findByDepartment(department);
        
        for (Seller seller2 : sellers) {
            System.out.println(seller2);
        }

        System.out.println("\n=== TEST 3: seller findAll ===");
        sellers = sellerDaoJDBC.findAll();
    
        for (Seller seller2 : sellers) {
            System.out.println(seller2);
        }

        System.out.println("\n=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", LocalDateTime.now(), 4000.0, department);
        sellerDaoJDBC.insert(newSeller);
        System.out.println("Inserted! New ID = " + newSeller.getId());

        System.out.println("\n=== TEST 5: seller update ===");
        seller = sellerDaoJDBC.findById(1);
        seller.setName("Marta Waine");
        sellerDaoJDBC.update(seller);
        System.out.println("Updated!");

        System.out.println("\n=== TEST 6: seller deleteById ===");
        System.out.print("Set ID to delete a seller: ");
        int id = sc.nextInt();
        sellerDaoJDBC.deleteById(id);
        System.out.print("Delete completed!");


        sc.close();
    }
}
