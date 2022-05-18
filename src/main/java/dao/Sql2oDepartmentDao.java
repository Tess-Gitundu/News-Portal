package dao;

import models.Department;
import models.Employee;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao{
    private final Sql2o sql2o;

    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Department department) {
        String sql = "INSERT INTO departments (name, description, numberOfEmployees) VALUES (:name, :description, :numberOfEmployees)";
        try(Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .addParameter("name", department.getDepartmentName())
                    .addParameter("description", department.getDescription())
                    .addParameter("numberOfEmployees", department.getNumberOfEmployees())
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Department> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments")
                    .executeAndFetch(Department.class);
        }
    }

    @Override
    public Department findById(int departmentId) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM departments WHERE id = :id")
                    .addParameter("id", departmentId)
                    .executeAndFetchFirst(Department.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from departments WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "Delete from departments";

        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Employee> getAllEmployeesInADepartment(int departmentId) {
        ArrayList<Employee> employees = new ArrayList<>();

        String joinQuery = "SELECT employeeid FROM departments_employees WHERE departmentid = :departmentid;";
        try(Connection con = sql2o.open()){
            List<Integer> allEmployeesIds = con.createQuery(joinQuery)
                    .addParameter("departmentid", departmentId)
                    .executeAndFetch(Integer.class);
            for (Integer employeeId: allEmployeesIds) {
                String employeeQuery = "SELECT * FROM employees WHERE id = :employeeId";
                employees.add(
                        con.createQuery(employeeQuery)
                                .addParameter("employeeId", employeeId)
                                .executeAndFetchFirst(Employee.class));
            }
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
        return employees;
    }

    @Override
    public void addEmployeeToDepartment(Department department, Employee employee) {
        String sql = "INSERT INTO departments_employees (departmentid, employeeid) VALUES (:departmentId, :employeeId);";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("departmentId", department.getId())
                    .addParameter("employeeId", employee.getId())
                    .executeUpdate();
            employee.setDepartmentId(department.getId());
        }catch (Sql2oException ex) {
            System.out.println("There was an error adding employee to department" + ex);
        }
    }
}
