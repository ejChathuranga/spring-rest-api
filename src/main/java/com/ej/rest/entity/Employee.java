package com.ej.rest.entity;


import javax.persistence.*;

@Entity
@Table(name = "employee")
@Access(value = AccessType.FIELD)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String firstName;
    private String lastName;
    private String emailId;
    private String salary;
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dep_id", referencedColumnName = "id")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roll_id", referencedColumnName = "id")
    private EmpRoll empRoll;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Family family;

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EmpRoll getEmpRoll() {
        return empRoll;
    }

    public void setEmpRoll(EmpRoll empRoll) {
        this.empRoll = empRoll;
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
                ", empRoll=" + empRoll +
                '}';
    }
}
