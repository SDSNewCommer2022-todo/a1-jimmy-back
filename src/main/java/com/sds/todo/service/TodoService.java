package com.sds.todo.service;

import com.sds.todo.domain.entity.TaskEntity;
import com.sds.todo.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TaskRepository taskRepo;

    public List<TaskEntity> findAllTasksByName(String name){
        return taskRepo.findTaskEntitiesByOwner(name);
    }
    public void addTask(String owner, String content){
        TaskEntity task = new TaskEntity(owner, content);
        taskRepo.save(task);
    }

    public void updateTaskStatus(long id, String status){
        TaskEntity task = taskRepo.findById(id).get();
        task.setStatus(status);
        taskRepo.save(task);
    }

    public void updateAllTaskStatus(String owner, String status){
        List<TaskEntity> tasks = taskRepo.findTaskEntitiesByOwner(owner);
        tasks.forEach((el -> el.setStatus(status)));
        taskRepo.saveAll(tasks);
    }

    public void updateTaskContent(long id, String content){
        TaskEntity task = taskRepo.findById(id).get();
        task.setContent(content);
        taskRepo.save(task);
    }

}
