package com.ej.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

public class Department {

    private long id;
    @NotBlank
    private String name;
    @NotBlank
    private String desc;

    public Department() {
    }

    public Department(long id,
                      @JsonProperty("name") String name,
                      @JsonProperty("description") String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
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
}