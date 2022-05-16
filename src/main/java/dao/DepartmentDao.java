package dao;

import models.Department;

import java.util.List;

public interface DepartmentDao {
    //create
    void add(Department department);
    //void addDepartmentToEmployee(Department department, Employee employee);

    //read
    List<Department> getAll();
    // List<Employee> getAllEmployeesForADepartment(int id);

    //update
    //omit for now

    //delete
    void deleteById(int id);
    void clearAll();
}
