package com.amaris.demo.controller;

import com.amaris.demo.dto.EmployeeDTO;
import com.amaris.demo.repository.EmployeeRepository;
import com.amaris.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController
{
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("api/employees/{id}")
    public ResponseEntity<EmployeeDTO> findEmployeeById(@PathVariable Integer id)
    {
        EmployeeDTO employee = employeeService.findEmployeeById(id);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
