package Application;

import DB.DB;
import Model.DAO.DAOFactory;
import Model.DAO.DepartmentDAO;
import Model.DAO.Impl.DepartmentDAOJDBC;
import Model.DAO.Impl.SellerDAOJDBC;
import Model.DAO.SellerDAO;
import Model.Entities.Department;
import Model.Entities.Seller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

            System.out.println("==TEST 1: find By Id");
            SellerDAO sellerDAO = DAOFactory.createSellerDao();
            Seller seller = sellerDAO.findById(3);
            System.out.println(seller);

            System.out.println("==TEST 2: find By Department");
            SellerDAO SellerDAO2 = DAOFactory.createSellerDao();
            List<Seller> sellerList = SellerDAO2.findByDepartment(new Department(2,null));
            sellerList.forEach(System.out::println);







    }
}
