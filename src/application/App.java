package application;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {
       
        SellerDao sellerDaoJDBC = DaoFactory.createSellerDaoJDBC();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDaoJDBC.findById(3);
        System.out.println(seller);

        System.out.println("\n=== TEST 2: seller findByDepartment ===");
        List<Seller> sellers = sellerDaoJDBC.findByDepartment(new Department(1, null));
        
        for (Seller seller2 : sellers) {
            System.out.println(seller2);
        }
    }
}
