package com.amaris.demo.response;

import com.amaris.demo.dto.EmployeeDTO;

public class EmployeeResponse extends BasicResponse
{
    private EmployeeDTO data;

    public EmployeeResponse() {
    }

    public EmployeeResponse(String status, EmployeeDTO data, String message)
    {
        super(status, message);
        this.data = data;
    }

    public EmployeeDTO getData() {
        return data;
    }

    public void setData(EmployeeDTO data) {
        this.data = data;
    }
}
