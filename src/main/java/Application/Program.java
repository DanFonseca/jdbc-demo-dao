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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) throws ParseException {
        SellerDAO sellerDAO = DAOFactory.createSellerDao();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        System.out.println("==TEST 1: find By Id");
        Seller seller = sellerDAO.findById(3);
        System.out.println(seller);
        System.out.println();

        System.out.println("==TEST 2: find By Department");
        List<Seller> findByDepartmentList = sellerDAO.findByDepartment(new Department(2, null));
        findByDepartmentList.forEach(System.out::println);
        System.out.println();

        System.out.println("==TEST 3: find All");
        List<Seller> findAll = sellerDAO.findAll();
        findAll.forEach(System.out::println);

        System.out.println("==TEST 4: Insert into");
        Seller joaoSeller = new Seller(2,"Joao","Joao@gmail.com", sdf.parse("01/05/2003"),1500.0,
                new Department(3,"Fashion"));
        sellerDAO.insert(joaoSeller);
        System.out.println(joaoSeller);


    }
}
