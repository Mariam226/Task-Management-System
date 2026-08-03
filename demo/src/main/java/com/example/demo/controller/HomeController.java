package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<String> home() {
        System.out.println("HOME ENDPOINT CALLED");
        return ResponseEntity.ok("Task Management API is running!");
    }
}