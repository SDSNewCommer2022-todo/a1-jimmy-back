package com.sds.todo.controller;

import com.sds.todo.domain.entity.TaskEntity;
import com.sds.todo.dto.TodoAddTaskDto;
import com.sds.todo.dto.TodoUpdateAllStatusDto;
import com.sds.todo.dto.TodoUpdateContentDto;
import com.sds.todo.dto.TodoUpdateStatusDto;
import com.sds.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping("/task")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("/")
    public void newTask(@RequestBody TodoAddTaskDto todoAddTaskDto){
        todoService.addTask(todoAddTaskDto.getOwner(), todoAddTaskDto.getContent());
    }

    @GetMapping("/{name}")
    public List getAllTask(@PathVariable String name){
        List<TaskEntity> tasks = todoService.findAllTasksByName(name);
        return tasks;
    }

    @PatchMapping("/status")
    public void updateStatus(@RequestBody TodoUpdateStatusDto todoUpdateStatusDto){
        todoService.updateTaskStatus(todoUpdateStatusDto.getId(), todoUpdateStatusDto.getStatus());
    }

    @PatchMapping("/status/all")
    public void updateAllStatus(@RequestBody TodoUpdateAllStatusDto todoUpdateAllStatusDto){
        todoService.updateAllTaskStatus(todoUpdateAllStatusDto.getOwner(), todoUpdateAllStatusDto.getStatus());
    }

    @PatchMapping("/content")
    public void updateContent(@RequestBody TodoUpdateContentDto todoUpdateContentDto){
        todoService.updateTaskContent(todoUpdateContentDto.getId(), todoUpdateContentDto.getContent());
    }

}