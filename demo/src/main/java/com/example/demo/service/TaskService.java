package com.example.demo.service;

import com.example.demo.classesPackage.Task;
import com.example.demo.classesPackage.User;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    private UserRepository userRepository;
    public TaskService(TaskRepository taskRepository,UserRepository userRepository){
        this.taskRepository=taskRepository;
        this.userRepository=userRepository;
    }
    public void deleteTask(Task task){
        taskRepository.delete(task);
    }
    public void addTask(String desc, int userId, Task.Priority priority) {
        Task task = new Task();
        User user = userRepository.findById(userId).get();
        task.setDesc(desc);
        task.setUser(user);
        task.setStatus(Task.Status.TODO);
        task.setPriority(priority);
        taskRepository.save(task);
    }
    public List<Task> showTask(){
    return taskRepository.findAll();
    }
    public void updateTask(Task.Status status, int id){
        Task task=taskRepository.findById(id).get();
        task.setStatus(status);
        taskRepository.save(task);
    }
}
