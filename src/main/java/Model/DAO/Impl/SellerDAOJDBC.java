package Model.DAO.Impl;

import DB.DB;
import DB.DBException;
import Model.DAO.SellerDAO;
import Model.Entities.Department;
import Model.Entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SellerDAOJDBC implements SellerDAO {
    private Connection conn;

    public SellerDAOJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller seller) {

    }

    @Override
    public void update(Seller seller) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {

        PreparedStatement st = null;
        ResultSet rs = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
            st = conn.prepareStatement("select s.*, d.Id, d.Name as dpName " +
                    "FROM seller as s " +
                    "inner join department as d " +
                    "on s.Id = d.Id " +
                    "where d.Id = ?");
            st.setInt(1, id);
            rs = st.executeQuery();

            if(rs.next()){
                Department department = instantiateDepartment(rs);
                Seller seller = instantiateSeller(rs, department);
                return seller;
            }
            return null;

        }catch (SQLException e){
            throw new DBException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Seller> sellerList = new ArrayList<>();

        try {
            st = conn.prepareStatement("select s.* , d.Name as dpName "+
                                        "from seller as s "+
                                        "inner join department as d "+
                                        "on s.DepartmentId = d.Id "+
                                        "WHERE d.Id = ? "+
                                        "order by s.Name");

            st.setInt(1, department.getId());
            rs = st.executeQuery();

               Map<Integer, Department> map = new HashMap<>();
               
                while(rs.next()){
                    Department dep = map.get(rs.getInt("DepartmentId"));
                    if(dep == null){
                        dep = instantiateDepartment(rs);
                        map.put(dep.getId(), dep);
                    }
                    sellerList.add(instantiateSeller(rs, dep));
            }


        }catch (SQLException e){
            e.getStackTrace();
            throw new DBException(e.getMessage());
        }

        return sellerList;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {

        Department department = new Department();
        department.setId(rs.getInt("DepartmentId"));
        department.setName(rs.getString("dpName"));

        return department;
    }

    private Seller instantiateSeller(ResultSet rs, Department department) throws SQLException {

        Seller seller = new Seller();
        seller.setId(rs.getInt("Id"));
        seller.setName(rs.getString("Name"));
        seller.setEmail(rs.getString("Email"));
        seller.setBirthDate(rs.getDate("BirthDate"));
        seller.setBaseSalary(rs.getDouble("BaseSalary"));
        seller.setDepartment(department);

        return seller;
    }

    @Override
    public List<Seller> findAll() {
        return null;
    }

}
