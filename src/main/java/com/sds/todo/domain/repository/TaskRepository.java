package com.sds.todo.domain.repository;

import com.sds.todo.domain.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface    TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findTaskEntitiesByOwner(String Owner);
}
