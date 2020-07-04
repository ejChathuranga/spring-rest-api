package com.ej.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
    @NotNull
    private long departmentId;
    @NotNull
    private long rollId;

    public Employee() {
    }

    public Employee(long id,
                    @JsonProperty("firstName") @NotBlank String firstName,
                    @JsonProperty("lastName") @NotBlank String lastName,
                    @JsonProperty("emailId") @NotBlank String emailId,
                    @JsonProperty("salary") @NotBlank String salary,
                    @JsonProperty("address") @NotBlank String address,
                    @JsonProperty("departmentId") @NotBlank long departmentId,
                    @JsonProperty("rollId") @NotBlank long rollId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.salary = salary;
        this.address = address;
        this.departmentId = departmentId;
        this.rollId = rollId;
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

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public long getRollId() {
        return rollId;
    }

    public void setRollId(long rollId) {
        this.rollId = rollId;
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
                ", departmentId=" + departmentId +
                ", rollId=" + rollId +
                '}';
    }
}