package com.example.demo.controller;
import com.example.demo.classesPackage.Task;
import com.example.demo.service.TaskService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }
    @DeleteMapping("/deleteTask")
    public void deleteTask(@RequestBody Task task){
        taskService.deleteTask(task);
    }
    @PostMapping("/addTask")
    public void addTask(@RequestBody Task task, Authentication authentication) {
        int userId = (int) authentication.getPrincipal();
        taskService.addTask(task.getDesc(), userId, task.getPriority());
    }
    @GetMapping("/showTask")
    public List<Task> showTask(){
        return taskService.showTask();
    }
    @PutMapping("/updateTask")
    public void updateTask(@RequestBody Task task){
        taskService.updateTask(task.getStatus(),task.getId());
    }
}
