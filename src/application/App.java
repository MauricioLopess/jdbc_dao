package application;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class App {
    public static void main(String[] args) throws Exception {
       
        SellerDao sellerDaoJDBC = DaoFactory.createSellerDaoJDBC();

        Seller seller = sellerDaoJDBC.findById(3);
        
        System.out.println(seller);
    }
}
