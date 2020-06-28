package com.ej.rest.model;

import com.ej.rest.entity.Department;
import com.ej.rest.entity.EmpRoll;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Employee {


    private long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String emailId;
    @NotBlank
    private String salary;
    @NotBlank
    private String address;
    @NotBlank
    private Department department;
    @NotBlank
    private EmpRoll roll;

    public Employee() {
    }

    public Employee(long id,
                    @JsonProperty("firstName") @NotBlank String firstName,
                    @JsonProperty("Name") @NotBlank String lastName,
                    @JsonProperty("emailId") @NotBlank String emailId,
                    @JsonProperty("salary") @NotBlank String salary,
                    @JsonProperty("address") @NotBlank String address,
                    @JsonProperty("department") @NotBlank Department department,
                    @JsonProperty("roll") @NotBlank EmpRoll roll) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.salary = salary;
        this.address = address;
        this.department = department;
        this.roll = roll;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EmpRoll getRoll() {
        return roll;
    }

    public void setRoll(EmpRoll roll) {
        this.roll = roll;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", salary='" + salary + '\'' +
                ", address='" + address + '\'' +
                ", department=" + department +
                ", roll=" + roll +
                '}';
    }
}