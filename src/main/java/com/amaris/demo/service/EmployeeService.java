package com.amaris.demo.service;

import com.amaris.demo.dto.EmployeeDTO;
import com.amaris.demo.error_handling.exception.NotFoundException;
import com.amaris.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService
{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDTO findEmployeeById(Integer id)
    {
        this.validationIdEmployee(id);

        EmployeeDTO employee = employeeRepository.findEmployeeById(id);

        if (employee == null)
            throw new NotFoundException("Employee with id '" + id + "' not found");

        return employeeRepository.findEmployeeById(id);
    }

    public void validationIdEmployee(Integer id)
    {
        if (id == null)
            throw new RuntimeException("The employee id must not be null");
        if (id <= 0)
            throw new RuntimeException("The employee id must not be less than zero");
    }
}
