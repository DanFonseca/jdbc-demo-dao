package Application;

import Model.DAO.DAOFactory;
import Model.DAO.DepartmentDAO;
import Model.Entities.Department;

import java.util.List;

public class DepartmentDAO_TEST {
    public static void main(String[] args) {

        DepartmentDAO departmentDAO = DAOFactory.createDepartmentDAO();
        System.out.println("building department");
        Department department = new Department(125, "teste");
        departmentDAO.insert(department);
        System.out.println("get department");
        System.out.println(department);
        System.out.println("deleting deparment");
        departmentDAO.deleteById(department.getId());

        List<Department> departmentList = departmentDAO.findAll();
        departmentList.forEach(System.out::println);

    }
}
