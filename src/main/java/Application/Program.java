package Application;

import DB.DB;
import Model.DAO.DAOFactory;
import Model.DAO.Impl.SellerDAOJDBC;
import Model.DAO.SellerDAO;
import Model.Entities.Department;
import Model.Entities.Seller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class Program {
    public static void main(String[] args) {

            SellerDAO sellerDAO = DAOFactory.createSellerDao();
            Seller seller = sellerDAO.findById(3);
            System.out.println(seller);

    }
}
