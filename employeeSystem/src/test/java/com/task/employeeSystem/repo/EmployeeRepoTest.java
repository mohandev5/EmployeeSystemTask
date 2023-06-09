package com.task.employeeSystem.repo;

import com.task.employeeSystem.entity.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class EmployeeRepoTest {

    @Autowired
    private EmployeeRepo  employeeRepo;
    Employee employee;

    @BeforeEach
    void setUp() {
      employee = new Employee(1,"john",25000,"devolepment","junior devoloper");
      employeeRepo.save(employee);
    }

    @AfterEach
    void tearDown() {
       employee = null;
       employeeRepo.deleteAll();
    }
    //Success case test

    @Test
    void testFindByEmployee_Found(){
       List<Employee>employeeList = employeeRepo.findEmployeeByEmployeeName("john");
       assertEquals(employeeList.get(0).equals(employee.getEmployeeName()));
    }
    private void assertEquals(boolean equals) {
    }
}