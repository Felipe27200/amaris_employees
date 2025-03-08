package com.amaris.demo.repository;

import com.amaris.demo.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class EmployeeRepository
{
    private RestTemplate restTemplate;

    @Autowired
    public EmployeeRepository(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public EmployeeDTO findEmployeeById(Integer id)
    {
        EmployeeDTO employee = restTemplate.getForObject(
                "https://dummy.restapiexample.com/api/v1/employee/" + id,
                EmployeeDTO.class
        );

        return employee;
    }
}
