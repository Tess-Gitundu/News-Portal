package models;

import org.junit.jupiter.api.Test;

import java.nio.file.Watchable;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    public Department setUpDepartment(){
        Department testDepartment = new Department("Maths", "Science", "2");
        return testDepartment;
    }

    @Test
    void getDepartmentName() {
        Department testDepartment = setUpDepartment();
        assertEquals("Maths", testDepartment.getDepartmentName());
    }

    @Test
    void getDescription() {
        Department testDepartment = setUpDepartment();
        assertEquals("Science", testDepartment.getDescription());
    }

    @Test
    void getNumberOfEmployees() {
        Department testDepartment = setUpDepartment();
        assertEquals("2", testDepartment.getNumberOfEmployees());
    }
}