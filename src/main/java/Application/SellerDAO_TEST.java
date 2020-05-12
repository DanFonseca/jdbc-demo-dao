package Application;

import Model.DAO.DAOFactory;
import Model.DAO.SellerDAO;
import Model.Entities.Department;
import Model.Entities.Seller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class SellerDAO_TEST {
    public static void main(String[] args) throws ParseException {
        SellerDAO sellerDAO = DAOFactory.createSellerDao();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        System.out.println("==TEST 1: find By Id");
        Seller seller = sellerDAO.findById(10);
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
        Seller joaoSeller = new Seller(2, "Joao", "Joao@gmail.com", sdf.parse("01/05/2003"), 1500.0,
                new Department(3, "Fashion"));
        sellerDAO.insert(joaoSeller);
        System.out.println(joaoSeller);

        System.out.println("==TEST 5: Update into");
        seller.setBaseSalary(2500.0);
        seller.setName("Rodrigo");
        seller.setEmail("rodrigo@gmail.com");
        seller.setDepartment(new Department(2, "Electronics"));
        sellerDAO.update(seller);
        System.out.println(seller);


    }
}
