package com.example.demo.classesPackage;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String gmail;
    private String password;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private  List<Task>tasks=new ArrayList<>();
    public List<Task> getTasks() {
        return tasks;
    }
    public String getGmail() {
        return gmail;
    }
    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }
}