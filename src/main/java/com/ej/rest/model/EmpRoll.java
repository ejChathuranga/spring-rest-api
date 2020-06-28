package com.ej.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class EmpRoll {

    private long id;
    @NotBlank
    private String name;
    @NotBlank
    private String desc;
    @NotBlank
    private String minSalary;
    @NotBlank
    private String maxSalary;

    public EmpRoll() {
    }

    public EmpRoll(long id, @NotBlank String name, @NotBlank String desc, @NotBlank String minSalary, @NotBlank String maxSalary) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
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
}