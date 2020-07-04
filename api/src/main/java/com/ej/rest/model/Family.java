package com.ej.rest.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Family {

    private long id;
    @NotBlank
    private String fullName;
    @NotBlank
    private String relation;
    @NotBlank
    private String mobile;
    @NotNull
    private long empId;

    public Family() {
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }
}