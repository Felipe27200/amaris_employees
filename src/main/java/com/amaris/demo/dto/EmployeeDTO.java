package com.amaris.demo.dto;

public class EmployeeDTO
{
    private Integer Id;
    private String employee_name;
    private String employee_salary;
    private Integer employee_age;
    private String profile_image;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer id, String employee_name, String employee_salary, Integer employee_age) {
        Id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
    }

    public EmployeeDTO(Integer id, String employee_name, String employee_salary, Integer employee_age, String profile_image) {
        Id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(String employee_salary) {
        this.employee_salary = employee_salary;
    }

    public Integer getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(Integer employee_age) {
        this.employee_age = employee_age;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }
}
