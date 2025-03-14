package com.amaris.demo.response;

import com.amaris.demo.dto.EmployeeDTO;

public class BasicResponse
{
    private String status;
    private String message;

    public BasicResponse() {
    }

    public BasicResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
