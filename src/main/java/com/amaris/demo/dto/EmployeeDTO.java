package com.amaris.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeDTO
{
    @JsonProperty("id")
    private Integer Id;
    @JsonProperty("employee_name")
    private String employeeName;

    @JsonProperty("employee_salary")
    private int employeeSalary;

    @JsonProperty("employee_age")
    private int employeeAge;

    @JsonProperty("profile_image")
    private String profileImage;

    private Integer anualSalary;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer id, String employeeName, int employeeSalary, int employeeAge, String profileImage) {
        Id = id;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeAge = employeeAge;
        this.profileImage = profileImage;
    }

    public EmployeeDTO(Integer id, String employeeName, int employeeSalary, int employeeAge, String profileImage, Integer anualSalary) {
        Id = id;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeAge = employeeAge;
        this.profileImage = profileImage;
        this.anualSalary = anualSalary;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public Integer getAnualSalary() {
        return anualSalary;
    }

    public void setAnualSalary(Integer anualSalary) {
        this.anualSalary = anualSalary;
    }
}
