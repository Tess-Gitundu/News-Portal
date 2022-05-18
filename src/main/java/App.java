import com.google.gson.Gson;
import dao.Sql2oDepartmentDao;
import dao.Sql2oEmployeeDao;
import dao.Sql2oNewsDao;
import models.Department;
import models.Employee;
import models.News;
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

        //creating a new department
        post("/departments/new", "application/json" ,(request, response) -> {
            Department department = gson.fromJson(request.body(), Department.class);
            sql2oDepartmentDao.add(department);
            response.status(200);
            return gson.toJson(department);
        });

        //listing all the departments
        get("/departments", "application/json",(request, response) -> {
            List<Department> list = sql2oDepartmentDao.getAll();
            response.status(200);
            return gson.toJson(list);
        });

        // Finding a department by Id
        get("/departments/:id", "application/json", (request, response) -> {
            int departmentId = Integer.parseInt(request.params("id"));
            return gson.toJson(sql2oDepartmentDao.findById(departmentId));
        });

        //Finding all the employees in a department
        get("/departments/employees", "application/json", (request, response) -> {
            int departmentId = Integer.parseInt(request.params("departmentId"));
            return  gson.toJson(sql2oDepartmentDao.getAllEmployeesInADepartment(departmentId));
        });

        //create a new employee
        post("/departments/:departmentId/employee/new", "application/json", (request, response) -> {
            int departmentId = Integer.parseInt(request.params("departmentId"));
            Department newDepartment = sql2oDepartmentDao.findById(departmentId);
            Employee employee = gson.fromJson(request.body(), Employee.class);
            sql2oEmployeeDao.add(employee);
            employee.setDepartmentId(newDepartment.getId());
            sql2oDepartmentDao.addEmployeeToDepartment(newDepartment, employee);
            response.status(200);
            return gson.toJson(employee);
        });


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

        //Creating news
        post("/news/new", "application/json", (request, response) -> {
            News news = gson.fromJson(request.body(), News.class);
            sql2oNewsDao.add(news);
            response.status(200);
            return gson.toJson(news);
        });


        //List all news available
        get("/news", "application/json", (request, response) -> {
            List<News> news = sql2oNewsDao.getAll();
            response.status(200);
            return gson.toJson(news);
        });

        //List news per Department
        get ("/news/:employeeId", "application/json", (request, response) -> {
            int employeeId = Integer.parseInt(request.params("employeeId"));
            return gson.toJson(sql2oNewsDao.getAllNewsByEmployee(employeeId));
        });
    }
}
