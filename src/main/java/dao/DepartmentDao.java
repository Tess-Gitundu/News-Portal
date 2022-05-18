package dao;

import models.Department;
import models.Employee;

import java.util.List;

public interface DepartmentDao {
    //create
    void add(Department department);
    void addEmployeeToDepartment(Department department, Employee employee);

    //read
    List<Department> getAll();
    List<Employee> getAllEmployeesInADepartment(int id);
    Department findById(int departmentId);


    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}
