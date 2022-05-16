package dao;

import models.Employee;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oEmployeeDao implements EmployeeDao {
    private final Sql2o sql2o;

    public Sql2oEmployeeDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Employee employee) {
        String sql = "INSERT INTO employees (employee, role, position, email, departmentId) VALUES (:employee, :role, :position, :email, :departmentId)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(employee)
                    .executeUpdate()
                    .getKey();
            employee.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Employee> getAll() {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM employees")
                    .executeAndFetch(Employee.class);
        }
    }

    @Override
    public Employee findById(int id) {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM employees WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Employee.class);
        }
    }

    @Override
    public void update(int id, String employee, String role, String position, String email, int departmentId) {
        String sql = "UPDATE employees SET (employee, role, position, email, departmentId) = (SELECT :employee, :role, :position, :email, :departmentId FROM employees) WHERE id = :id";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("employee", employee)
                    .addParameter("role", role)
                    .addParameter("position", position)
                    .addParameter("email", email)
                    .addParameter("departmentId", departmentId)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM employees WHERE id = :id";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE FROM employees";
        try (Connection con = sql2o.open()){
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
