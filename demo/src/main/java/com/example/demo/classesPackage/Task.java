package com.example.demo.classesPackage;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
   private User user;
    @Column(name = "description")
   private String desc;
   public enum Status{
       TODO, IN_PROGRESS, DONE
   }
   public enum Priority{
       LOW, MEDIUM, HIGH
   }
   @Enumerated(EnumType.STRING)
   private Priority priority;
    @Enumerated(EnumType.STRING)
   private Status status;
    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public User getUser() {
        return user;
    }
    public String getDesc() {
        return desc;
    }
    public Priority getPriority() {
        return priority;
    }
    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
