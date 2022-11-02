package com.sds.todo.service;

import com.sds.todo.domain.entity.TaskEntity;
import com.sds.todo.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TaskRepository taskRepo;

    public void addTask(String owner, String content){
        TaskEntity task = new TaskEntity(owner, content);
        taskRepo.save(task);
    }
    public List<TaskEntity> findAllTasks(){
        List<TaskEntity> ret = new ArrayList<>();
        taskRepo.findAll().forEach(e->ret.add(e));
        return ret;
    }

    public List<TaskEntity> findAllTasksByName(String name){
        return taskRepo.findTaskEntitiesByOwner(name);
    }
}
