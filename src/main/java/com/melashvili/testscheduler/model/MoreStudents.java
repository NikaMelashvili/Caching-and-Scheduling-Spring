package com.melashvili.testscheduler.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "testss2")
public class MoreStudents {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firtsName;
}
