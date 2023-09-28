import java.time.LocalDateTime;

import model.entities.Department;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {
        Department department = new Department(1, "Books");
        Seller seller = new Seller(21, "Bob", "bob@gmail.com", LocalDateTime.now(), 3000.00, department);
        
        System.out.println(seller);
    }
}
