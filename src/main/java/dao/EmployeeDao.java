package dao;

import models.Employee;

import java.util.List;

public interface EmployeeDao {
    //create
    void add (Employee employee);
    // void addEmployeeToDepartment(Employee employee, Department department)

    //read
    List<Employee> getAll();
    Employee findById(int id);
    // List<Employee> getAllDepartmentsForAnEmployee(int employeeId);

    //update
    void update(int id, String employee, String role, String position, String email, int departmentId);

    //delete
    void deleteById(int id);
    void clearAll();
}
