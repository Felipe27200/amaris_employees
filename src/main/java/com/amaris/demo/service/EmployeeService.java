package com.amaris.demo.service;

import com.amaris.demo.dto.EmployeeDTO;
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
        return employeeRepository.findEmployeeById(id);
    }
}
