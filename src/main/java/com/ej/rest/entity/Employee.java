package com.ej.rest.entity;


import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "employee")
@Access(value=AccessType.FIELD)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Employee() {
    }

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
