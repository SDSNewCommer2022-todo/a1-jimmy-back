package com.sds.todo.controller;

import com.sds.todo.domain.entity.TaskEntity;
import com.sds.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/task")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("/")
    public void newTask(@RequestBody Map<String, Object> requestData){
        String owner = requestData.get("owner").toString();
        String content = requestData.get("content").toString();
        todoService.addTask(owner, content);
    }

    @GetMapping("/{name}")
    public List getAllTask(@PathVariable String name){
        List<TaskEntity> tasks = todoService.findAllTasksByName(name);
        return tasks;
    }

    @PatchMapping("/status")
    public void updateStatus(@RequestBody Map<String, Object> requestData){
        int id = (int) requestData.get("id");
        String status = (String) requestData.get("status");
        todoService.updateTaskStatus(id, status);
    }

    @PatchMapping("/status/all")
    public void updateAllStatus(@RequestBody Map<String, Object> requestData){
        String owner = (String) requestData.get("owner");
        String status = (String) requestData.get("status");
        todoService.updateAllTaskStatus(owner, status);
    }

    @PatchMapping("/content")
    public void updateContent(@RequestBody Map<String, Object> requestData){
        int id = (int) requestData.get("id");
        String content = (String) requestData.get("content");
        todoService.updateTaskContent(id, content);
    }

}
