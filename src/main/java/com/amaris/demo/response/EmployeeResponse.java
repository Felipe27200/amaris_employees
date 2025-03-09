package com.amaris.demo.response;

import com.amaris.demo.dto.EmployeeDTO;

public class EmployeeResponse
{
    private String status;
    private EmployeeDTO data;
    private String message;

    public EmployeeResponse() {
    }

    public EmployeeResponse(String status, EmployeeDTO data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EmployeeDTO getData() {
        return data;
    }

    public void setData(EmployeeDTO data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
