package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    public Employee setUpEmployee(){
        Employee testEmployee = new Employee("Pure", "Teacher", "Principal", "pureteacher@gmail.com", 1);
        return testEmployee;
    }
    @Test
    void getEmployee() {
        Employee testEmployee = setUpEmployee();
        assertEquals("Pure", testEmployee.getEmployee());
    }
    @Test
    void getRole() {
        Employee testEmployee = setUpEmployee();
        assertEquals("Teacher", testEmployee.getRole());
    }
    @Test
    void getPosition() {
        Employee testEmployee = setUpEmployee();
        assertEquals("Principal", testEmployee.getPosition());
    }
    @Test
    void getEmail() {
        Employee testEmployee = setUpEmployee();
        assertEquals("pureteacher@gmail.com", testEmployee.getEmail());
    }

    @Test
    void getDepartmentId() {
        Employee testEmployee = setUpEmployee();
        assertEquals(1, testEmployee.getDepartmentId());
    }
}