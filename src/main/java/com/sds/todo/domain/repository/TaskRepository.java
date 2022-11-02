package com.sds.todo.domain.repository;

import com.sds.todo.domain.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface    TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findTaskEntitiesByOwner(String Owner);

    @Transactional
    void deleteTaskEntitiesByOwner(String Owner);
}
