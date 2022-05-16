package models;

import java.util.Objects;

public class Employee {
    private String employee;
    private String role;
    private String position;
    private String email;
    private int departmentId;
    private int id;

    public Employee(String employee, String role, String position, String email, int departmentId) {
        this.employee = employee;
        this.role = role;
        this.position = position;
        this.email = email;
        this.departmentId = departmentId;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee1 = (Employee) o;
        return departmentId == employee1.departmentId && id == employee1.id && Objects.equals(employee, employee1.employee) && Objects.equals(role, employee1.role) && Objects.equals(position, employee1.position) && Objects.equals(email, employee1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, role, position, email, departmentId, id);
    }
}
