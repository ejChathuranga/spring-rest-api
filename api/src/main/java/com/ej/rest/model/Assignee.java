package com.ej.rest.model;

import javax.validation.constraints.NotBlank;

public class Assignee {
    private long id;
    @NotBlank
    private long userId;
    @NotBlank
    private long supervisorId;

    public Assignee() {
    }

    public Assignee(long id, @NotBlank long userId, @NotBlank long supervisorId) {
        this.id = id;
        this.userId = userId;
        this.supervisorId = supervisorId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(long supervisorId) {
        this.supervisorId = supervisorId;
    }

    @Override
    public String toString() {
        return "Assignee{" +
                "id=" + id +
                ", userId=" + userId +
                ", supervisorId=" + supervisorId +
                '}';
    }
}
