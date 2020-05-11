package Application;

import Model.Entities.Department;
import Model.Entities.Seller;
import java.util.Date;

public class Program {
    public static void main(String[] args) {

        Department department = new Department(1, "Books");
        Seller seller = new Seller(1,"Jorge","jorge@gmail.com",new Date(),500.0,department);
        System.out.println(seller);
    }
}
