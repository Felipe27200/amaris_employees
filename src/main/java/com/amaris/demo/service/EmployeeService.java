package com.amaris.demo.service;

import com.amaris.demo.dto.EmployeeDTO;
import com.amaris.demo.error_handling.exception.NotFoundException;
import com.amaris.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        this.setAnnualSalary(employee);

        return employeeRepository.findEmployeeById(id);
    }

    public List<EmployeeDTO> findAllEmployees()
    {
        List<EmployeeDTO> employeesList = this.employeeRepository.findAll();

        if (employeesList == null || employeesList.isEmpty())
            throw new NotFoundException("No employees found");

        for (EmployeeDTO employee : employeesList)
        {
            this.setAnnualSalary(employee);
        }

        return employeesList;
    }

    public void validationIdEmployee(Integer id)
    {
        if (id == null)
            throw new RuntimeException("The employee id must not be null");
        if (id <= 0)
            throw new RuntimeException("The ID must be greater than zero");
    }

    private void setAnnualSalary(EmployeeDTO employee)
    {
        employee.setAnnualSalary((employee.getEmployeeSalary() * 12));
    }
}
