package com.sds.todo.domain.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "task")
public class TaskEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 20)
    private String owner;

    @Column(length = 100)
    private String content;

    @Column(length = 20)
    private String status;


    @Column
    @CreationTimestamp
    private java.sql.Timestamp created_time;

    @Column
    @UpdateTimestamp
    private java.sql.Timestamp modified_date;
}
