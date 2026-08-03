package com.example.demo.controller;

import com.example.demo.classesPackage.User;
import com.example.demo.config.JwtSecurity;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
private UserService userService;
private JwtSecurity jwtSecurity;
public UserController(UserService userService, JwtSecurity jwtSecurity){
    this.userService=userService;
    this.jwtSecurity=jwtSecurity;
}
@PostMapping("/login")
    public String login(@RequestBody User user){
    User user1= userService.login(user.getPassword(),user.getGmail());
    if(user1!=null){
        String token =jwtSecurity.generateToken(user1);
       return token;
    }
   return null;
}
@PostMapping("/signup")
    public void signup(@RequestBody User user){

      userService.signup(user.getPassword(),user.getGmail());
}
}
