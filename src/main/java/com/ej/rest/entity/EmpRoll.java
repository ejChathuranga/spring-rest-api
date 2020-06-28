package com.ej.rest.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "emp_roll")
@Access(value = AccessType.FIELD)
public class EmpRoll {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private long id;

    @NotNull
    @Size(max = 65)
    @Column(name = "_name")
    private String name;

    @Column(name = "_desc")
    private String desc;
    @Column(name = "_min_salary")
    private String minSalary;
    @Column(name = "_max_salary")
    private String maxSalary;

    public EmpRoll() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    @Override
    public String toString() {
        return "EmpRoll{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", minSalary='" + minSalary + '\'' +
                ", maxSalary='" + maxSalary + '\'' +
                '}';
    }
}