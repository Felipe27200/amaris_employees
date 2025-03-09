package com.amaris.demo.response;

public class CustomErrorResponse extends BasicResponse
{
    private int statusCode;

    public CustomErrorResponse() { }

    public CustomErrorResponse(int statusCode, String message)
    {
        super("unsuccessful", message);
        this.statusCode = statusCode;
    }

    public CustomErrorResponse(String status, String message, int statusCode) {
        super(status, message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
