package com.sds.todo.domain.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "task")
public class TaskEntity {
    @Id
    private Long id;

    @Column(length = 20)
    private String owner;

    @Column(length = 100)
    private String content;

    @Column(length = 20)
    private String status;

    @Column
    private java.sql.Timestamp created_time;

    @Column
    private java.sql.Timestamp modified_date;
}
