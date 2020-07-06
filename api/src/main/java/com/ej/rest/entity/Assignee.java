package com.ej.rest.entity;


import javax.persistence.*;

@Entity
@Table(name = "assignee")
@Access(value = AccessType.FIELD)
public class Assignee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id")
    private long id;

    @Column(name = "_user_id")
    private String userId;

    @Column(name = "_supervisor_id")
    private String supervisorId;

    public Assignee() {
    }

    public Assignee(String userId, String supervisorId) {
        this.userId = userId;
        this.supervisorId = supervisorId;
    }

    @Override
    public String toString() {
        return "Assignee{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", supervisorId='" + supervisorId + '\'' +
                '}';
    }
}
