package Model.DAO;

import Model.Entities.Seller;
import java.util.List;

public interface SellerDAO {

    void insert (Seller seller);
    void update (Seller seller);
    void deleteById (Integer id);
    DepartmentDAO findById (Integer id);
    List<Seller> findAll();

}
