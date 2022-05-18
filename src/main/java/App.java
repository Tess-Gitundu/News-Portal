import com.google.gson.Gson;
import dao.Sql2oDepartmentDao;
import dao.Sql2oEmployeeDao;
import dao.Sql2oNewsDao;
import models.Department;
import models.Employee;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        String connector = "jdbc:postgresql://localhost:5432/news_portal";
        Sql2o sql2o = new Sql2o(connector, "tess", "Njeri@Postgres" );
        Sql2oDepartmentDao sql2oDepartmentDao = new Sql2oDepartmentDao(sql2o);
        Sql2oEmployeeDao sql2oEmployeeDao = new Sql2oEmployeeDao(sql2o);
        Sql2oNewsDao sql2oNewsDao = new Sql2oNewsDao(sql2o);
        Connection conn = sql2o.open();
        Gson gson = new Gson();

        //create a new employee
        post("/employee/new", "application/json", ((request, response) -> {
            int departmentId = Integer.parseInt(request.queryParams("departmentId"));
            Department newDepartment = sql2oDepartmentDao.findById(departmentId);
            Employee employee = gson.fromJson(request.body(), Employee.class);
            sql2oEmployeeDao.add(employee);
            employee.setDepartmentId(newDepartment.getId());
            sql2oDepartmentDao.addEmployeeToDepartment(newDepartment, employee);
            response.status(200);
            return gson.toJson(employee);
        }));

        //listing all the employees
        get("/employees", "application/json", (request, response) -> {
            List<Employee> employees = sql2oEmployeeDao.getAll();
            response.status(200);
            return gson.toJson(employees);
        });

        //find an employee by their id
        get("/employee/:id", "application/json", (request, response) -> {
            int employeeId = Integer.parseInt(request.params("id"));
            return gson.toJson(sql2oEmployeeDao.findById(employeeId));
        });
    }
}
