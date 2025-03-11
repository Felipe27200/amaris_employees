package com.amaris.demo.service;

import com.amaris.demo.dto.EmployeeDTO;
import com.amaris.demo.error_handling.exception.NotFoundException;
import com.amaris.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @MockitoBean
    private EmployeeRepository employeeRepository;

    private EmployeeDTO mockEmployee;

    @BeforeEach
    void setUpEmployee()
    {
        // Instantiate an employee for testing
        mockEmployee = new EmployeeDTO(1, "Tiger Nixon", 320800, 61, "");
    }

    @Test
    void findEmployeeByIdTest()
    {
        Integer employeeId = 1;

        // The first argument is the method to be called.
        // The second is the value that will be used in it.
        when(employeeRepository.findEmployeeById(employeeId)).thenReturn(mockEmployee);

        EmployeeDTO employee = employeeService.findEmployeeById(employeeId);

        // Check the data
        assertNotNull(employee);
        assertEquals("Tiger Nixon", employee.getEmployeeName());
        assertEquals(320800, employee.getEmployeeSalary());
        assertEquals(61, employee.getEmployeeAge());
    }

    @Test
    void findEmployeeByIdNotFoundTest() {
        Integer notFoundId = 999;

        when(employeeRepository.findEmployeeById(notFoundId)).thenReturn(null);

        NotFoundException exception = assertThrows(
                NotFoundException.class,
                () -> employeeService.findEmployeeById(notFoundId)
        );

        System.out.println(exception.getMessage());

        assertEquals("Employee with id '999' not found", exception.getMessage());
    }
}
