package com.sds.todo.controller;

import com.sds.todo.domain.entity.TaskEntity;
import com.sds.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/task")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("/save")
    public void newTask(@RequestBody Map<String, Object> requestData){
        String owner = requestData.get("owner").toString();
        String content = requestData.get("content").toString();
        todoService.addTask(owner, content);
    }

    @PostMapping("/get-all-task")
    public List getAllTask(@RequestBody Map<String, Object> requestData){
        String name = (String) requestData.get("name");
        List<TaskEntity> tasks = todoService.findAllTasksByName(name);
        return tasks;
    }
}
