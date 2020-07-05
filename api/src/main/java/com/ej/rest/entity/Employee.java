package com.ej.rest.entity;


import javax.persistence.*;

@Entity
@Table(name = "employee")
@Access(value = AccessType.FIELD)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private long id;

    @Column(name = "_first_name")
    private String firstName;
    @Column(name = "_last_name")
    private String lastName;
    @Column(name = "_email_id")
    private String emailId;
    @Column(name = "_salary")
    private String salary;
    @Column(name = "_address")
    private String address;

    @Column(name = "_department")
    private String department;

    @Column(name = "_roll")
    private String roll;

    public Employee() {
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
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
                ", departmentId=" + department +
                ", rollId=" + roll +
                '}';
    }
}
