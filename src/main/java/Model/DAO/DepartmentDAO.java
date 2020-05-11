package Model.DAO;

import Model.Entities.Department;
import java.util.List;

public interface DepartmentDAO {
    void insert (Department department);
    void update (Department department);
    void deleteById (Integer id);
    DepartmentDAO findById (Integer id);
    List<Department> findAll();
}
