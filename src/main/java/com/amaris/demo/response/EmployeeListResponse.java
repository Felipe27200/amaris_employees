package com.amaris.demo.response;

import com.amaris.demo.dto.EmployeeDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EmployeeListResponse extends BasicResponse
{
    @JsonProperty("data")
    private List<EmployeeDTO> employees;

    public EmployeeListResponse()
    {
    }

    public EmployeeListResponse(String status, String message, List<EmployeeDTO> employees)
    {
        super(status, message);
        this.employees = employees;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }
}
