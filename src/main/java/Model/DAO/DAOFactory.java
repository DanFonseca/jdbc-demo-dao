package Model.DAO;

import DB.DB;
import Model.DAO.Impl.DepartmentDAOJDBC;
import Model.DAO.Impl.SellerDAOJDBC;

import java.sql.Connection;

public class DAOFactory {

    public static SellerDAO createSellerDao(){
        return new SellerDAOJDBC(DB.getConnection());
    }

    public static DepartmentDAO createDepartmentDAO (){
        return new DepartmentDAOJDBC(DB.getConnection());
    }
}
