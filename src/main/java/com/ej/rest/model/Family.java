package com.ej.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class Family {

    private long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String relation;
    @NotBlank
    private String mobile;

    public Family() {
    }

    public Family(long id, @NotBlank String firstName, @NotBlank String relation, @NotBlank String mobile) {
        this.id = id;
        this.firstName = firstName;
        this.relation = relation;
        this.mobile = mobile;
    }
}